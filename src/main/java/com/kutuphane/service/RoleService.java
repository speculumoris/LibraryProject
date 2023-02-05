package com.kutuphane.service;

import com.kutuphane.exception.ResourceNotFoundexception;
import com.kutuphane.repository.RoleRepository;
import com.kutuphane.user.Role;
import com.kutuphane.user.role.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByType(RoleType admin) {
        Role role=roleRepository.findByName(admin).orElseThrow(()->new ResourceNotFoundexception("Role bulunamadı"));

        return role;
    }
}
