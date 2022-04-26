package com.dictionary.ws.entities.DTO;

import lombok.Data;

@Data
public class WorkspaceVocabularyDTO {

    Long id;

    String name;

    String component;

    String pronunciation;

    String audio;

    String definition;

    String definitionInAnyLanguage;
}
