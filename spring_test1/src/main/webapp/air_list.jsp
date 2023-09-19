<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>예약 총원 (총 :${sum}명)<p>
<table>
<thead>
<tr>
<th>아디</th>
<th>고객명</th>
<th>항공사</th>
<th>인원</th>
<th>등록일</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${list}">
<tr>
<td>${item[1]}</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>