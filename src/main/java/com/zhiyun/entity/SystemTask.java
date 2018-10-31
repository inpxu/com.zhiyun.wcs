/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhiyun.base.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 系统任务表实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class SystemTask extends BaseEntity<Long> {

	private static final long serialVersionUID = 5814129502265246325L;

	// ~~~~实体属性
	// 库区
	@Pattern(regexp="[\\S]{0,20}", message="库区字段过长")
	private String areaName;
	// 仓库
	@Pattern(regexp="[\\S]{0,20}", message="仓库字段过长")
	private String storeName;
	// 起始节点id
	@Max(value=9223372036854775807L,message="起始节点id字段过长")
	private Long startSiteId;
	// 终止节点id
	@Max(value=9223372036854775807L,message="终止节点id字段过长")
	private Long endSiteId;
	// 进出库标记0进/1出/2搬运
	@Max(value=99999999999L,message="进出库标记0进/1出/2搬运字段过长")
	private Integer inMark;
	// 物料类型
	@Pattern(regexp="[\\S]{0,30}", message="物料类型字段过长")
	private String matterType;
	// 物料名称
	@Pattern(regexp="[\\S]{0,30}", message="物料名称字段过长")
	private String matterName;
	// 数量
	@Max(value=99999999999L,message="数量字段过长")
	private Integer amount;
	// 请求时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date requestTime;
	// 任务号
	@Max(value=9223372036854775807L,message="任务号字段过长")
	private Long taskId;
	// 企业id
	@Max(value=9223372036854775807L,message="企业id字段过长")
	private Long companyId;
	// 是否完成
	@Pattern(regexp="[\\S]{0,3}", message="是否完成字段过长")
	private String isFinished;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 库区
	 */
	public String getAreaName() {
		return this.areaName;
	}

	/**
	 * 库区
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	/**
	 * 仓库
	 */
	public String getStoreName() {
		return this.storeName;
	}

	/**
	 * 仓库
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	/**
	 * 起始节点id
	 */
	public Long getStartSiteId() {
		return this.startSiteId;
	}

	/**
	 * 起始节点id
	 */
	public void setStartSiteId(Long startSiteId) {
		this.startSiteId = startSiteId;
	}
	
	/**
	 * 终止节点id
	 */
	public Long getEndSiteId() {
		return this.endSiteId;
	}

	/**
	 * 终止节点id
	 */
	public void setEndSiteId(Long endSiteId) {
		this.endSiteId = endSiteId;
	}
	
	/**
	 * 进出库标记0进/1出/2搬运
	 */
	public Integer getInMark() {
		return this.inMark;
	}

	/**
	 * 进出库标记0进/1出/2搬运
	 */
	public void setInMark(Integer inMark) {
		this.inMark = inMark;
	}
	
	/**
	 * 物料类型
	 */
	public String getMatterType() {
		return this.matterType;
	}

	/**
	 * 物料类型
	 */
	public void setMatterType(String matterType) {
		this.matterType = matterType;
	}
	
	/**
	 * 物料名称
	 */
	public String getMatterName() {
		return this.matterName;
	}

	/**
	 * 物料名称
	 */
	public void setMatterName(String matterName) {
		this.matterName = matterName;
	}
	
	/**
	 * 数量
	 */
	public Integer getAmount() {
		return this.amount;
	}

	/**
	 * 数量
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	/**
	 * 请求时间
	 */
	public java.util.Date getRequestTime() {
		return this.requestTime;
	}

	/**
	 * 请求时间
	 */
	public void setRequestTime(java.util.Date requestTime) {
		this.requestTime = requestTime;
	}
	
	/**
	 * 任务号
	 */
	public Long getTaskId() {
		return this.taskId;
	}

	/**
	 * 任务号
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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
	
	/**
	 * 是否完成
	 */
	public String getIsFinished() {
		return this.isFinished;
	}

	/**
	 * 是否完成
	 */
	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}
}
