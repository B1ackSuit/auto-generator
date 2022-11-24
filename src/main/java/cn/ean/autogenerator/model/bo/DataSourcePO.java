package cn.ean.autogenerator.model.bo;

import lombok.Data;

/**
 * @author ean
 * @FileName DataSourceBO
 * @Date 2022/11/24 15:49
 **/
@Data
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
