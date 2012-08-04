package com.narratage.reserve.user.bean;

import java.util.Date;

public class UserBean {
	
	private String user_id;
	private String password;
	private String name;
	private String phone;
	private String jumin;
	private String address;
	private boolean sex;
	private int hint;
	private String answer;
	private boolean receive_mail;
	private boolean receive_sms;
	private String passport_number;
	private Date passport_date;
	private int passport_country;
	private double mileage;
	private String job;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getHint() {
		return hint;
	}
	public void setHint(int hint) {
		this.hint = hint;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isReceive_mail() {
		return receive_mail;
	}
	public void setReceive_mail(boolean receive_mail) {
		this.receive_mail = receive_mail;
	}
	public boolean isReceive_sms() {
		return receive_sms;
	}
	public void setReceive_sms(boolean receive_sms) {
		this.receive_sms = receive_sms;
	}
	public String getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}
	public Date getPassport_date() {
		return passport_date;
	}
	public void setPassport_date(Date passport_date) {
		this.passport_date = passport_date;
	}
	public int getPassport_country() {
		return passport_country;
	}
	public void setPassport_country(int passport_country) {
		this.passport_country = passport_country;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
