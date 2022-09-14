import java.util.*;

class DietPlan{

	public static void main(String[] args) {
		System.out.println("Enter the name of the dishes");
		Scanner in = new Scanner(System.in);

		int num = 0;
		ArrayList<String> dish = new ArrayList<String>(7);
		while(num<7) 
		{
			String data = in.nextLine();
			if(!dish.contains(data))
			{
				dish.add(data);
				num++;
			}
		}
		System.out.println("You have entered 7 dishes");
		in.close();
		
		ListIterator<String> itr = dish.listIterator(0);
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("After sorting");
        Collections.sort(dish, Comparator.comparing(String::length));
		ListIterator<String> itr2 = dish.listIterator(0);
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
		System.out.println("After removing excluded item");
        dish.removeIf(n -> n.contains("cheese")||n.contains("butter")||n.contains("pasteries")||n.contains("fries"));  
        ListIterator<String> itr3 = dish.listIterator(0);
		while(itr3.hasNext()) {
			System.out.println(itr3.next());
		}
		
	}

}
