package cn.hstc.mapper;

import cn.hstc.pojo.CommentRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chen
 * @create 2021-04-20 11:05
 */

public interface ICommentRecordMapper extends BaseMapper<CommentRecord> {

    @Select("select * from comment_record where article_id = #{articleId} order by comment_date")
    List<CommentRecord> findListByArticleId(@Param("articleId") Integer articleId, IPage<CommentRecord> commentRecordIPage);
}
