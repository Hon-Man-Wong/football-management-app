package com.createment.footballmanager;

import com.createment.footballmanager.Team.TeamService;
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
public class PlayersControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllPlayers() throws Exception {
        mockMvc.perform(get("/players"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[3]").exists())
                .andExpect(jsonPath("$[4]").doesNotExist());
    }

    @Test
    void shouldReturnPlayerById() throws Exception {
        mockMvc.perform(get("/players/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Lutsharel Geertruida"));
    }

    @Test
    void shouldReturnExceptionWhenPlayerNotFound() throws Exception {
        mockMvc.perform(get("/players/11"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnPlayersFilteredByName() throws Exception {
        mockMvc.perform(get("/players").param("name", "Bob"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Bob"))
                .andExpect(jsonPath("$[1]").doesNotExist());
    }

    @Test
    void shouldReturnPlayersFilteredByTeam() throws Exception {
        mockMvc.perform(get("/players").param("team", "Feyenoord"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lutsharel Geertruida"))
                .andExpect(jsonPath("$[3]").doesNotExist());
    }
}
