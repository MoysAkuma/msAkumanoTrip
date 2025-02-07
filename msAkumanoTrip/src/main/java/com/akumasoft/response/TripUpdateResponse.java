package com.akumasoft.response;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TripUpdateResponse {
	@JsonProperty("CodeStatus")
	private int Code;
	
	@JsonProperty("Description")
	private String Description;
	
	public TripUpdateResponse(Boolean rst) {
		this.Code = (rst) ? 201 : 500; 
		this.Description = (rst) ? "Update success": "Update failed";
	}
}
