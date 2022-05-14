import java.util.InputMismatchException;
import java.util.Scanner;

// teste Alex Maria Bob
// se eu colocar uma letra por ex vai dar java.util.InputMismatchException
// se eu colocar pra procurar em umap posicao que nao existe, 
// java.lang.ArrayIndexOutOfBoundsExcepction. acessando o limite do array fora
// do limite
// e.printStackTrace(); printa o rastreamento do stack -- sequencia de chamada que gerou excecao
public class Excecao {

	public static void main(String[] args) {
	method1();

	System.out.println("End of program.");
	}
	
	public static void method1() {
		System.out.println("***********METHOD 1 START***********");
		method2();
		System.out.println("***********METHOD 1 END*************");
	}
	
	public static void method2() {
		System.out.println("***********METHOD 2 START***********");
	Scanner sc = new Scanner(System.in);
		
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position.");
			//e.printStackTrace();
			//sc.next(); ---> pra dar tempo de ver
		} catch(InputMismatchException e) { // apelido "e"
			System.out.println("Input error.");
		}
		System.out.println("***********METHOD 2 END***********");
		sc.close();
	}
}
