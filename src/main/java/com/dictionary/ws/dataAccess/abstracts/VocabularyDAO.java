package com.dictionary.ws.dataAccess.abstracts;

import com.dictionary.ws.entities.concretes.Vocabulary;
import com.dictionary.ws.entities.concretes.WorkspaceVocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VocabularyDAO extends JpaRepository<Vocabulary,Long> {

 Optional<Vocabulary> getByListClassIdAndWorkspaceVocabularyId(Long listClassId,Long workspaceVocabularyId);
}
