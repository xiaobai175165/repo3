package cn.kgc.tangcco.zhangdi.fina.dao.impl;

import java.util.List;

import cn.kgc.tangcco.zhangdi.common.BaseDao;
import cn.kgc.tangcco.zhangdi.fina.dao.FinaDao;
import cn.kgc.tangcco.zhangdi.fina.entity.Fina;


public class FinaDaoImpl implements FinaDao {

	@Override
	public List<Fina> querys() {
		// TODO Auto-generated method stub
		String sql="select * from fin";
		return   BaseDao.getQueryList(sql, Fina.class);
	}
	public List<Fina> querys(String id) {
		// TODO Auto-generated method stub
		String sql="select * from fin where id like ?";
		return   BaseDao.getQueryList(sql, Fina.class,"%"+id+"%");
	}
	public List<Fina> querys(String id,int risk) {
		// TODO Auto-generated method stub
		String sql="select * from fin where id like ? and risk=?";
		return   BaseDao.getQueryList(sql, Fina.class,"%"+id+"%",risk);
	}
	public List<Fina> querys(int risk) {
		// TODO Auto-generated method stub
		String sql="select * from fin where risk=?";
		return   BaseDao.getQueryList(sql, Fina.class,risk);
	}

	@Override
	public int addFlower(Fina f) {
		// TODO Auto-generated method stub
		String sql="insert into fin values(?,?,?,?,?,?)";
		
		return BaseDao.UpdeGoods(sql, f.getId(),f.getRisk(),f.getIncome(),f.getSalestarting(),f.getEnd(),f.getSaleend());
	}

}
