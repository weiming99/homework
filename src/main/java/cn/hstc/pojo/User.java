package cn.hstc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chen
 * @crete 2021-04-17-15:39
 */
@Data
@NoArgsConstructor
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField()
    private String username;

    @TableField()
    private String password;

    @TableField()
    private String gender;

    @TableField()
    private String trueName;

    @TableField()
    private String phone;

    @TableField()
    private String personalBrief;


}
