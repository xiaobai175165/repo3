package cn.kgc.tangcco.zhongjiban.entity;
import java.util.UUID;
public class Emp {
		 public  static int capacity;//模拟数据库中最大的值
		 private int id ;
		 private String account;
		 private String passworld;
		 private String firstName;
		 private String lastname;
		 private int gender;
		 private int salary;
		 private int role;
		 private String uuid ;
		 private int deptid;
		public Emp() {
			super();
			capacity++;
		}
		public Emp( String account, String passworld, String firstName, String lastname, int gender, int salary,
				int role, String uuid, int deptid) {
			super();
			this.id = ++capacity;
			this.account = account;
			this.passworld = passworld;
			this.firstName = firstName;
			this.lastname = lastname;
			this.gender = gender;
			this.salary = salary;
			this.role = role;
			this.uuid = uuid;
			this.deptid = deptid;
		}
		public static int getCapacity() {
			return capacity;
		}
		public static void setCapacity(int capacity) {
			Emp.capacity = capacity;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getPassworld() {
			return passworld;
		}
		public void setPassworld(String passworld) {
			this.passworld = passworld;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public int getGender() {
			return gender;
		}
		public void setGender(int gender) {
			this.gender = gender;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public int getDeptid() {
			return deptid;
		}
		public void setDeptid(int deptid) {
			this.deptid = deptid;
		}
		@Override
		public String toString() {
			return  "\t姓名" + lastname + "\t 薪资" + salary ;
		}
		
		 
}
