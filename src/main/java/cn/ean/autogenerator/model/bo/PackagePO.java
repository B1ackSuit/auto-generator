package cn.ean.autogenerator.model.bo;

import lombok.Data;

/**
 * @author ean
 * @FileName PackageBO
 * @Date 2022/11/24 16:17
 **/
@Data
public class PackagePO {

    private String Entity;

    private String Mapper;

    private String Service;

    private String ServiceImpl;

    private String Controller;
}
