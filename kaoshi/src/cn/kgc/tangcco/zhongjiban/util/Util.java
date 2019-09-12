package cn.kgc.tangcco.zhongjiban.util;

public class Util {
	public static String getRole(int a) {
		if(a==0) {
			return "保留";
		}else if(a==1) 
		{
			return "管理员";
		}else if(a==2) {
			return "部门经理";
		}
		else if(a==3) {
			return "普通员工";
		}else {
			return "保留";
		}
	}
}
