
public class EmpTree {
	Employee root;
	int count =0;
	
	class Employee {    
	    	int EmpId;
	    	String EmpName, email;
	    	long PhoneNo;
	        Employee left, right; 
            void setEmpId(int EmpId){
    	        this.EmpId = EmpId;
    	    }
    	    int getEmpId(){
    	        return EmpId;
    	    }

    	    void setPhoneNo(long PhoneNo){
    	        this.PhoneNo = PhoneNo;
    	    }
    	    long getPhoneNo(){
    	        return PhoneNo;
    	    }

    	    void setEmpName(String EmpName){
    	        this.EmpName = EmpName;
    	    }
    	    String getEmpName(){
    	        return EmpName;
    	    }

    	    void setEmail(String email){
    	        this.email = email;
    	    }
    	    String getEmail(){
    	        return email;
    	    }
    	    Employee(){
    	    	left = null; 
	            right = null;
    	    }
	        Employee(int EmpId, String EmpName, String email, long PhoneNo){ 
	            /*this.EmpId = EmpId;
	            this.EmpName = EmpName; 
	            this.email = email; 
	            this.PhoneNo = PhoneNo; */
	        	setEmpId(EmpId);
	        	setEmpName(EmpName);
	        	setEmail(email);
	        	setPhoneNo(PhoneNo);
	        } 
	}
	public void add(int id, String name, String mail, long phone) {
		
		Employee new_Employee = new Employee(id,name,mail,phone); 
		if (root == null) { 
			root = new_Employee; 
			count++;
		} 
		else { 
				Employee last =root;
				Employee prev =root;
				while(last!=null)
				{
				prev=last;
				if(last.EmpId > id)
					last=last.left;
		    	else
		    		last=last.right;
		    	}
		    	if(prev.EmpId > id) {
		    		prev.left=new_Employee;
		    		count++;
		    	}
		    	else {
		    		prev.right=new_Employee;
		    		count++;
		    	}
		    }
	} 
	
	/*public boolean find(int Sid) {
		return search(root, Sid);
	}*/
	
	Employee search1(Employee p, int Sid) {
		if(p!=null) 
		{
			if(p.EmpId == Sid) {
				Employee current = new Employee(); 
				current.setEmpId(p.EmpId);
				current.setEmpName(p.EmpName);
				current.setEmail(p.email);
				current.setPhoneNo(p.PhoneNo);
				return current;
			}
			else if(p.EmpId>Sid)
				 return search1(p.left,Sid);
			else 
				 return search1(p.right,Sid);
		}
		return null;
	}
	
	boolean search(Employee p, int Sid) {
		if(p!=null) 
		{
			if(p.EmpId == Sid) {
				Employee current = new Employee(); 
				current.setEmpName(p.EmpName);
				return true;
			}
			else if(p.EmpId>Sid)
				 return search(p.left,Sid);
			else 
				 return search(p.right,Sid);
		}
		return false;
	}
	
	int countEmployees(Employee p) {
		
		if(p!=null)
		{
			return 1+countEmployees(p.right)+countEmployees(p.left);
		}
		return 0;
		
	}
	
	boolean isEmpty()
	{
		if (root == null)
			return true;
		else
			return false;
	}
	
	public void TreePrint(int printChoice)
	{
		if(printChoice == 1)
			inorder(root);
		else if(printChoice == 2)
			preorder(root);
		else if(printChoice == 3)
			postorder(root);
		else
			System.out.println("wrong choice!!!");
			
	}
	
	void inorder(Employee p)
	{
		
		if(p!=null)
		{
		inorder(p.right);
		System.out.println(p.EmpId+","+p.EmpName+","+p.email+","+p.PhoneNo);
		inorder(p.left);
		
		}
	}

	void preorder(Employee p)
	{
		if(p!=null)
		{
		System.out.println(p.EmpId+","+p.EmpName+","+p.email+","+p.PhoneNo);
		preorder(p.left);
		preorder(p.right);
		}
	}
	void postorder(Employee p)
	{
		if(p!=null)
		{
		postorder(p.left);
		postorder(p.right);
		System.out.println(p.EmpId+","+p.EmpName+","+p.email+","+p.PhoneNo);
		}
	}
} 

