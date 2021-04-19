package cn.hstc.mapper;

import cn.hstc.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
public interface IUserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username}")
    User getByUsername(@Param("username") String username);
}
