package tws.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashMap;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void should_return_ok_when_query_all_parkingLots() throws Exception {
        //Given
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parkinglots");
        //When
        ResultActions performResult = mockMvc.perform(requestBuilder);
        //Then
        performResult
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_201_status_when_create_parkingLot() throws Exception {
        //Given
        HashMap map=new HashMap();
        String id= UUID.randomUUID().toString();
        map.put("id",id);
        map.put("capacity",10);

        String postString = objectMapper.writeValueAsString(map);
        System.out.println(postString);
        MockHttpServletRequestBuilder input = post("/parkinglots")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postString);
        //When
        ResultActions result = mockMvc.perform(input);
        //Then
        result
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }
}
