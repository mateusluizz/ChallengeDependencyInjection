package com.devsuperior.dsinjection.services;

import com.devsuperior.dsinjection.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    @Autowired
    DiscountService discountService;

    public double total(Order order) {
        return order.getBasic() +
                shippingService.shipment(order) -
                discountService.discount(order);
    }
}
