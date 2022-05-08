import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		
		Date y1 = sdf1.parse("25/06/2018");
		Date y2 = sdf2.parse("25/06/2018 15:42:07");
		System.out.println(y1);
		System.out.println(y2);
		
		// outro formato
		
		System.out.println(sdf2.format(y1));
		System.out.println(sdf2.format(y2));
		
		// data com o hor�rio ATUAL
		Date x1 = new Date(); 
		System.out.println(sdf2.format(x1));
		Date x2 = new Date(System.currentTimeMillis());
		System.out.println(sdf2.format(x2));
	}
}