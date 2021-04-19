package cn.hstc.mapper;

import cn.hstc.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
public interface IArticleMapper extends BaseMapper<Article> {

    @Select("select * from article")
    List<Article> findList(IPage<Article> articleIPage);
}
