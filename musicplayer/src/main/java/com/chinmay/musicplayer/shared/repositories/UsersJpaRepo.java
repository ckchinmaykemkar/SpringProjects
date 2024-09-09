package com.chinmay.musicplayer.shared.repositories;

import com.chinmay.musicplayer.shared.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersJpaRepo extends JpaRepository<Users,Long> {

    @Query(value = "SELECT u FROM Users u WHERE u.userName = ?1")
    public Users findByUserName(String userName);
}
