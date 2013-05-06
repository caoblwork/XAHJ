package com.evalley.xahj.util;

import java.util.UUID;

/**
 * @Description UUID生成器类
 * @author Evalley
 * @date 2011-10-11 上午10:42:18
 */
public class UUIDGenerator {
	/** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        return UUID.randomUUID().toString().replaceAll("-", ""); 
    }
    
    /** 
     * 获得指定数目的UUID 
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数组 
     */ 
    public static String[] getUUID(int number){ 
        String[] UUIDs = null;
        if(number > 0){ 
        	UUIDs = new String[number]; 
        	for(int i=0; i<number; i++){ 
        		UUIDs[i] = getUUID(); 
        	} 
        } 
        return UUIDs; 
    } 
}
