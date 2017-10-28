package com.app.ezzygo.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "LayoutDetails" database table.
 * 
 */
@Entity
@Table(name="\"LayoutDetails\"")
@NamedQuery(name="LayoutPojo.findAll", query="SELECT l FROM LayoutPojo l")
public class LayoutPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"layoutId\"")
	private long layoutId;

	@Column(name="\"busId\"")
	private BigDecimal busId;

	@Column(name="\"deck\"")
	private String deck;

	@Column(name="\"rowNumber\"")
	private BigDecimal rowNumber;

	@Column(name="\"seatId\"")
	private BigDecimal seatId;

	@Column(name="\"seatName\"")
	private String seatName;

	@Column(name="\"seatType\"")
	private String seatType;

	//bi-directional many-to-one association to BusPojo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private BusPojo busDetail;

	public LayoutPojo() {
	}

	public long getLayoutId() {
		return this.layoutId;
	}

	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}

	public BigDecimal getBusId() {
		return this.busId;
	}

	public void setBusId(BigDecimal busId) {
		this.busId = busId;
	}

	public String getDeck() {
		return this.deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}

	public BigDecimal getRowNumber() {
		return this.rowNumber;
	}

	public void setRowNumber(BigDecimal rowNumber) {
		this.rowNumber = rowNumber;
	}

	public BigDecimal getSeatId() {
		return this.seatId;
	}

	public void setSeatId(BigDecimal seatId) {
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