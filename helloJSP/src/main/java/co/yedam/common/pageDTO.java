package co.yedam.common;

public class pageDTO {
	int total; //전체건수.
	int currentPage; //현재페이지
	boolean next, prev; //이후, 이전 페이지 존재여부 
	int startPage, endPage;   //
	int boardNo;
	
	
	//
	
	
	public pageDTO(int boardNo , int total , int currentPage) {
		
		this.currentPage= currentPage;
		
		int realEnd = (int)Math.ceil(total/5.0);  //실제마지막페이지 
		this.boardNo = boardNo;
		this.total = total;  
		
		this.endPage =(int)Math.ceil(currentPage/10.0)*10;  //1*10이라는말 
		this.startPage=this.endPage-9; 
		
		this.endPage =this.endPage>realEnd ? realEnd : this.endPage;
		//계산상 페이지가 > 진짜 원래 마지막페이지보다 크면 > 진짜 마지막페이지로하고 > 
		this.prev = this.startPage > 1; //이전페이지가 있다는말
		this.next = this.endPage < realEnd; //이후페이지가 있다는말 
		//
		
	}
	
	
	//endpage는 현재 페이지 기준으로 
	
	
	
	
	
}
