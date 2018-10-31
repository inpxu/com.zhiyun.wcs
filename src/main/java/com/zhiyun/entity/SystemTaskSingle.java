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
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class SystemTaskSingle extends BaseEntity<Long> {

	private static final long serialVersionUID = 2025813763615032302L;

	// ~~~~实体属性
	// 起始节点id
	@Max(value=9223372036854775807L,message="起始节点id字段过长")
	private Long startSiteId;
	// 终止节点id
	@Max(value=9223372036854775807L,message="终止节点id字段过长")
	private Long endSiteId;
	// 需要完成时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date requestedTime;
	// 任务号
	@Max(value=9223372036854775807L,message="任务号字段过长")
	private Long taskId;
	// 企业id
	@Max(value=9223372036854775807L,message="企业id字段过长")
	private Long companyId;
	// 类型0上下料1移箱
	@Max(value=99999999999L,message="类型0上下料1移箱字段过长")
	private Integer singleType;
	// 任务状态
	@Pattern(regexp="[\\S]{0,3}", message="任务状态字段过长")
	private String jobStatus;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
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
	 * 需要完成时间
	 */
	public java.util.Date getRequestedTime() {
		return this.requestedTime;
	}

	/**
	 * 需要完成时间
	 */
	public void setRequestedTime(java.util.Date requestedTime) {
		this.requestedTime = requestedTime;
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
	 * 类型0上下料1移箱
	 */
	public Integer getSingleType() {
		return this.singleType;
	}

	/**
	 * 类型0上下料1移箱
	 */
	public void setSingleType(Integer singleType) {
		this.singleType = singleType;
	}
	
	/**
	 * 任务状态
	 */
	public String getJobStatus() {
		return this.jobStatus;
	}

	/**
	 * 任务状态
	 */
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
}
