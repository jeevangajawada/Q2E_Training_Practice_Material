package com.iiht.training.eloan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.exception.CustomerNotFoundException;
import com.iiht.training.eloan.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto userDto, BindingResult result){
		
		if(result.hasErrors()) {
			throw new CustomerNotFoundException("Invalid data format!");
		}
		
		System.out.println("after-register -> " + userDto);
		
		UserDto outputDto = new UserDto();
		outputDto = this.customerService.register(userDto);
		
		System.out.println("outputDto -> " + outputDto);
		
		ResponseEntity<UserDto> response = new ResponseEntity<UserDto> (outputDto, HttpStatus.OK);
		
		return response;
	}
	
	/*
	 * @PostMapping("/interviews") public ResponseEntity<Object>
	 * createInterview(@Valid @RequestBody Interview interview) {
	 * 
	 * return interviewRestService.createInterview(interview);
	 * 
	 * }
	 */
	
	@PostMapping("/apply-loan/{customerId}")
	public ResponseEntity<LoanOutputDto> applyLoan(@PathVariable Long customerId,
												 @RequestBody LoanDto loanDto){
		return null;
	}
	
	@GetMapping("/loan-status/{loanAppId}")
	public ResponseEntity<LoanOutputDto> getStatus(@PathVariable Long loanAppId){
		return null;
	}
	
	@GetMapping("/loan-status-all/{customerId}")
	public ResponseEntity<List<LoanOutputDto>> getStatusAll(@PathVariable Long customerId){
		return null;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(CustomerNotFoundException ex){
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getMessage(),
									  System.currentTimeMillis(),
									  HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response =
				new ResponseEntity<ExceptionResponse>(exception, HttpStatus.NOT_FOUND);
		return response;
	}
}
