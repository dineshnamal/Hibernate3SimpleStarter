package com.agency.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH_COMMISSION_CONFIG")
public class BranchCommissionConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BRANCH_COMMISSION_CONFIG_ID")
	private Integer id;

	@Column(name = "BRA")
	private String name;

	@ManyToMany
	private Collection<Branch> branchList = new ArrayList<Branch>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(Collection<Branch> branchList) {
		this.branchList = branchList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
