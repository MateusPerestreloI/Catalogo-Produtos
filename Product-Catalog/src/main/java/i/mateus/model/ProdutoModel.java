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

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel {
	
	private long codProduto;
	private String nomeProduto;
	private String descProduto;
	private double precoProduto;
	private CategoriaModel categoriaModel;
	private MarcaModel marcaModel;
	
	public ProdutoModel(long codProduto, String nomeProduto, String descProduto, double precoProduto,
			CategoriaModel categoriaModel, MarcaModel marcaModel) {
		super();
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
		this.descProduto = descProduto;
		this.precoProduto = precoProduto;
		this.categoriaModel = categoriaModel;
		this.marcaModel = marcaModel;
	}

	public ProdutoModel() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "COD_PRODUTO")
	@GeneratedValue(generator = "SEQ_PRODUTO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PRODUTO", initialValue = 1000, allocationSize = 1)
	public long getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}
	
	@Column(name = "NOME_PRODUTO")
	@NotNull(message = "Nome Obrigatório")
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Column(name = "DESC_PRODUTO")
	@NotNull(message = "Descrição Obrigatório")
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	@Column(name = "PRECO_PRODUTO")
	@DecimalMin(value = "0.01", message = "PRECO deve ser acima de 0.01")
	@NumberFormat(style = Style.CURRENCY)
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	
	@ManyToOne
	@JoinColumn(name = "COD_CATEGORIA")
	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}
	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}
	
	@ManyToOne
	@JoinColumn(name = "COD_CATEGORIA")
	public MarcaModel getMarcaModel() {
		return marcaModel;
	}
	public void setMarcaModel(MarcaModel marcaModel) {
		this.marcaModel = marcaModel;
	}

	@Override
	public String toString() {
		return "ProdutoModel [codProduto=" + codProduto + ", nomeProduto=" + nomeProduto + ", descProduto="
				+ descProduto + ", precoProduto=" + precoProduto + ", categoriaModel=" + categoriaModel
				+ ", marcaModel=" + marcaModel + "]";
	}	
}
