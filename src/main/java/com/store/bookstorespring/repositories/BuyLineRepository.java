package com.store.bookstorespring.repositories;

import com.store.bookstorespring.entities.BuyLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyLineRepository extends JpaRepository<BuyLine, Long>{
}
