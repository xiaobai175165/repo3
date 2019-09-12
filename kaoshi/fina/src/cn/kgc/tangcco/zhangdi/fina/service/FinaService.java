package cn.kgc.tangcco.zhangdi.fina.service;

import java.util.List;

import cn.kgc.tangcco.zhangdi.fina.entity.Fina;

public interface FinaService {
	List<Fina> querys();
	List<Fina> querys(String id);
	List<Fina> querys(String id,int risk);
	List<Fina> querys(int risk);
	int addFlower(Fina f);
}
