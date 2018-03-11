package com.wx.dao;

import com.wx.model.WxproOrderItem;
import com.wx.model.WxproOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxproOrderItemMapper {
    int countByExample(WxproOrderItemExample example);

    int deleteByExample(WxproOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxproOrderItem record);

    int insertSelective(WxproOrderItem record);

    List<WxproOrderItem> selectByExample(WxproOrderItemExample example);

    WxproOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxproOrderItem record, @Param("example") WxproOrderItemExample example);

    int updateByExample(@Param("record") WxproOrderItem record, @Param("example") WxproOrderItemExample example);

    int updateByPrimaryKeySelective(WxproOrderItem record);

    int updateByPrimaryKey(WxproOrderItem record);
}