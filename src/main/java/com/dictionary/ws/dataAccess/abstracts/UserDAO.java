package com.dictionary.ws.dataAccess.abstracts;

import com.dictionary.ws.entities.concretes.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    User findByUserName(String username);

    Page<User> findAllByUserNameNot(String username, Pageable pageable);

}
