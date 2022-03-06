package com.dictionary.ws.business.abstracts;

import com.dictionary.ws.entities.concretes.Vocabulary;

public interface VocabularyService {

    Vocabulary getVocabulary(String vocab);
}
