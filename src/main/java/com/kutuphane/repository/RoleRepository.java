package com.kutuphane.repository;

import com.kutuphane.user.Role;
import com.kutuphane.user.role.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleType admin);

}
