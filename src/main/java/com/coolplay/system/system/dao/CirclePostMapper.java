/*
 * 北京果敢时代科技有限公司
 * 北京市朝阳区望京SOHO T3 B座1607
 * 邮编：100022
 * 网址：www.davdian.com
 */

package com.coolplay.system.system.dao;
import com.coolplay.system.system.model.CirclePostModel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.*;
import com.coolplay.system.system.dao.*;
import com.coolplay.system.system.service.*;

/**
 * @author  davdian
 * @version 1.0
 * @since 1.0
 */

public interface CirclePostMapper extends Mapper<CirclePostModel> {

	public List<CirclePostModel> find(Map<String, Object> param);

	public CirclePostModel findById(@Param("id") Integer id);

	public List<CirclePostModel> findByPostId(@Param("postId")Integer postId);

	public int updateTopByCirclePostInfo(@Param("circleIds")List<Integer> circleIds, @Param("postId")Integer postId, @Param("isTop")Integer isTop);

	public int updateTopByPostId(@Param("postId")Integer postId, @Param("isTop")Integer isTop);
}
