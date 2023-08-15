package com.springboot.web.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.web.entity.SignupEntity;

public interface SignupRepository extends JpaRepository<SignupEntity, Integer> {
	//find - By  -  attribute
	public Optional<SignupEntity> findByName(String username);
	public Optional<SignupEntity> findByEmailAndPassword(String email,String password);
	public Optional<SignupEntity>  findByEmailOrName(String email,String name);
	public Optional<SignupEntity>  findByEmail(String email);
	public Optional<SignupEntity>  findByNameAndEmail(String username,String email);
	
	public List<SignupEntity>  findByRole(String role);
	
	@Modifying
	@Transactional
	@Query(value="update SignupEntity se SET se.password = ?1 WHERE se.email = ?2")
	public void updatePasswordByEmail(String password, String email); 
	
}
