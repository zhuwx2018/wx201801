package com.wx.dao;

import com.wx.model.WxproOrder;
import com.wx.model.WxproOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxproOrderMapper {
    int countByExample(WxproOrderExample example);

    int deleteByExample(WxproOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxproOrder record);

    int insertSelective(WxproOrder record);

    List<WxproOrder> selectByExample(WxproOrderExample example);

    WxproOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxproOrder record, @Param("example") WxproOrderExample example);

    int updateByExample(@Param("record") WxproOrder record, @Param("example") WxproOrderExample example);

    int updateByPrimaryKeySelective(WxproOrder record);

    int updateByPrimaryKey(WxproOrder record);
}