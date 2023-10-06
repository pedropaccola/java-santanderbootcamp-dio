package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void update(Long id, Customer customer);
    void deleteById(Long id);

}
