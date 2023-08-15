package com.kuebiko.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.kuebiko.dao.CreditCardTypesRepository;
import com.kuebiko.dao.entity.CreditCardType;
import com.kuebiko.service.dto.CreditCardTypeDTO;
import com.kuebiko.service.dto.PatchDTO;

@Service
@Scope("singleton")
public class CreditCardTypeService {

	@Autowired
	private CreditCardTypesRepository cardTypesRepository;

	public void deleteById(int ctid) {
		cardTypesRepository.deleteById(ctid);
	}

	public CreditCardTypeDTO findCardDetailsByName(String name) {
		Optional<CreditCardType> creditCardType = cardTypesRepository.findByName(name);
		CreditCardTypeDTO cardTypeDTO = new CreditCardTypeDTO();
		BeanUtils.copyProperties(creditCardType.get(), cardTypeDTO);
		return cardTypeDTO;
	}

	public List<CreditCardTypeDTO> findAll() {
		List<CreditCardType> crediCardList = cardTypesRepository.findAll();
		List<CreditCardTypeDTO> list = new ArrayList<CreditCardTypeDTO>();
		for (CreditCardType crt : crediCardList) {
			CreditCardTypeDTO cardTypeDTO = new CreditCardTypeDTO();
			BeanUtils.copyProperties(crt, cardTypeDTO);
			list.add(cardTypeDTO);
		}
		return list;
	}

	public byte[] findById(int cctid) {
		CreditCardType creditCardType = cardTypesRepository.findById(cctid).get();
		return creditCardType.getPhoto();
	}

	public void save(PatchDTO patchDTO) {
		CreditCardType creditCardType = cardTypesRepository.findById(patchDTO.getId()).get();
		if ("benefit1".equalsIgnoreCase(patchDTO.getName())) {
			creditCardType.setBenefit1(patchDTO.getValue());
		} else if ("benefit2".equalsIgnoreCase(patchDTO.getName())) {
			creditCardType.setBenefit2(patchDTO.getValue());
		} else if ("benefit3".equalsIgnoreCase(patchDTO.getName())) {
			creditCardType.setBenefit3(patchDTO.getValue());
		} else if ("benefit4".equalsIgnoreCase(patchDTO.getName())) {
			creditCardType.setBenefit4(patchDTO.getValue());
		}
		cardTypesRepository.save(creditCardType);
	}

	public void save(CreditCardTypeDTO creditCardTypeDTO) {
		CreditCardType entity = new CreditCardType();
		BeanUtils.copyProperties(creditCardTypeDTO, entity);
		entity.setDoe(new Timestamp(new Date().getTime()));
		entity.setDom(new Timestamp(new Date().getTime()));
		// Set unique card type number
		Random random = new Random();
		StringBuilder number = new StringBuilder();
		number.append(String.format("%03d", random.nextInt(1000)));
		entity.setCcode("cardType-" + number);
		cardTypesRepository.save(entity);
	}

	public void update(CreditCardTypeDTO creditCardTypeDTO) {
		CreditCardType dbCreditCardType = cardTypesRepository.findById(creditCardTypeDTO.getId()).get();
		dbCreditCardType.setDom(new Timestamp(new Date().getTime()));
		dbCreditCardType.setAnnualFee(creditCardTypeDTO.getAnnualFee());
		dbCreditCardType.setBenefit1(creditCardTypeDTO.getBenefit1());
		dbCreditCardType.setBenefit2(creditCardTypeDTO.getBenefit2());
		dbCreditCardType.setBenefit3(creditCardTypeDTO.getBenefit3());
		dbCreditCardType.setBenefit4(creditCardTypeDTO.getBenefit4());
		cardTypesRepository.save(dbCreditCardType);
	}

}
