package com.akumasoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.akumasoft.request.*;

import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "trips")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long TripID;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name = "InitialDate")
	private String InitialDate;
	
	@Column(name = "FinalDate")
	private String FinalDate;
	
	@Column(name = "UbicationID")
	private Long UbicationID;
	
	@Column(name = "International")
	private Boolean International;
	
	public Trip(CreateTripRequest t) {
		this.Name = t.getName();
		this.Description = t.getDescription();
		this.InitialDate = t.getInitialDate();
		this.FinalDate = t.getFinalDate();
		this.UbicationID = t.getUbicationID();
		this.International = t.getIsInternational();
	}
	
	public Trip(UpdateTripRequest t) {
		this.TripID = t.getID();
		this.Name = t.getName();
		this.Description = t.getDescription();
		this.InitialDate = t.getInitialDate();
		this.FinalDate = t.getFinalDate();
		this.UbicationID = t.getUbicationID();
		this.International = t.getInternational();
	}
}
