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
@Table(name = "CATEGORIA_TB")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class CategoriaModel {

	@Id
	@Column(name = "COD_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_CATEGORIA")
	@SequenceGenerator(name = "SEQ_CATEGORIA", initialValue = 1, allocationSize = 1)
	private long codCategoria;

	@Column(name = "NOME_CATEGORIA")
	@NotNull(message = "Nome obrigatório")
	private String nomeCategoria;
}
