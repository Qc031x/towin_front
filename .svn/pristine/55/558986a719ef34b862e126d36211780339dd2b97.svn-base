<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div>
  <form name="bageBarForm" action="">
    ${pager.pageNo}/${pager.totalPages }
    <a href="javascript:pagBarSubmit(1);"><s:text name="pageBar.first"/></a>
    <a href="javascript:pagBarSubmit(${pager.pageNo-1});"><s:text name="pageBar.previous"/></a>
    <a href="javascript:pagBarSubmit(${pager.pageNo+1});"><s:text name="pageBar.next"/></a>
    <a href="javascript:pagBarSubmit(${pager.totalPages});"><s:text name="pageBar.last"/></a>
    &nbsp;&nbsp;<input type="text" id="pageNo" style="width:30px"/>
    <input type="button" value="GO" onclick="pagBarSubmit(document.getElementById('pageNo').value);"/>
  </form>
	<SCRIPT type="text/javascript">
	   var pageBar_fmArr = document.forms;
	   var pageBar_fmObj = null;
       for(var i = 0 ; i < pageBar_fmArr.length ; i++){
         if(pageBar_fmArr[i].name == "bageBarForm"){
           pageBar_fmObj = pageBar_fmArr[i-1];
           break;
         }
       }
	    var pageBoxObj = document.createElement("input");
	    pageBoxObj.setAttribute("type", "hidden");
	    pageBoxObj.setAttribute("name", "pager.pageNo");
	    pageBoxObj.setAttribute("id", "pager.pageNo");
	    pageBar_fmObj.appendChild(pageBoxObj);
	    
	    function pagBarSubmit(n){
	      document.getElementById("pager.pageNo").value = n;
	      pageBar_fmObj.submit();
	    }
	</SCRIPT>
</div>