package top.yms.consumer.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.yms.consumer.pojo.User;

//@FeignClient("user-service")
@FeignClient(value = "user-service", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
    @GetMapping("/user/{id}")
    User queryUserById(@PathVariable("id") Long id);
}
