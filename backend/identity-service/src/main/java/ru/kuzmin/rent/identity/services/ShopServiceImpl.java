package ru.kuzmin.rent.identity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.rent.identity.services.interfaces.ShopService;
import ru.kuzmin.rent.identity.dao.ShopDao;
import ru.kuzmin.rent.identity.entities.Shop;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopDao shopDao;

    @Autowired
    public ShopServiceImpl(ShopDao shopDao) {
        this.shopDao = shopDao;
    }


    @Override
    public Shop save(Shop shop) {
        if(shop.getId() != null) {
            shop = shopDao.insert(shop);
        } else {
            shopDao.update(shop);
        }
        return shop;
    }

    @Override
    public void delete(Shop shop) {
        shopDao.delete(shop);
    }
}
