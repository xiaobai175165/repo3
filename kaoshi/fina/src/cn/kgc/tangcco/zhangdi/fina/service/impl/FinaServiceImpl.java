package cn.kgc.tangcco.zhangdi.fina.service.impl;

import java.util.List;

import cn.kgc.tangcco.zhangdi.fina.dao.FinaDao;
import cn.kgc.tangcco.zhangdi.fina.entity.Fina;
import cn.kgc.tangcco.zhangdi.fina.service.FinaService;
import oracle.net.aso.f;

public class FinaServiceImpl implements FinaService {
private FinaDao finaDao;
	@Override
	public List<Fina> querys() {
		// TODO Auto-generated method stub
		return finaDao.querys();
	}

	@Override
	public int addFlower(Fina f) {
		// TODO Auto-generated method stub
		return finaDao.addFlower(f);
	}

	@Override
	public List<Fina> querys(String id) {
		// TODO Auto-generated method stub
		return finaDao.querys(id);
	}

	@Override
	public List<Fina> querys(String id, int risk) {
		// TODO Auto-generated method stub
		return finaDao.querys(id, risk);
	}

	@Override
	public List<Fina> querys(int risk) {
		// TODO Auto-generated method stub
		return finaDao.querys(risk);
	}

}
