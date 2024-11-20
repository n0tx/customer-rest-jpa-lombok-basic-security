package com.riki.company.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.riki.company.dto.UserDetailResponseDTO;

public interface AppUserService extends UserDetailsService {
	public UserDetailResponseDTO findUserDetail();
}
