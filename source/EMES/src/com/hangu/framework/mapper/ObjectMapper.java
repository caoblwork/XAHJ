package com.hangu.framework.mapper;

import org.dozer.MappingException;

public interface ObjectMapper {
    /**
     * 将source对象转换成类型为destinationClass的对象
     * 
     * @param <T> 目的对象类型
     * @param source 源对象
     * @param destinationClass 目的对象Class
     * @return 转换后的新对象
     * @throws MappingException
     */
    public abstract <T> T map(Object source, Class<T> destinationClass) throws MappingException;

    /**
     * 将source对象转换为destination的对象(值拷贝)
     * 
     * @param source 源对象
     * @param destination 目的对象
     * @throws MappingException
     */
    public abstract void map(Object source, Object destination) throws MappingException;

    /**
     * 使用指定mapId的转换规则将source对象转换为类型为destinationClass的对象
     * 
     * @param <T> 目的对象类型
     * @param source 源对象
     * @param destinationClass 目的对象Class
     * @param mapId mapId
     * @return 转换后的新对象
     * @throws MappingException
     */
    public abstract <T> T map(Object source, Class<T> destinationClass, String mapId) throws MappingException;

    /**
     * 使用指定mapId的转换规则将source对象转换为destination的对象(值拷贝)
     * 
     * @param source 源对象
     * @param destination 目的对象
     * @param mapId mapId
     * @throws MappingException
     */
    public abstract void map(Object source, Object destination, String mapId) throws MappingException;

}