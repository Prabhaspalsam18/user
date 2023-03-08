package org.example.repositry;

import org.example.model.UserDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataMongoRepositry extends MongoRepository<UserDataMongo, String> {
}
