package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "BoardingDetails" database table.
 * 
 */
@Entity
@Table(name="\"BoardingDetails\"")
@NamedQuery(name="BoardingPojo.findAll", query="SELECT b FROM BoardingPojo b")
public class BoardingPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"boardingId\"")
	private long boardingId;

	@Column(name="\"address\"")
	private String address;

	@Column(name="\"cityId\"")
	private java.math.BigDecimal cityId;

	@Column(name="\"contact1\"")
	private String contact1;

	@Column(name="\"contact2\"")
	private String contact2;

	@Column(name="\"name\"")
	private String name;

	//bi-directional many-to-one association to CityPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private CityPojo cityDetail;

	//bi-directional many-to-one association to TicketPojo
	@OneToMany(mappedBy="boardingDetail")
	private List<TicketPojo> ticketDetails;

	public BoardingPojo() {
	}

	public long getBoardingId() {
		return this.boardingId;
	}

	public void setBoardingId(long boardingId) {
		this.boardingId = boardingId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.math.BigDecimal getCityId() {
		return this.cityId;
	}

	public void setCityId(java.math.BigDecimal cityId) {
		this.cityId = cityId;
	}

	public String getContact1() {
		return this.contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return this.contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityPojo getCityDetail() {
		return this.cityDetail;
	}

	public void setCityDetail(CityPojo cityDetail) {
		this.cityDetail = cityDetail;
	}

	public List<TicketPojo> getTicketDetails() {
		return this.ticketDetails;
	}

	public void setTicketDetails(List<TicketPojo> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	public TicketPojo addTicketDetail(TicketPojo ticketDetail) {
		getTicketDetails().add(ticketDetail);
		ticketDetail.setBoardingDetail(this);

		return ticketDetail;
	}

	public TicketPojo removeTicketDetail(TicketPojo ticketDetail) {
		getTicketDetails().remove(ticketDetail);
		ticketDetail.setBoardingDetail(null);

		return ticketDetail;
	}

}