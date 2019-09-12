package cn.kgc.tangcco.zhongjiban.entity;

public class Dept {
	public static int no;
	private int id;
	private String name;
	private String ciry;
	public static int getNo() {
		return no;
	}
	public static void setNo(int no) {
		Dept.no = no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCiry() {
		return ciry;
	}
	public void setCiry(String ciry) {
		this.ciry = ciry;
	}
	public Dept(int id, String name, String ciry) {
		super();
		this.id = id;
		this.name = name;
		this.ciry = ciry;
	}
	public Dept() {
		super();
	}
	@Override
	public String toString() {
		return "部门姓名" + name + "\t部门地址" + ciry ;
	}
	
}
