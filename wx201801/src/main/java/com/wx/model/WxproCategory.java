package com.wx.model;

import java.util.Date;

public class WxproCategory {
    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    //重写eqlals
    @Override
    public boolean equals(Object obj) {
    	if(this == obj){return true;}
    	if(obj == null || obj.getClass()!=this.getClass()){return false;}
    	WxproCategory category = (WxproCategory) obj;
    	return category.getId()!=null? category.getId().equals(this.getId()):this.getId()==null;
    }
    @Override
    public int hashCode() {
    	return id ==null ? 0:id.hashCode();
    }
    
}