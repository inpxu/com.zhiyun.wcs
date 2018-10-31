package com.zhiyun.device.dto.config;
/**
 * 是否需要应答(帧确认)
 * @author Think
 *
 */
public enum Ack {
	
	NO("发起端无需应答", (byte)0x00),
	
	YES("发起端需做应答", (byte)0x01),
	
	SUCCESS("命令执行成功", (byte)0x06),
	
	FAIL_NOSUPPORT("校验和正确，命令不被支持", (byte)0x3F),
	
	FAIL_CHECKERROR("校验和不正确", (byte)0x15),
	
	FAIL_DOERROR("校验和正确，命令执行失败", (byte)0x45),
	
	FAIL_NOSEND("指令未被送达", (byte)0x4E),
	
	FAIL_NONETWORK("通讯地址不存在/机器猫网络异常", (byte)0x54);
	
	 // 成员变量  
    private String desc;  
    
    private byte code;
    // 构造方法
    private Ack(String desc, byte code) {  
        this.desc = desc; 
        this.code = code;  
    }
    
    /**
     * 根据值获取枚举类
     * @param b
     * @return
     */
	public static Ack valueOf(byte b) {
		switch (b) {
		case (byte)0x00:
			return Ack.NO;
		case (byte)0x01:
			return Ack.YES;
		case (byte)0x06:
			return Ack.SUCCESS;
		case (byte)0x3F:
			return Ack.FAIL_NOSUPPORT;
		case (byte)0x15:
			return Ack.FAIL_CHECKERROR;
		case (byte)0x45:
			return Ack.FAIL_DOERROR;
		case (byte)0x4E:
			return Ack.FAIL_NOSEND;
		case (byte)0x54:
			return Ack.FAIL_NONETWORK;
		
		}
		return null;
	}
    
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public byte getCode() {
		return code;
	}
	public void setCode(byte code) {
		this.code = code;
	}  
    
    
}
