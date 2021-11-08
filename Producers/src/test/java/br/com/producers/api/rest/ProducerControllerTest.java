package br.com.producers.api.rest;

import br.com.producers.application.component.impl.FileReaderCompImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
@EnableConfigurationProperties
class ProducerControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    @Value("classpath:movielist.csv")
//    Resource movieList;

    @Test
    @ConfigurationProperties(prefix = "test")
    void testGetWinners() throws Exception {

        String response = "{\"min\":[{\"producer\":\"ALLAN CARR\",\"interval\":1,\"previousWin\":2020,\"followingWin\":2021},{\"producer\":\"JOEL SILVER\",\"interval\":1,\"previousWin\":1990,\"followingWin\":1991},{\"producer\":\"BO DEREK\",\"interval\":6,\"previousWin\":1984,\"followingWin\":1990},{\"producer\":\"BUZZ FEITSHANS\",\"interval\":9,\"previousWin\":1985,\"followingWin\":1994},{\"producer\":\"MATTHEW VAUGHN\",\"interval\":13,\"previousWin\":2002,\"followingWin\":2015}],\"max\":[{\"producer\":\"ALLAN CARR\",\"interval\":40,\"previousWin\":1980,\"followingWin\":2020},{\"producer\":\"MATTHEW VAUGHN\",\"interval\":13,\"previousWin\":2002,\"followingWin\":2015},{\"producer\":\"BUZZ FEITSHANS\",\"interval\":9,\"previousWin\":1985,\"followingWin\":1994},{\"producer\":\"BO DEREK\",\"interval\":6,\"previousWin\":1984,\"followingWin\":1990},{\"producer\":\"JOEL SILVER\",\"interval\":1,\"previousWin\":1990,\"followingWin\":1991}]}";

        var result = mockMvc.perform(get("/api/winners")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();


        Assert.assertEquals("A resposta precisa ser igual a resposta esperada!", response,result);
    }

}