package com.store.bookstorespring.seeds;

import com.store.bookstorespring.entities.Role;
import com.store.bookstorespring.entities.User;
import com.store.bookstorespring.enums.ERoles;
import com.store.bookstorespring.repositories.RoleRepository;
import com.store.bookstorespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
       loadUserData();
    }

    private void loadUserData() {
        Set<Role> roles=new HashSet();
        Role adminrole=roleRepository.findById(1L).get();
        Role userrole=roleRepository.findById(2L).get();
        if (userRepository.count() == 0) {
            User user = new User();
            user.setName("Spring Blog");
            user.setLastname("admin");
            user.setEmail("test@test.com");
          //  user.setPassword(new BCryptPasswordEncoder().encode("test123"));
            user.setPassword("123456");
            roles.add(adminrole);
            roles.add(userrole);
            user.setRoles(roles);
            user.setStatus(true);
            userRepository.save(user);
        }
        if(userRepository.count() == 1){
            User user2 = new User();
            user2.setName("user2 user2");
            user2.setLastname("user2");
            user2.setEmail("user2@test.com");
            user2.setStatus(true);
          //  user2.setPassword(new BCryptPasswordEncoder().encode("test123"));
            user2.setPassword("123456");
            Set<Role> roles2=new HashSet();
            roles2.add(userrole);
            user2.setRoles(roles2);
            userRepository.save(user2);
        }
        System.out.println(userRepository.count());
    }
}
