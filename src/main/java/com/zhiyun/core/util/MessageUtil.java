package com.zhiyun.core.util;

import com.zhiyun.entity.SitSet;

/**
 * 报文生成工具类
 * 报文生成工具类主要用来生成写多个寄存器和写单个寄存器的报文
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-11-07 08:47
 */
public class MessageUtil {

    /**
     * 写多个寄存报文工具类
     *
     * @param messageContent 消息内容
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/11/7 17:28
     */
    public static String message4ManyRegister(String messageContent) {
        StringBuilder sb = new StringBuilder();
        sb.append("01010301");
        //实际命令字节数
        int orderByteLenth = (messageContent.length() / 2);
        //标准modbus命令字节长度，需要注意的是要加上之前的一位0x01的长度1，因为0x01是写死的，所以直接加1
        int standardModbusByteLenth = orderByteLenth + 2;
        //机器猫需要的--整个modbus报文的长度，所以加上7个字节长度
        int mcatByteLenth = orderByteLenth + 8;
        //1. 拼接机器猫需要的命令长度,转16进制
        if (orderByteLenth <= 255) {
            sb.append(String.format("%02x", mcatByteLenth));
        } else {
            throw new RuntimeException("报文长度错误");
        }
        //2. 拼接固定的4个字节的0
        sb.append("0000000000");
        //3. 拼接标准modbus报文长度
        if (standardModbusByteLenth <= 255) {
            sb.append(String.format("%02x", standardModbusByteLenth));
        } else {
            throw new RuntimeException("报文长度错误");
        }
        //4. 拼接固定0110 10表示写多个寄存器
        sb.append("0110");
        //5.拼接实际报文
        sb.append(messageContent);
        //6.拼接机器猫停止标志
        sb.append("0000");
        return sb.toString();
    }

    /**
     * 写单个寄存器
     *
     * @param messageContent 消息内容
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/11/8 10:49
     */
    public static String message4SingleRegister(String messageContent) {
        StringBuilder sb = new StringBuilder();
        sb.append("01010301");
        //实际命令字节数
        int orderByteLenth = (messageContent.length() / 2);
        //标准modbus命令字节长度，需要注意的是要加上之前的一位0x01的长度1，因为0x01是写死的，所以直接加1
        int standardModbusByteLenth = orderByteLenth + 2;
        //机器猫需要的--整个modbus报文的长度，所以加上7个字节长度
        int mcatByteLenth = orderByteLenth + 8;
        //1. 拼接机器猫需要的命令长度,转16进制
        if (orderByteLenth <= 255) {
            sb.append(String.format("%02x", mcatByteLenth));
        } else {
            throw new RuntimeException("报文长度错误");
        }
        //2. 拼接固定的4个字节的0
        sb.append("0000000000");
        //3. 拼接标准modbus报文长度
        if (standardModbusByteLenth <= 255) {
            sb.append(String.format("%02x", standardModbusByteLenth));
        } else {
            throw new RuntimeException("报文长度错误");
        }
        //4. 拼接固定0110 10表示写多个寄存器
        sb.append("0106");
        //5.拼接实际报文,------->需要非常注意的是，捷顺报文高低位需要互换
        String registerAddr = messageContent.substring(0, 4);
        sb.append(registerAddr);
        String order = messageContent.substring(4);
        String higth = order.substring(0, 2);
        String low = order.substring(2);
        sb.append(low);
        sb.append(higth);
        //6.拼接机器猫停止标志
        sb.append("0000");
        return sb.toString();
    }

    /**
     * 通过站点名，将站点转换成报文
     * 如 0001 0002
     *
     * @param siteName
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/11/8 13:04
     */
    public static String parseSite2Byte(String siteName) {
        StringBuilder stringBuilder = new StringBuilder();
        //位置寄存器值
        String positionByte = "00" + String.format("%02x", Integer.parseInt(siteName.substring(1, 3)));
        stringBuilder.append(positionByte);
        //层数寄存器值
        String layerByte = "00" + siteName.substring(4);
        stringBuilder.append(layerByte);
        return stringBuilder.toString();
    }

    /**
     * 生成设置位置报文
     *
     * @param siteName
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/11/9 10:26
     */
    public static String generateMessageContentForPositionSet(String siteName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0001000204");
        String s = MessageUtil.parseSite2Byte(siteName);
        stringBuilder.append(s);
        return stringBuilder.toString();
    }

    /**
     * 生成设置动作报文
     *
     * @param sitSet 站定
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/11/9 10:52
     */
    public static String generateMessageContentForMotionSet(SitSet sitSet, Integer selectFork, Integer putBox, Integer getBox, Integer move) {
        String code = null;
        StringBuilder stringBuilder = new StringBuilder();
        //        stringBuilder.append("0000");
        //命令
        stringBuilder.append(sitSet.getLine());
        stringBuilder.append("000");
        //货叉选择0A 1B
        stringBuilder.append(selectFork);
        //放箱子0 1执行
        stringBuilder.append(putBox);
        //取箱子
        stringBuilder.append(getBox);
        //行走
        stringBuilder.append(move);
        //转换成16进制
        String s = Integer.toString(Integer.parseInt(stringBuilder.toString(), 2), 16);
        if (s.length() < 2) {
            code = "000" + s;
        } else {
            code = "00"+s;
        }

        return "0000" + code;
    }

}
