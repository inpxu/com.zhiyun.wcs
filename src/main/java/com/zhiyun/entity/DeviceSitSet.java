/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class DeviceSitSet extends BaseEntity<Long> {

	private static final long serialVersionUID = 1864694486754190064L;

	// ~~~~实体属性
	// 物流设备编码
	@Pattern(regexp="[\\S]{0,30}", message="物流设备编码字段过长")
	private String diviceNo;
	// 节点id
	@Max(value=9223372036854775807L,message="节点id字段过长")
	private Long sitId;
	// 节点类型节点0,上料1,下料2
	@Max(value=99999999999L,message="节点类型节点0,上料1,下料2字段过长")
	private Integer siteType;
	// 列名
	@Pattern(regexp="[\\S]{0,20}", message="列名字段过长")
	private String listName;
	// 生产设备编码
	@Pattern(regexp="[\\S]{0,30}", message="生产设备编码字段过长")
	private String prodMacNo;
	// 层数
	@Max(value=99999999999L,message="层数字段过长")
	private Integer layer;
	// 节点内置编码
	@Pattern(regexp="[\\S]{0,20}", message="节点内置编码字段过长")
	private String macInSiteNo;
	// 企业id
	@Max(value=9223372036854775807L,message="企业id字段过长")
	private Long companyId;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 物流设备编码
	 */
	public String getDiviceNo() {
		return this.diviceNo;
	}

	/**
	 * 物流设备编码
	 */
	public void setDiviceNo(String diviceNo) {
		this.diviceNo = diviceNo;
	}
	
	/**
	 * 节点id
	 */
	public Long getSitId() {
		return this.sitId;
	}

	/**
	 * 节点id
	 */
	public void setSitId(Long sitId) {
		this.sitId = sitId;
	}
	
	/**
	 * 节点类型节点0,上料1,下料2
	 */
	public Integer getSiteType() {
		return this.siteType;
	}

	/**
	 * 节点类型节点0,上料1,下料2
	 */
	public void setSiteType(Integer siteType) {
		this.siteType = siteType;
	}
	
	/**
	 * 列名
	 */
	public String getListName() {
		return this.listName;
	}

	/**
	 * 列名
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	/**
	 * 生产设备编码
	 */
	public String getProdMacNo() {
		return this.prodMacNo;
	}

	/**
	 * 生产设备编码
	 */
	public void setProdMacNo(String prodMacNo) {
		this.prodMacNo = prodMacNo;
	}
	
	/**
	 * 层数
	 */
	public Integer getLayer() {
		return this.layer;
	}

	/**
	 * 层数
	 */
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	
	/**
	 * 节点内置编码
	 */
	public String getMacInSiteNo() {
		return this.macInSiteNo;
	}

	/**
	 * 节点内置编码
	 */
	public void setMacInSiteNo(String macInSiteNo) {
		this.macInSiteNo = macInSiteNo;
	}
	
	/**
	 * 企业id
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
