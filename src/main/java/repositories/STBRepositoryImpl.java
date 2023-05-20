package repositories;
import model.STB;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class STBRepositoryImpl implements stbRepository  {
    
    private MongoTemplate mongoTemplate;

    @Autowired
    public STBRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    
    @Override
    public List<STB> findAll() {
        Query query = new Query();
        return mongoTemplate.find(query, STB.class);
    }

    
    @Override
    public Optional<STB> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, STB.class));
    }

    @Override
    public STB save(STB entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public void delete(STB entity) {
        mongoTemplate.remove(entity);
    }

	@Override
	public <S extends STB> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<STB> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends STB> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends STB> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends STB> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends STB> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<STB> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public void deleteAll(Iterable<? extends STB> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends STB> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends STB> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends STB> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends STB> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends STB, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public STB findByTitre(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public STB findByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<STB> findByDateGreaterThan(Date Date) {
		// TODO Auto-generated method stub
		return null;
	}

	public STB findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getLastInsertedId() {
	    Query query = new Query();
	    query.with(Sort.by(Sort.Direction.DESC, "id"));
	    query.limit(1);

	    STB lastSTB = mongoTemplate.findOne(query, STB.class);

	    if (lastSTB != null) {
	    	String idString = lastSTB.getId();
	        int id = Integer.parseInt(idString);
	        return id;
	    } else {
	        return 0; // Si aucune STB n'a été insérée auparavant, retourner 0 ou une valeur par défaut
	    }
	}




	@Override
	public boolean existsByTitreAndVersionAndDate(String id, String titre, String description, Date date, String nomEntite) {
	    Query query = new Query();
	    query.addCriteria(Criteria.where("id").ne(id));
	    query.addCriteria(Criteria.where("titre").is(titre));
	    query.addCriteria(Criteria.where("description").is(description));
	    query.addCriteria(Criteria.where("date_validation").is(date));
	    query.addCriteria(Criteria.where("nom_entite_client").is(nomEntite));

	    long count = mongoTemplate.count(query, STB.class);

	    return count > 0;
	}



	

	@Override
	public boolean existsById(String id) {
		 	Query query = new Query();
		    query.addCriteria(Criteria.where("_id").ne(id));
		    long count = mongoTemplate.count(query, STB.class);

		    return count > 0;
	}


	@Override
	public void deleteById(String id) {
	    mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), STB.class);
	}



	@Override
	public Iterable<STB> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub
		
	}



	

   
}
