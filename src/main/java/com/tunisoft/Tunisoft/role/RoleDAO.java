package com.tunisoft.Tunisoft.role;

import com.tunisoft.Tunisoft.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleDAO extends JpaRepository<Role,Long> {

 /*   @Query(
            value= "select distinct *" +
                    " from roles" +
                    "where name=+:name",
            nativeQuery = true)
    Role findByName(@Param("name") String name);*/

    Role findRoleByName(String name);

}
