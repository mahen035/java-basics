package com.training.customersvc.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.customersvc.dto.Account;

@FeignClient(name = "account-service", url = "http://localhost:8082")
public interface AccountClient {
	
	@PostMapping("/account")
	Account addAccount(@RequestBody Account account);

}
