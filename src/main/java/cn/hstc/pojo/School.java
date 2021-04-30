package cn.hstc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen
 * @create 2021-04-20 17:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField()
    private String name;

    @TableField()
    private String province;

    @TableField()
    private String type;

    @TableField()
    private String nature;

    @TableField()
    private String url;

    @TableField()
    private String phone;

    @TableField()
    private String email;

    @TableField()
    private String address;

    @TableField()
    private String introduction;

    @TableField()
    private String picture;
}
