package com.springboot.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.web.dao.SignupRepository;
import com.springboot.web.dto.SignupDTO;
import com.springboot.web.entity.SignupEntity;



//This annotation is used to create a bean of service layer
@Service
public class SignupService {
	
	@Autowired
	private SignupRepository  signupRepository;
	
	public byte[] findUserPhoto(int sid) {
		SignupEntity signupEntity=signupRepository.findById(sid).get();
		//WE ARE CHANGING IT
		return signupEntity.getPphoto();
	}
	
	@Transactional
	public void updateProfileByEmail(SignupDTO signupDTO) {
		SignupEntity signupEntity=signupRepository.findByEmail(signupDTO.getEmail()).get();
		//WE ARE CHANGING IT
		signupEntity.setName(signupDTO.getName()); // this is edited name coming from GUI
		signupEntity.setGender(signupDTO.getGender());// this is edited gender coming from GUI
		signupEntity.setDom(new Timestamp(new Date().getTime()));
		signupEntity.setPphoto(signupDTO.getPphoto());// this is edited name coming from GUI
	}
	
	@Transactional
	public void updateProfile(SignupDTO signupDTO) {
		SignupEntity signupEntity=signupRepository.findById(signupDTO.getSid()).get();
		//WE ARE CHANGING IT
		signupEntity.setName(signupDTO.getName()); // this is edited name coming from GUI
		signupEntity.setGender(signupDTO.getGender());// this is edited gender coming from GUI
		signupEntity.setDom(new Timestamp(new Date().getTime()));
		signupEntity.setPphoto(signupDTO.getPphoto());// this is edited name coming from GUI
	}
	
	

	
	public void persist(SignupDTO signupDTO) {
		  //  /WEB-INF/login.jsp
		   //JDBC PROGRAMMING
//		signupDTO.setRole(Role.CUSTOMER.getValue());
		SignupEntity  entity=new SignupEntity();
		BeanUtils.copyProperties(signupDTO, entity);
		entity.setDoe(new Timestamp(new Date().getTime()));
		entity.setDom(new Timestamp(new Date().getTime()));
		signupRepository.save(entity);
	}
	
	public List<SignupDTO>  findAllByRole(String role) {
		 List<SignupEntity> entityList=signupRepository.findByRole(role);
		 return convertIntoDTO(entityList);
	}
	
	public List<SignupDTO>  findAll() {
		 List<SignupEntity> entityList=signupRepository.findAll();
		 return convertIntoDTO(entityList);
	}
	
	private List<SignupDTO> convertIntoDTO( List<SignupEntity> entityList){
		 List<SignupDTO> dtosList=new ArrayList<SignupDTO>();
		 for(SignupEntity entity : entityList) {
			 SignupDTO dto=new SignupDTO();
			 BeanUtils.copyProperties(entity, dto);

			 dtosList.add(dto);
		 }
		 return dtosList;
	}
	
	public Optional<SignupDTO> findByEmailAndPassword(String email,String password) {
		Optional<SignupEntity> optional=signupRepository.findByEmailAndPassword(email,password);
		SignupDTO signupDTO = null;
		if (optional.isPresent()) {
			signupDTO=new SignupDTO();
			BeanUtils.copyProperties(optional.get(), signupDTO);
		}
		// Optional - class which was introduce java8 -2014
		return Optional.ofNullable(signupDTO);
	}
	
	
	//Optional<SignupEntity> - >> Optional<SignupDTO>
	public Optional<SignupDTO> findByName(String name) {
		Optional<SignupEntity> optional=signupRepository.findByName(name);
		SignupDTO signupDTO = null;
		if (optional.isPresent()) {
			signupDTO=new SignupDTO();
			BeanUtils.copyProperties(optional.get(), signupDTO);
		}
		// Optional - class which was introduce java8 -2014
		return Optional.ofNullable(signupDTO);
	}
	
	
	//Optional<SignupEntity> - >> Optional<SignupDTO>
		public Optional<SignupDTO> findBySid(int sid) {
			Optional<SignupEntity> optional=signupRepository.findById(sid);
			SignupDTO signupDTO = null;
			if (optional.isPresent()) {
				signupDTO=new SignupDTO();
				BeanUtils.copyProperties(optional.get(), signupDTO);
			}
			// Optional - class which was introduce java8 -2014
			return Optional.ofNullable(signupDTO);
		}
	
	//Optional<SignupEntity> - >> Optional<SignupDTO>
	public Optional<SignupDTO> findByEmail(String email) {
		Optional<SignupEntity> optional=signupRepository.findByEmail(email);
		SignupDTO signupDTO = null;
		if (optional.isPresent()) {
			signupDTO=new SignupDTO();
			BeanUtils.copyProperties(optional.get(), signupDTO);
			
		}
		// Optional - class which was introduce java8 -2014
		return Optional.ofNullable(signupDTO);
	}
	
	
	public List<SignupDTO> findRecords(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<SignupEntity> page = signupRepository.findAll(pageable);
		List<SignupEntity> products = page.getContent();
		List<SignupDTO> dtosList = new ArrayList<SignupDTO>();
		for (SignupEntity entity : products) {
			SignupDTO dto = new SignupDTO();
			BeanUtils.copyProperties(entity, dto);

			dtosList.add(dto);
		}
		return dtosList;
	}

	@Transactional
	public void updatePassword(String email,String password) {
		
		SignupEntity entity=signupRepository.findByEmail(email).get();
		entity.setPassword(password);
	}
	
	public void updatePasswordByEmail(String email, String newPassword) {
		signupRepository.updatePasswordByEmail(newPassword, email);
	}

	public void deleteById(int sid) {
		signupRepository.deleteById(sid);
		
	}



}
