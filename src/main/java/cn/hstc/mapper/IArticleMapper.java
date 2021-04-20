package cn.hstc.mapper;

import cn.hstc.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
public interface IArticleMapper extends BaseMapper<Article> {

    @Select("select * from article order by publish_date")
    List<Article> findList(IPage<Article> articleIPage);


    @Select("SELECT DISTINCT a.id, a.user_id, a.user_name, a.article_title, a.article_content, a.article_tags, a.article_categories, a.publish_date, a.update_date, a.likes FROM article  a INNER JOIN  comment_record c ON c.article_id = a.id ORDER BY c.comment_date ")
    List<Article> findListByComment(IPage<Article> articleIPage);

    @Select("select * form article where article_tags=#{tag} order by publish_date")
    List<Article> findListByTag(@Param("tag") String tag, IPage<Article> articleIPage);

    @Select("select * form article where article_categories=#{category} order by publish_date")
    List<Article> findListByCategory(@Param("category") String category, IPage<Article> articleIPage);
}
