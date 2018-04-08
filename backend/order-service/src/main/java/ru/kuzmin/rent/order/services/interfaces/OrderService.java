package ru.kuzmin.rent.order.services.interfaces;

import ru.kuzmin.rent.order.entities.Order;

public interface OrderService {

    Order create(Order order);
}
