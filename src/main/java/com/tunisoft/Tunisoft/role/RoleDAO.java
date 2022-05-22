package com.tunisoft.Tunisoft.role;

import com.tunisoft.Tunisoft.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
