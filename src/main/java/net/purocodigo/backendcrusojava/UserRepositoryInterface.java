package net.purocodigo.backendcrusojava;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.purocodigo.backendcrusojava.entities.UserEntity;

@Repository
public interface UserRepositoryInterface extends CrudRepository<UserEntity, Long>{
    
    //public UserEntity findUserByEmail(String email);
}
