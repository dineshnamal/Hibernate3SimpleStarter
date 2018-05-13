package com.agency.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDITOR")
public class Creditor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CREDITOR_ID")
    private Integer id;

    @Column(name = "CREDITOR_CODE")
    private String creditorCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreditorCode() {
		return creditorCode;
	}

	public void setCreditorCode(String creditorCode) {
		this.creditorCode = creditorCode;
	}
    
    
}
