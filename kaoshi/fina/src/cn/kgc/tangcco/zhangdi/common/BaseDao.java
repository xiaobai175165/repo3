package cn.kgc.tangcco.zhangdi.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao {
	private static DataSource dataSource=new ComboPooledDataSource("myschool");//src/c3p0-config.xml
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();//线程本地池
	private static QueryRunner queryRunner=new QueryRunner(dataSource);
	public static Connection getCon() {//获取连接（事务才用）
		Connection conn=threadLocal.get();
		if(conn==null) {
			try {
				conn=dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadLocal.set(conn);
		}
		return conn;
	}
	public static void closeCon(Connection con) {
		if(con!=null) {
			threadLocal.remove();
		}
		
	}
	public static int UpdeGoods(String sql,Object... obj) {
		try {
			return queryRunner.update(sql,obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public static<T> List<T> getQueryList(String sql,Class<T> clazz,Object...objects){
		try {
			return queryRunner.query(sql,new BeanListHandler<T>(clazz), objects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static<T>  T getQuery(String sql,Class<T> clazz,Object...objects){
		try {
			return queryRunner.query(sql,new BeanHandler<T>(clazz), objects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static int queryCount(String sql,Object...objects) {
		try {
			return queryRunner.query(sql, new ScalarHandler<Long>(),objects).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
