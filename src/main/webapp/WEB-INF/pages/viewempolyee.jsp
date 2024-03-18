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
			    	
			    	  <h2>empolyee Information</h2>
                      <h3>&#x2022;empolyeeId : ${empolyee.empolyeeId}</h3>
                      <h3>&#x2022; empolyee Name : ${empolyee.name}</h3>
                     <h3>&#x2022; empolyee gender : ${empolyee.gender} <br><br></h3>
                     <h3>&#x2022; empolyee city : ${empolyee.city}</h3>
                     
                  
                     <a href="javascript:history.back()">Go Back</a>
			
</body>
</html>