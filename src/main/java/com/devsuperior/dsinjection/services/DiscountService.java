package com.devsuperior.dsinjection.services;

import com.devsuperior.dsinjection.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double discount(Order order){
        if (order.getDiscount() > 0.0) {
            return order.getBasic() * order.getDiscount() / 100;
        } else {
            return 0.0;
        }
    }
}
