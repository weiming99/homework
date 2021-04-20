package cn.hstc.mapper;

import cn.hstc.pojo.School;
import cn.hstc.pojo.SchoolMajor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chen
 * @create 2021-04-20 11:05
 */

public interface ISchoolMajorMapper extends BaseMapper<SchoolMajor> {

    @Select("select * from school_major where major_id=#{majorId} order by major_score")
    List<SchoolMajor> selectListByMajorId(@Param("majorId") String id);

    @Select("SELECT DISTINCT major_id ,major_name FROM school_major ")
    List<SchoolMajor> selectDistinctList();
}
