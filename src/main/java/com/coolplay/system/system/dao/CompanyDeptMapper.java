/*
 * 北京果敢时代科技有限公司
 * 北京市朝阳区望京SOHO T3 B座1607
 * 邮编：100022
 * 网址：www.davdian.com
 */

package com.coolplay.system.system.dao;

import com.coolplay.system.system.model.CompanyDeptModel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author  davdian
 * @version 1.0
 * @since 1.0
 */

public interface CompanyDeptMapper extends Mapper<CompanyDeptModel> {

	public List<CompanyDeptModel> find(Map<String, Object> param);

	public CompanyDeptModel findById(@Param("id") int id);

}
