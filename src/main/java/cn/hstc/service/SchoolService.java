package cn.hstc.service;

import cn.hstc.mapper.ISchoolMapper;
import cn.hstc.mapper.IUserMapper;
import cn.hstc.pojo.School;
import cn.hstc.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
@Service
public class SchoolService {

    @Resource
    private ISchoolMapper schoolMapper;

    public List<School> getList(){
        return schoolMapper.selectList(null);
    }

    public School get(Integer id) {
        return schoolMapper.selectById(id);
    }
}
