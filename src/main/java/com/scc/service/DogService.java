package com.scc.service;

import com.scc.model.Dog;
import com.scc.repository.DogRepository;
import com.scc.utils.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.scc.config.PubConfiguration.PubSubGateway;
import org.springframework.stereotype.Service;

/**
 * Created by AnthonyLenovo on 05/01/2019.
 */
@Service
public class DogService extends AbstractGenericService<Dog>  {

	private static final Logger logger = LoggerFactory.getLogger(DogService.class);

    @Autowired
    private DogRepository dogRepository;

    public DogService(PubSubGateway pubSubGateway) {
		super(pubSubGateway, Constants.dogDomaine);
	}
    
    public Dog getDogById(long dogId){

        try {
            return dogRepository.findById(dogId);
        }
        finally{
        }
    }

    @SuppressWarnings("unchecked")
	@Override
	protected <T> T populateMessage(int _id, String _action) {

        Dog dog = new Dog();
        if (!_action.equals("D")) {
            dog = getDogById(_id);
            if (dog == null) {
                return null;
            }
        } else
            dog.withId(_id);

        return (T) dog;
	}

}