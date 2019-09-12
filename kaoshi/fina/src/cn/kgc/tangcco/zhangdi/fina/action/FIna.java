package cn.kgc.tangcco.zhangdi.fina.action;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.zhangdi.common.PropertyFactory;
import cn.kgc.tangcco.zhangdi.fina.entity.Fina;
import cn.kgc.tangcco.zhangdi.fina.service.FinaService;

/**
 * Servlet implementation class FIna
 */

@WebServlet("/fina.action")
public class FIna extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FinaService flower=(FinaService) PropertyFactory.getObject("finaService");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String oper=request.getParameter("operate");
		if(oper==null) {
			tofina(request, response);
		}else if(oper.equals("select")) {
			dofina(request, response);
		}else if(oper.equals("tofinalist")) {
			tofinalist(request, response);
		}else if(oper.equals("add")){
			add(request, response);
		}else if(oper.equals("addfina")) {
			addfina(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void tofina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Fina> fina=flower.querys();
		request.setAttribute("finalist", fina);
		request.getRequestDispatcher("WEB-INF/Fina/fina.jsp").forward(request, response);
	}


	public void dofina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//保存cookie
		String id = request.getParameter("id");
		String risk=request.getParameter("risk");
		List<String> cookieList =getcook(request, response);//读取原有的cookie
		if (cookieList.contains(id)) {//存在
			cookieList.remove(id);
		}else {
			if (cookieList.size()==5) {
		cookieList.remove(0);
			}
		}
		cookieList.add(id);//加到最后
		for (int i = 0; i < cookieList.size(); i++) {
			Cookie cki = new Cookie("id-"+i,cookieList.get(i));
			cki.setMaxAge(2*30*24*60*60);
			response.addCookie(cki);
		}
		
		response.sendRedirect("fina.action?operate=tofinalist&id="+id+"&risk="+risk);
	}
	private List<String> getcook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> cookieList = new LinkedList<String>();
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for (Cookie cki : cookies) {
				if (cki.getName().startsWith("id")) {
					cookieList.add(cki.getValue());
				}
			}
		}
		return cookieList;
	}

	public void tofinalist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> cookieList = getcook(request, response);
		Collections.reverse(cookieList);
		request.setAttribute("cookieList", cookieList);
		System.out.println(cookieList);
		String id = request.getParameter("id");
		String risk=request.getParameter("risk");
		List<Fina> finalist=null;
		if (id!=null&&!risk.equals("0")) {
		finalist =flower.querys(id, Integer.parseInt(risk));
		}else if (id!=null&&risk.equals("0")){
			finalist =flower.querys(id);
		}else if(id==null&&!risk.equals("0")) {
			finalist =flower.querys(Integer.parseInt(risk));
		}
		request.setAttribute("finalist", finalist);
		request.getRequestDispatcher("WEB-INF/Fina/fina.jsp").forward(request, response);
	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Fina> fina=flower.querys();
		request.setAttribute("finalist", fina);
		request.getRequestDispatcher("WEB-INF/Fina/add.jsp").forward(request, response);
	
	}
	public void addfina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		 String name=request.getParameter("name"); 
		 int risk=Integer.parseInt(request.getParameter("risk"));
		 String nickName=request.getParameter("nickname");
		 String property=request.getParameter("property");
		 String price=request.getParameter("price");
		 String production=request.getParameter("production");
		 Fina flower=new Fina( name,nickName, property, production, price,risk); 
		 	int a=this.flower.addFlower(flower);
		 	if(a>0) { 
		 		List<Fina> fina=this.flower.querys();
				request.setAttribute("finalist", fina);
		  request.setAttribute("name", "添加成功");
		  request.getRequestDispatcher("WEB-INF/Fina/fina.jsp").forward( request, response);
		   }else { 
			   List<Fina> fina=this.flower.querys();
						request.setAttribute("finalist", fina);
		  request.setAttribute("name","添加失败");
		  request.getRequestDispatcher("WEB-INF/Fina/fina.jsp").forward( request, response);
		 
		  }
	}
	}
