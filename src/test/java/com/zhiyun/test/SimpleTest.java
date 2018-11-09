package com.zhiyun.test;

import com.flame.dto.ProtocalData;
import com.zhiyun.core.util.MessageUtil;
import com.zhiyun.entity.SitSet;
import org.junit.Test;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-11-01 09:44
 */
public class SimpleTest {
    @Test
    public void demo9() {
        ProtocalData protocalData = new ProtocalData();
        System.err.println(protocalData);
    }

    @Test
    public void demo1() {
        int a = 255;
        System.out.println(Integer.toHexString(a));
    }

    @Test
    public void demo2() {
        System.out.println(String.format("%02x", 10));

    }

    @Test
    public void demo3() {
        String s = MessageUtil.message4ManyRegister("000100020400020001");
        System.out.println(s);
    }

    @Test
    public void demo4() {
        String s = MessageUtil.message4SingleRegister("00000009");
        System.out.println(s);

    }

    @Test
    public void demo5() {
        //入库路径规划
        String startSiteName = "106-1";
        String endSiteName = "101-2";

        String substring = startSiteName.substring(0, 1);
        System.out.println(substring);
        String substring1 = endSiteName.substring(0, 1);
        if (substring.equals(substring1)) {
            System.err.println("第一列");
            //起点叫车
        }

    }


     @Test
     public void demo6(){
         String s = MessageUtil.parseSite2Byte("101-1");
         System.out.println(s);

     }
      @Test
      public void demo7(){
         StringBuilder stringBuilder= new StringBuilder();
         Integer line =0;
          stringBuilder.append(line);
          stringBuilder.append("000");
          //货叉选择0A 1B
          stringBuilder.append("1");
          //放箱子0 1执行
          stringBuilder.append("1");
          //取箱子
          stringBuilder.append("0");
          //行走
          stringBuilder.append("0");
          System.out.println(stringBuilder.toString());
          //转换成16进制
          System.out.println(Integer.toString(Integer.parseInt(stringBuilder.toString(), 2), 16));

      }
       @Test
       public void demo8(){
           SitSet sitSet= new SitSet();
           sitSet.setLine(0);
           String s = MessageUtil.generateMessageContentForMotionSet(sitSet, 0, 0, 1, 0);
           System.out.println(s);
       }

}
