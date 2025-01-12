package com.akumasoft.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akumasoft.entity.Trip;
import com.akumasoft.request.CreateTripRequest;
import com.akumasoft.request.UpdateTripRequest;
import com.akumasoft.service.TripService;
import com.akumasoft.handler.ResponseHandler;

@RestController
@RequestMapping("/trip/")
public class tripcontroller {
	@Autowired
	TripService srvTrip;
	
	@PostMapping("/Create")
	public ResponseEntity<Object> create(@RequestBody CreateTripRequest rq) {
		Trip t = this.srvTrip.createTrip(rq);
		if(t == null) {
			return ResponseHandler.generateResponsedata("Process of Creation failed", HttpStatus.INTERNAL_SERVER_ERROR, t);
		} else {
			return ResponseHandler.generateResponsedata("Process of Creation success", HttpStatus.CREATED, t);
		}
		
	}
	
	@PostMapping("/Update")
	public ResponseEntity<Object> update(@RequestBody UpdateTripRequest rq) {
		if(this.srvTrip.updateTrip(rq)) {
			return ResponseHandler.generateResponse("Process of Edition success", HttpStatus.OK);
		} else {
			return ResponseHandler.generateResponse("Process of Edition failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/Read/{TripID}")
	public ResponseEntity<Object> read(@PathVariable Long TripID ) {
		Trip t = this.srvTrip.readTrip(TripID);
		return ResponseHandler.generateResponsedata("Process of Creation success", HttpStatus.OK, t);
	}
	
	@DeleteMapping("/Delete/{TripID}")
	public ResponseEntity<Object> delete(@PathVariable Long TripID ) {
		if( this.srvTrip.deleteTrip(TripID)) {
			return ResponseHandler.generateResponse("Process of deletion success", HttpStatus.OK);
		} else {
			return ResponseHandler.generateResponse("Process of deletion failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * @GetMapping("/new")
	public List<TripResponse> getNewPublicTrips(){
		List<Trip> tripList = srvTrip.getNewPublicTrips();
		List<TripResponse> tripRL = new ArrayList<TripResponse>();
		
		tripList.stream().forEach(v -> {
			tripRL.add(new TripResponse(v));
		});
		
		return tripRL;
	}
	
	@GetMapping("like/{TripName}")
	public List<TripSearchResponse> getLikeTripName(@RequestParam String TripName) {
		List<Trip> tripList = srvTrip.findByName(TripName);
		List<TripSearchResponse> tripRL = new ArrayList<TripSearchResponse>();
		tripList.stream().forEach(v -> {
			tripRL.add(new TripSearchResponse(v));
		});
		
		return tripRL;
	}
	*/
}
