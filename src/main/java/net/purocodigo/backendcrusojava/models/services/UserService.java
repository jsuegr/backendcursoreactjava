package net.purocodigo.backendcrusojava.models.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.purocodigo.backendcrusojava.UserRepositoryInterface;
import net.purocodigo.backendcrusojava.entities.UserEntity;
import net.purocodigo.backendcrusojava.models.shared.UserDto;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepositoryInterface userRepository;


    @Override
    public UserDto createUser(UserDto user) {
        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        
        //Provisionalmente se asigna un password encriptado
        userEntity.setEncryptedPassword("testPassword");
        userEntity.setUserId("testIdPublico");

        UserEntity storedUserDetails = this.userRepository.save(userEntity);

        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, userToReturn);

        return userToReturn;
    }
    
}
