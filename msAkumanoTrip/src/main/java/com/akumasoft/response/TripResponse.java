package com.akumasoft.response;
import com.akumasoft.entity.Trip;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TripResponse {
	@JsonProperty("TripID")
	private Long ID;
	
	@JsonProperty("TripName")
	private String Name;
	
	@JsonProperty("Description")
	private String Description;
	
	@JsonProperty("InitialDate")
	private String InitialDate;
	
	@JsonProperty("FinalDate")
	private String FinalDate;
	
	@JsonProperty("UbicationID")
	private Long UbicationID;
	
	@JsonProperty("IsInternational")
	private Boolean International;
	
	public TripResponse(Trip trip) {
		this.ID = trip.getTripID();
		this.Name = trip.getName();
		this.Description = trip.getDescription();
		this.InitialDate = trip.getInitialDate();
		this.FinalDate = trip.getFinalDate();
		this.UbicationID = trip.getUbicationID();
		this.International = trip.getInternational();
	}
}
