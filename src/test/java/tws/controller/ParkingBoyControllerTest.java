package tws.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingBoyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_ok_and_content_when_query_all_user() throws Exception {
        //Given
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parkingboys");
        //When
        ResultActions performResult = mockMvc.perform(requestBuilder);
        //Then
        performResult
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
