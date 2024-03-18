<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${allDepartment}" var="c">
					<a href="getAllEmoplyee/${c.depertmentId}" class="btn btn-secondary "><h3>&#x2022; ${c.depertmentName }</h3></text>
			</c:forEach>

</body>
</html>