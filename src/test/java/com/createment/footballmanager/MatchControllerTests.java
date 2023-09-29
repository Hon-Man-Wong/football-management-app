package com.createment.footballmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MatchControllerTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldReturnMatchesByTeam() throws Exception {
        mockMvc.perform(get("/matches").param("team", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].homeTeam.name").value("Sparta"));
    }

    @Test
    void shouldReturnMatchesByTeamFilter() throws Exception {
        mockMvc.perform(get("/matches").param("homeTeam", "Feye"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].awayTeam.name").value("Excelsior"));
    }
}
