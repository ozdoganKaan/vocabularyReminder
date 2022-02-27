package com.dictionary.ws.business.concretes;

import com.dictionary.ws.business.abstracts.UserService;
import com.dictionary.ws.core.CustomAnnotation.CurrentUser;
import com.dictionary.ws.core.Exception.UserNotFound;
import com.dictionary.ws.core.Results.ErrorResult;
import com.dictionary.ws.core.Results.ResultConfiguration;
import com.dictionary.ws.core.Results.SuccessResult;
import com.dictionary.ws.core.SecurityConfiguration.CustomUserDetails;
import com.dictionary.ws.dataAccess.abstracts.UserDAO;
import com.dictionary.ws.entities.DTO.UserDTO;
import com.dictionary.ws.entities.DTO.UserUpdateDTO;
import com.dictionary.ws.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {




    UserDAO userDAO;
    PasswordEncoder passwordEncoder;
    ApplicationContext ctx =
            new AnnotationConfigApplicationContext(ResultConfiguration.class);

    UserDTO userDTO =ctx.getBean(UserDTO.class);
    SuccessResult successResult =ctx.getBean(SuccessResult.class);

    @Autowired
    public UserManager(UserDAO userDAO ) {
        this.userDAO = userDAO;
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

    @Override
    public SuccessResult saveUser(User user) {


            String encodedPsw = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPsw);
            userDAO.save(user);


            return successResult ;
        }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public Page<User> getUsers(Pageable pageable,  User user) {

        if(user!=null){
            return userDAO.findAllByUserNameNot(user.getUserName(),pageable);
        }
        return userDAO.findAll(pageable);
    }

    @Override
    public User getByUserName(String username) {
        User user = userDAO.findByUserName(username);
        if(user==null){
            throw new UserNotFound();
        }else{
            return user;
        }

    }

    @Override
    public User updateUser(UserUpdateDTO userUpdateDTO, String username) {
            User user= userDAO.findByUserName(username);
            user.setNameAndLastName(userUpdateDTO.getNameAndLastName());
            if(userUpdateDTO.getImage()!=null){
                user.setImage(userUpdateDTO.getImage());
            }
            userDAO.save(user);
        return user;
    }
}
