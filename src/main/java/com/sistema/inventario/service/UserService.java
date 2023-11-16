package com.sistema.inventario.service;

import com.sistema.inventario.exceptions.NotFoundException;
import com.sistema.inventario.model.User;
import com.sistema.inventario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        if (id == 0){
            throw new NotFoundException("User id is null");
        }
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new NotFoundException("User not found");
        }
        return user.get();
    }

    public User updateUser(User user, Long id){
        if(userRepository.existsById(id)){
            User userBd = userRepository.findById(id).get();
            userBd.setFirstName(user.getFirstName());
            userBd.setLastName(user.getLastName());
            userBd.setAddress(user.getAddress());
            userBd.setEmail(user.getEmail());
            userBd.setPhone(user.getPhone());
            return userRepository.save(userBd);
        }
        return null;
    }
    public Boolean deleteUserById(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }
}
