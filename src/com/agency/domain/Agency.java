package com.agency.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "AGENCY")
public class Agency {

	// @EmbeddedId
	// Private LoginName userId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Generate primary key value for me {AUTO , Identity , Sequence ,
													// Table} , most depend on the DB system.
													// Default Auto - let hibernate to decide what strategy should it
													// use
													// Identity - DB provded Identity column used
													// Sequence - HB sequence object uses to generate
													// Table - Can have seperate table that table has seperate record
													// what should be next value
	@Column(name = "AGENCY_ID")
	private Integer id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	@Lob // Lob on top of string default to CLOG - Charater log , Lob on Byte stream -//
			// BLOB ,
	private String description;

	@Column(name = "FIRST_FINANCIAL_PERIOD_DATE")
	@Temporal(TemporalType.DATE) // Do not save the time
	private Date firstFinancialPeriodDate;

	@Embedded
	private AgencyGST agencyAUGst;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "gstName", column = @Column(name = "US_GST_NAME")),
			@AttributeOverride(name = "gstTaxCode", column = @Column(name = "US_GST_TAX_CODE")),
			@AttributeOverride(name = "gstPercentage", column = @Column(name = "US_GST_PERCENTAGE")) })
	private AgencyGST agencyUSGst;
	// Collection of objects
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "AGENCY_BI_SERVER", joinColumns = @JoinColumn(name = "AGENCY_ID"))

	@GenericGenerator(name = "BINumberGenerator-uuid", strategy = "com.agency.custom.BINumberGenerator")
	@CollectionId(columns = {
			@Column(name = "AGENCY_ID_OF_BI") }, generator = "BINumberGenerator-uuid", type = @Type(type = "int"))
	// private Set<BIServer> biServers;
	private Collection<BIServer> biServers = new ArrayList<BIServer>();

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMMISSION_CREDITOR_ID")
	@ForeignKey(name = "FK_AGENCY_COMMISSION_CREDITOR")
	private Creditor commissionCreditor;

	@OneToMany
	@JoinColumn(name = "AGENCY_ID")
//	@JoinTable(name="BRANCH_SERVICE",joinColumns=@JoinColumn(name="AGENCY_ID"),inverseJoinColumns=@JoinColumn(name="BRANCH_ID"))
	private Collection<Branch> branch = new ArrayList<Branch>();

	/*
	 * @ElementCollection Create Sub table Create number of records = collection
	 * size
	 * 
	 */

	// private Set<Consultant> consult ants;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFirstFinancialPeriodDate() {
		return firstFinancialPeriodDate;
	}

	public void setFirstFinancialPeriodDate(Date firstFinancialPeriodDate) {
		this.firstFinancialPeriodDate = firstFinancialPeriodDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AgencyGST getAgencyAUGst() {
		return agencyAUGst;
	}

	public void setAgencyAUGst(AgencyGST agencyAUGst) {
		this.agencyAUGst = agencyAUGst;
	}

	public AgencyGST getAgencyUSGst() {
		return agencyUSGst;
	}

	public void setAgencyUSGst(AgencyGST agencyUSGst) {
		this.agencyUSGst = agencyUSGst;
	}

	public Collection<BIServer> getBiServers() {
		return biServers;
	}

	public void setBiServers(Collection<BIServer> biServers) {
		this.biServers = biServers;
	}

	public Creditor getCommissionCreditor() {
		return commissionCreditor;
	}

	public void setCommissionCreditor(Creditor commissionCreditor) {
		this.commissionCreditor = commissionCreditor;
	}

	public Collection<Branch> getBranch() {
		return branch;
	}

	public void setBranch(Collection<Branch> branch) {
		this.branch = branch;
	}

	// public Set<Consultant> getConsultants() {
	// return consultants;
	// }
	//
	// public void setConsultants(Set<Consultant> consultants) {
	// this.consultants = consultants;
	// }

	// public Set<BIServer> getBiServers() {
	// return biServers;
	// }
	//
	// public void setBiServers(Set<BIServer> biServers) {
	// this.biServers = biServers;
	// }
	//

}
