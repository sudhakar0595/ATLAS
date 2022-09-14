import java.util.*;
public class Customer {

	public static void main(String[] args) {
		List<int []> cust = new ArrayList<int []>();
		Scanner in = new Scanner(System.in);
		boolean x = true;
		while (x) {
			System.out.println("Enter 1 to add customers");
			System.out.println("Enter 2 to show customers");
			System.out.println("Enter 3 to exit");
			var input = in.nextInt();
			switch(input) {
			case 1:
				System.out.println("Enter the details of the customer");
				int pay = in.nextInt();
				int prime = in.nextInt();
				int num = in.nextInt();
				int[] data = {pay,prime,num};
				int voucher = findDisc(data);
				int[] data1 = {pay,prime,num,voucher};
				//List<int> list = Arrays.asList(data);
				cust.add(data1);
				break;
			case 2:
				cust.forEach((n) -> {
				System.out.println(Arrays.toString(n));
				});
				break;
			case 3:
				x = false;
				break;
			default:
				System.out.println("Enter valid input");
			}
		}
		in.close();
	}
	
	public static int findDisc(int[] d) {
		if(d[0]==1 && d[1] ==1 && d[2]>5) {
			int discount = 30;
			return discount;
		}
		else if(d[0]==1 && d[1] ==1) {
			int discount = 20;
			return discount;
		}
		else if(d[0]==1 || d[1] ==1) {
			int discount = 10;
			return discount;
		}
		return 0;
	}

}
