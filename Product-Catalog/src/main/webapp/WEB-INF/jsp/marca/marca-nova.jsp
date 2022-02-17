<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@page isErrorPage="true"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Cadastrar Marca</title>
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
</head>
<body>
	<form:form modelAttribute="marcaModel" action="${contextPath}/marca" method="POST">
		<spring:hasBindErrors name="marcaModel">
			<div>
				<form:errors path="*"/>
			</div>
		</spring:hasBindErrors>
		
		<div>
			<label>Nome da Marca:</label>
			<form:input type="text" path="nomeMarca"/>
			<font color="red"><form:errors path="nomeMarca"/></font>
		</div>
		<table>
			<tr>
				<th><a href="${contextPath}/marca">Cancelar</a></th>
				<th><button type="submit">Gravar</button></th>
			</tr>
		</table>
	</form:form>
</body>
</html>