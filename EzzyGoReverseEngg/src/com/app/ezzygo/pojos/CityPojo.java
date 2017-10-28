package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "CityDetails" database table.
 * 
 */
@Entity
@Table(name="\"CityDetails\"")
@NamedQuery(name="CityPojo.findAll", query="SELECT c FROM CityPojo c")
public class CityPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"cityId\"")
	private long cityId;

	@Column(name="\"cityName\"")
	private String cityName;

	@Column(name="\"stateName\"")
	private String stateName;

	//bi-directional many-to-one association to BoardingPojo
	@OneToMany(mappedBy="cityDetail")
	private List<BoardingPojo> boardingDetails;

	//bi-directional many-to-one association to SchedulePojo
	@OneToMany(mappedBy="cityDetail1")
	private List<SchedulePojo> scheduleDetails1;

	//bi-directional many-to-one association to SchedulePojo
	@OneToMany(mappedBy="cityDetail2")
	private List<SchedulePojo> scheduleDetails2;

	public CityPojo() {
	}

	public long getCityId() {
		return this.cityId;
	}

	public void setCityId(long cityId) {
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

	public List<BoardingPojo> getBoardingDetails() {
		return this.boardingDetails;
	}

	public void setBoardingDetails(List<BoardingPojo> boardingDetails) {
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

	public List<SchedulePojo> getScheduleDetails1() {
		return this.scheduleDetails1;
	}

	public void setScheduleDetails1(List<SchedulePojo> scheduleDetails1) {
		this.scheduleDetails1 = scheduleDetails1;
	}

	public SchedulePojo addScheduleDetails1(SchedulePojo scheduleDetails1) {
		getScheduleDetails1().add(scheduleDetails1);
		scheduleDetails1.setCityDetail1(this);

		return scheduleDetails1;
	}

	public SchedulePojo removeScheduleDetails1(SchedulePojo scheduleDetails1) {
		getScheduleDetails1().remove(scheduleDetails1);
		scheduleDetails1.setCityDetail1(null);

		return scheduleDetails1;
	}

	public List<SchedulePojo> getScheduleDetails2() {
		return this.scheduleDetails2;
	}

	public void setScheduleDetails2(List<SchedulePojo> scheduleDetails2) {
		this.scheduleDetails2 = scheduleDetails2;
	}

	public SchedulePojo addScheduleDetails2(SchedulePojo scheduleDetails2) {
		getScheduleDetails2().add(scheduleDetails2);
		scheduleDetails2.setCityDetail2(this);

		return scheduleDetails2;
	}

	public SchedulePojo removeScheduleDetails2(SchedulePojo scheduleDetails2) {
		getScheduleDetails2().remove(scheduleDetails2);
		scheduleDetails2.setCityDetail2(null);

		return scheduleDetails2;
	}

}