package cn.hstc.service;

import cn.hstc.mapper.IUserMapper;
import cn.hstc.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
@Service
public class UserService {

    @Resource
    private IUserMapper userMapper;

    public User get(Serializable id) {
        return userMapper.selectById(id);
    }


    public User getByUsername(String username) {
        return this.userMapper.getByUsername(username);
    }
}
