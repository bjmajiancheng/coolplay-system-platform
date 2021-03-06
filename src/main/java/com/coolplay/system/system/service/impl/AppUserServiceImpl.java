/*
 * 北京果敢时代科技有限公司
 * 北京市朝阳区望京SOHO T3 B座1607
 * 邮编：100022
 * 网址：www.davdian.com
 */

package com.coolplay.system.system.service.impl;

import java.util.List;

import com.coolplay.system.common.baseservice.impl.BaseService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coolplay.system.system.model.UserModel;
import tk.mybatis.mapper.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import com.coolplay.system.system.dao.*;
import com.coolplay.system.system.service.*;

/**
 * @author  davdian
 * @version 1.0
 * @since 1.0
 */

@Service("appUserService")
public class AppUserServiceImpl extends BaseService<UserModel> implements IAppUserService {
	@Autowired
	private AppUserMapper appUserMapper;
	
	@Override
	public UserModel findById(Integer id) {
		if(id == null) {
			return null;
		}
		return appUserMapper.findById(id);
	}


	public List<UserModel> find(Map<String, Object> param) {
		return appUserMapper.find(param);
	}

	@Override
	public PageInfo<UserModel> selectByFilterAndPage(UserModel userModel, int pageNum,
		int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<UserModel> list = this.selectByFilter(userModel);
		return new PageInfo<>(list);
	}

	@Override
	public List<UserModel> selectByFilter(UserModel userModel) {
		Example example = new Example(UserModel.class);
		Example.Criteria criteria = example.createCriteria();

		if(StringUtils.isNotEmpty(userModel.getSortWithOutOrderBy())) {
			example.setOrderByClause(userModel.getSortWithOutOrderBy());
		}
		return getMapper().selectByExample(example);
	}


	public Map<Integer, UserModel> findMapByUserIds(List<Integer> userIds) {
		if(CollectionUtils.isEmpty(userIds)) {
			return Collections.emptyMap();
		}

		List<UserModel> userModels = this.find(Collections.singletonMap("ids", userIds));
		if(CollectionUtils.isEmpty(userModels)) {
			return Collections.emptyMap();
		}

		Map<Integer, UserModel> userModelMap = new HashMap<Integer, UserModel>();
		for(UserModel userModel : userModels) {
			userModelMap.put(userModel.getId(), userModel);
		}

		return userModelMap;
	}
}
