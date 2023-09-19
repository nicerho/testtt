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
<c:forEach var="item" items="${list}"> <!-- set : 해당 값을 다른 이름으로 활용할 수 있또록 하는 태그 -->
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
<c:set var="page" value="${sum/4}"/>
<!-- 페이지번호 -->
<c:forEach varStatus="no" begin="1" end="${page+(1-(page%1))%1}" step="1">
<div style="width:30px;height:30px;border:1px solid black; display:inline-block;line-height:30px;text-align:center;cursor:pointer" onclick="abc(${no.index})">${no.index}</div>
</c:forEach>
</body>
<script>
function abc(pg){
	alert(pg)
}
</script>
</html>