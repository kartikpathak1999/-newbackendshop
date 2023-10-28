package com.aswini.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aswini.profile.entity.Profile;

@Repository
public interface ProfleRepository extends MongoRepository<Profile,Integer> {

}
