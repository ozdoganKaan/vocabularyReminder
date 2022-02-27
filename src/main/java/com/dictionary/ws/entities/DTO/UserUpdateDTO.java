package com.dictionary.ws.entities.DTO;

public class UserUpdateDTO {

    String nameAndLastName;

    String image;

    public UserUpdateDTO(String nameAndLastName, String image) {
        this.nameAndLastName = nameAndLastName;
        image = image;
    }

    public UserUpdateDTO(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
    }

    public UserUpdateDTO() {
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public void setNameAndLastName(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image = image;
    }
}
