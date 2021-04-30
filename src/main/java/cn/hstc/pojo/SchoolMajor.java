package cn.hstc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen
 * @crete 2021-04-20-23:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolMajor {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField()
    private String majorId;

    @TableField()
    private String majorName;

    @TableField()
    private Integer majorScore;

    @TableField()
    private Integer schoolId;

    @TableField()
    private String schoolName;

}
