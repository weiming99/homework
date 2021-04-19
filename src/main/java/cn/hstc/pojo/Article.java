package cn.hstc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen
 * @crete 2021-04-17-22:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField()
    private Integer authorId;

    @TableField()
    private String authorName;

    @TableField()
    private String articleTitle;

    @TableField()
    private String articleContent;

    @TableField()
    private String articleTags;

    @TableField()
    private String articleCategories;

    @TableField()
    private String publishDate;

    @TableField()
    private String updateDate;


    @TableField()
    private Integer likes;


}
