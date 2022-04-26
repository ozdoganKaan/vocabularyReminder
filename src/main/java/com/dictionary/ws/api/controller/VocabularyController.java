package com.dictionary.ws.api.controller;

import com.dictionary.ws.business.concretes.VocabularyService;
import com.dictionary.ws.entities.DTO.SaveVocabDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vocabulary")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    @PostMapping("/save")
    public void saveVocabularyToList(@RequestBody SaveVocabDTO saveVocabDTO){
        vocabularyService.saveVocabulary(saveVocabDTO);
    }
}
