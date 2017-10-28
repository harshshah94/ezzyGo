package com.app.ezzygo.pojos;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the "LayoutDetails" database table.
 * 
 */
@Entity
@Table(name = "LayoutDetails")
@NamedQuery(name = "LayoutPojo.findAll", query = "SELECT l FROM LayoutPojo l")
public class LayoutPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "layoutId",columnDefinition="number(7)",nullable=false)
	private Long layoutId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "busId")
	private BusPojo busDetail;

	@Column(name = "seatId",columnDefinition="number(2)",nullable=false)
	private Integer seatId;

	@Column(name = "seatName",columnDefinition="char(5)",nullable=false)
	private String seatName;

	@Column(name = "rowNumber",columnDefinition="number(1)",nullable=false)
	private Integer rowNumber;

	@Column(name = "seatType",columnDefinition="char(5)",nullable=false)
	private String seatType;

	@Column(name = "deck",columnDefinition="char(1)",nullable=false)
	private String deck;

	public LayoutPojo() {
	}

	public LayoutPojo(BusPojo busDetail, Integer seatId, String seatName,
			Integer rowNumber, String seatType, String deck) {
		super();
		this.busDetail = busDetail;
		this.seatId = seatId;
		this.seatName = seatName;
		this.rowNumber = rowNumber;
		this.seatType = seatType;
		this.deck = deck;
	}

	public Long getLayoutId() {
		return this.layoutId;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public String getDeck() {
		return this.deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}

	public Integer getRowNumber() {
		return this.rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getSeatId() {
		return this.seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public String getSeatName() {
		return this.seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getSeatType() {
		return this.seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public BusPojo getBusDetail() {
		return this.busDetail;
	}

	public void setBusDetail(BusPojo busDetail) {
		this.busDetail = busDetail;
	}

}