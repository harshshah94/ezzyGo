package com.app.ezzygo.pojos;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "CityDetails")
@NamedQuery(name = "CityPojo.findAll", query = "SELECT c FROM CityPojo c")
public class CityPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cityId",columnDefinition="number(7)",nullable=false)
	private Long cityId;

	@Column(name = "cityName",columnDefinition="varchar2(30)",nullable=false,unique=true)
	private String cityName;

	@Column(name = "stateName",columnDefinition="varchar2(30)",nullable=false)
	private String stateName;

	@OneToMany(mappedBy = "cityDetail")
	private Collection<BoardingPojo> boardingDetails = new ArrayList<BoardingPojo>();

	public CityPojo() {
	}

	public CityPojo(String cityName, String stateName) {
		super();
		this.cityName = cityName;
		this.stateName = stateName;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Collection<BoardingPojo> getBoardingDetails() {
		return this.boardingDetails;
	}

	public void setBoardingDetails(Collection<BoardingPojo> boardingDetails) {
		this.boardingDetails = boardingDetails;
	}

	public BoardingPojo addBoardingDetail(BoardingPojo boardingDetail) {
		getBoardingDetails().add(boardingDetail);
		boardingDetail.setCityDetail(this);

		return boardingDetail;
	}

	public BoardingPojo removeBoardingDetail(BoardingPojo boardingDetail) {
		getBoardingDetails().remove(boardingDetail);
		boardingDetail.setCityDetail(null);

		return boardingDetail;
	}
}