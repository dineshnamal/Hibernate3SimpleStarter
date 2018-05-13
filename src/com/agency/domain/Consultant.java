package com.agency.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "consultant")
@Entity
public class Consultant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONSULTANT_ID")
	private Integer id;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "NAME")
	private String name;

	@Column(name = "POSITION")
	private String position;

	@Column(name = "WORK_PHONE")
	private String workPhone;

	@Column(name = "HOME_MOBILE_PHONE")
	private String homeMobilePhone;

	@Column(name = "FAX")
	private String fax;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "REPORTING_EMAIL")
	private String reportingEmail;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getHomeMobilePhone() {
		return homeMobilePhone;
	}

	public void setHomeMobilePhone(String homeMobilePhone) {
		this.homeMobilePhone = homeMobilePhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReportingEmail() {
		return reportingEmail;
	}

	public void setReportingEmail(String reportingEmail) {
		this.reportingEmail = reportingEmail;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
