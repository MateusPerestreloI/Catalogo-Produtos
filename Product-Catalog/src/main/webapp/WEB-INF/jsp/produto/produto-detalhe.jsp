<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhes do produto</title>
</head>
<body>
	<div>
				
		<h2>Produto</h2>
					
		<div>
			<label>Nome:</label>
			<b>${produtoModel.nomeProduto}</b>
        </div>
                        
        <div>
			<label>Categoria:</label>
			<label>${produtoModel.categoriaModel.nomeCategoria}</label>
        </div>
                        
        <div>
			<label>Marca:</label>
			<label>${produtoModel.marcaModel.nomeMarca}</label>
        </div>
						
		<div>
			<label>Descri��o:</label>
			<label>${produtoModel.descProduto}</label>
		</div>
						
		<div>
			<label>Pre�o:</label>
			<label>${produtoModel.precoProduto}</label>
		</div>
		<hr>
						
		<a href="${contextPath}/produto">Voltar</a>
                            
        <br>
        <br>	
					
	</div>
</body>
</html>