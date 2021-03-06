<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Alterar produto</title>
	<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
</head>
<body>
	<form:form modelAttribute="produtoModel" action="${contextPath}/produto" method="put">
		<spring:hasBindErrors name="produtoModel">
			<div>
				<form:errors path="*"/>
			</div>
		</spring:hasBindErrors>
		
		<div>
			<form:input type="hidden" value="${produtoModel.codProduto}" path="codProduto"/>
		</div>
		
		<div>
			<label>Nome do Produto:</label>
			<form:input type="text" path="nomeProduto" />
			<font color="red"><form:errors path="nomeProduto"/></font>
		</div>

		<div>
			<label>Categoria:</label>
			<form:select path="categoriaModel.codCategoria">
				<form:options items="${categorias}" itemValue="codCategoria" itemLabel="nomeCategoria"/>
			</form:select>
		</div>

		<div>
			<label>Marca:</label>
			<form:select path="marcaModel.codMarca">
				<form:options items="${marcas}" itemValue="codMarca" itemLabel="nomeMarca"/>
			</form:select>
		</div>
		
		<div>
			<label>Descri??o do Produto:</label>
			<form:input path="descProduto" rows="4" cols="100"/>
			<font color="red"><form:errors path="descProduto"/></font>
		</div>
		
		<div>
			<label>Pre?o do Produto:</label>
			<form:input type="text" path="precoProduto"/>
			<font color="red"><form:errors path="precoProduto"/></font>
		</div>
		
		<table>
			<tr>
				<th><a href="${contextPath}/produto">Cancelar</a></th>
				<th><button type="submit">Gravar</button></th>
			</tr>
		</table>
	</form:form>
</body>
</html>