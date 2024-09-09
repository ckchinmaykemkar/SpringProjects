package com.chinmay.split.shared.repositories;

import com.chinmay.split.shared.entity.Groups_table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface GroupJpaRepo extends JpaRepository<Groups_table,Long> {


    @Query(value = "SELECT gt FROM Groups_table gt WHERE gt.group_id =?1")
    public List<Groups_table> getGroupById(String grpId);
}
