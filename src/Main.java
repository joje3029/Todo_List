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

		doWorkes.add(new doWork(1 , "1번 글"));
		doWorkes.add(new doWork(2 , "2번 글"));	
		doWorkes.add(new doWork(3 , "3번 글"));
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
//현 상태 문제. wirte를 했는데 arraylist에 저장이 안되는지 list를 하면 무조건 할일이 없다고 뜸.
//저장해서 수정할것.-> arraylist를 while문 안에 넣었었으니 매번 초기화 된거잖아.

//이제 수정하는 기능 만들고. 삭제랑. 체크 기능 만들기(todo 된것만 list 나오게-> 수정할때 V넣고 V있는것만 list하면 나오게 하기)

