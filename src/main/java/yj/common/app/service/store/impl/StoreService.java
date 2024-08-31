package yj.common.app.service.store.impl;

import org.springframework.stereotype.Service;
import yj.common.app.service.store.IStoreService;

/**
 * @Model: 应用 -
 * @Description: TODO
 * @Author: hyk
 * @Date: 2024/8/31
 **/
@Service
public class StoreService implements IStoreService {
    @Override
    public void updateStoreFavoriteUsersCountAdd1(Long storeId) {
        System.out.println("执行业务逻辑：" + storeId);
    }
}
