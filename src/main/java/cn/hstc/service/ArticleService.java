package cn.hstc.service;

import cn.hstc.mapper.IArticleMapper;
import cn.hstc.pojo.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author chen
 * @crete 2021-04-17-15:45
 */
@Service
public class ArticleService {

    @Resource
    private IArticleMapper articleMapper;

    public Article get(Serializable id) {
        return articleMapper.selectById(id);
    }


}
