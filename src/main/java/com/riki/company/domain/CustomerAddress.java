package com.riki.company.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_address")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = -4690859293392789011L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "province", nullable = false)
	private String province;
	
	@Column(name = "customer", nullable = false)
	private String customer;
	
}
