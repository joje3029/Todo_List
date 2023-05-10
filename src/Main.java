import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		int lastArticleId = 0;
		List<toDo> Do = new ArrayList<>();
		
		
	while(true) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("명령어) ");
		String cmd = sc.nextLine();
		
		if(cmd.equals("exit")) {
			break;
		}
		
		if(cmd.equals("todo write")) {
			int id = lastArticleId + 1;
			lastArticleId = id;
			System.out.printf("할 일) ");
			String work = sc.nextLine();
			
			toDo toDo1 = new toDo(id, work);
			
			Do.add(toDo1);
			
		} else if(cmd.equals("todo list")) {
			System.out.printf("	번호 | 할 일");
			System.out.printf("	%d	| %s", toDo.id, Do.work);
			
			
//현재 변수 이름이 이거고 저거고 다 Do가 들어가고 DO로 되다 보니 헷갈림. 우선 변수 이름부터 바꾸고 주석으로 설명좀 붙이자.
			
			
		}
		
		System.out.println("== 프로그램 끝 ==");
		
		
		
		
		sc.close();
		break;
	
	}
	}
}

class toDo{
	int id;
	String work;

	public toDo(int id,String work) {
		this.id = id;
		this.work = work;
	}
	
	
}