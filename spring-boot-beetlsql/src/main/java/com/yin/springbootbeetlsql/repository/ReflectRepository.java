package com.yin.springbootbeetlsql.repository;

import com.yin.springbootbeetlsql.convert.AbstractConvert;
import com.yin.springbootbeetlsql.utils.ReflectClassUtils;
import org.beetl.sql.core.TailBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/4
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public abstract class ReflectRepository<VO, PO> {

    public VO toVO(Class<VO> vo, PO po) throws IllegalAccessException, InstantiationException {
        VO v = vo.newInstance();
        BeanUtils.copyProperties(po, v);

        if (TailBean.class.isAssignableFrom(po.getClass())) {
            TailBean tail = (TailBean) po;

            Map<String, Object> tails = tail.getTails();

            ReflectClassUtils.copyPropertiesFromMap(v, tails);
        }
        return v;
    }

    public List<VO> toVOs(Class<VO> vo, List<PO> pos) throws IllegalAccessException, InstantiationException {
        List<VO> vos = new ArrayList<>();

        pos.forEach(po -> {

            VO v = null;
            try {
                v = vo.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(po, v);

            if (TailBean.class.isAssignableFrom(po.getClass())) {
                TailBean tail = (TailBean) po;

                Map<String, Object> tails = tail.getTails();

                ReflectClassUtils.copyPropertiesFromMap(v, tails);
            }
            vos.add(v);

        });

        return vos;
    }


/*    public static Object copyPropertiesFromMap2Bean(Object updateObj, Map<String, Object> params) {
        Field[] fields = updateObj.getClass().getDeclaredFields();

        for (Field field : fields) {

            String fileName = field.getName();
            Object o = params.get(fileName);
            if (null != o) {

                Method method = null;
                try {
                    method = updateObj.getClass().getMethod("set" + fileName.replaceFirst(String.valueOf(fileName.charAt(0)), String.valueOf(fileName.charAt(0)).toUpperCase()), String.class);
                    method.invoke(updateObj, o);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }


            }
        }

        return updateObj;
    }*/

/*    *//**
     * 扩展属性值保存到vo
     *
     * @param target
     * @param params
     * @return
     *//*
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
    }*/
}
