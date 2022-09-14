import java.util.Scanner;


public class TreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t1 = new Tree(); 
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
                System.out.println("Enter integer element to insert");
                t1.add(in.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to search :: ");
                int sval=in.nextInt();
                if(t1.search(sval))
                {
                	 System.out.println("Element found ");
                }
                else
                {
                	System.out.println("Element not found ");
                }
                break;                                          
            case 3 : 
                System.out.println("Nodes = "+ t1.countNodes(t1.root));
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
