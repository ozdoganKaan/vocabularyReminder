package com.dictionary.ws.entities.DTO;

import com.dictionary.ws.entities.concretes.Vocabulary;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ListClassDTO {

    Long id;

    String name;

    UserDTO user;

    List<VocabularyDTO> vocabularyList;


}
