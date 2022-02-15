INSERT INTO CATEGORIA_TB (COD_CATEGORIA, NOME_CATEGORIA) VALUES (SEQ_CATEGORIA.NEXTVAL, 'Notebook');
INSERT INTO CATEGORIA_TB (COD_CATEGORIA, NOME_CATEGORIA) VALUES (SEQ_CATEGORIA.NEXTVAL, 'Smartphone');
INSERT INTO CATEGORIA_TB (COD_CATEGORIA, NOME_CATEGORIA) VALUES (SEQ_CATEGORIA.NEXTVAL, 'TV');
INSERT INTO CATEGORIA_TB (COD_CATEGORIA, NOME_CATEGORIA) VALUES (SEQ_CATEGORIA.NEXTVAL, 'Tablet');

INSERT INTO MARCA_TB (COD_MARCA, NOME_MARCA) VALUES (SEQ_MARCA.NEXTVAL, 'LG');
INSERT INTO MARCA_TB (COD_MARCA, NOME_MARCA) VALUES (SEQ_MARCA.NEXTVAL, 'Apple');
INSERT INTO MARCA_TB (COD_MARCA, NOME_MARCA) VALUES (SEQ_MARCA.NEXTVAL, 'Samsumg');
INSERT INTO MARCA_TB (COD_MARCA, NOME_MARCA) VALUES (SEQ_MARCA.NEXTVAL, 'Sony');

INSERT INTO PRODUTO_TB (COD_PRODUTO, NOME_PRODUTO, DESC_PRODUTO, PRECO_PRODUTO, COD_CATEGORIA, COD_MARCA) VALUES (SEQ_PRODUTO.NEXTVAL, 'SmartPhone XY', 'Celular de ultima geração', 1.99, 1, 1);
INSERT INTO PRODUTO_TB (COD_PRODUTO, NOME_PRODUTO, DESC_PRODUTO, PRECO_PRODUTO, COD_CATEGORIA, COD_MARCA) VALUES (SEQ_PRODUTO.NEXTVAL, 'Liquidificador', 'Aparelho que liquidifica', 2.99, 2, 2);
INSERT INTO PRODUTO_TB (COD_PRODUTO, NOME_PRODUTO, DESC_PRODUTO, PRECO_PRODUTO, COD_CATEGORIA, COD_MARCA) VALUES (SEQ_PRODUTO.NEXTVAL, 'Lava-louça', 'Aparato para lavar a louça suja', 3.99, 3, 3);
INSERT INTO PRODUTO_TB (COD_PRODUTO, NOME_PRODUTO, DESC_PRODUTO, PRECO_PRODUTO, COD_CATEGORIA, COD_MARCA) VALUES (SEQ_PRODUTO.NEXTVAL, 'Sanduicheira', 'Eletrodoméstico usado para esquentar pão', 4.99, 4, 4);