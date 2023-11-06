package com.dreamquest.manytomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dreamquest.manytomany.entity.Reservation;

public interface ReservationDAO extends JpaRepository<Reservation, Long> {

	
}
