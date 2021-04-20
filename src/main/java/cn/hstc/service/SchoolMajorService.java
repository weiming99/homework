package cn.hstc.service;

import cn.hstc.mapper.ISchoolMajorMapper;
import cn.hstc.mapper.ISchoolMapper;
import cn.hstc.pojo.School;
import cn.hstc.pojo.SchoolMajor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
@Service
public class SchoolMajorService {

    @Resource
    private ISchoolMajorMapper schoolMajorMapper;

    public List<SchoolMajor> getList(){
        return schoolMajorMapper.selectDistinctList();
    }

    public List<SchoolMajor> get(String id) {
        return schoolMajorMapper.selectListByMajorId(id);
    }
}
