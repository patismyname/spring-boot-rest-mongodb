package com.pattanaapp.repository;

import com.pattanaapp.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {

    @Override
    void delete(Profile profile);
}