package com.alta.ecommerce;

import com.alta.ecommerce.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/product/",
                String.class)).contains("id");

        var result = this.restTemplate.getForObject("http://localhost:" + port + "/product/",
                String.class);

        List< Product > p = new ArrayList<>();
        Type productlisttype = new TypeToken<ArrayList<Product>>(){}.getType();
        Gson gson = new Gson();
        p = new Gson().fromJson(result, productlisttype);

        assertThat(p.size()).isEqualTo(1);
    }
}
