package com.chinmay.split.shared.repositories;

import com.chinmay.split.shared.entity.User_table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserJpaRepo extends JpaRepository<User_table,Long> {
}
