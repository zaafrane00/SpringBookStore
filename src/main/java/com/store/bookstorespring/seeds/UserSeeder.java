package com.store.bookstorespring.seeds;

import com.store.bookstorespring.entities.User;
import com.store.bookstorespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
       // loadUserData();
    }

   /* private void loadUserData() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setName("Spring Blog");
            user.setLastname("admin");
            user.setEmail("test@test.com");
            user.setPassword(new BCryptPasswordEncoder().encode("test123"));
            HashSet<String> roles=new HashSet();
            roles.add("ROLE_ADMIN");
            roles.add("ROLE_USER");
            user.setRoles(roles);
            user.setStatus(true);
            userRepository.save(user);
        }
        System.out.println(userRepository.count());
    }*/
}
