package pastexam;

import java.time.LocalDate;
import java.util.Scanner;

public class BoardApplication {
	public static Members[] membersArray = new Members[100];
	public static Board[] boardArray = new Board[100];
	public static Scanner scanner = new Scanner(System.in);
	static int count=0;

	public static void main(String[] args) {
		
		loginMenu();//로그인메뉴메소드 호출

	}
	

	public static void mainMenu() {
		
		boolean mrun = true;
		while(mrun){
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 로그아웃 | 2. 목록 | 3. 글쓰기| 4. 보기 | 5. 삭제 | 6. 종료");
			System.out.println("--------------------------------------------------------");
		
		
	
	
			int selectNo = Integer.parseInt(scanner.nextLine());
			//메뉴 입력을 
	
			if( selectNo ==1){
				
				System.out.println("로그아웃이 되었습니다.");
				loginMenu();
			
		
		
		
			}else if(selectNo == 2){
				
				System.out.println("---------------------------------------------");
				System.out.println("번호\t 제목 \t 날짜 \t \t 글쓴이 \t 조회수 ");
				System.out.println("---------------------------------------------");
				
				for(int i =0; i<boardArray.length; i++){
					
					if(boardArray[i] != null){
					
					System.out.print(i+1+"번째\t");
					System.out.print(boardArray[i].title);
					System.out.print("\t");
					System.out.print(boardArray[i].currDate);
					System.out.print("\t");
					System.out.print(boardArray[i].writer);
					System.out.print("\t");
					System.out.print(boardArray[i].hitcount);
					System.out.println("\t");

					}
				}
				
		
		
		
			}else if(selectNo == 3){
		
				int cnt = 1;
				
				System.out.print("제목 : ");
				String title = scanner.nextLine();
				System.out.print("내용 : ");
				String content = scanner.nextLine();
				System.out.print("글쓴이 : ");
				String writer = scanner.nextLine();
				LocalDate currdate= LocalDate.now();
				int hitcount=0;
				
				Board boards = new Board(title, content, writer, currdate, hitcount,count);
				count++;
				
				for(int i =0; i<boardArray.length; i++){
					if(boardArray[i] == null){
						boardArray[i] = boards;
						
						break;
					}
				}
		
				
			}else if(selectNo == 4){
				System.out.println("선택:");
				int i = Integer.parseInt(scanner.nextLine());
				//System.out.println("a");
			
				System.out.println(i+"번째");
				System.out.println(boardArray[i-1].title);
				System.out.println(boardArray[i-1].writer);
				System.out.println(++boardArray[i-1].hitcount);
				System.out.println(boardArray[i-1].currDate);
				System.out.println(boardArray[i-1].content);
				
				
				
				
				
		
		
		
		
		}else if(selectNo == 5){
			System.out.print("선택: ");
			int i = Integer.parseInt(scanner.nextLine());
			
			boardArray[i-1]=null;
			
			
			
			
			
			
		
		}else if(selectNo == 6){
				System.out.println("프로그램 종료");
				mrun = false;
		}
	}
	}








	private static void loginMenu() {
		boolean run=true;
		
		while(run){
			
			System.out.println("---------------------");
			System.out.println("1. 회원가입 | 2. 로그인");
			System.out.println("---------------------");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if (selectNo==1){
				createMembers();
			}else if(selectNo == 2){
				run = isloginMembers();//아이디와 패스워드를 확인하는 메소드를 호출해서 true나 false를 받는다
				if(run){//로그인이 실패해서 true값을 받으면 다시 로그인메뉴를 실행한다.
					loginMenu();
				}
					
			}
		}
		mainMenu();//로그인이 성공하면 run값이 false가되고 다음메뉴인 mainMenu를 호출한다.
			
			
		
	}




	private static void createMembers() {
		System.out.print("아이디: ");
		String id = scanner.nextLine();
		System.out.print("이름: ");
		String name = scanner.nextLine();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine();
		
		Members member = new Members(id, name, password);
		
		for(int i = 0; i< membersArray.length; i++){
			if(membersArray[i] == null){
				membersArray[i] = member;
				System.out.println("회원가입 되셨습니다.");
				break;
			}
		}
		
	}
	public static boolean isloginMembers(){
		
		
		System.out.print("아이디: ");
		String id = scanner.nextLine();
		System.out.print("패스워드: ");
		String password = scanner.nextLine();
		
		for(int i = 0; i<membersArray.length; i++){
			/*if(!(membersArray[i].getId().equals(id))){
				System.out.println("회원가입이 필요합니다.");
				return false;
			}
			*/
			if(membersArray[i].getId().equals(id) && membersArray[i].getPassword().equals(password)){
				System.out.println("로그인이 되었습니다.");
				
				return false;
				}
				
			
		}//for
		return true;
		
		
	}



}
