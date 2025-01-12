package com.akumasoft.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateTripRequest {
	@JsonProperty("TripID")
	private Long ID;
	
	@NotBlank(message = "Trip Name is required")
	private String Name;
	
	@NotBlank(message = "Trip Description is required")
	private String Description;
	
	@NotBlank(message = "Trip Initial Date is required")
	private String InitialDate;
	
	@NotBlank(message = "Trip Final Date is required")
	private String FinalDate;
	
	@NotBlank(message = "Trip UbicationID is required")
	private Long UbicationID;
	
	@NotBlank(message = "Trip International flag is required")
	private Boolean International;
}
