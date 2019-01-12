package com.scc.repository;

import com.scc.model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by AnthonyLenovo on 06/01/2019.
 */
@Repository
public interface DogRepository extends CrudRepository<Dog,String>  {
    public Dog findById(long id);
}