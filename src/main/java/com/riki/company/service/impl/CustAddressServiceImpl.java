package com.riki.company.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.riki.company.domain.CustomerAddress;
import com.riki.company.dto.CustAddressCreateRequestDTO;
import com.riki.company.dto.CustAddressDetailResponseDTO;
import com.riki.company.dto.CustAddressListResponseDTO;
import com.riki.company.dto.CustAddressUpdateRequestDTO;
import com.riki.company.repository.CustAddressRepository;
import com.riki.company.service.CustAddressService;
import com.riki.exception.ResourceNotFoundException;


@Service
public class CustAddressServiceImpl implements CustAddressService {

	@Autowired
	private CustAddressRepository custAddressRepository;

	/*
	@Override
	public void createNewCustAddress(CustAddressCreateRequestDTO dto) {
		CustomerAddress custAddress = new CustomerAddress();
		custAddress.setProvince(dto.getProvince());
		custAddress.setAddress(dto.getAddress());
		custAddress.setCustomer(dto.getCustomer());
		custAddressRepository.save(custAddress);
	}
	*/
	
	@Override
	public CustomerAddress createNewCustAddress(CustAddressCreateRequestDTO dto) {
		CustomerAddress custAddress = new CustomerAddress();
		custAddress.setProvince(dto.getProvince());
		custAddress.setAddress(dto.getAddress());
		custAddress.setCustomer(dto.getCustomer());
		return custAddressRepository.save(custAddress);
	}

	@Override
	public CustAddressDetailResponseDTO findCustAddress(Long id) {
		CustAddressDetailResponseDTO dto = new CustAddressDetailResponseDTO();
		CustomerAddress customerAddress = custAddressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("customer_address.not.found"));
		dto.setAddress(customerAddress.getAddress());
		dto.setProvince(customerAddress.getProvince());
		dto.setCustomer(customerAddress.getCustomer());
		return dto;
	}

	@Override
	public List<CustAddressListResponseDTO> findCustomerAddressAll(String address) {
		address = ObjectUtils.isEmpty(address) ? "%" : "%" + address + "%";
		
		List<CustomerAddress> customerAddressResponses = custAddressRepository.findAllByAddressLike(address);
		
		return customerAddressResponses.stream().map((ca) -> {
			CustAddressListResponseDTO dto = new CustAddressListResponseDTO();
			dto.setId(ca.getId());
			dto.setAddress(ca.getAddress());
			dto.setProvince(ca.getProvince());
			dto.setCustomer(ca.getCustomer());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void updateCustomerAddress(Long id, CustAddressUpdateRequestDTO dto) {
		CustomerAddress custAddress = custAddressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("customer_address.not.found"));
		custAddress.setAddress(dto.getAddress());
		custAddress.setProvince(dto.getProvince());
		custAddress.setCustomer(dto.getCustomer());
		custAddressRepository.save(custAddress);
	}

	@Override
	public void deleteCustomerAddress(Long id) {
		CustomerAddress custAddress = custAddressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("customer_address.not.found"));
		custAddressRepository.delete(custAddress);
	}
	
}
