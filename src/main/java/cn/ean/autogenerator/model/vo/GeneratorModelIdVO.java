package cn.ean.autogenerator.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ean
 * @FileName GeneratorModelIdPO
 * @Date 2022/12/20 23:58
 **/
@Data
@ApiModel(value = "GeneratorModelIdVO对象", description = "GeneratorModelIdVO对象")
public class GeneratorModelIdVO {

    private Integer dataSourcePKID;

    private Integer globalConfigPKID;

    private Integer packagePKID;

    private Integer strategyConfigPKID;

}
