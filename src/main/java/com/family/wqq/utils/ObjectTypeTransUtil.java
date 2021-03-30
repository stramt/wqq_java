package com.family.wqq.utils;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.util.*;

/**
 * @ClassName ObjectTypeTransUtil
 * @Description 类型转换工具类 主要用户entity vo dto 之间的相互转换
 * @Author hdp
 * @Date 2020/11/18 10:03
 * @Version 1.0
 **/
public class ObjectTypeTransUtil {

    /**
     * @Author hdp
     * @Description 将entity转成model
     * @Date 10:05 2020/11/18
     * @Param <F> 源类型
     *         <T> 目标类型
     * @return <T> 目标类
     **/
    public static <F,T> T entityToModel(F entity,Class<T> modelClass){
        Object  model = null;
        if(entity == null || modelClass == null){
            return null;
        }
        try {
            model= modelClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(entity,model);
        return (T)model;
    }
    /**
     * @Author hdp
     * @Description 将源集合转成目标集合
     * @Date 10:13 2020/11/18
     * @Param
     * @return
     **/
    public static <F,T> List<T> entityListToModelList(List<F> fromList,Class<T> tClass){
        if(CollectionUtil.isEmpty(fromList)){
            return new ArrayList<>();
        }
        List<T> tList = new ArrayList<>();
        for(F f:fromList){
            T t = entityToModel(f,tClass);
            tList.add(t);
        }
        return tList;
    }
    /**
     * @Author hudongping@xdf.cn
     * @Description object 转map
     * @Date 15:19 2021/2/25
     * @Param
     * @return
     **/
    public static Map<Object, Object> objConvertToMap(Object args) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(args.getClass()))
                .filter(pd -> !"class".equals(pd.getName()))
                .collect(HashMap::new,
                        (map, pd) -> map.put(pd.getName(), ReflectionUtils.invokeMethod(pd.getReadMethod(), args)),
                        HashMap::putAll);
    }
}
