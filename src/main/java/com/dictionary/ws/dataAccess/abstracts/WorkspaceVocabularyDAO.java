package com.dictionary.ws.dataAccess.abstracts;

import com.dictionary.ws.entities.concretes.WorkspaceVocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceVocabularyDAO extends JpaRepository<WorkspaceVocabulary,Long> {

    WorkspaceVocabulary getVocabularyByName(String name);
}
