package com.zhangtao.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.zhangtao.cms.domain.Collect;

public interface CollectService {

	/**
	 * 
	 * @Title: addCollect
	 * @Description: 文章的收藏
	 * @param collect
	 * @return
	 * @return: int
	 */
	int insert(Collect collect);

	/**
	 * 
	 * @Title: delete
	 * @Description: 取消收藏
	 * @param id
	 * @return
	 * @return: int
	 */
	int delete(Integer id);

	/**
	 * 
	 * @Title: select
	 * @Description: 显示我的收藏夹
	 * @return
	 * @return: List<Collect>
	 */
	PageInfo<Collect> select(Integer userId,Integer page,Integer pageSize);
	/**
	 * 
	 * @Title: selectByUrlAndUserID 
	 * @Description: 根据标题和用户ID查询是否已经收藏
	 * 
	 * @param url
	 * @param userId
	 * @return
	 * @return: Collect
	 */
	Collect selectByTitleAndUserID(@Param("title")String title,@Param("userId")Integer userId);
}
