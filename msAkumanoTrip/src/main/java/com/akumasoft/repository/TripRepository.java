package com.akumasoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akumasoft.entity.*;
import com.akumasoft.request.*; 

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
	Trip createTrip(CreateTripRequest tripcrq);
	Trip readTrip(Long tripid);
	Boolean updateTrip(UpdateTripRequest triurq);
	Boolean deleteTrip(Long tripid);
}
