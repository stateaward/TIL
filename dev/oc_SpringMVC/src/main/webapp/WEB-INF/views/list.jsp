<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>
<center>

		<h1>MVC 게시판</h1>			
		
		<form method="post" action="search.bod">
			<b>검색:</b>
			<select name="condition">
				<option value="title">제목</option>
				<option value="name">글쓴이</option>
			</select>
			<input type="text" name="word">
			<input type="submit" value="검색">
		</form>
		
		<TABLE BORDER=1 CELLSPACING=1 CELLPADDING = 1><TR>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>번호</th>
		<th width=200 bgcolor=#113366><font color=#ffffee size=2>제목</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>글쓴이</th>
		<th width=150 bgcolor=#113366><font color=#ffffee size=2>날짜</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>조회수</th>

	  	<c:forEach items="${list}" var="row">
		    <tr bgcolor=pink>
			   <td align=center bgcolor=pink>&nbsp;<font size=2>${row.num}</td>	<!-- row.getNum() -->
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>
		      	<a href="read.bod?num=${row.num}">${row.title}</a>
		      </td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>${row.name}</td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>${row.wdate}</td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>${row.count}</td>	       
		    </tr>
	    </c:forEach>
	   
</table>
<br></br>
<a href="insertForm.bod">새글쓰기</a>
</body></html>