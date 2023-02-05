package com.kutuphane.security;

import com.kutuphane.exception.ResourceNotFoundexception;
import com.kutuphane.repository.UserRepository;
import com.kutuphane.user.Role;
import com.kutuphane.user.User;
import com.kutuphane.user.role.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundexception("user not found"));

        if (user!=null){
            return new org.springframework.security.core.userdetails.
                    User(user.getUserName(),
                        user.getPassword(),
                        buildGrantedAuthorities(user.getUserRole()));
        }else {
            throw new UsernameNotFoundException("user not found username: "+username);
        }
    }

    private static List<SimpleGrantedAuthority> buildGrantedAuthorities(final Set<Role> userRole) {
        List<SimpleGrantedAuthority> grantedList=new ArrayList<>();

        for (Role role:userRole) {
            grantedList.add(new SimpleGrantedAuthority(role.getRoleName().name()));
        }
        return grantedList;
    }
}
