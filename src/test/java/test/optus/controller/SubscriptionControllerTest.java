/**
 * 
 */
package test.optus.controller;

import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import test.optus.service.StringHandlingService;

/**
 * @author donren
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SubscriptionController.class)
public class SubscriptionControllerTest {
	@Autowired
    private MockMvc mockMvc;

	@MockBean
	StringHandlingService service;
	@Test
    public void testUserController () throws Exception {
		given(
				this.service.truncateString("testetest", 3)).willReturn(
				"....test....");
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.request(HttpMethod.GET, "/subscribe", "acoutbtou.abc.marbadcr");
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
    }
}
