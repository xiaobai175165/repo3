package cn.kgc.tangcco.zhangdi.common;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PropertyUtil {
	private static Map<String,Bean> map=new HashMap<String, Bean>();
	static {
		SAXReader sax=new SAXReader();
		try {
			URL url=PropertyFactory.class.getResource("/");
			String str=url.getPath();
			Document doc=sax.read(str+"files/applicationContext.xml");
			Element element=doc.getRootElement();
			Iterator<Element> itr=element.elements("bean").iterator();
			while (itr.hasNext()) {
				Element element2 = (Element) itr.next();
				Bean bean=new Bean(element2.attributeValue("id"),element2.attributeValue("class"));
				map.put(element2.attributeValue("id"), bean);
			
				if(element2.elements("property").size()>0) {
					List<Property> list=new ArrayList<Property>();
					for (Object obj : element2.elements("property")) {
						Element ele=(Element)obj;
						String name=ele.attributeValue("name");
						String ref=ele.attributeValue("ref");
						list.add(new Property(name,ref));
						bean.setProperty(list);
					}
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  Bean  getBean(String id) {
		return map.get(id);
	}
}
