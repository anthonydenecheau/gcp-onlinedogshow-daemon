package com.scc.pub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scc.pub.model.Dog;


/**
 * Created by AnthonyLenovo on 06/01/2019.
 */
@Repository
public interface DogRepository extends CrudRepository<Dog,String>  {
    public Dog findById(long id);
}