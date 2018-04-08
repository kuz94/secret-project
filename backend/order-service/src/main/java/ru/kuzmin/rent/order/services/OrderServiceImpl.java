package ru.kuzmin.rent.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.rent.order.dao.OrderDao;
import ru.kuzmin.rent.order.entities.Order;
import ru.kuzmin.rent.order.services.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Order create(Order order) {
        return null;
    }
}
