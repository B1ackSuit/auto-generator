package cn.ean.autogenerator.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author ean
 * @FileName GlobalConfigPO
 * @Date 2022/11/24 15:30
 **/
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@TableName("global_config")
@ApiModel(value = "GlobalConfigPO对象", description = "GlobalConfigPO对象")
public class GlobalConfigPO {

    @ApiModelProperty("逆向代码生成地址")
    private String OutputDirectory;

    @ApiModelProperty("作者")
    private String Author;

    @ApiModelProperty("是否开启输出目录:1.开启，2.关闭")
    private Boolean Open;

    @ApiModelProperty("逆向xml文件是否开启 BaseResultMap:1:开启，2:关闭")
    private Boolean BaseResultMap;

    @ApiModelProperty("逆向xml文件是否开启 BaseResultList:1:开启，2:关闭")
    private Boolean BaseResultList;

    @ApiModelProperty("逆向实体类是否开启 Swagger2注解:1:开启，2:关闭")
    private Boolean Swagger2;
}
