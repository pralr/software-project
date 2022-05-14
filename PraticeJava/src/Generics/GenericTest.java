import java.util.Scanner;
// problemas de type safety e performance quando a gente usa object
// portanto troca Object por um tipo generico e corre pro abraço

public class GenericTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		PrintService<Integer> p1 = new PrintService<>();
		PrintService<String> p2 = new PrintService<>();
		
		System.out.println("How many things do you want to add?");
		int qt = scan.nextInt();
		
		for(int i = 0; i < qt; i++) {
			System.out.print("Type integer: ");
			Integer a = scan.nextInt();
			p1.addValue(a);
			
			System.out.print("Type string: ");
			String b = scan.next();
			p2.addValue(b);
		}
		
		p1.print();
		p2.print();
		
		scan.close();
	}
	
}

