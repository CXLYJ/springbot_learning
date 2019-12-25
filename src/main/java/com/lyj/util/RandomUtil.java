package com.lyj.util;

import java.util.Random;

/**
 * @author 作者 :lyj
 * @version 创建时间：2018年8月24日 下午3:19:06
 * 生成随机八位数
 */
public class RandomUtil {

	public static String getRandom(int n){
		StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<n;i++){
            str.append(random.nextInt(10));
        }
        //将字符串转换为数字并输出
        String num=str.toString();
        return num;
	}
	
}
