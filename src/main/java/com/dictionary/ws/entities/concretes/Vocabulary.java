package com.dictionary.ws.entities.concretes;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @ManyToMany(mappedBy = "vocabularyList")
    private List<ListClass> listClassList=new ArrayList<>();

    private DateFormat dateOfAdded;




    public Vocabulary() {
    }

    public Vocabulary(String name, String component, String pronunciation, String audio, String definition, String definitionInAnyLanguage, List<String> examples, DateFormat dateOfAdded) {
        this.name = name;
        this.component = component;
        this.pronunciation = pronunciation;
        this.audio = audio;
        this.definition = definition;
        this.definitionInAnyLanguage = definitionInAnyLanguage;
        this.examples = examples;
        this.dateOfAdded = dateOfAdded;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinitionInAnyLanguage() {
        return definitionInAnyLanguage;
    }

    public void setDefinitionInAnyLanguage(String definitionInAnyLanguage) {
        this.definitionInAnyLanguage = definitionInAnyLanguage;
    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public DateFormat getDateOfAdded() {
        return dateOfAdded;
    }

    public void setDateOfAdded(DateFormat dateOfAdded) {
        this.dateOfAdded = dateOfAdded;
    }
}
