<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhes da Categoria</title>
</head>
<body>
	<div>
				
		<h2>Categoria</h2>
					
		<div>
			<label>Nome:</label>
			<b>${categoriaModel.nomeCategoria}</b>
        </div>			
		<a href="${contextPath}/categoria">Voltar</a>
      </div>
</body>
</html>