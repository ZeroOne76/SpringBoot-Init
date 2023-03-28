package com.shanhai.springbootinittemplate.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.util.Map;

/**
 * JWT工具类
 */
public class JwtUtils {
    private static final String defaultKey = "shanhai_shanhai";
    private static final DateField defaultDateField = DateField.MINUTE;
    private static final int defaultTime = 60;


    /**
     * 生成token
     * @param payload 放入载荷中的数据
     * @param key 加解密密钥
     * @param signDate 签名时间
     * @param expireDate 过期时间
     * @param workDate 起效时间
     * @return token
     */
    public static String createToken(
            Map<String,Object> payload,
            String key,
            DateTime signDate,
            DateTime expireDate,
            DateTime workDate) {
        payload.put(JWTPayload.ISSUED_AT,signDate);
        payload.put(JWTPayload.EXPIRES_AT,expireDate);
        payload.put(JWTPayload.NOT_BEFORE,workDate);
        return JWTUtil.createToken(payload,key.getBytes());
    }

    /**
     * 默认现在生效,默认过期 2h
     * @param payload 载荷数据
     * @return token
     */
    public static String createToken(Map<String,Object> payload){
        DateTime now = new DateTime();
        return createToken(payload,JwtUtils.defaultKey,now,now.offset(defaultDateField,defaultTime*2),now);
    }

    /**
     * 自定义过期时间
     * @param payload 载荷数据
     * @param time 时间
     * @param dateField 时间单位
     * @return token
     */
    public static String createToken(Map<String,Object> payload,int time,DateField dateField){
        DateTime now = new DateTime();
        return createToken(payload,defaultKey,now,now.offset(dateField,time),now);
    }

    /**
     * 使用自定义密钥生成
     * @param payload 载荷
     * @param time 过期时间
     * @param dateField 时间单位
     * @param key 密钥
     * @return token
     */
    public static String createToken(Map<String,Object> payload,int time,DateField dateField,String key){
        DateTime now = new DateTime();
        return createToken(payload,key,now,now.offset(dateField,time),now);
    }

    /**
     * 使用自定义密钥生成
     * @param payload 载荷
     * @param key 密钥
     * @return token
     */
    public static String createToken(Map<String,Object> payload,String key){
        DateTime now = new DateTime();
        return createToken(payload,key,now,now.offset(defaultDateField,defaultTime*2),now);
    }



}
