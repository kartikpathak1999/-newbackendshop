package com.kartikeya.product.controller;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartikeya.product.ProductServiceApplication;
import com.kartikeya.product.entity.Product;
import com.kartikeya.product.exception.NoProperDataException;
import com.kartikeya.product.service.ProductServiceImpl;
import com.kartikeya.product.service.SequenceGeneratorService;

@SpringBootTest
//@AutoConfigureMockMvc
//@ContextConfiguration(classes = ProductServiceApplication.class)
//@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
public class ProductControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	@MockBean
	private ProductServiceImpl productserviceImpl;
	
	
	MockMvc mockMvc;
	
	@BeforeEach
	void printApplicationContext() {
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    //This  
	    Arrays.stream(webApplicationContext.getBeanDefinitionNames())
	            .map(name -> webApplicationContext.getBean(name).getClass().getName())
	            .sorted()
	            .forEach(System.out::println);
	}
	
	
	@Test
	void testPlanterServiceNotNull() {
		assertThat(productserviceImpl).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
	   @Test
	    void testShowProducts() throws Exception {
	        Product p1 = new Product(233, "Electronics", "iPhone", "Mobile", "5", "good", "url",
	        		"50000","desc","specs");
	        Product p2 = new Product(333, "Electronics", "iPhone", "Mobile", "5", "good", "url",
	        		"50000","desc","specs");
	        List<Product> productList = new ArrayList<Product>();
	        productList.add(p1);
	        productList.add(p2);
	        when(productserviceImpl.getAllCustomers()).thenReturn(productList);
	        mockMvc.perform(get("/product/allproducts"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json"))
	                .andExpect(jsonPath("$[*]", hasSize(2)))
	                .andExpect(jsonPath("$[0].cust_id").value(233))
	                .andExpect(jsonPath("$[0].productType").value("Electronics"))
	                .andExpect(jsonPath("$[0].productName").value("iPhone"))
	                .andExpect(jsonPath("$[0].category").value("Mobile"))
	                .andExpect(jsonPath("$[0].rating").value("5"))
	                .andExpect(jsonPath("$[0].review").value("good"))
	                .andExpect(jsonPath("$[0].imageUrl").value("url"))
	                .andExpect(jsonPath("$[0].price").value("50000"))
	                .andExpect(jsonPath("$[0].description").value("desc"))
	                .andExpect(jsonPath("$[0].specification").value("specs"));

	    }
}
