package com.example.ElectricitySubsc;

import com.example.springweb.domObj.AddressDO;
import com.example.springweb.domObj.ElectricityBill;
import com.example.springweb.domObj.ElectricitySubscDO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class SpringwebApplicationTests {

	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	@Test
	public void testGetAllElectricity() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/electrics")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].id").exists())
				.andExpect(jsonPath("$[*].name").exists())
				.andExpect(jsonPath("$[*].lastname").exists())
				.andExpect(jsonPath("$[*].department").exists());
	}
	@Test
	public void testGetElectricityById() throws Exception{
		String electricId = "4";
		mockMvc.perform(get("/api/v1//electrics/{electricId}", electricId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.lastname").exists())
				.andExpect(jsonPath("$.department").exists());
	}
	@Test
	public void testGetElectricityByName() throws Exception {
		String ElectricName = "oguz";
		mockMvc.perform(get("/api/v1/electrics-by-name/{electricName}", ElectricName)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.lastname").exists())
				.andExpect(jsonPath("$.department").exists());
	}

	@Test
	public void testCreateElectricity() throws Exception {

		ElectricitySubscDO newElectricity = new ElectricitySubscDO();
		newElectricity.setName("ouz");
		newElectricity.setLastname("boz");
		newElectricity.setDepartment("sanayi");
		AddressDO newAddress = new AddressDO();
		newAddress.setCity("istanbul");
		newAddress.setRegion("buyukcekmece");
		newAddress.setPostCode("1260");
		newElectricity.setAddress(newAddress);
		ElectricityBill newBill= new ElectricityBill();
		newBill.setAmount("amount");
		newBill.setCompany("company");
		newBill.setPeriod("period");
		newBill.setPrice("price");
		newElectricity.setBill(newBill);
		mockMvc.perform(post("/api/v1/electric")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newElectricity)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.lastname").exists())
				.andExpect(jsonPath("$.department").exists())
				.andExpect(jsonPath("$.address").exists())
				.andExpect(jsonPath("$.address.id").exists())
				.andExpect(jsonPath("$.address.city").exists())
				.andExpect(jsonPath("$.address.region").exists())
				.andExpect(jsonPath("$.address.postCode").exists())
				.andExpect(jsonPath("$.bill").exists())
				.andExpect(jsonPath("$.bill.id").exists())
				.andExpect(jsonPath("$.bill.company").exists())
				.andExpect(jsonPath("$.bill.amount").exists())
				.andExpect(jsonPath("$.bill.period").exists())
				.andExpect(jsonPath("$.bill.price").exists());
	}
	@Test
	public void testUpdateElectricity() throws Exception {
		ElectricitySubscDO newElectricity = new ElectricitySubscDO();
		newElectricity.setId(4L);
		newElectricity.setName("oguz2");
		newElectricity.setLastname("ok2");
		newElectricity.setDepartment("ev2");
		AddressDO newAddress = new AddressDO();
		newAddress.setCity("ankara2");
		newAddress.setRegion("Ayaş");
		newAddress.setPostCode("006");
		newElectricity.setAddress(newAddress);
		ElectricityBill newBill = new ElectricityBill();
		newBill.setAmount("9482 kw");
		newBill.setCompany("Enerji2");
		newBill.setPeriod("kış");
		newBill.setPrice("900");
		newElectricity.setBill(newBill);

		mockMvc.perform(put("/api/v1/electric")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newElectricity)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.lastname").exists())
				.andExpect(jsonPath("$.department").exists())
				.andExpect(jsonPath("$.address").exists())
				.andExpect(jsonPath("$.address.city").exists())
				.andExpect(jsonPath("$.address.region").exists())
				.andExpect(jsonPath("$.address.postCode").exists())
				.andExpect(jsonPath("$.bill").exists())
				.andExpect(jsonPath("$.bill.company").exists())
				.andExpect(jsonPath("$.bill.amount").exists())
				.andExpect(jsonPath("$.bill.period").exists())
				.andExpect(jsonPath("$.bill.price").exists());
	}
	@Test
	public void testDeleteElectricity() throws Exception {
		String electricId = "4";
		mockMvc.perform(delete("/api/v1/electrics-delete/{electricId}", electricId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
