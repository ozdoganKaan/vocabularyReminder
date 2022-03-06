package com.dictionary.ws.business.concretes;

import com.dictionary.ws.business.abstracts.VocabularyService;
import com.dictionary.ws.dataAccess.abstracts.VocabularyDAO;
import com.dictionary.ws.entities.concretes.Vocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocabularyManager implements VocabularyService {

    @Autowired
    VocabularyDAO vocabularyDAO;

    @Override
    public Vocabulary getVocabulary(String vocab) {
        return vocabularyDAO.getVocabularyByName(vocab);
    }
}
