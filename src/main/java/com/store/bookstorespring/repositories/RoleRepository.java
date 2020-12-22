package com.store.bookstorespring.repositories;

import com.store.bookstorespring.entities.Role;
import com.store.bookstorespring.enums.ERoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByName(ERoles name);
}
