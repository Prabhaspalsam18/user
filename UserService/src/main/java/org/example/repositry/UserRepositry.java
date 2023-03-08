package org.example.repositry;

import org.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositry extends MongoRepository<User, String> {
}
