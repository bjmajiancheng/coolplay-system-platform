/*
 * 北京果敢时代科技有限公司
 * 北京市朝阳区望京SOHO T3 B座1607
 * 邮编：100022
 * 网址：www.davdian.com
 */

package com.coolplay.system.system.service;

import com.coolplay.system.common.baseservice.IBaseService;
import com.coolplay.system.system.model.BannerModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.*;
import com.coolplay.system.system.dao.*;
import com.coolplay.system.system.service.*;

/**
 * @author  davdian
 * @version 1.0
 * @since 1.0
 */

public interface IBannerService extends IBaseService<BannerModel> {

	public BannerModel findById(Integer id);

	public List<BannerModel> find(Map<String, Object> param);

	public PageInfo<BannerModel> selectByFilterAndPage(BannerModel bannerModel, int pageNum, int pageSize);

	public List<BannerModel> selectByFilter(BannerModel bannerModel);

}
