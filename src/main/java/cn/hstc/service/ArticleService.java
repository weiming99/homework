package cn.hstc.service;

import cn.hstc.mapper.IArticleMapper;
import cn.hstc.pojo.Article;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

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


    public List<Article> page() {
        IPage<Article> articleIPage = new Page<>(1, 4);
        return articleMapper.findList(articleIPage);
    }
}
