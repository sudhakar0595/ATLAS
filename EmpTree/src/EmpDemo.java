import java.util.Scanner;

public class EmpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpTree t1 = new EmpTree();
		Scanner in=new Scanner(System.in);
        while(true)    
        {
            System.out.println("\nBinary Tree Operations\n");
            System.out.println("1. add");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. Traversing");
            System.out.println("0. exit");
 
            int choice = in.nextInt();
            if(choice == 0)
            	break;
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter Employee ID");
                int EmpId = in.nextInt();  
                if(!t1.search(t1.root,EmpId)) {
                System.out.println("Enter Employee Name");
                String EmpName = in.next();
                System.out.println("Enter Employee Email");
                String email = in.next(); 
                System.out.println("Enter Employee Phone Number");
                long PhoneNo = in.nextLong(); 
                t1.add(EmpId, EmpName, email, PhoneNo);
                }
                else {
                	System.out.println("Emploee ID already exists");
                }
                break;                          
            case 2 : 
                System.out.println("Enter Employee ID to search");
                int Sid=in.nextInt();
                EmpTree.Employee test = t1.search1(t1.root,Sid);
                if(test == null)
                {
                	 System.out.println("Employee not found ");
                }
                else
                {
                	System.out.println("Employee found ");
                	System.out.println(test.EmpId+","+test.EmpName+","+test.email+","+test.PhoneNo);
                }
                break;                                          
            case 3 : 
                System.out.println("Nodes = "+ t1.countEmployees(t1.root));
                break;     
            case 4 : 
                System.out.println("Empty status = "+ t1.isEmpty());
                break; 
            case 5 : 
            	System.out.println("1. Inorder");
                System.out.println("2. preorder");
                System.out.println("3. postorder");
                int printchoice = in.nextInt();
                t1.TreePrint(printchoice);
                break; 
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
        }
        in.close();
	}
}
