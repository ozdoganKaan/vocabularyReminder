package com.dictionary.ws.business.concretes;

import com.dictionary.ws.dataAccess.abstracts.VocabularyDAO;
import com.dictionary.ws.dataAccess.abstracts.WorkspaceVocabularyDAO;
import com.dictionary.ws.entities.concretes.WorkspaceVocabulary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkspaceVocabularyService {


    private final WorkspaceVocabularyDAO workspaceVocabularyDAO;

    public WorkspaceVocabulary getVocabulary(String vocab) {
        return workspaceVocabularyDAO.getVocabularyByName(vocab);
    }

    public WorkspaceVocabulary getVocabularyById(Long id) { return workspaceVocabularyDAO.getById(id); }
}
