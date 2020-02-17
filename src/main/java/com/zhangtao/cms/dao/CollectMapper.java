package com.zhangtao.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangtao.cms.domain.Collect;

public interface CollectMapper {
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
	List<Collect> select(Integer userId);
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
