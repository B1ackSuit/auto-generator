package cn.ean.autogenerator.service.impl;

import cn.ean.autogenerator.mapper.*;
import cn.ean.autogenerator.model.bo.ResponseBO;
import cn.ean.autogenerator.model.po.DataSourcePO;
import cn.ean.autogenerator.model.po.StrategyConfigPO;
import cn.ean.autogenerator.model.vo.DataSourceVO;
import cn.ean.autogenerator.model.po.GlobalConfigPO;
import cn.ean.autogenerator.model.po.PackagePO;
import cn.ean.autogenerator.model.vo.GeneratorModelIdVO;
import cn.ean.autogenerator.model.vo.GlobalConfigVO;
import cn.ean.autogenerator.service.RemoteCodeGeneratorService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * @author ean
 * @FileName RemoteCodeGeneratorServiceImpl
 * @Date 2022/11/24 15:29
 **/
@Service
public class RemoteCodeGeneratorServiceImpl implements RemoteCodeGeneratorService {


    private RemoteCodeGeneratorMapper remoteCodeGeneratorMapper;
    private GlobalConfigMapper globalConfigMapper;
    private DataSourceMapper dataSourceMapper;
    private PackageMapper packageMapper;
    private StrategyConfigMapper strategyConfigMapper;

    private final String userCurrentWorkingDirectory = System.getProperty("user.dir");

    public RemoteCodeGeneratorServiceImpl() {
    }

    @Autowired
    public RemoteCodeGeneratorServiceImpl(RemoteCodeGeneratorMapper remoteCodeGeneratorMapper,
                                          GlobalConfigMapper globalConfigMapper,
                                          DataSourceMapper dataSourceMapper,
                                          PackageMapper packageMapper,
                                          StrategyConfigMapper strategyConfigMapper) {
        this.remoteCodeGeneratorMapper = remoteCodeGeneratorMapper;
        this.globalConfigMapper = globalConfigMapper;
        this.dataSourceMapper = dataSourceMapper;
        this.packageMapper = packageMapper;
        this.strategyConfigMapper = strategyConfigMapper;
    }

    @Override
    public ResponseBO defineGlobalConfig(GlobalConfigVO globalConfigVO) {
        GlobalConfigPO globalConfigPO = new GlobalConfigPO();

        // ????????????????????????????????????JWT???????????????????????????
        globalConfigPO.setAuthor("blacksuit");

        globalConfigPO.setOpen(globalConfigVO.getOpen() == 1);
        globalConfigPO.setBaseResultMap(globalConfigVO.getBaseResultMap() == 1);
        globalConfigPO.setBaseColumnList(globalConfigVO.getBaseColumnList() == 1);
        globalConfigPO.setSwagger2(globalConfigVO.getSwagger2() == 1);

        // ??????user.dir:??????????????????

        globalConfigPO.setOutputDirectory(userCurrentWorkingDirectory + globalConfigVO.getOutputDirectoryForUser());
        return ResponseBO.success("????????????????????????");
    }

    @Override
    public ResponseBO defineDataSource(DataSourceVO dataSourceVO) {
        return ResponseBO.success("???????????????????????????");
    }

    @Override
    public void definePackage(PackagePO packagePO) {

    }

    @Override
    public ResponseBO autoGenerator(GeneratorModelIdVO generatorModelIDVO) {
        AutoGenerator autoGenerator = new AutoGenerator();


        Integer dataSourcePKID = generatorModelIDVO.getDataSourcePKID();
        Integer globalConfigPKID = generatorModelIDVO.getGlobalConfigPKID();
        Integer packagePKID = generatorModelIDVO.getPackagePKID();
        Integer strategyPKID = generatorModelIDVO.getStrategyConfigPKID();

        GlobalConfigPO globalConfigPO = globalConfigMapper.selectById(globalConfigPKID);

        if (!isEmpty(globalConfigPO)){
            GlobalConfig globalConfig = new GlobalConfig();
            String projectPath = globalConfigPO.getOutputDirectory();
            globalConfig.setOutputDir(projectPath);
            globalConfig.setAuthor(globalConfigPO.getAuthor());
            // ??????????????????
            globalConfig.setOpen(globalConfigPO.getOpen());
            // xml???????????? BaseResultMap
            globalConfig.setBaseResultMap(globalConfigPO.getBaseResultMap());
            // xml???????????? BaseColumnList
            globalConfig.setBaseColumnList(globalConfigPO.getBaseColumnList());
            // ??????????????? Swagger2 ??????
            globalConfig.setSwagger2(globalConfigPO.getSwagger2());
            autoGenerator.setGlobalConfig(globalConfig);
        } else {
            return ResponseBO.error("???????????????????????????????????????");
        }

        DataSourcePO dataSourcePO = dataSourceMapper.selectById(dataSourcePKID);
        if (!isEmpty(dataSourcePO)){
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setUrl(dataSourcePO.getUrl());
            dataSourceConfig.setDriverName(dataSourcePO.getDriverName());
            dataSourceConfig.setUsername(dataSourcePO.getUsername());
            dataSourceConfig.setPassword(dataSourcePO.getPassword());
            autoGenerator.setDataSource(dataSourceConfig);
        } else {
            return ResponseBO.error("????????????????????????????????????");
        }


        PackagePO packagePO = packageMapper.selectById(packagePKID);
        if (!isEmpty(packagePO)) {
            PackageConfig packageConfig = new PackageConfig();
            packageConfig.setParent(packagePO.getParent());
            packageConfig.setEntity(packagePO.getEntity());
            packageConfig.setMapper(packagePO.getMapper());
            packageConfig.setService(packagePO.getService());
            packageConfig.setServiceImpl(packagePO.getServiceImpl());
            packageConfig.setController(packagePO.getController());
            autoGenerator.setPackageInfo(packageConfig);
        } else {
            return ResponseBO.error("??????????????????????????????????????????");
        }

        /* ?????????????????????????????????????????????????????? */

        //???????????????
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        // ??????????????????
        // freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // Velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // ?????????????????????
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        // ?????????????????????????????????
        fileOutConfigList.add(new FileOutConfig(templatePath) {
            // ?????????????????????????????????Entity????????????????????????????????? xml ??????????????????????????????
            @Override
            public String outputFile(TableInfo tableInfo) {
                return userCurrentWorkingDirectory + "/src/main/resources/mapper/" +
                //    tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                    tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        });

        injectionConfig.setFileOutConfigList(fileOutConfigList);

        autoGenerator.setCfg(injectionConfig);

        // ????????????
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        StrategyConfigPO strategyConfigPO = strategyConfigMapper.selectById(strategyPKID);
        if (!isEmpty(strategyConfigPO)) {
            // ????????????
            StrategyConfig strategy = new StrategyConfig();
            // ??????????????????????????????????????????
            strategy.setNaming(NamingStrategy.underline_to_camel);
            //????????????????????????????????????????????????
            strategy.setColumnNaming(NamingStrategy.no_change);
            //lombok??????
            strategy.setEntityLombokModel(true);
            //?????? @RestController ?????????
            strategy.setRestControllerStyle(true);
            // strategy.setInclude(scanner("?????????????????????????????????").split(","));
            strategy.setInclude(strategyConfigPO.getInclude());
            strategy.setControllerMappingHyphenStyle(true);
            //?????????
            strategy.setTablePrefix("t_");
            autoGenerator.setStrategy(strategy);
        } else {
            return ResponseBO.error("???????????????????????????????????????");
        }

        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();


        return ResponseBO.success("autoGenerator????????????");
    }
}
