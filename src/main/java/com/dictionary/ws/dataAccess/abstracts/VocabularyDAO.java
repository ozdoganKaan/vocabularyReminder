package com.dictionary.ws.dataAccess.abstracts;

import com.dictionary.ws.entities.concretes.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabularyDAO extends JpaRepository<Vocabulary,Long> {

    Vocabulary getVocabularyByName(String name);
}
