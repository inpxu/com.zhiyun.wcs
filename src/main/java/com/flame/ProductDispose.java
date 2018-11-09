package com.flame;

import com.flame.dto.ProtocalData;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xhc
 * @version v1.0
 * @date 2018-10-12 14:13
 */
@Service("productDispose")
public class ProductDispose {
    private static final Logger logger = LoggerFactory.getLogger(ProductDispose.class);

    @Resource
    private JmsTemplate jmsQueueTemplate;

    /**
     * 发送数据报文
     *
     * @param
     * @return
     */
    public boolean sendToMachine(String commonCode, String dataCode) {
        boolean flag = false;
        try {

            if (commonCode == null || "".equals(commonCode)) {
                return flag;
            }
            String time = String.valueOf(System.currentTimeMillis());
            byte[] codeBytes = buildByteArr(dataCode, time);

            ProtocalData protocalData = new ProtocalData((byte) 0x0D, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x04, commonCode, codeBytes);
            jmsQueueTemplate.convertAndSend(protocalData);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        return flag;
    }

    /**
     * 组成数据报文
     *
     * @param dataCode
     * @return
     */
    private static byte[] buildByteArr(String dataCode, String time) {
        byte[] bytes = null;
        try {
            //数据转偶数
            time = time.length() % 2 == 1 ? "0" + time : time;
            dataCode = dataCode.length() % 2 == 1 ? "0" + dataCode : dataCode;

            String data = time + (dataCode == null ? "" : dataCode);

            String length = Integer.toHexString(data.length() / 2);
            data = length.length() == 2 ? "00" + length + data : length + data;
            bytes = Hex.decodeHex(data.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        return bytes;
    }
}
