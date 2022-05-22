package com.tunisoft.Tunisoft.user;

import com.tunisoft.Tunisoft.dto.RoleToUserForm;
import com.tunisoft.Tunisoft.role.Role;
import com.tunisoft.Tunisoft.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> index(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/add").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }


    @PostMapping("/roles/add")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/roles/add").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/roles/addtouser")
    public ResponseEntity<?> addRoleTOUser(@RequestBody RoleToUserForm request){
        userService.addRoleToUser(request.getRoleName(),request.getUserName());
        return ResponseEntity.ok().build();
    }


}
