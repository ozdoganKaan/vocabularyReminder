package com.dictionary.ws.entities.DTO;

import com.dictionary.ws.entities.concretes.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTO {

    String userName;

    String nameAndLastName;

    String image;

    public UserDTO(User user) {
        this.userName = user.getUserName();
        this.nameAndLastName = user.getNameAndLastName();
        this.image = user.getImage();
    }

    public UserDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        this.image = image;
    }
}
