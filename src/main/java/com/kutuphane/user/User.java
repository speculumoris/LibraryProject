package com.kutuphane.user;

import com.kutuphane.user.role.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ıd;

    @NotNull (message = "cannot null")
    @NotBlank(message = "cannot blank")
    private String userName;
    private String userSurname;

    @Email(message = "please enter valid email")
    private String userEmail;
    private String nickName;

    @NotNull (message = "cannot null")
    @NotBlank(message = "cannot blank")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="t_userRole",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns =@JoinColumn(name = "role_id"))
    private Set<Role> userRole=new HashSet<>();


}
