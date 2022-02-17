<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categorias</title>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
</head>
<body>

    <nav role="navigation">
        <div>
            <div>
            	<jsp:include page="../menu.jsp" />
            </div>
        </div>
    </nav>

	<div>
		<p>
			<a href="${contextPath}/categoria?isNew=true">Nova Categoria</a>
		</p>
		<c:if test="${not empty mensagemCategoria}">
			<div>
				<h4>${mensagemCategoria}</h4>
			</div>
		</c:if>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th width="220">Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categorias}" var="categoria">
					<tr>
						<td>${categoria.nomeCategoria}</td>
						<td>
							<form:form method="delete" action="${contextPath}/categoria/${categoria.codCategoria}">
								<a href="${contextPath}/categoria/${categoria.codCategoria}?isEdit=false">Detalhes</a>
								<a href="${contextPath}/categoria/${categoria.codCategoria}?isEdit=true">Editar</a>
								<input type="submit" value="Excluir">
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>