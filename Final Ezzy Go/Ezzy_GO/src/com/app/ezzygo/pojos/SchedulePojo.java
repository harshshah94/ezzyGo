package com.app.ezzygo.pojos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the "ScheduleDetails" database table.
 * 
 */
@Entity
@Table(name = "ScheduleDetails")
@NamedQuery(name = "SchedulePojo.findAll", query = "SELECT s FROM SchedulePojo s")
public class SchedulePojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "routeId",columnDefinition="number(7)",nullable=false)
	private Long routeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "busId",nullable=false)
	private BusPojo busDetail;

/*	@Temporal(TemporalType.DATE)
	@Column(name = "dateOfJourney",columnDefinition="date",nullable=false)
	private Date dateOfJourney;*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sourceCityId",nullable=false)
	private CityPojo sourceCity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destinationCityId",nullable=false)
	private CityPojo destinationCity;

	@Column(name = "departureTime",nullable=false,columnDefinition="date")
	private Date departureTime;

	@Column(name = "arrivalTime",nullable=false,columnDefinition="date")
	private Date arrivalTime;

	@Column(name = "seatFare",columnDefinition="number(4)",nullable=false)
	private Integer seatFare;

	@Column(name = "sleepFare",columnDefinition="number(4)",nullable=false)
	private Integer sleepFare;

	@Column(name = "remainingSeats",columnDefinition="number(2)")
	private Integer remainingSeats;

	// bi-directional many-to-one association to TicketPojo
	@OneToMany(mappedBy = "scheduleDetail")
	private Collection<TicketPojo> ticketDetails = new ArrayList<>();

	public SchedulePojo() {
		
		busDetail= new BusPojo();
	}

	public Long getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Date getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

/*	public Date getDateOfJourney() {
		return this.dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}*/

	public Date getDepartureTime() {
		return this.departureTime;
	}

	public SchedulePojo(BusPojo busDetail, CityPojo sourceCity,
			CityPojo destinationCity, Date departureTime, Date arrivalTime,
			Integer seatFare, Integer sleepFare) {
		super();
		this.busDetail = busDetail;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seatFare = seatFare;
		this.sleepFare = sleepFare;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public CityPojo getDestinationCity() {
		return this.destinationCity;
	}

	public void setDestinationCity(CityPojo destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Integer getRemainingSeats() {
		return this.remainingSeats;
	}

	public void setRemainingSeats(Integer remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public Integer getSeatFare() {
		return this.seatFare;
	}

	public void setSeatFare(Integer seatFare) {
		this.seatFare = seatFare;
	}

	public Integer getSleepFare() {
		return this.sleepFare;
	}

	public void setSleepFare(Integer sleepFare) {
		this.sleepFare = sleepFare;
	}

	public CityPojo getSourceCity() {
		return this.sourceCity;
	}

	public void setSourceCity(CityPojo sourceCity) {
		this.sourceCity = sourceCity;
	}

	public BusPojo getBusDetail() {
		return this.busDetail;
	}

	public void setBusDetail(BusPojo busDetail) {
		this.busDetail = busDetail;
	}

	public Collection<TicketPojo> getTicketDetails() {
		return this.ticketDetails;
	}

	public void setTicketDetails(Collection<TicketPojo> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	public TicketPojo addTicketDetail(TicketPojo ticketDetail) {
		getTicketDetails().add(ticketDetail);
		ticketDetail.setScheduleDetail(this);

		return ticketDetail;
	}

	public TicketPojo removeTicketDetail(TicketPojo ticketDetail) {
		getTicketDetails().remove(ticketDetail);
		ticketDetail.setScheduleDetail(null);

		return ticketDetail;
	}

}