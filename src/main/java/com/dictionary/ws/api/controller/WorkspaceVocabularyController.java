package com.dictionary.ws.api.controller;

import com.dictionary.ws.business.concretes.WorkspaceVocabularyService;
import com.dictionary.ws.entities.concretes.WorkspaceVocabulary;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class WorkspaceVocabularyController {

   final private WorkspaceVocabularyService workspaceVocabularyService;

    @GetMapping("/api/vocabularies")
    public WorkspaceVocabulary getVocab(@RequestParam("vocab") String vocab){
      return   workspaceVocabularyService.getVocabulary(vocab);
    }
}
