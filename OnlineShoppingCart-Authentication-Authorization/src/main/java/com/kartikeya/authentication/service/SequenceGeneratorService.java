package com.kartikeya.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.kartikeya.authentication.models.DBSequenceProduct;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {

	    @Autowired
	    private MongoOperations mongoOperations;


    public int getSequenceNumberForProduct(String sequenceName) {
        
        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no/	      
        Update update = new Update().inc("seq",500);
        DBSequenceProduct counter = mongoOperations
	                .findAndModify(query,
                         update, options().returnNew(true).upsert(true),
                        DBSequenceProduct.class);
	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

