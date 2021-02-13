package com.waterkemper.springsecurityjwt.api;

import com.waterkemper.springsecurityjwt.model.persistmaps.mapkeyjoincolumn.Order;
import com.waterkemper.springsecurityjwt.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/order")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @PostMapping
    public void post(@RequestBody Order order) {
//        repository.save(order);
    }

    @GetMapping
    public Iterable<Order> findAll() {
        return repository.findAll();
    }
}
