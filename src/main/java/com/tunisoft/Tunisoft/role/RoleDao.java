package com.tunisoft.Tunisoft.role;


import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
