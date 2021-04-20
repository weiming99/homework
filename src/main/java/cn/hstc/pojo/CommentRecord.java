package cn.hstc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chen
 * @create 2021-04-20 11:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRecord implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField()
    private Integer articleId;

    @TableField()
    private Integer answererId;

    @TableField()
    private String answererName;

    @TableField()
    private Integer respondentId;

    @TableField()
    private Date commentDate;

    @TableField()
    private Integer likes;

    @TableField()
    private String commentContent;


}
