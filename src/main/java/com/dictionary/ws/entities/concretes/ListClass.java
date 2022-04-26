package com.dictionary.ws.entities.concretes;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ListClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date createDate;


    @OneToMany(mappedBy = "listClass")
    private List<Vocabulary> vocabularyList= new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ListClass(String name, Date createDate, User user) {
        this.name = name;
        this.createDate = createDate;
        this.user = user;
    }

    public ListClass() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Vocabulary> getVocabularyList() {
        return vocabularyList;
    }

    public void setVocabularyList(List<Vocabulary> vocabularyList) {
        this.vocabularyList = vocabularyList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
