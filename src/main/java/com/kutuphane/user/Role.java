package com.kutuphane.user;

import com.kutuphane.user.role.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ıd;

    @Enumerated(EnumType.STRING)
    private RoleType roleName;

    @Override
    public String toString() {
        return "Role{" +
                "roleName=" + roleName +
                '}';
    }
}
