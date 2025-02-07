package com.akumasoft.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchByFiltersRequest {
	@JsonProperty("TripIDs")
	private String IDs;
	
	@JsonProperty("Name")
	private String Name;
	
	@JsonProperty("Description")
	private String Description;
}
