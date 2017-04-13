package com.sgfm.ueditor.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.sgfm.ueditor.PathFormat;
import com.sgfm.ueditor.define.AppInfo;
import com.sgfm.ueditor.define.BaseState;
import com.sgfm.ueditor.define.FileType;
import com.sgfm.ueditor.define.State;

public class BinaryUploader {

	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		//FileItemStream fileStream = null;
		boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

        if ( isAjaxUpload ) {
            upload.setHeaderEncoding( "UTF-8" );
        }

		try {
			
			/*FileItemIterator iterator = upload.getItemIterator(request);

			while (iterator.hasNext()) {
				fileStream = iterator.next();

				if (!fileStream.isFormField())
					break;
				fileStream = null;
			}

			if (fileStream == null) {
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}*/
			
			MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;

			String[] fileNames = wrapper.getFileNames("upfile");
			File[] files = wrapper.getFiles("upfile");

			String savePath = (String) conf.get("savePath");
			/*String originFileName = fileStream.getName();*/
			String originFileName = fileNames[0];
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			savePath = savePath + originFileName+suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			savePath = PathFormat.parse(savePath, originFileName);

			//String physicalPath = (String) conf.get("rootPath") + savePath;

			/*InputStream is = fileStream.openStream();*/
			/*if(savePath!=""){
				//获取原始文件名称（服务器上存储的）并将其删除			
				File f = new File(savePath);			
				f.delete();
			}	*/
			InputStream is = new FileInputStream(files[0]);
			State storageState = StorageManager.saveFileByInputStream(is,
					savePath, maxSize);
			is.close();
			
			if (storageState.isSuccess()) {
				int lastIndex02 = savePath.substring(0, savePath.lastIndexOf("/")).lastIndexOf("/");
				storageState.putInfo("url", savePath.substring(lastIndex02));
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}

			return storageState;
		}  catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
}
