package cn.ean.autogenerator.controller;

import cn.ean.autogenerator.model.bo.*;
import cn.ean.autogenerator.aspect.*;
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
    public void globalConfig(@RequestBody GlobalConfigPO globalConfigPO) {
        remoteCodeGeneratorService.defineGlobalConfig(globalConfigPO);
    }

    @Log(title = "数据源配置", businessType = BusinessTypeEnum.INSERT)
    @ApiOperation(value = "数据源配置")
    @PostMapping("/mysql/dataSource")
    public void dataSource(@RequestBody DataSourcePO dataSourcePO) {
        remoteCodeGeneratorService.defineDataSource(dataSourcePO);
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
