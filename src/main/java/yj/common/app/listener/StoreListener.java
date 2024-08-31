package yj.common.app.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yj.common.app.service.store.IStoreService;

/**
 * @Model: 应用 -
 * @Description: TODO
 * @Author: hyk
 * @Date: 2024/8/31
 **/
@Component
public class StoreListener {
    @Autowired
    private  IStoreService storeService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "store.addFavorite.success.queue", durable = "true"),
            exchange = @Exchange(name = "addFavorite.direct"),
            key = "addFavorite.success" // 绑定的KEY
    ))
    public void listenAddFavoriteCountsSuccess(Long storeId) {
        storeService.updateStoreFavoriteUsersCountAdd1(storeId);
    }
}
