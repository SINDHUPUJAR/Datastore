package net.javaguides.springboot.springboot_rest;




import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;




import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.web.context.WebApplicationContext;


import net.javaguides.springboot.springboot_rest_controller.UserController;



@Nested
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)

@SpringBootTest
public class SpringbootRestApplicationTests {

	
	@Autowired
	MockMvc mockMvc;
	@Autowired
	WebApplicationContext context;
	
	@InjectMocks
	UserController user;
	
	@org.junit.Test
	public void createUserTest() throws Exception
	{
		/*User user = new User();
		user.setId("1");
		user.setUsername("sindhu");
		user.setStatus("active");
		user.setFirstName("sindhups");
		user.setLastName("pujar");
		user.setEmail("sindhu.pujar@gmail.com");
		user.setCreatedBy("1");
		user.setCreatedDate("1994-02-03");
		user.setLastModifiedBy("1");
		user.setLastmodifieddate("1994-03-04");
		String jsoRequest=om.writeValueAsString(user);
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.post("/createusers").contentType(MediaType.APPLICATION_JSON).content("")).andExpect(MockMvcResultMatchers.status().isOk());
		String resultContent=result.getResponse().getContentAsString();
		Response response =om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isDone()==Boolean.TRUE);
		*/
		System.out.println("welcome to spring");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/createusers").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "    \"id\":3,\n" + "    \"createdBy\": \"004\",\n"
                        + "    \"email\": \"sandy.pujar.com\",\n" + "    \"firstName\": \"sandu1\",\n"
                        + "    \"lastModifiedBy\": \"002\",\n" + "    \"lastName\": \"pujar\",\n"
                        + "    \"status\": \"inactive\",\n" + "    \"username\": \"sandy\"\n" + "  \n" + "}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
                
	}
	@org.junit.Test
	public void getAllUsersTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/getusers").contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@org.junit.Test
	public void getUserById() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}/{email}").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "    \"id\":3,\n" + "    \"createdBy\": \"004\",\n"
                        + "    \"email\": \"sandy.pujar.com\",\n" + "    \"firstName\": \"sandu1\",\n"
                        + "    \"lastModifiedBy\": \"002\",\n" + "    \"lastName\": \"pujar\",\n"
                        + "    \"status\": \"inactive\",\n" + "    \"username\": \"sandy\"\n" + "  \n" + "}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
                
	}
	@org.junit.Test
	public void updateUser() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.put("/updateuser/{id}").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "    \"id\":3,\n" + "    \"createdBy\": \"004\",\n"
                        + "    \"email\": \"sandy.pujar.com\",\n" + "    \"firstName\": \"sandu1\",\n"
                        + "    \"lastModifiedBy\": \"002\",\n" + "    \"lastName\": \"pujar\",\n"
                        + "    \"status\": \"inactive\",\n" + "    \"username\": \"sandy\"\n" + "  \n" + "}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
                
	}
	
	@org.junit.Test
	public void deleteUser() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteuser/{id}").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "    \"id\":3,\n" + "    \"createdBy\": \"004\",\n"
                        + "    \"email\": \"sandy.pujar.com\",\n" + "    \"firstName\": \"sandu1\",\n"
                        + "    \"lastModifiedBy\": \"002\",\n" + "    \"lastName\": \"pujar\",\n"
                        + "    \"status\": \"inactive\",\n" + "    \"username\": \"sandy\"\n" + "  \n" + "}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
                
	}
}
