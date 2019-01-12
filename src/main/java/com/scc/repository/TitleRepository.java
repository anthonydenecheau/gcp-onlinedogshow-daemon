package com.scc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scc.model.Title;

@Repository
public interface TitleRepository extends CrudRepository<Title,String>  {
    
	public Title findById(long id);

}