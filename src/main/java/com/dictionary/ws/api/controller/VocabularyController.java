package com.dictionary.ws.api.controller;

import com.dictionary.ws.business.abstracts.VocabularyService;
import com.dictionary.ws.dataAccess.abstracts.VocabularyDAO;
import com.dictionary.ws.entities.concretes.Vocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class VocabularyController {

    @Autowired
    VocabularyService vocabularyService;

    @GetMapping("/api/dictionary/{vocab}")
    public Vocabulary getVocab(@PathVariable("vocab") String vocab){
      return   vocabularyService.getVocabulary(vocab);
    }
}
