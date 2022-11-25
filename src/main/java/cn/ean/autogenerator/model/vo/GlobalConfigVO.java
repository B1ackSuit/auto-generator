package cn.ean.autogenerator.model.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ean
 * @FileName GlobalConfigVO
 * @Date 2022/11/25 14:44
 **/
@Data
@ApiModel(value = "GlobalConfigVO对象", description = "GlobalConfigVO对象")
public class GlobalConfigVO {


    @ApiModelProperty("逆向代码生成地址")
    private String OutputDirectory;

    @ApiModelProperty("是否开启输出目录:1.开启，2.关闭")
    private Byte Open;

    @ApiModelProperty("逆向xml文件是否开启 BaseResultMap:1:开启，2:关闭")
    private Byte BaseResultMap;

    @ApiModelProperty("逆向xml文件是否开启 BaseResultList:1:开启，2:关闭")
    private Byte BaseResultList;

    @ApiModelProperty("逆向实体类是否开启 Swagger2注解:1:开启，2:关闭")
    private Byte Swagger2;

}
