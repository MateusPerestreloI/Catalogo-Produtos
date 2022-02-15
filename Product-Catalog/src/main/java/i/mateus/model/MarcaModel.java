package i.mateus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MARCA_TB")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class MarcaModel {

	@Id
	@Column(name = "COD_MARCA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MARCA")
	@SequenceGenerator(name = "SEQ_MARCA", initialValue = 1, allocationSize = 1)
	private long codMarca;

	@Column(name = "NOME_MARCA")
	@NotNull(message = "Nome obrigatório")
	private String nomeMarca;

}
