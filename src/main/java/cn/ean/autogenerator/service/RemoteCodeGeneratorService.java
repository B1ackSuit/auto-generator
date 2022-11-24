package cn.ean.autogenerator.service;

import cn.ean.autogenerator.model.bo.DataSourcePO;
import cn.ean.autogenerator.model.bo.GlobalConfigPO;
import cn.ean.autogenerator.model.bo.PackagePO;

/**
 * @author ean
 * @FileName RemoteCodeGeneratorService
 * @Date 2022/11/24 15:28
 **/
public interface RemoteCodeGeneratorService {

    void defineGlobalConfig(GlobalConfigPO globalConfigPO);

    void defineDataSource(DataSourcePO dataSourcePO);

    void definePackage(PackagePO packagePO);
}
