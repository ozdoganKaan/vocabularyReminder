package com.dictionary.ws.dataAccess.abstracts;

import com.dictionary.ws.entities.concretes.ListClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListClassDAO extends JpaRepository<ListClass,Long> {

    Optional<ListClass> findByNameAndUserId(String listName,Long userId);
}
