package com.riki.company.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riki.company.dto.UserDetailResponseDTO;
import com.riki.company.service.AppUserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserResource {

	private final AppUserService appUserService;
	
	@GetMapping("/v1/user")
	public ResponseEntity<UserDetailResponseDTO> findUserDetail() {
		return ResponseEntity.ok(appUserService.findUserDetail());
	}
}
