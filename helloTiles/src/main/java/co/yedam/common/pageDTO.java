package co.yedam.common;

public class pageDTO {
	int total; //전체건수. //댓글 몇개 달렸는지
	int currentPage; //현재페이지
	boolean next, prev; //이후, 이전 페이지 존재여부 
	int startPage, endPage;   
	int boardNo;
	
	
	//
	
	//현재페이지,진짜끝페이지,게시판번호,등록된댓글건수,현재페이지기준 시작,마지막페이지, 이전,이후페이지 여부
	public pageDTO(int boardNo , int total , int currentPage) {
		
		this.currentPage= currentPage;
		
		int realEnd = (int)Math.ceil(total/5.0);  //한 페이지에 댓글 5개씩 넣을때 마지막페이지 
		this.boardNo = boardNo;
		this.total = total;  
		
		this.endPage =(int)Math.ceil(currentPage/10.0)*10;  //현재 1페이지일때 마지막페이지는 10페이지
		this.startPage=this.endPage-9;    // 시작페이지는 마지막페이지 -  9 
		
		this.endPage =this.endPage > realEnd ? realEnd : this.endPage;
		//endpage가 > 진짜 원래마지막 페이지 보다 크면 > realEnd가 마지막페이지가 되고 , 아니면 this.endPage가된다
		this.prev = this.startPage > 1; //ex) 11페이지 21페이지 이면 이전페이지가 있다는말 >>true
		this.next = this.endPage < realEnd; //이후페이지가 있다는말 >> true 
		//
		
	}
	
	
	
	
	
	
}
