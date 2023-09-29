package com.createment.footballmanager;

import com.createment.footballmanager.Team.TeamService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllTeams() throws Exception {
        mockMvc.perform(get("/teams"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[4]").exists())
                .andExpect(jsonPath("$[5]").doesNotExist());
    }

    @Test
    void shouldReturnTeamById() throws Exception {
        mockMvc.perform(get("/teams/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Feyenoord"));
    }

    @Test
    void shouldReturnExceptionWhenTeamNotFound() throws Exception {
        mockMvc.perform(get("/teams/11"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnPlayersOfTeamById() throws Exception {
        mockMvc.perform(get("/teams/1/players"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].name").value("Bob"));
    }
}
