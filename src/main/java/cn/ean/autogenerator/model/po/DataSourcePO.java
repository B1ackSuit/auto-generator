package cn.ean.autogenerator.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author ean
 * @FileName DataSourceBO
 * @Date 2022/11/24 15:49
 **/
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@TableName("ag_datasource")
@ApiModel(value = "DataSourcePO对象", description = "DataSourcePO对象")
public class DataSourcePO {

    /**
     * url
     */
    private String url;

    /**
     * DriverName
     */
    private String driverName;

    /**
     * Username
     */
    private String username;

    /**
     * Password
     */
    private String password;


}
