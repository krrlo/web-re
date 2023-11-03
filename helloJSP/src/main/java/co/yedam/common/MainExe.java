package co.yedam.common;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;

public class MainExe {

	public static void main(String[] args) {
		

		BoardService svc = new BoardServiceImpl();

	

		svc.boardList().forEach(st -> System.out.println(st));
		/// 리스트 돌려서 뽑아내기

		

	}///
}///