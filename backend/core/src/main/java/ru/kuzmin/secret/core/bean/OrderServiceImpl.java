package ru.kuzmin.secret.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.secret.core.bean.interfaces.OrderService;
import ru.kuzmin.secret.core.dao.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
