package com.hangu.framework.mapper;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

/**
 * Mapper适配器类
 * 
 * @author 李显锋
 * @version 1.0
 * 
 */
public class MapperAdapter implements ObjectMapper {
    /**
     * Dozer的Mapper
     */
    private Mapper mapper=new DozerBeanMapper();
    /**
     * dozer配置的MAP-ID信息<br>
     * 结构：<标识,map-id>
     */
    private Map<String, String> mapIds=new HashMap<String, String>();

    /**
     * @param mapIds the mapIds to set
     */
    public void setMapIds(Map<String, String> mapIds) {
        this.mapIds = mapIds;
    }

    /**
     * @param mapper the mapper to set
     */
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.prochanges.smartfw.mapper.ObjectMapper#map(java.lang.Object,
     * java.lang.Class)
     */
    public <T> T map(Object source, Class<T> destinationClass) throws MappingException {
        return mapper.map(source, destinationClass);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.prochanges.smartfw.mapper.ObjectMapper#map(java.lang.Object,
     * java.lang.Object)
     */
    public void map(Object source, Object destination) throws MappingException {
        mapper.map(source, destination);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.prochanges.smartfw.mapper.ObjectMapper#map(java.lang.Object,
     * java.lang.Class, java.lang.String)
     */
    public <T> T map(Object source, Class<T> destinationClass, String mapId) throws MappingException {
        if (mapId == null) {
            return mapper.map(source, destinationClass);
        }
        if (mapIds != null && mapIds.containsKey(mapId)) {
            return mapper.map(source, destinationClass, mapIds.get(mapId));
        } else {
            return mapper.map(source, destinationClass);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.prochanges.smartfw.mapper.ObjectMapper#map(java.lang.Object,
     * java.lang.Object, java.lang.String)
     */
    public void map(Object source, Object destination, String mapId) throws MappingException {
        if (mapId == null) {
            mapper.map(source, destination);
            return;
        }
        if (mapIds != null && mapIds.containsKey(mapId)) {
            mapper.map(source, destination, mapIds.get(mapId));
        } else {
            mapper.map(source, destination);
        }
    }
}
