package com.waterkemper.springsecurityjwt.repositories;

import com.waterkemper.springsecurityjwt.model.persistmaps.mapkeyjoincolumn.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
}
