package com.jijo.bank.customer;

import com.jijo.bank.customer.data.CustomerDataGateway;
import com.jijo.bank.customer.data.CustomerRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerDataGateway gateway;

    public CustomerController(CustomerDataGateway gateway) {
        this.gateway = gateway;
    }


    @GetMapping("/{customerId}")
    public CustomerInfo show(@PathVariable long customerId) {
        CustomerRecord record = gateway.find(customerId);

        if (record == null) {
            return null;
        }

        return new CustomerInfo(record.id, record.name, "customer info");
    }
}
