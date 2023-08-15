package com.kuebiko.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuebiko.dao.entity.CreditCardType;

@Repository
public interface CreditCardTypesRepository extends JpaRepository<CreditCardType, Integer> {
	
	public Optional<CreditCardType> findByName(String name);
}
