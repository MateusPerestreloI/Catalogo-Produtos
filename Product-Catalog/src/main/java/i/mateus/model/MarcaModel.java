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
@Table(name = "TB_MARCA")
public class MarcaModel {
	
	private long codMarca;
	private String nomeMarca;
	
	
	public MarcaModel(long codMarca, String nomeMarca) {
		super();
		this.codMarca = codMarca;
		this.nomeMarca = nomeMarca;
	}

	public MarcaModel() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "COD_MARCA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MARCA")
	@SequenceGenerator(name = "SEQ_MARCA", initialValue = 1, allocationSize = 1)
	public long getCodMarca() {
		return codMarca;
	}

	public void setCodMarca(long codMarca) {
		this.codMarca = codMarca;
	}

	@Column(name = "NOME_MARCA")
	@NotNull(message = "Nome obrigatório")
	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	@Override
	public String toString() {
		return "MarcaModel [codMarca=" + codMarca + ", nomeMarca=" + nomeMarca + "]";
	}
}
