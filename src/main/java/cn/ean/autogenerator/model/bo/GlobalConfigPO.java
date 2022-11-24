package cn.ean.autogenerator.model.bo;

import lombok.Data;

/**
 * @author ean
 * @FileName GlobalConfigPO
 * @Date 2022/11/24 15:30
 **/
@Data
public class GlobalConfigPO {
    /**
     * 逆向代码生成地址
     */
    private String OutputDirectory;

    /**
     * 作者
     */
    private String Author;

    /**
     * 是否开启输出目录:
     * 1:开启
     * 2:关闭
     */
    private Byte Open;

    /**
     * 逆向xml文件是否开启 BaseResultMap
     * 1:开启
     * 2:关闭
     */
    private Byte BaseResultMap;

    /**
     * 逆向xml文件是否开启 BaseResultList
     * 1:开启
     * 2:关闭
     */
    private Byte BaseResultList;

    /**
     * 逆向实体类是否开启 Swagger2注解
     * 1:开启
     * 2:关闭
     */
    private Byte Swagger2;
}
