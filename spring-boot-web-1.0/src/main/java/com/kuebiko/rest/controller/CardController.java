package com.kuebiko.rest.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.kuebiko.service.CreditCardTypeService;
import com.kuebiko.service.dto.AppResponse;
import com.kuebiko.service.dto.CreditCardTypeDTO;
import com.kuebiko.service.dto.ImageResponse;
import com.kuebiko.service.dto.PatchDTO;

@RestController
@RequestMapping("/v1")
public class CardController {

	@Autowired
	private CreditCardTypeService creditCardTypeService;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
		// Convert multipart object to byte[]
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	@PatchMapping("/cardtypes")
	@ResponseStatus(code = HttpStatus.OK)
	public AppResponse updateCardType(@RequestBody PatchDTO patchDTO)
			throws IOException {
		creditCardTypeService.save(patchDTO);
		AppResponse appResponse = new AppResponse();
		appResponse.setCode("C213");
		appResponse.setMessage(patchDTO.getName()+" is updated");
		return appResponse;
	}
	
	
	@PutMapping("/cardtypes")
	@ResponseStatus(code = HttpStatus.OK)
	public AppResponse updateCardType(@RequestBody CreditCardTypeDTO creditCardTypeDTO, Model model)
			throws IOException {
		creditCardTypeService.save(creditCardTypeDTO);
		AppResponse appResponse = new AppResponse();
		appResponse.setCode("C213");
		appResponse.setMessage("Updated");
		return appResponse;
	}

	@DeleteMapping("/cardtypes/{ctid}")
	@ResponseStatus(code = HttpStatus.OK)
	public AppResponse deleteCardType(@PathVariable int ctid) {
		creditCardTypeService.deleteById(ctid);
		AppResponse appResponse = new AppResponse();
		appResponse.setCode("C213");
		appResponse.setMessage("Deleted");
		return appResponse;
	}

	@PostMapping("/cardtypes")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AppResponse createCardType(@RequestBody CreditCardTypeDTO creditCardTypeDTO, Model model)
			throws IOException {
		System.out.println("The values from the credit card type form are: " + creditCardTypeDTO);
		creditCardTypeService.save(creditCardTypeDTO);
		AppResponse appResponse = new AppResponse();
		appResponse.setCode("C213");
		appResponse.setMessage("Created");
		return appResponse;
	}

	@GetMapping("/cardtypes")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CreditCardTypeDTO> showCards() {
		List<CreditCardTypeDTO> cardTypeDTOs = creditCardTypeService.findAll();
		return cardTypeDTOs;
	}

	@GetMapping("/cardtypes/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public CreditCardTypeDTO getCardDetails(@PathVariable String name) {
		CreditCardTypeDTO cardTypeDTO = creditCardTypeService.findCardDetailsByName(name);
		return cardTypeDTO;
	}
	
	@GetMapping("/cardtypes/count")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String,Object> getCardTypeCount() {
	    
	    List<CreditCardTypeDTO> cardTypeDTOs = creditCardTypeService.findAll();
	    
	    Map<String,Object> map =new LinkedHashMap<>();
	    map.put("totalCount",cardTypeDTOs.size());
	    map.put("description","Credit Card Type!");
		return map; //when return map = it will be converted as JSON
	}

	@GetMapping("/cimage")
	@ResponseStatus(code = HttpStatus.OK)
	public ImageResponse loadImage(@RequestParam int ctid) throws IOException {
		// Fetch photo
		byte[] photo = creditCardTypeService.findById(ctid);
		ImageResponse imageResponse = new ImageResponse();
		imageResponse.setImage(photo);
		imageResponse.setCtid(ctid);
		return imageResponse;
	}

}
