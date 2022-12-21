package cn.ean.autogenerator.model.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ean
 * @FileName PackageBO
 * @Date 2022/11/24 16:17
 **/
@Data
public class PackagePO {

    private String parent;

    private String entity;

    private String mapper;

    private String service;


    @ApiModelProperty("ex: service.impl")
    private String serviceImpl;

    private String controller;
}
