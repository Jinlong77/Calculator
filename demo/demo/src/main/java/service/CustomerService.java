package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public com.example.demo.entity.Customer addCustomer(com.example.demo.entity.Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<com.example.demo.entity.Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public List<com.example.demo.entity.Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public com.example.demo.entity.Customer updateCustomer(Long id, com.example.demo.entity.Customer customerDetails) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            return customerRepository.save(customer);
        }).orElseGet(() -> customerRepository.save(customerDetails));
    }
}
