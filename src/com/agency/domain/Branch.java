package com.agency.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "BRANCH")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BRANCH_ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENCY_ID")    
    @ForeignKey(name = "FK_B_AGENCY")
    private Agency agency;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	
	

}
