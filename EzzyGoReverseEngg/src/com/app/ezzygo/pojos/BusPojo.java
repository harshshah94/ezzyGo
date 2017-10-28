package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "BusDetails" database table.
 * 
 */
@Entity
@Table(name="\"BusDetails\"")
@NamedQuery(name="BusPojo.findAll", query="SELECT b FROM BusPojo b")
public class BusPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"busId\"")
	private long busId;

	@Column(name="\"ac\"")
	private String ac;

	@Column(name="\"agentEmail\"")
	private String agentEmail;

	@Column(name="\"busName\"")
	private String busName;

	@Column(name="\"busStructure\"")
	private String busStructure;

	@Column(name="\"busType\"")
	private String busType;

	@Column(name="\"passingNumber\"")
	private String passingNumber;

	//bi-directional many-to-one association to UserPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private UserPojo userDetail;

	//bi-directional many-to-one association to LayoutPojo
	@OneToMany(mappedBy="busDetail")
	private List<LayoutPojo> layoutDetails;

	//bi-directional many-to-one association to SchedulePojo
	@OneToMany(mappedBy="busDetail")
	private List<SchedulePojo> scheduleDetails;

	public BusPojo() {
	}

	public long getBusId() {
		return this.busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getAgentEmail() {
		return this.agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public String getBusName() {
		return this.busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusStructure() {
		return this.busStructure;
	}

	public void setBusStructure(String busStructure) {
		this.busStructure = busStructure;
	}

	public String getBusType() {
		return this.busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getPassingNumber() {
		return this.passingNumber;
	}

	public void setPassingNumber(String passingNumber) {
		this.passingNumber = passingNumber;
	}

	public UserPojo getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserPojo userDetail) {
		this.userDetail = userDetail;
	}

	public List<LayoutPojo> getLayoutDetails() {
		return this.layoutDetails;
	}

	public void setLayoutDetails(List<LayoutPojo> layoutDetails) {
		this.layoutDetails = layoutDetails;
	}

	public LayoutPojo addLayoutDetail(LayoutPojo layoutDetail) {
		getLayoutDetails().add(layoutDetail);
		layoutDetail.setBusDetail(this);

		return layoutDetail;
	}

	public LayoutPojo removeLayoutDetail(LayoutPojo layoutDetail) {
		getLayoutDetails().remove(layoutDetail);
		layoutDetail.setBusDetail(null);

		return layoutDetail;
	}

	public List<SchedulePojo> getScheduleDetails() {
		return this.scheduleDetails;
	}

	public void setScheduleDetails(List<SchedulePojo> scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}

	public SchedulePojo addScheduleDetail(SchedulePojo scheduleDetail) {
		getScheduleDetails().add(scheduleDetail);
		scheduleDetail.setBusDetail(this);

		return scheduleDetail;
	}

	public SchedulePojo removeScheduleDetail(SchedulePojo scheduleDetail) {
		getScheduleDetails().remove(scheduleDetail);
		scheduleDetail.setBusDetail(null);

		return scheduleDetail;
	}

}