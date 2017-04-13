<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="pager" class="pagecondiv clearfix">
    <script type="text/javascript" src="/js/Cls_jsPage.js"></script>
    
   <script type="text/javascript">

   //alert(${pages.pageSize})
    var ss = new Cls_jsPage('${pages.totalRows}', '${pages.pageSize}',2, "ss");
      // var ss = new Cls_jsPage('100', '10',2, "ss");
       ss.setPageSE("page=", "");
        ss.setPageInput("page");
        ss.setUrl("");
        ss.setPageFrist("首页", "首页");
        ss.setPagePrev("上一页", "上一页");
        ss.setPageNext("下一页", "下一页");
        ss.setPageLast("末页", "末页");
        //ss.setPageText("<font class='normalTextSmall'><u><b>{$PageNum}</b></u></font>", "{$PageNum}");
        ss.setPageText("<a class='active'><u><b>{$PageNum}</b></u></a>", "{$PageNum}");
        
        //ss.setPageTextF("<td class='tablebody2'>&nbsp;{$PageTextF}&nbsp;</td>", "<td class='tablebody1'>&nbsp;{$PageTextF}&nbsp;</td>");
        ss.setPageTextF("{$PageTextF}", "{$PageTextF}");
        ss.setPageSelect("{$PageNum}", "{$PageNum}");
     //alert('${pages.totalRows}')
        //  ss.setHtml('<div class="noprint" ><font size="2"><div class="fenye"> <span><em>${pages.pageNo}</em>/${pages.totalPages}</span>{$PageFrist}{$PagePrev}{$PageText}{$PageNext}{$PageLast}<span>共${pages.totalRows}条</span></div></font></div>');
        if('${pages.totalRows}'=='' || '${pages.totalRows}'=='0'){
        	//alert(4)
             ss.setHtml('<div class="noprint" ><font size="2"><div class="fenye"> <span>暂无数据</span></div></font></div>');
        }
        else{
        	 ss.setHtml('<div class="noprint" ><font size="2"><div class="fenye"> <span><em>${pages.pageNo}</em>/${pages.totalPages}</span>{$PageFrist}{$PagePrev}{$PageText}{$PageNext}{$PageLast}<span>共${pages.totalRows}条</span></div></font></div>');
        }
             
          ss.Write();
  //alert(ss)
    </script>
</div>


