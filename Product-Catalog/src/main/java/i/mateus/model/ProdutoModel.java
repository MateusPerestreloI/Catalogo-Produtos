package i.mateus.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PRODUTO_TB")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ProdutoModel {

	@Id
	@Column(name = "COD_PRODUTO")
	@GeneratedValue(generator = "SEQ_PRODUTO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PRODUTO", initialValue = 1000, allocationSize = 1)
	private long codProduto;
	
	@Column(name = "NOME_PRODUTO")
	@NotNull(message = "Nome Obrigatório")
	@Size(min = 2, message = "Nome precisa conter 2 ou mais caracteres")
	private String nomeProduto;

	@Column(name = "DESC_PRODUTO")
	@NotNull(message = "Descrição Obrigatório")
	private String descProduto;

	@Column(name = "PRECO_PRODUTO")
	@DecimalMin(value = "0.01", message = "PRECO deve ser acima de 0.01")
	@NumberFormat(style = Style.CURRENCY)
	private float precoProduto;
	
	@ManyToOne
	@JoinColumn(name = "COD_CATEGORIA", nullable = false)
	private CategoriaModel categoriaModel;
	
	@ManyToOne
	@JoinColumn(name = "COD_MARCA", nullable = false)
	private MarcaModel marcaModel;
	
}
