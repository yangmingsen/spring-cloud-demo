package top.yms.consumer.dao;

import org.springframework.stereotype.Component;
import top.yms.consumer.pojo.User;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("用户查询出现异常！, 发生熔断");
        return user;
    }
}
