package cn.ean.autogenerator.service.impl;

import cn.ean.autogenerator.model.bo.ResponseBO;
import cn.ean.autogenerator.model.vo.DataSourceVO;
import cn.ean.autogenerator.model.po.GlobalConfigPO;
import cn.ean.autogenerator.model.po.PackagePO;
import cn.ean.autogenerator.model.vo.GlobalConfigVO;
import cn.ean.autogenerator.service.RemoteCodeGeneratorService;
import org.springframework.stereotype.Service;

/**
 * @author ean
 * @FileName RemoteCodeGeneratorServiceImpl
 * @Date 2022/11/24 15:29
 **/
@Service
public class RemoteCodeGeneratorServiceImpl implements RemoteCodeGeneratorService {

    private GlobalConfigPO globalConfigPO;

    @Override
    public ResponseBO defineGlobalConfig(GlobalConfigVO globalConfigVO) {
        // 设置作者（暂用，后续采用JWT读取当前用户方式）
        globalConfigPO.setAuthor("blacksuit");

        globalConfigPO.setOpen(globalConfigVO.getOpen() == 1);
        globalConfigPO.setBaseResultMap(globalConfigVO.getBaseResultMap() == 1);
        globalConfigPO.setBaseResultList(globalConfigVO.getBaseResultList() == 1);
        globalConfigPO.setSwagger2(globalConfigVO.getSwagger2() == 1);

        // 测试user.dir:用户工作目录
        String userCurrentWorkingDirectory = System.getProperty("user.dir");
        globalConfigPO.setOutputDirectory(userCurrentWorkingDirectory + globalConfigVO.getOutputDirectory());
        return ResponseBO.success("添加全局配置成功");
    }

    @Override
    public ResponseBO defineDataSource(DataSourceVO dataSourceVO) {
        return ResponseBO.success("添加数据源配置成功");
    }

    @Override
    public void definePackage(PackagePO packagePO) {

    }
}
