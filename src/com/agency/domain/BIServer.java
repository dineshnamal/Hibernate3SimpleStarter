package com.agency.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;
@Embeddable
public class BIServer {
	@Column(name = "BI_SERVER_ADDRESS")
	private String biServerAddress;

	@Column(name = "BI_ADMIN_USERNAME")
	private String biAdminUsername;

	@Column(name = "BI_ADMIN_PASSWORD")
	private String biAdminPassword;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "DEFAULT_YELLOWFIN_BI_ROLE_ID")
	// @ForeignKey(name = "FK_YF_AGENCY_YF_ROLE")
	// private YellowfinBIRole defaultYellowfinBIRole;

	// @Column(name = "DEFAULT_REPORTING_ENGINE")
	// @Enumerated(EnumType.STRING)
	// private ReportingEngineEnum defaultReportingEngine;

	@Column(name = "SHOW_ALTERNATIVE_REPORTING_ENGINE")
	@Type(type = "org.hibernate.type.YesNoType")
	// @DefaultBoolean(defaultValue = false)
	private Boolean showAlternativeReportingEngine;

	// @Column(name = "DEFAULT_REPORTING_ENGINE_FOR_ONLINE_USERS")
	// @Enumerated(EnumType.STRING)
	// private ReportingEngineEnum defaultReportingEngineForOnlineUsers;

	@Column(name = "SHOW_ALTERNATIVE_REPORTING_ENGINE_FOR_ONLINE_USERS")
	@Type(type = "org.hibernate.type.YesNoType")
	// @DefaultBoolean(defaultValue = false)
	private Boolean showAlternativeReportingEngineForOnlineUsers;

	public String getBiServerAddress() {
		return biServerAddress;
	}

	public void setBiServerAddress(String biServerAddress) {
		this.biServerAddress = biServerAddress;
	}

	public String getBiAdminUsername() {
		return biAdminUsername;
	}

	public void setBiAdminUsername(String biAdminUsername) {
		this.biAdminUsername = biAdminUsername;
	}

	public String getBiAdminPassword() {
		return biAdminPassword;
	}

	public void setBiAdminPassword(String biAdminPassword) {
		this.biAdminPassword = biAdminPassword;
	}

	public Boolean getShowAlternativeReportingEngine() {
		return showAlternativeReportingEngine;
	}

	public void setShowAlternativeReportingEngine(Boolean showAlternativeReportingEngine) {
		this.showAlternativeReportingEngine = showAlternativeReportingEngine;
	}

	public Boolean getShowAlternativeReportingEngineForOnlineUsers() {
		return showAlternativeReportingEngineForOnlineUsers;
	}

	public void setShowAlternativeReportingEngineForOnlineUsers(Boolean showAlternativeReportingEngineForOnlineUsers) {
		this.showAlternativeReportingEngineForOnlineUsers = showAlternativeReportingEngineForOnlineUsers;
	}

}
