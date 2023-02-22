package com.ragu.SpringBoot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shopmall {
        
	@Id
	private int shopno;
	private String shopname;
	private String shopaddress;
	private String cityname;
	
	
	public String toString() {
		return shopname+ " : " +shopno+  " :" +shopaddress+ ":" +cityname;
	}
	
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getShopno() {
		return shopno;
	}
	public void setShopno(int shopno) {
		this.shopno = shopno;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopaddress() {
		return shopaddress;
	}
	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}
}
