package com.wind.ssm.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * json工具类，用于json与bean之前的转换
 * @author wind 
 * @date 2017-12-03 14:42:00
 */
public class JsonUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private final static ObjectMapper mapper = new ObjectMapper();
    static {
        // 美化输出
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // 设置时间格式
        //mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // bean转json时，不转null字段
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 当发现不存在的字段时不报错
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private JsonUtil() {}

    /**
     * 将json string反序列化成非集合对象
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("将json字符串：{}转换成{}时发生异常。", json, String.valueOf(clazz), e);
        }
        return null;
    }

    /**
     * 将json array反序列化为list对象
     *
     * @param json
     * @param clazz 泛型类型
     * @return
     */
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        JavaType javaType = getCollectionType(ArrayList.class, clazz);
        try {
            return mapper.readValue(json, javaType);
        } catch (IOException e) {
            logger.error("将json数组:{}转换成List<{}>时发生异常。", json, String.valueOf(clazz), e);
        }
        return null;
    }

    /**
     * 将json array反序列化为array对象
     *
     * @param json
     * @param clazz 数组类型
     * @return
     */
    public static <T> T[] jsonToArray(String json, Class<T[]> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("将json数组: {} 转换成{}数组对象时发生异常。", json, String.valueOf(clazz), e);
        }
        return null;
    }

    /**
     * 将json array反序列化为map对象
     *
     * @param json
     * @param clazz value类型
     * @return
     */
    public static <T> Map<String,T> jsonToMap(String json, Class<T> clazz) {
        JavaType javaType = getCollectionType(Map.class, String.class, clazz);
        try {
            return mapper.readValue(json, javaType);
        } catch (IOException e) {
            logger.error("将json字符串: {} 转换成Map<String,{}>时发生异常。", json, String.valueOf(clazz), e);
        }
        return null;
    }

    /**
     * 将对象序列化为json字符串
     * @param obj
     * @return
     */
    public static String beanToJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("将对象：{} 转换成json时发生异常", obj, e);
        }
        return null;
    }

    /**
     * 将json字符串转换为jsonNode对象
     * @param json
     * @return
     */
    public static JsonNode jsonToNode(String json){
        try {
            return mapper.readTree(json);
        } catch (IOException e) {
            logger.error("将json字符串：{} 转换成jsonNode发生异常。", json, e);
        }
        return null;
    }

    /**
     * 将jsonNode字符串转换为JavaBean对象
     * @param node
     * @return
     */
    public static <T> T nodeToBean(JsonNode node, Class<T> clazz) {
        try {
            return mapper.treeToValue(node, clazz);
        } catch (IOException e) {
            logger.error("JsonNode：{}转换成{}时发生异常。", node, String.valueOf(clazz), e);
        }
        return null;
    }

    /**
     *获取collection带泛型的对象
     * @param collectionClass
     * @param elementClasses 不定参，按顺序输入泛型类型
     * @return
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}