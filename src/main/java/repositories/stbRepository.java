package repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import model.STB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface stbRepository extends MongoRepository<STB, String>{ 

    STB findByTitre(String titre);

    STB findByDescription(String description);

    List<STB> findByDateGreaterThan(Date Date);

	Optional<STB> findById(String id);
	boolean existsByTitreAndVersionAndDate(String id, String titre, String description, Date date, String nom_entite);
	
	boolean existsById(String id);
    
	void deleteById(String id);
   
   
}