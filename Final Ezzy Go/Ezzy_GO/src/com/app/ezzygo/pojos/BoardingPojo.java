package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "BoardingDetails")
@NamedQuery(name = "BoardingPojo.findAll", query = "SELECT b FROM BoardingPojo b")
public class BoardingPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "boardingId",columnDefinition="number(7)",nullable=false)
	private Long boardingId;
	
	@Column(name = "name",columnDefinition="varchar2(20)",nullable=false)
	private String name;

	@Column(name = "address",columnDefinition="varchar2(50)",nullable=false)
	private String address;

	// bi-directional many-to-one association to CityPojo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityId",nullable=false)
	private CityPojo cityDetail;

	@Column(name = "contact1",columnDefinition="char(13)",nullable=false)
	private String contact1;

	@Column(name = "contact2",columnDefinition="char(13)")
	private String contact2;

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
}