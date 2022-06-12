package yaho.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CompanyControllerTest {
    @Autowired private MockMvc mockMvc;

    @DisplayName("Company Get 테스트")
    @Test
    void companiesRead() throws Exception {
        mockMvc.perform(get("/companies"))
                .andExpect(status().isOk())
                .andExpect(view().name("companies/total_list"))
                .andExpect(model().attributeExists("companyForm"))
                .andExpect(model().attributeExists("companyList"));
    }

    @DisplayName("Company Post 테스트")
    @Test
    void companiesCreate() throws Exception {
        mockMvc.perform(post("/companies")
                        .param("companyName","성은테크")
                        .param("telNumber","0101234564")
                        .param("email","kse@kse")
                        .param("location","마산")
                )
                .andExpect(status().is3xxRedirection());
    }
    void companyUpdate(){

    }
    void companyDelete(){

    }
}