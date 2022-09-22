package guru.springframework.brewery.web.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import guru.springframework.brewery.domain.Customer;
import guru.springframework.brewery.repositories.BeerOrderRepository;
import guru.springframework.brewery.repositories.CustomerRepository;
import guru.springframework.brewery.services.BeerOrderService;
import guru.springframework.brewery.web.model.BeerOrderPagedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerOrderControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = customerRepository.findAll().get(0);
    }

    @Test
    void listOrders() {


      BeerOrderPagedList pagedList= restTemplate.getForObject(
                        "/api/v1/customers/"+customer.getId().toString()+"/orders", BeerOrderPagedList.class);

                    assertThat(pagedList.getContent()).hasSize(1);
               }






}