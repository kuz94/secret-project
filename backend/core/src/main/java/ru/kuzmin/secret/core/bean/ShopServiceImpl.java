package ru.kuzmin.secret.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmin.secret.core.bean.interfaces.ShopService;
import ru.kuzmin.secret.core.dao.ShopDao;
import ru.kuzmin.secret.core.entity.Shop;

@Service
public class ShopServiceImpl implements ShopService{

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
