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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingBoyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void should_return_ok_when_query_all_parkingBoys() throws Exception {
        //Given
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parkingboys");
        //When
        ResultActions performResult = mockMvc.perform(requestBuilder);
        //Then
        performResult
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_201_status_when_create_parkingBoy() throws Exception {

        MockHttpServletRequestBuilder input = post("/parkingboys")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content("{}");
        //When
        ResultActions result = mockMvc.perform(input);
        //Then
        result
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_200_status_when_add_parkinglot_to_parkingboy() throws Exception {

        MockHttpServletRequestBuilder input = put("/parkingboys/1/parkinglots/100");
        //When
        ResultActions result = mockMvc.perform(input);
        //Then
        result
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

    }

    @Test
    public void should_return_ok_and_list_when_query_parkinglots_by_parkingboyid() throws Exception {
        //Given
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parkingboys/2/parkinglots");
        //When
        ResultActions performResult = mockMvc.perform(requestBuilder);
        //Then
        performResult
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
        .andExpect(content().string("[{\"id\":\"101\",\"capacity\":2,\"parkingboyid\":\"2\"}]"));
    }

    @Test
    public void should_return_ok_and_list_when_query_parkinglots() throws Exception {
        //Given
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parkingboys/parkinglots");
        //When
        ResultActions performResult = mockMvc.perform(requestBuilder);
        //Then
        performResult
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }


}
