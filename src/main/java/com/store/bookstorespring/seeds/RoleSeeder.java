package com.store.bookstorespring.seeds;

import com.store.bookstorespring.enums.ERoles;
import com.store.bookstorespring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.store.bookstorespring.entities.Role;

@Component
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count()==0){
            Role adminrole =new Role(ERoles.ROLE_ADMIN);
            Role userrole =new Role(ERoles.ROLE_USER);
            roleRepository.save(adminrole);
            roleRepository.save(userrole);
        }
    }
}
