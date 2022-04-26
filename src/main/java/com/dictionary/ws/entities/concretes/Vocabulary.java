package com.dictionary.ws.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer version = 0;

    @ManyToOne
    private WorkspaceVocabulary workspaceVocabulary;

    @ManyToOne
    @JoinColumn(name = "vocabulary_list_id")
    private ListClass listClass;

    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist(){
        createdDate=LocalDateTime.now();
    }
}