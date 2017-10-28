package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BusDetails")
@NamedQuery(name = "BusPojo.findAll", query = "SELECT b FROM BusPojo b")
public class BusPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "busId", columnDefinition = "number(7)")
	private Long busId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agentEmail")
	private UserPojo agentDetails;

	@NotEmpty(message = "Bus name should not empty")
	@Column(name = "busName", columnDefinition = "varchar2(20)", nullable = false)
	private String busName;

	@NotEmpty(message = "Passing number should not empty")
	@Column(name = "passingNumber", columnDefinition = "varchar2(12)", nullable = false)
	private String passingNumber;

	@Column(name = "ac", columnDefinition = "char(1)", nullable = false)
	private String ac;

	@Column(name = "busType", columnDefinition = "char(8)", nullable = false)
	private String busType;

	public String getDoubleDecker() {
		return doubleDecker;
	}

	public void setDoubleDecker(String doubleDecker) {
		this.doubleDecker = doubleDecker;
	}

	@Column(name = "busStructure", columnDefinition = "char(3)", nullable = false)
	private String busStructure;

	@Column(name = "doubleDecker", columnDefinition = "char(1)", nullable = false)
	private String doubleDecker;

	// bi-directional many-to-one association to LayoutPojo
	@OneToMany(mappedBy = "busDetail")
	private List<LayoutPojo> layoutDetails = new ArrayList<>();

	// bi-directional many-to-one association to SchedulePojo
	@OneToMany(mappedBy = "busDetail")
	private List<SchedulePojo> scheduleDetails = new ArrayList<>();;

	public BusPojo() {
		ac = "Y";
		busType = "sleeping";
		doubleDecker = "Y";
	}

	public Long getBusId() {
		return this.busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public UserPojo getAgentDetails() {
		return this.agentDetails;
	}

	public void setAgentDetails(UserPojo agentDetails) {
		this.agentDetails = agentDetails;
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