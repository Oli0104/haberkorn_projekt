package de.noellang.customerapi.controller;

import de.noellang.customerapi.entity.Customer;
import de.noellang.customerapi.repository.CustomerRepository;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    public List<Customer> index() {
        return customerRepository.findAll();
    }

    @PostMapping("")
    public void addPerson(@RequestBody Customer c)
    {
        try
        {
            customerRepository.save(c);
        }
        catch(Exception e)
        {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
