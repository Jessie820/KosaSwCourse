package pastexam;


import java.time.LocalDate;

public class Board {
	
	public int count;
	public String title;
	public String writer;
	public String content;
	LocalDate currDate = LocalDate.now();
	public int hitcount;

	
	public int getcount() {
		return count;
	}


	public void setcount(int count) {
		this.count = count;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDate getCurrDate() {
		return currDate;
	}


	public void setCurrDate(LocalDate currDate) {
		this.currDate = currDate;
	}


	public int getHitcount() {
		return hitcount;
	}


	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}


	public Board( String title, String writer, String content, LocalDate currDate, int hitcount,int count){
	
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.currDate=currDate;
		this.hitcount = hitcount;
		this.count = count;

	}
	//public void
}
