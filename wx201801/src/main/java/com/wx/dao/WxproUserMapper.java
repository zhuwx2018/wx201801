package com.wx.dao;

import com.wx.model.WxproUser;
import com.wx.model.WxproUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxproUserMapper {
    int countByExample(WxproUserExample example);

    int deleteByExample(WxproUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxproUser record);

    int insertSelective(WxproUser record);

    List<WxproUser> selectByExample(WxproUserExample example);

    WxproUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxproUser record, @Param("example") WxproUserExample example);

    int updateByExample(@Param("record") WxproUser record, @Param("example") WxproUserExample example);

    int updateByPrimaryKeySelective(WxproUser record);

    int updateByPrimaryKey(WxproUser record);
}