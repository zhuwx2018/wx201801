package com.wx.dao;

import com.wx.model.WxproCart;
import com.wx.model.WxproCartExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WxproCartMapper {
    int countByExample(WxproCartExample example);

    int deleteByExample(WxproCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxproCart record);

    int insertSelective(WxproCart record);

    List<WxproCart> selectByExample(WxproCartExample example);

    WxproCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxproCart record, @Param("example") WxproCartExample example);

    int updateByExample(@Param("record") WxproCart record, @Param("example") WxproCartExample example);

    int updateByPrimaryKeySelective(WxproCart record);

    int updateByPrimaryKey(WxproCart record);

	WxproCart selectCartByUserIdProductId(@Param("userId")Integer userId,@Param("productId") Integer productId);

	List<WxproCart> selectCartByUserId(Integer userId);

	int deleteByUserIdProductId(@Param("userId")Integer userId, @Param("productId")Integer productId);

	int deleteByUserIdProductIds(@Param("userId")Integer userId, @Param("productIdlist")List<String> productIdlist);


	int updateByUserId4Checked(@Param("userId")Integer userId, @Param("checked")Integer checked,@Param("productId")Integer productId);


}