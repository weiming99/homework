package cn.hstc.service;

import cn.hstc.mapper.IArticleMapper;
import cn.hstc.mapper.ICommentRecordMapper;
import cn.hstc.pojo.Article;
import cn.hstc.pojo.CommentRecord;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
@Service
public class CommentRecordService {

    @Resource
    private ICommentRecordMapper commentRecordMapper;

    public CommentRecord get(Serializable id) {
        return commentRecordMapper.selectById(id);
    }


    public List<CommentRecord> pageByArticleId(Integer articleId) {
        IPage<CommentRecord>  commentRecordIPage= new Page<>(1, 5);
        return commentRecordMapper.findListByArticleId(articleId,commentRecordIPage);

    }


//    public List<CommentRecord> page() {
//        IPage<CommentRecord>  commentRecordIPage= new Page<>(1, 5);
//        return commentRecordMapper.findList(commentRecordIPage);
//    }
}
