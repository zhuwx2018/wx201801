package com.wx.dao;

import com.wx.model.WxproProduct;
import com.wx.model.WxproProductExample;
import com.wx.model.WxproProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxproProductMapper {
    int countByExample(WxproProductExample example);

    int deleteByExample(WxproProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxproProductWithBLOBs record);

    int insertSelective(WxproProductWithBLOBs record);

    List<WxproProductWithBLOBs> selectByExampleWithBLOBs(WxproProductExample example);

    List<WxproProduct> selectByExample(WxproProductExample example);

    WxproProductWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxproProductWithBLOBs record, @Param("example") WxproProductExample example);

    int updateByExampleWithBLOBs(@Param("record") WxproProductWithBLOBs record, @Param("example") WxproProductExample example);

    int updateByExample(@Param("record") WxproProduct record, @Param("example") WxproProductExample example);

    int updateByPrimaryKeySelective(WxproProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WxproProductWithBLOBs record);

    int updateByPrimaryKey(WxproProduct record);
}