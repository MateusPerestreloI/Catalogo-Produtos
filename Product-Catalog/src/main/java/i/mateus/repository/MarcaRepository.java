package i.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import i.mateus.model.MarcaModel;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaModel, Long>{

}
