package com.luv2code.springboot.medylite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String reviewDesc;
	
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shopId;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users userId;
	
	public Review()
	{
		
	}

	public Review(String reviewDesc) {
		
		this.reviewDesc = reviewDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	public Shop getShopId() {
		return shopId;
	}

	public void setShopId(Shop shopId) {
		this.shopId = shopId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewDesc=" + reviewDesc + ", shopId=" + shopId + ", userId=" + userId + "]";
	}
	
	
	
}
