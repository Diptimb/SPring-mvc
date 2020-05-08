package com.example.ticketBooking.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "sources_and_destinations",uniqueConstraints = @UniqueConstraint(columnNames = {"source","destination"}))
public class Destination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int detail_id;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "distance")
	@Min(value = 200)
	private Double distance;


	public Destination(int detail_id, String source, Double distance,String destination) {
		super();
		this.detail_id = detail_id;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	public Destination(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Destination(int detail_id, String source, String destination) {
		super();
		this.detail_id = detail_id;
		this.source = source;
		this.destination = destination;
	}

	public Destination() {
		super();
	}



}
