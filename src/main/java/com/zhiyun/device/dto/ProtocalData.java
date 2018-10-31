package com.zhiyun.device.dto;

import com.zhiyun.device.dto.config.Ack;
import com.zhiyun.device.util.ByteUtil;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProtocalData implements Serializable{


	private byte[] devType ={0x00,0x10};// 设备类别
	
	private byte afn=0x0c;// 设备类别
	
	private byte common =0x00;// 命令编码   暂无用；
	
	private Ack ack;
	
	private byte firOrFin= 0x03;
	
	private byte channelCode;  //通道标识   0x00  SCADA  0x01 NB
	
	private byte useCode;  //用途标识   0x00  标准数采  0x01 定制服务
	
	private byte appCode;//应用标识
	
	private byte fnCode;//功能标识
	
	private String commCode;//机联网编码
	
	private byte[] content;//报文内容 
	
	private String modifyTime;
	
	public ProtocalData(){}
	
	public ProtocalData(byte ack,byte channelCode,byte useCode,byte appCode,byte fnCode,String commCode,byte[] content){
		this.ack = Ack.valueOf(ack);
		this.channelCode = channelCode;
		this.useCode = useCode;
		this.appCode = appCode;
		this.fnCode = fnCode;
		this.commCode = commCode;
		this.content = content;
		
	}


    public ProtocalData(byte afn,byte ack,byte channelCode,byte useCode,byte appCode,byte fnCode,String commCode,byte[] content){
        this.afn = afn;
        this.ack = Ack.valueOf(ack);
        this.channelCode = channelCode;
        this.useCode = useCode;
        this.appCode = appCode;
        this.fnCode = fnCode;
        this.commCode = commCode;
        this.content = content;
    }
	
	
	
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(byte[] modifyTimeBytes) {
		String modifyTimeStr = ByteUtil.byteArrayToHexString(modifyTimeBytes, false);
		StringBuffer sb= new StringBuffer("20");
		sb.append(modifyTimeStr.subSequence(0, 2)).append("-")
		.append(modifyTimeStr.subSequence(2, 4)).append("-")
		.append(modifyTimeStr.subSequence(4, 6)).append(" ")
		.append(modifyTimeStr.subSequence(6, 8)).append(":")
		.append(modifyTimeStr.subSequence(8, 10)).append(":")
		.append(modifyTimeStr.subSequence(10, 12));
//		if(DateUtil.strToDate(sb.toString())==null)
//			this.modifyTime = DateUtil.nowToStr();
//		else
			this.modifyTime = sb.toString();
		
		//this.modifyTime = new String(modifyTimeBytes);
	}
	
//	public static void main(String[] args) {
//		byte[] modifyTimeBytes = {0x18,0x08,0x22,0x13,0x38,0x40};
//		
//		System.out.println(sb.toString());
//	}

	public byte[] getDevType() {
		return devType;
	}

	public void setDevType(byte[] devType) {
		this.devType = devType;
	}

	public byte getAfn() {
		return afn;
	}

	public void setAfn(byte afn) {
		this.afn = afn;
	}

	public byte getCommon() {
		return common;
	}

	public void setCommon(byte common) {
		this.common = common;
	}

	public Ack getAck() {
		return ack;
	}

	public void setAck(Ack ack) {
		this.ack = ack;
	}

	public byte getFirOrFin() {
		return firOrFin;
	}

	public void setFirOrFin(byte firOrFin) {
		this.firOrFin = firOrFin;
	}

	public byte getUseCode() {
		return useCode;
	}

	public void setUseCode(byte useCode) {
		this.useCode = useCode;
	}

	public byte getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(byte channelCode) {
		this.channelCode = channelCode;
	}

	public byte getAppCode() {
		return appCode;
	}

	public void setAppCode(byte appCode) {
		this.appCode = appCode;
	}

	public byte getFnCode() {
		return fnCode;
	}

	public void setFnCode(byte fnCode) {
		this.fnCode = fnCode;
	}

	public String getCommCode() {
		return commCode;
	}

	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
	
}
