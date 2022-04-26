package com.dictionary.ws.entities.DTO;

import com.dictionary.ws.entities.concretes.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {

    Long id;

    String userName;

    String nameAndLastName;

    String image;

    public UserDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.nameAndLastName = user.getNameAndLastName();
        this.image = user.getImage();
    }

    public UserDTO() {
    }

}
