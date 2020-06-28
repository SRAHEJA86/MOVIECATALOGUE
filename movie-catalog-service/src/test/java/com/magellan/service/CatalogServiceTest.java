package com.magellan.service;

import com.magellan.model.UserRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.ExpectedCount.manyTimes;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CatalogService.class)
class CatalogServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RestTemplate restTemplate;
    private MockRestServiceServer mockServer;

    @Autowired
    WebApplicationContext context;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        MockMvcClientHttpRequestFactory requestFactory = new MockMvcClientHttpRequestFactory(mockMvc);
        this.restTemplate = new RestTemplate(requestFactory);
        this.mockServer = MockRestServiceServer.bindTo(restTemplate).build();
    }

    @Test
    public void test_the_rest_client_by_mocking() {
        try {
            ResponseEntity<UserRating> userRating = getResponseEntity();
            assertNotNull(userRating);
            assertEquals(userRating.getStatusCode(), HttpStatus.OK);
            mockServer.verify();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ResponseEntity<UserRating> getResponseEntity() {
        String url = "http://localhost:8183/ratings";

        mockServer.expect(manyTimes(), requestTo(url)).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

        return restTemplate.getForEntity(url, UserRating.class);
    }

    String jsonResponse =  "{\"rating\":[{\"movieId\":\"200\",\"rating\":\"5\"}," +
            "{\"movieId\":\"100\",\"rating\":\"3\"}]}";

    @Test
    void getCatalog() {
    }

    @Test
    void updateCatalogMovie() {
    }

    @Test
    void deleteCatalogMovie() {
    }

    @Test
    void addCatalogMovie() {
    }

    @Test
    void addCatalogRating() {
    }

    @Test
    void updateCatalogRating() {
    }

    @Test
    void deleteCatalogRating() {
    }
}