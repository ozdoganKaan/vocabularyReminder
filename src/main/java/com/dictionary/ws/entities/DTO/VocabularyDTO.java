package com.dictionary.ws.entities.DTO;

import com.dictionary.ws.entities.concretes.WorkspaceVocabulary;
import lombok.Data;

import java.text.DateFormat;

@Data
public class VocabularyDTO {

    Long id;

    Integer version=0;

    WorkspaceVocabularyDTO workspaceVocabularyDTO;

    ListClassDTO listClassDTO;

}
