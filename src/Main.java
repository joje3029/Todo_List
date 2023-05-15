import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
	static List<doWork> doWorkes; 
	
	static {
		doWorkes = new ArrayList<>();
	}
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		TestData();
		
		Scanner sc = new Scanner(System.in);
		
		int id = 3;
		
		
		while(true) {
		
		System.out.printf("명령어) ");
		String cmd = sc.nextLine().trim();
		
		if(cmd.equals("exit")) {
			break;
		}
		
		if(cmd.equals("todo write")) {
			id++;
			System.out.printf("할 일 : ");
			String work = sc.nextLine();
		
			System.out.printf("%d번 할 일 이 생성되었습니다\n", id);
	
			doWork doWorking = new doWork(id, work);
			
			doWorkes.add(doWorking);
			
		}else if(cmd.equals("todo list")){
			if(doWorkes.size()==0) {
				System.out.println("할일이 없습니다");
				continue;
			}
			
			System.out.println("	번호	|	할일	");
			for(int i = doWorkes.size() - 1; i >= 0; i--) {
				doWork dowork = doWorkes.get(i);
			System.out.printf("	%d	|	%s	\n", dowork.id, dowork.work);
			}
		
		}else if(cmd.startsWith("todo modifey ")){	
			String[] cmdBits = cmd.split(" ");
			int Id = Integer.parseInt(cmdBits[2]);
		
			doWork foundWork = null;
			
			for(int i = 0; i < doWorkes.size(); i++) {
				doWork dowork = doWorkes.get(i);	
			
				if(dowork.id == Id) {
					foundWork = dowork;
					break;
				}
			}
			
			if(foundWork == null) {
				System.out.printf("%d번 할 일은 존재하지 않습니다\n",Id);
			}
			System.out.printf("수정할 할 일 : ");
			String work = sc.nextLine();
			
			foundWork.work = work;
			
			System.out.printf("%d번 할 일이 수정되었습니다.\n", Id);
			
		}else if(cmd.startsWith("todo delete ")){	
			String[] cmdBits = cmd.split(" ");
			int Id = Integer.parseInt(cmdBits[2]);
			
			doWork foundWork = null;
			
			for(int i = 0; i < doWorkes.size(); i++) {
				doWork dowork = doWorkes.get(i);	
			
				if(dowork.id == Id) {
					foundWork = dowork;
					break;
				}
			}
			
			if(foundWork == null) {
				System.out.printf("%d번 할 일은 존재하지 않습니다\n",Id);
			}

			doWorkes.remove(foundWork);
			
			System.out.printf("%d번 할 일이 삭제되었습니다.\n", Id);
			
	
			
		}else {
			System.out.println("존재하지 않는 명령어 입니다.");
			continue;
		}
	}

		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}

	private static void TestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다");

		doWorkes.add(new doWork(1 , "1번 할 일"));
		doWorkes.add(new doWork(2 , "2번 할 일"));	
		doWorkes.add(new doWork(3 , "3번 할 일"));
	}
	
	
}

class doWork{
	int id;
	String work;

	public doWork(int id, String work) {
		this.id = id;
		this.work = work;
	}

	
}
// 체크 기능 만들기(todo 된것만 list 나오게-> 수정할때 V넣고 V있는것만 list하면 나오게 하기)
// v 체크 표시를 어디다가 해야할까. 번호? 할일? 번호쪽이 더 나은듯. 
//그럼 v한것만 list 나오게?
//아니면 v란을 만들어서 한건 v하게 하는 기능을 만들까. 어느쪽이 나은지 고민해야겠네.
