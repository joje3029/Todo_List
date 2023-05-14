import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		
		int id = 0;
		
		while(true) {
		
		List<doWork> doWorkes = new ArrayList<>();
		
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
			
			System.out.println();
			
		}else if(cmd.equals("todo list")){
			if(doWorkes.size()==0) {
				System.out.println("할일이 없습니다");
				continue;
			}
			
			System.out.println("	번호	|	할일	");
			for(int i = doWorkes.size() - 1; i >= 0; i--) {
				doWork dowork = doWorkes.get(i);
			System.out.printf("	%d	|	%s	", dowork.id, dowork.work);
			}
		
		}else {
			System.out.println("존재하지 않는 명령어 입니다.");
			continue;
		}
	}

		sc.close();
		System.out.println("== 프로그램 끝 ==");
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
//저장해서 수정할것.

