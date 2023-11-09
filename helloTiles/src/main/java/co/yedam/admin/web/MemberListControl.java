package co.yedam.admin.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.admin.service.MemberVO;
import co.yedam.common.Command;

public class MemberListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
			String path = "admin/memberList.tiles";  //tiles라고 끝나야 레이아웃이적용됨
			//WEB-INF/board/boardList.jsp  >>레이아웃 반영안된상태로 적용 
			List<MemberVO> list = new ArrayList<>();
			list.add(new MemberVO());
			req.setAttribute("list", list);
			
			try {
				req.getRequestDispatcher(path).forward(req, resp);
			}  catch (Exception e) {
				
				e.printStackTrace();
			}
			
		

	}

}
