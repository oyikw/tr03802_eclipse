package JSTL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSTL/pro")
public class ProduceSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product hw1=new Product(1,"HUAWEI P60",4988,"tp.png","洛可可白 每一支都独一无二",1300,0.98);
		Product hw2=new Product(2,"nova 12 Pro",4399,"tp.png","前置6000万人像追焦双摄",12421,0.88);
		Product hw3=new Product(3,"nova 12 活力版",2499,"tp.png","6.88mm超薄潮美直屏",233,0.88);
		Product hw4=new Product(4,"nova 11SE",1999,"tp.png","3200万高清自拍，一亿像素",124,0.58);
		Product hw5=new Product(5,"nova 9SE",4988,"tp.png","一亿像素超清摄影",15663,0.98);
		Product hw6=new Product(6,"Mate 50",3699,"tp.png","XMAGE影像",421,0.88);
		Product hw7=new Product(7,"Mate 50 Pro",4899,"tp.png","",3215,0.88);
		Product hw8=new Product(8,"Mate 60",5499,"tp.png","超可靠玄武架构，全焦段超清影像",1252,1.0);
		Product hw9=new Product(9,"Mate 60 Pro",7999,"tp.png","",99999,0.98);
		Product hw10=new Product(10,"Mate 60 Pro+",9999,"tp.png","双卫星通信，超可靠玄武架构",55555,0.98);
		Product hw11=new Product(11,"Mate 60 RS 非凡大师",12999,"tp.png","双卫星通信，超可靠玄武架构",99999,0.99);
		Product hw12=new Product(12,"Pocket S",3899,"tp.png","超感影像",124122,0.99);
		List<Product> list = new ArrayList<Product>();
		list.add(hw1);
		list.add(hw2);
		list.add(hw3);
		list.add(hw4);
		list.add(hw5);
		list.add(hw6);
		list.add(hw7);
		list.add(hw8);
		list.add(hw9);
		list.add(hw10);
		list.add(hw11);
		list.add(hw12);
		req.setAttribute("list", list);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}
}
