<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marcas</title>
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
			<a href="${contextPath}/marca?isNew=true">Nova Marca</a>
		</p>
		<c:if test="${not empty mensagemMarca}">
			<div>
				<h4>${mensagemMarca}</h4>
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
				<c:forEach items="${marcas}" var="marca">
					<tr>
						<td>${marca.nomeMarca}</td>
						<td>
							<form:form method="delete" action="${contextPath}/marca/${marca.codMarca}">
								<a href="${contextPath}/marca/${marca.codMarca}?isEdit=false">Detalhes</a>
								<a href="${contextPath}/marca/${marca.codMarca}?isEdit=true">Editar</a>
								<input type="submit" value="Excluir">
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>