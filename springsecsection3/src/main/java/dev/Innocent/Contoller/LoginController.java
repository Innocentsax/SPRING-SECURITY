package dev.Innocent.Contoller;

import dev.Innocent.Model.Customer;
import dev.Innocent.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    CustomerRepository customerRepository;

    @Autowired
    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer = null;
        ResponseEntity response = null;
        try{
            savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId()>0){
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        }catch (Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to  " + ex.getMessage());
        }
        return response;
    }
}
