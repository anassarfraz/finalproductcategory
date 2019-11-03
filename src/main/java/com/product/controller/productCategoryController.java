
package com.product.controller;


//import java.lang.invoke.MethodHandles.productcategory;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.model.ProductCategory;
import com.product.repository.productCategoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/productcategory")
public class productCategoryController {
	private static final Logger log = LoggerFactory.getLogger(productCategoryController.class);
	
	
	@Autowired
	private productCategoryRepository productcategoryrepository;

	@RequestMapping (method = RequestMethod.GET)
	public String findAll() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /productcategory");
		
		
		String rtn;
		List<ProductCategory> productcategory = productcategoryrepository.findActive();
		
		rtn = mapper.writeValueAsString(productcategory);
		
		return rtn;
		
	}

	@RequestMapping (value ="/all", method = RequestMethod.GET)
	public String getAll() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /productcategory/all");
			
		
		String rtn;
		List<ProductCategory> productcategory = productcategoryrepository.findAll();
		
		rtn = mapper.writeValueAsString(productcategory);
		
		return rtn;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getOne(@PathVariable Long id) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /productcategory/"+id);
		
		
		String rtn;
		ProductCategory productcategory = productcategoryrepository.findOne(id);
		
		rtn = mapper.writeValueAsString(productcategory);
		
		return rtn;
		
	}
	
	
	
	///////////

	@RequestMapping(method = RequestMethod.POST)
	public String insert(@RequestBody String data)
			throws JsonProcessingException, JSONException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		

		log.info("POST: /productcategory");
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		ProductCategory productcategory = new ProductCategory();
		String rtn ;//, workstation = null;
		
		
		

		if (!jsonObj.has("productcategory_NAME")) {
			errorDataLog( "product category", "name  is missing");
		}
		productcategory.setPRODUCTCATEGORY_NAME(jsonObj.getString("PRODUCTCATEGORY_NAME"));
		
		
		if (jsonObj.has("productcategory_DESC")) {
			errorDataLog( "product category", "Description  is missing");
			
		}
		productcategory.setPRODUCTCATEGORY_DESC(jsonObj.getString("productcategory_DESC"));
		
		
		productcategory.setISACTIVE("Y");
	
		productcategory = productcategoryrepository.saveAndFlush(productcategory);
		rtn = mapper.writeValueAsString(productcategory);



		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;

	}

	private void errorDataLog(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	//////////
	
	
}
