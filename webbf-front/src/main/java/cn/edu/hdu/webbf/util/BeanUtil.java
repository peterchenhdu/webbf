/*
 * File Name: BeanUtil.java

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年9月9日
 */
package cn.edu.hdu.webbf.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * spring bean相关工具类
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年9月9日
 * @see
 * @since webbf V1.0.0
 */
public class BeanUtil implements ApplicationContextAware
{
    private static ApplicationContext applicationContext;

    /**
     * 根据bean名字查找bean
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName)
    {
        return applicationContext.getBean(beanName);
    }
    /**
     * 根据bean名字和类型查找
     * @param beanName
     * @param clazs
     * @return
     */
    public static <T> T getBean(String beanName, Class<T> clazs)
    {
        return null == getBean(beanName) ? null : clazs.cast(getBean(beanName));
    }

    /**
     *
     * 得到applicationContext的引用
     *
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        BeanUtil.applicationContext = applicationContext;
    }

}
