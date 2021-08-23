<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html><body>
<center>

		<img alt="" src="resources/image/f3.jpg">
		<h1>EMP-DEPT JOIN</h1>
		
		<jsp:include page="loginCheck.jsp"/>			
		<br>
		
		<TABLE BORDER=1 CELLSPACING=1 CELLPADDING = 1><TR>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>사번</th>
		<th width=200 bgcolor=#113366><font color=#ffffee size=2>이름</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>부서번호</th>
		<th width=150 bgcolor=#113366><font color=#ffffee size=2>부서명</th>

	  	<c:forEach items="${list}" var="row">
		    <tr bgcolor=pink>
			   <td align=center bgcolor=pink>&nbsp;<font size=2>${row.num}</td>	<!-- row.getNum() -->
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>
		      	<a href="read.bod?num=${row.num}">${row.pass}</a>
		      </td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>${row.name}</td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>${row.wdate}</td>
		       
		    </tr>
	    </c:forEach>
	   
</table>
<br></br>
<a href="list.bod">돌아가기</a>
</body></html>