package cn.kgc.tangcco.zhangdi.common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PropertyFactory {
	private static Map<String,Object> map=new HashMap<String, Object>();
	public static Object getObject(String id) {
		if(map.containsKey(id)) {
			return map.get(id);
		}else {
			Bean bean=PropertyUtil.getBean(id);
			
			try {
				Object obj=Class.forName(bean.getClassName()).newInstance();
				
				map.put(id, obj);
				
				if(bean.getProperty()!=null) {
					Iterator<Property> itr=bean.getProperty().iterator();
					while (itr.hasNext()) {
						Property property = (Property) itr.next();
						
						try {
							Field field=obj.getClass().getDeclaredField(property.getName());
							field.setAccessible(true);
							
							field.set(obj, getObject(property.getRef()));
							
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			
			
			return obj;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(map.get(id));
			return map.get(id);
		}
	}
}
