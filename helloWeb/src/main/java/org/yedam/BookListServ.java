package org.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yedam.service.BookService;
import org.yedam.service.BookVO;
import org.yedam.service.MemberVO;
import org.yedam.service.serviceImpl.BookServiceImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/BookListServ")
public class BookListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BookListServ() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService bs = new BookServiceImpl();   
		List <BookVO> list = bs.bookList();  
		
		
		response.setContentType("text/json;charset=utf-8");  
		
		PrintWriter out = response.getWriter();   //응답
		
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);  //자바 객체를 list를 제이슨 포맷으로 만들어줌 
		out.print(json);  
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
