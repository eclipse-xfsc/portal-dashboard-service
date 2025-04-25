package eu.gaiax.dashboard.rest;

import eu.gaiax.dashboard.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unused")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles({"test"})
public class DashboardTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DashboardController service;

    @Test
    void getNews() throws Exception {
        NewsResponse body = new NewsResponse(
                Collections.singletonList(new NewsItem("id", "title", "st", "2022-08-08")));
        ResponseEntity rs = ResponseEntity.ok(body);
        when(service.getNews(any())).thenReturn(rs);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/dashboard/news"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2022-08-08")));
    }

    @Test
    void getTransactions() throws Exception {
        TransactionResponse body = new TransactionResponse(
                Collections.singletonList(new TransactionItem("id", "title", "st", "2022-08-08")));
        ResponseEntity rs = ResponseEntity.ok(body);
        when(service.getTransactions(any())).thenReturn(rs);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/dashboard/transactions"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2022-08-08")));
    }

    @Test
    void getDatasets() throws Exception {
        DatasetResponse body = new DatasetResponse(
                Collections.singletonList(new DatasetItem("id", "name", "img", "url", null, null, false, false, null)));
        ResponseEntity rs = ResponseEntity.ok(body);
        when(service.getDatasets(any())).thenReturn(rs);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/dashboard/datasets"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("img")));
    }

    @Test
    void getSP() throws Exception {
        ServicesResponse body = new ServicesResponse(
                Collections.singletonList(new ServiceItem("id", "name", "img", "url", null, null, false, false, null)));
        ResponseEntity rs = ResponseEntity.ok(body);
        when(service.getSP(any())).thenReturn(rs);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/dashboard/sp"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("img")));
    }

    @Test
    void getServices() throws Exception {
        ServicesResponse body = new ServicesResponse(
                Collections.singletonList(new ServiceItem("id", "name", "img", "url", null, null, false, false, null)));
        ResponseEntity rs = ResponseEntity.ok(body);
        when(service.getServices(any())).thenReturn(rs);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/dashboard/services"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("img")));
    }

    @Test
    void getStatistics() throws Exception {
        ResponseEntity rs = ResponseEntity.ok(new Statistics());
        when(service.getStatistics(any())).thenReturn(rs);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/dashboard/statistics"))
                .andExpect(status().isOk());
    }

    @Test
    void activate() throws Exception {
        ResponseEntity rs = ResponseEntity.ok().build();
        when(service.activate(any(), any(ActivateRq.class))).thenReturn(rs);
        String rq = JsonUtil.asJsonString(new ActivateRq("id", true));
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/dashboard/datasets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(rq))
                .andExpect(status().isOk());
    }

}