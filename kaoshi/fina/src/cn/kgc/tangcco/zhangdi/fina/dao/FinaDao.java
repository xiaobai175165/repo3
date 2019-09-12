package cn.kgc.tangcco.zhangdi.fina.dao;

import java.util.List;

import cn.kgc.tangcco.zhangdi.fina.entity.Fina;

public interface FinaDao {
	List<Fina> querys();
	List<Fina> querys(String id);
	List<Fina> querys(String id,int risk);
	List<Fina> querys(int risk);
	int addFlower(Fina f);
}
