package cn.ean.autogenerator.controller;

import cn.ean.autogenerator.aspect.*;
import cn.ean.autogenerator.model.bo.ResponseBO;
import cn.ean.autogenerator.model.po.DataSourcePO;
import cn.ean.autogenerator.model.po.PackagePO;
import cn.ean.autogenerator.model.vo.DataSourceVO;
import cn.ean.autogenerator.model.vo.GlobalConfigVO;
import io.swagger.annotations.ApiOperation;
import cn.ean.autogenerator.service.RemoteCodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ean
 * @FileName RemoteCodeGeneratorController
 * @Date 2022/11/24 15:23
 **/
@RestController
@RequestMapping("/remote/code/generator")
public class RemoteCodeGeneratorController {


    private RemoteCodeGeneratorService remoteCodeGeneratorService;


    public RemoteCodeGeneratorController() {
    }

    @Autowired
    public RemoteCodeGeneratorController(RemoteCodeGeneratorService remoteCodeGeneratorService) {
        this.remoteCodeGeneratorService = remoteCodeGeneratorService;
    }

    @Log(title = "全局配置", businessType = BusinessTypeEnum.INSERT)
    @ApiOperation(value = "全局配置")
    @PostMapping("/mysql/globalConfig")
    public ResponseBO globalConfig(@RequestBody GlobalConfigVO globalConfigVO) {
        return remoteCodeGeneratorService.defineGlobalConfig(globalConfigVO);
    }

    @Log(title = "数据源配置", businessType = BusinessTypeEnum.INSERT)
    @ApiOperation(value = "数据源配置")
    @PostMapping("/mysql/dataSource")
    public ResponseBO dataSource(@RequestBody DataSourceVO dataSourceVO) {
        return remoteCodeGeneratorService.defineDataSource(dataSourceVO);
    }

    @Log(title = "包配置", businessType = BusinessTypeEnum.INSERT)
    @ApiOperation(value = "包配置")
    @PostMapping("/mysql/package")
    public void dataSource(@RequestBody PackagePO packagePO) {
        remoteCodeGeneratorService.definePackage(packagePO);
    }

    @Log(title = "数据库表", businessType = BusinessTypeEnum.INSERT)
    @ApiOperation(value = "数据库表")
    @GetMapping("/mysql/{tables}")
    public void Generator(@PathVariable String tables) {

    }
}
