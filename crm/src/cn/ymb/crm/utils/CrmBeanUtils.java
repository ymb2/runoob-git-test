package cn.ymb.crm.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtils;



public class CrmBeanUtils {

	public static void changeProperty(Object sourceBean, Object targetBean) {
		try {
			Class sourceClass = sourceBean.getClass();
			Class targetClass = targetBean.getClass();
			if(sourceClass != targetClass){
				throw new RuntimeException("sourceBean 和  targetBean 不是同一种javabean");
			}
			BeanInfo beanInfo = Introspector.getBeanInfo(sourceClass,Object.class);
			PropertyDescriptor[] allPD = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : allPD) {
				String propName = pd.getName();
				Object propValue = pd.getReadMethod().invoke(sourceBean);
				if(propValue != null){
					BeanUtils.setProperty(targetBean, propName, propValue);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
