package com.akumasoft.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akumasoft.entity.Trip;
import com.akumasoft.repository.*;
import com.akumasoft.request.*;

@Service
public class TripService {
	@Autowired
	TripRepository TripRp;
	public Trip createTrip (CreateTripRequest crtrq) {
		return TripRp.save( 
			new Trip(crtrq) 
		);
	}
	
	public Trip readTrip(Long TripID ) {
		return TripRp.getReferenceById(TripID);
	}
	
	public Boolean updateTrip(UpdateTripRequest uptrq) {
		return (
				TripRp.save(
						new Trip(uptrq)
					) != null 
				);
	}
	
	public Boolean deleteTrip(Long TripID) {
		TripRp.deleteById(TripID);
		return true;
	}
}
