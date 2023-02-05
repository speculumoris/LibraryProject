package com.kutuphane.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {



    private String userName;
    private String userSurname;

    @Email(message = "please enter valid email")
    private String userEmail;
    private String nickName;


    private String password;

   /*Stateless oldugundan user bilgilerini UserServiceDetails'in anlayacağı şekilde çevirmeliyiz bu yüzden burada bu constructor kullanılamıyor.

    public UserDto(User user) {
        this.userName = user;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.nickName = nickName;
        this.password = password;
    }

    */
}
