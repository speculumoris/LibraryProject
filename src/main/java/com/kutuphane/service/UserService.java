package com.kutuphane.service;

import com.kutuphane.dto.UserDto;
import com.kutuphane.repository.UserRepository;
import com.kutuphane.user.Role;
import com.kutuphane.user.User;
import com.kutuphane.user.role.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(UserDto userDto) {

        User myUser=new User();

        myUser.setUserName(userDto.getUserName());
        myUser.setUserSurname(userDto.getUserSurname());
        myUser.setNickName(userDto.getNickName());
        myUser.setUserEmail(userDto.getUserEmail());

        String password=userDto.getPassword();
        String encodePassword=passwordEncoder.encode(password);
        myUser.setPassword(encodePassword);

        Role role = roleService.getRoleByType(RoleType.ADMIN);
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        myUser.setUserRole(roles);

        userRepository.save(myUser);

    }
}
