package i.mateus.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CATEGORIA")
public class CategoriaModel {

	private long codCategoria;
	private String nomeCategoria;
	
	public CategoriaModel(long codCategoria, String nomeCategoria) {
		super();
		this.codCategoria = codCategoria;
		this.nomeCategoria = nomeCategoria;
	}
	
	public CategoriaModel() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "COD_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_CATEGORIA")
	@SequenceGenerator(name = "SEQ_CATEGORIA", initialValue = 1, allocationSize = 1)
	public long getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(long codCategoria) {
		this.codCategoria = codCategoria;
	}

	@Column(name = "NOME_CATEGORIA")
	@NotNull(message = "Nome obrigatório")
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public String toString() {
		return "CategoriaModel [codCategoria=" + codCategoria + ", nomeCategoria=" + nomeCategoria + "]";
	}	
}
