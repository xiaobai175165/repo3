package cn.kgc.tangcco.zhangdi.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Filea {
	public static void addXml() {
		Document doc=DocumentHelper.createDocument();
		doc.addElement("beans");
		fileXml(new File("src/cn/kgc/tangcco"), doc);
		sareXml(doc);
	}
	public static void fileXml(File f,Document doc) {
		File[] fl=f.listFiles();
		for (File file : fl) {
			if(file.isDirectory()) {
				fileXml(file, doc);
			}else {
				String str=file.getName();
				if(str.endsWith("Impl.java")) {
					int a=str.indexOf("Impl.java");
					str=str.substring(0,a);
					char[] cs=str.toCharArray();
					cs[0]=(char)(cs[0]+32);
					StringBuilder sb=new StringBuilder();
					for (char c : cs) {
						sb.append(c);
					}
					str=sb.toString();
					Element e=doc.getRootElement();
					Element ele=e.addElement("bean");
					ele.addAttribute("id", str);
					String className=file.getPath();
					className=className.substring(4,className.length()-5);
					className=className.replace("\\", ".");
					ele.addAttribute("class",className);
					if(str.endsWith("Service")) {
						Object o;
						try {
							o = Class.forName(className).newInstance();
							Field[] l=o.getClass().getDeclaredFields();
							List la=Arrays.asList(l);
							la.forEach(i->{
							Element eles=ele.addElement("property");
							eles.addAttribute("name", ((Field)i).getName());
							eles.addAttribute("ref",  ((Field)i).getName());
							});
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
				}
			}
		}
	}
	public static void sareXml(Document doc) {
		XMLWriter write=null;
		OutputFormat f=OutputFormat.createPrettyPrint();
		try {
		
			write=new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/files/applicationContext.xml"), "utf-8"), f);
			write.write(doc);
			write.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
