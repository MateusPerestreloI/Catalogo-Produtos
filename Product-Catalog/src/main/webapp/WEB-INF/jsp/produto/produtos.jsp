<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Produtos</title>
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
</head>
<body>
	<div>
		<p>
			<a href="${contextPath}/produto?isNew=true">Novo Produto</a>
		</p>
		<c:if test="${not empty mensagemProduto}">
			<div>
				<h4>${mensagemProduto}</h4>
			</div>
		</c:if>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Categoria</th>
					<th>Marca</th>
					<th>Preço</th>
					<th width="220">Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td>${produto.nomeProduto}</td>
						<td>${produto.categoriaModel.nomeCategoria}</td>
						<td>${produto.marcaModel.nomeMarca}</td>
						<td>${produto.precoProduto}</td>
						<td>
							<form:form method="delete" action="${contextPath}/produto/${produto.codProduto}">
								<a href="${contextPath}/produto/${produto.codProduto}?isEdit=false">Detalhes</a>
								<a href="${contextPath}/produto/${produto.codProduto}?isEdit=true">Editar</a>
								<input type="submit" value="Excluir">
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>