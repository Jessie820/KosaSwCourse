package pastexam;

import java.time.LocalDate;
import java.util.Scanner;

public class BoardApplication {
	public static Members[] membersArray = new Members[100];
	public static Board[] boardArray = new Board[100];
	public static Scanner scanner = new Scanner(System.in);
	static int count=0;

	public static void main(String[] args) {
		
		loginMenu();//�α��θ޴��޼ҵ� ȣ��

	}
	

	public static void mainMenu() {
		
		boolean mrun = true;
		while(mrun){
			System.out.println("--------------------------------------------------------");
			System.out.println("1. �α׾ƿ� | 2. ��� | 3. �۾���| 4. ���� | 5. ���� | 6. ����");
			System.out.println("--------------------------------------------------------");
		
		
	
	
			int selectNo = Integer.parseInt(scanner.nextLine());
			//�޴� �Է��� 
	
			if( selectNo ==1){
				
				System.out.println("�α׾ƿ��� �Ǿ����ϴ�.");
				loginMenu();
			
		
		
		
			}else if(selectNo == 2){
				
				System.out.println("---------------------------------------------");
				System.out.println("��ȣ\t ���� \t ��¥ \t \t �۾��� \t ��ȸ�� ");
				System.out.println("---------------------------------------------");
				
				for(int i =0; i<boardArray.length; i++){
					
					if(boardArray[i] != null){
					
					System.out.print(i+1+"��°\t");
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
				
				System.out.print("���� : ");
				String title = scanner.nextLine();
				System.out.print("���� : ");
				String content = scanner.nextLine();
				System.out.print("�۾��� : ");
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
				System.out.println("����:");
				int i = Integer.parseInt(scanner.nextLine());
				//System.out.println("a");
			
				System.out.println(i+"��°");
				System.out.println(boardArray[i-1].title);
				System.out.println(boardArray[i-1].writer);
				System.out.println(++boardArray[i-1].hitcount);
				System.out.println(boardArray[i-1].currDate);
				System.out.println(boardArray[i-1].content);
				
				
				
				
				
		
		
		
		
		}else if(selectNo == 5){
			System.out.print("����: ");
			int i = Integer.parseInt(scanner.nextLine());
			
			boardArray[i-1]=null;
			
			
			
			
			
			
		
		}else if(selectNo == 6){
				System.out.println("���α׷� ����");
				mrun = false;
		}
	}
	}








	private static void loginMenu() {
		boolean run=true;
		
		while(run){
			
			System.out.println("---------------------");
			System.out.println("1. ȸ������ | 2. �α���");
			System.out.println("---------------------");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if (selectNo==1){
				createMembers();
			}else if(selectNo == 2){
				run = isloginMembers();//���̵�� �н����带 Ȯ���ϴ� �޼ҵ带 ȣ���ؼ� true�� false�� �޴´�
				if(run){//�α����� �����ؼ� true���� ������ �ٽ� �α��θ޴��� �����Ѵ�.
					loginMenu();
				}
					
			}
		}
		mainMenu();//�α����� �����ϸ� run���� false���ǰ� �����޴��� mainMenu�� ȣ���Ѵ�.
			
			
		
	}




	private static void createMembers() {
		System.out.print("���̵�: ");
		String id = scanner.nextLine();
		System.out.print("�̸�: ");
		String name = scanner.nextLine();
		System.out.print("��й�ȣ: ");
		String password = scanner.nextLine();
		
		Members member = new Members(id, name, password);
		
		for(int i = 0; i< membersArray.length; i++){
			if(membersArray[i] == null){
				membersArray[i] = member;
				System.out.println("ȸ������ �Ǽ̽��ϴ�.");
				break;
			}
		}
		
	}
	public static boolean isloginMembers(){
		
		
		System.out.print("���̵�: ");
		String id = scanner.nextLine();
		System.out.print("�н�����: ");
		String password = scanner.nextLine();
		
		for(int i = 0; i<membersArray.length; i++){
			/*if(!(membersArray[i].getId().equals(id))){
				System.out.println("ȸ�������� �ʿ��մϴ�.");
				return false;
			}
			*/
			if(membersArray[i].getId().equals(id) && membersArray[i].getPassword().equals(password)){
				System.out.println("�α����� �Ǿ����ϴ�.");
				
				return false;
				}
				
			
		}//for
		return true;
		
		
	}



}
