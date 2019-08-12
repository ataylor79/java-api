package shop.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;


    ArrayList<Product> productsArrayList = new ArrayList<Product>();

    Product mockProduct = new Product("TestProduct", new BigDecimal(1.99));
    Optional<Product> mockProductResponse = Optional.ofNullable(mockProduct);

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getProduct() throws Exception{
        Mockito.when(
                productService.getByName(Mockito.anyString())
        ).thenReturn(mockProductResponse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product?name=test").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"name\": \"TestProduct\",\"price\":1.99 }";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getProducts() throws Exception {
        productsArrayList.add(mockProduct);
        Mockito.when(productService.getAll()).thenReturn(productsArrayList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/all").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("Expected: " + mockProduct.toString());
        System.out.println("Result: " + result);

        JSONAssert.assertEquals(mockProduct.toString(), result.getResponse().getContentAsString(), false);
    }
}
