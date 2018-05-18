package com.agency.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "BRANCH")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BRANCH_ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "branchList")
	private Collection<BranchCommissionConfig> branchCommissionConfigList = new ArrayList<BranchCommissionConfig>();

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name = "PARENT_BRANCH_ID")
	// @ForeignKey(name = "FK_B_PARENT_BRANCH")
	private Branch parentBranch;

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

	public Collection<BranchCommissionConfig> getBranchCommissionConfigList() {
		return branchCommissionConfigList;
	}

	public void setBranchCommissionConfigList(Collection<BranchCommissionConfig> branchCommissionConfigList) {
		this.branchCommissionConfigList = branchCommissionConfigList;
	}

	public Branch getParentBranch() {
		return parentBranch;
	}

	public void setParentBranch(Branch parentBranch) {
		this.parentBranch = parentBranch;
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
