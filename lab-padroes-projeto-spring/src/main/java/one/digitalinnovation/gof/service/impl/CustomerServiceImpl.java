package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Address;
import one.digitalinnovation.gof.model.AddressRepository;
import one.digitalinnovation.gof.model.Customer;
import one.digitalinnovation.gof.model.CustomerRepository;
import one.digitalinnovation.gof.service.CustomerService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public void save(Customer customer) {
        saveCustomerWithCep(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerDb = customerRepository.findById(id);
        if (customerDb.isPresent()) {
            saveCustomerWithCep(customer);
        }
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    private void saveCustomerWithCep(Customer customer) {
        //check if exists
        String cep = customer.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.findAddress(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        customer.setAddress(address);
        customerRepository.save(customer);
    }
}
