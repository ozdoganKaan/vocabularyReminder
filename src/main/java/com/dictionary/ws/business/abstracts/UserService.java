package com.dictionary.ws.business.abstracts;

import com.dictionary.ws.core.Results.Result;
import com.dictionary.ws.entities.DTO.UserDTO;
import com.dictionary.ws.entities.DTO.UserUpdateDTO;
import com.dictionary.ws.entities.concretes.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {

    Result saveUser(User user);
    User findByUserName(String username);
    Page<User> getUsers(Pageable pageable, User user);

    User getByUserName(String username);

    User updateUser(UserUpdateDTO userUpdateDTO,String username);
}
