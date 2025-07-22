package com.it.piv.mms.domain;

public class ApplicationObject {
	
	private String cust_type;
	private String name;
	private String address_l1;
	private String address_l2;
	private String city;
	private String tariff;
	
	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress_l2() {
		return address_l2;
	}

	public void setAddress_l2(String address_l2) {
		this.address_l2 = address_l2;
	}

	public String getAddress_l1() {
		return address_l1;
	}

	public void setAddress_l1(String address_l1) {
		this.address_l1 = address_l1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}

	@Override
	public String toString() {
		return "ApplicationObject [cust_type=" + cust_type + ", name=" + name
				+ ", address_l1=" + address_l1 + ", address_l2=" + address_l2
				+ ", city=" + city + ", tariff=" + tariff + "]";
	}
	
	
}
