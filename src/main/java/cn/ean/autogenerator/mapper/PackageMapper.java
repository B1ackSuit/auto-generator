package cn.ean.autogenerator.mapper;

import cn.ean.autogenerator.model.po.PackagePO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ean
 * @FileName PackageMapper
 * @Date 2022/12/21 10:53
 **/
@Mapper
public interface PackageMapper extends BaseMapper<PackagePO> {
}
