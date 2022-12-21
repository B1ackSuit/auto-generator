package cn.ean.autogenerator.service;

import cn.ean.autogenerator.model.bo.ResponseBO;
import cn.ean.autogenerator.model.po.DataSourcePO;
import cn.ean.autogenerator.model.po.PackagePO;
import cn.ean.autogenerator.model.vo.DataSourceVO;
import cn.ean.autogenerator.model.vo.GeneratorModelIdVO;
import cn.ean.autogenerator.model.vo.GlobalConfigVO;

/**
 * @author ean
 * @FileName RemoteCodeGeneratorService
 * @Date 2022/11/24 15:28
 **/
public interface RemoteCodeGeneratorService {

    ResponseBO defineGlobalConfig(GlobalConfigVO globalConfigVO);

    ResponseBO defineDataSource(DataSourceVO dataSourceVO);

    void definePackage(PackagePO packagePO);

    ResponseBO autoGenerator(GeneratorModelIdVO generatorModelIdVO);
}
