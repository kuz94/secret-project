package ru.kuzmin.rent.identity.services.interfaces;

import ru.kuzmin.rent.identity.entities.Shop;

public interface ShopService {

    Shop save(Shop shop);

    void delete(Shop shop);
}
