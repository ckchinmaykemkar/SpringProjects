package com.chinmay.moviesvc.shared.repository;

import com.chinmay.moviesvc.shared.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookingShowJpaRepo extends JpaRepository<Booking,Long> {
}
