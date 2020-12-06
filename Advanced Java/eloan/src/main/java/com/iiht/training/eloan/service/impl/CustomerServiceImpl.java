package com.iiht.training.eloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UsersRepository usersRepository;
	
	// utility method
		private UserDto convertEntityToOutputDto(Users user) {
			UserDto userOutputDto = new UserDto();
			userOutputDto.setId(user.getId());
			userOutputDto.setFirstName(user.getFirstName());
			userOutputDto.setLastName(user.getLastName());
			userOutputDto.setEmail(user.getEmail());
			userOutputDto.setMobile(user.getMobile());
			return userOutputDto;
		}

		private Users covertInputDtoToEntity(UserDto userInputDto) {
			Users user = new Users();
			//user.setId(userInputDto.getId());
			user.setFirstName(userInputDto.getFirstName());
			user.setLastName(userInputDto.getLastName());
			user.setEmail(userInputDto.getEmail());
			user.setMobile(userInputDto.getMobile());
			return user;
		}
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	/*
	 * @Override public UserDto register(UserDto userDto) { // TODO Auto-generated
	 * method stub return null; }
	 */
	
	@Override
	public UserDto register(UserDto userDto) {
		// convert dto into entity
		Users registeruser = this.covertInputDtoToEntity(userDto);
		// save entity in DB : returns the copy of newly added record back
		
		System.out.println("register user" + registeruser);
		
		Users newregisteruser = this.usersRepository.save(registeruser);
		// convert entity into output dto
		
		System.out.println("register new user" + newregisteruser);
		
		UserDto userOutputDto = this.convertEntityToOutputDto(newregisteruser);
		return userOutputDto;
	}

	@Override
	public LoanOutputDto applyLoan(Long customerId, LoanDto loanDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanOutputDto getStatus(Long loanAppId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanOutputDto> getStatusAll(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
