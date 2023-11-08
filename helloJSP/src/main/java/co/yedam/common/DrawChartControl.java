package co.yedam.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.reply.service.ReplyService;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class DrawChartControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		// 차트그리기
		// json 데이터 => [작성자, 건수] 받아와서 자바스크립트 페이지에서 그려주기

		ReplyService svc = new ReplyServiceImpl();
		List <Map<String, Object>> list = svc.getReplyCountBywriter();

		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(list));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
