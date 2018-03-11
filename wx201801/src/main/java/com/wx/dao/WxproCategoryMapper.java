package com.wx.dao;

import com.wx.model.WxproCategory;
import com.wx.model.WxproCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxproCategoryMapper {
    int countByExample(WxproCategoryExample example);

    int deleteByExample(WxproCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxproCategory record);

    int insertSelective(WxproCategory record);

    List<WxproCategory> selectByExample(WxproCategoryExample example);

    WxproCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxproCategory record, @Param("example") WxproCategoryExample example);

    int updateByExample(@Param("record") WxproCategory record, @Param("example") WxproCategoryExample example);

    int updateByPrimaryKeySelective(WxproCategory record);

    int updateByPrimaryKey(WxproCategory record);
    
    List<WxproCategory> selectByParentId(Integer parentId);
}