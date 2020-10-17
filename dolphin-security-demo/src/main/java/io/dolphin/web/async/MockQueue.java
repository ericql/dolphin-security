package io.dolphin.web.async;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-17 14:34
 */
@Data
@Component
public class MockQueue {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String placeOrder;

    private String completeOrder;

    public void setPlaceOrder(String placeOrder) throws Exception {
        new Thread(() -> {
            logger.info("接到下单请求, " + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕," + placeOrder);
        }).start();
    }
}
