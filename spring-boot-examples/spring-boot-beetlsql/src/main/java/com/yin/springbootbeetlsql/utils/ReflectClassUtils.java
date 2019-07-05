package com.yin.springbootbeetlsql.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/5
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public class ReflectClassUtils {

    public static Object copyPropertiesFromMap(Object target, Map<String, Object> params) {


        Assert.notNull(target, "Source must not be null");

        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();

            if (null == writeMethod) {
                continue;
            }
            String methodName = String.valueOf(writeMethod.getName().charAt(3)).toLowerCase() + writeMethod.getName().substring(4);
            if (params.containsKey(methodName)) {
                try {
                    writeMethod.invoke(target, params.get(methodName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return target;
    }

}
