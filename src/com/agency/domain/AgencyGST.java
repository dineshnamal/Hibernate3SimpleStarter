package com.agency.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AgencyGST {
	
	@Column(name = "GST_NAME")
	private String gstName;
	
	@Column(name = "GST_PERCENTAGE")
	private BigDecimal gstPercentage;
	
	@Column(name = "GST_TAX_CODE")
	private String gstTaxCode;

	public String getGstName() {
		return gstName;
	}

	public void setGstName(String gstName) {
		this.gstName = gstName;
	}

	public BigDecimal getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(BigDecimal gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public String getGstTaxCode() {
		return gstTaxCode;
	}

	public void setGstTaxCode(String gstTaxCode) {
		this.gstTaxCode = gstTaxCode;
	}

}
