package com.dictionary.ws.entities.concretes;

import com.dictionary.ws.core.CustomAnnotation.UniqueUserName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "user_table")
@JsonIgnoreProperties({"lists"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size(min=4,max=40)
    @UniqueUserName
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String nameAndLastName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<ListClass> lists=new ArrayList<>();



    private String image;



    public User(String userName, String password, String nameAndLastName) {
        this.userName = userName;
        this.password = password;
        this.nameAndLastName = nameAndLastName;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public void setNameAndLastName(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
    }

    public List<ListClass> getLists() {
        return lists;
    }

    public void setLists(List<ListClass> lists) {
        this.lists = lists;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
