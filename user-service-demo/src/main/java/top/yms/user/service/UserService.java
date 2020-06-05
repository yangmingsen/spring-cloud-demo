package top.yms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yms.user.mapper.UserMapper;
import top.yms.user.pojo.User;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /*public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }*/

    public List<User> findALl() {
        return userMapper.selectAll();
    }

    public User queryById(Long id) {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.userMapper.selectByPrimaryKey(id);
    }


}
