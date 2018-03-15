/**
 * 
 */
package com.boot.test.springboot;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author sunil.yadav
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

}
