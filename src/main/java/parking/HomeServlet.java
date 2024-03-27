//package parking;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import parking.dao.dengjiDAO;
//import parking.util.dengji;
//	
///**
//  Servlet implementation class home
// */
//@WebServlet("/parking/apply")
//public class HomeServlet extends HttpServlet {	
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	    req.setCharacterEncoding("utf-8");
//	    resp.setContentType("text/html;charset=utf-8");
//	    
//	    String sta = req.getParameter("sta_time");
//	    String exit = req.getParameter("stop_time");
//	    String dtel = req.getParameter("tel");
//	    String carNumber = req.getParameter("cp");
//	    String bz = req.getParameter("bz");
//	    
//		
//		if(sta!=null && exit !=null) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"); 
//		LocalDateTime stime =LocalDateTime.parse(sta, formatter);
//		LocalDateTime etime =LocalDateTime.parse(exit, formatter);
//		  
//		Timestamp entryTime = Timestamp.valueOf(stime); 
//		Timestamp exitTime = Timestamp.valueOf(etime);
//			 
//
//		dengji dj;
//			  
//		if (bz != null && !bz.isEmpty()) {
//			dj = new dengji(entryTime, exitTime, dtel,carNumber, bz);
//		}else { 
//			dj = new dengji(entryTime, exitTime, dtel,carNumber);
//		}
//			 
//
//		dengjiDAO daoinsert = new dengjiDAO(); 
//		int result = daoinsert.doInsert(dj);
//		if (result > 0) {
//			System.out.println("插入成功");
//		} else {
//			System.out.println("插入失败");
//			}
//		}
//	}
//}