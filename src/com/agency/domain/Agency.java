package com.agency.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCY")
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AGENCY_ID")
	private Integer id;

	@Column(name = "CODE")
	private String code;

}
