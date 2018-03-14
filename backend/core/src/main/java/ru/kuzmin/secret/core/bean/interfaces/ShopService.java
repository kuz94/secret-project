package ru.kuzmin.secret.core.bean.interfaces;

import ru.kuzmin.secret.core.entity.Shop;

public interface ShopService {

    Shop save(Shop shop);

    void delete(Shop shop);
}
