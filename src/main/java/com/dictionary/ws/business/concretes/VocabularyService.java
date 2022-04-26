package com.dictionary.ws.business.concretes;


import com.dictionary.ws.dataAccess.abstracts.VocabularyDAO;
import com.dictionary.ws.entities.DTO.SaveVocabDTO;
import com.dictionary.ws.entities.concretes.ListClass;
import com.dictionary.ws.entities.concretes.Vocabulary;
import com.dictionary.ws.entities.concretes.WorkspaceVocabulary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VocabularyService {

    private final ListClassService listClassService;
    private final VocabularyDAO vocabularyDAO;
    private final WorkspaceVocabularyService workspaceVocabularyService;

    @Transactional
    public void saveVocabulary(SaveVocabDTO saveVocabDTO) {
        ListClass listClass=listClassService.getList(saveVocabDTO.getListId());

        if(!this.getByListClassIdAndWorkspaceVocabularyId(saveVocabDTO.getListId(),saveVocabDTO.getVocabId()).isPresent()) {

            Vocabulary vocabulary = new Vocabulary();
            WorkspaceVocabulary workspaceVocabulary = workspaceVocabularyService.getVocabularyById(saveVocabDTO.getVocabId());
            vocabulary.setListClass(listClass);
            vocabulary.setWorkspaceVocabulary(workspaceVocabulary);

            vocabularyDAO.save(vocabulary);
        }
    }

    public Optional<Vocabulary> getByListClassIdAndWorkspaceVocabularyId(Long listClassId,Long workspaceVocabularyId){
       return vocabularyDAO.getByListClassIdAndWorkspaceVocabularyId(listClassId,workspaceVocabularyId);
    }
}
