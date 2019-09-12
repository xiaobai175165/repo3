package cn.kgc.tangcco.zhongjiban.action;

import java.util.Scanner;

import cn.kgc.tangcco.zhongjiban.entity.Dept;
import cn.kgc.tangcco.zhongjiban.entity.Emp;
import cn.kgc.tangcco.zhongjiban.util.*;

public class EnpManager {
	private Dept[] dept=new Dept[100];
	private Emp[] emp=new Emp[100];
	private Scanner input;
	public void inio() {
		dept[0]=new Dept(1, "董市会", "北京");
		dept[1]=new Dept(2, "生成部", "上海");
		Emp e=new Emp();
		emp[0]=new Emp("user01", "123456","张三", "张三",1,6666,2 , UuidCode.getUuid(), 1);
		emp[1]=new Emp("user02", "123456","张四", "张四",1,6666,3 , UuidCode.getUuid(), 2);
	}
	public void mant() {
		inio();
		int num=0;
		input =new Scanner(System.in);
		do {
		System.out.println("1.查看所有员工信息\n"
				+ "2.添加员工\n"
				+ "3.添加部门\n"
				+ "4.删除部门\n"
				+ "0.退出");
		System.out.println("请输入编号");
		num=input.nextInt();
		switch (num) {
		case 1:
			System.out.println("员工信息如下");
			showInfo();
			break;

		default:
			break;
		}
		}while(num!=0);
	}
	public void showInfo() {
		for (Emp emp1 : emp) {
			if(emp1!=null) {
			System.out.println(emp1.getAccount()+"\t"+Util.getRole(emp1.getRole())+emp1+"   "+dept[emp1.getDeptid()-1]);
		}}
	}
}
