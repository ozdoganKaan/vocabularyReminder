package com.dictionary.ws.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class WorkspaceVocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String component;

    private String pronunciation;

    private String audio;

    private String definition ;

    private String definitionInAnyLanguage;

    @ElementCollection
    @CollectionTable(name = "exp_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "list")
    private List<String> examples=new ArrayList<>();




}
