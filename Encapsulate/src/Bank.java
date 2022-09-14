
public class Bank {
	   	private long AccNum, PhoneNo;
	    private String Name, gender;
	    private String email ;
	    
	    void setAccNum(long AccNum){
	        this.AccNum = AccNum;
	    }
	    long getAccNum(){
	        return AccNum;
	    }

	    void setPhoneNum(long PhoneNo){
	        this.PhoneNo = PhoneNo;
	    }
	    long getPhoneNum(){
	        return PhoneNo;
	    }

	    void setName(String Name){
	        this.Name = Name;
	    }
	    String getName(){
	        return Name;
	    }

	    void setGender(String gender){
	        this.gender = gender;
	    }
	    String getGender(){
	        return gender;
	    }

	    void setEmail(String email){
	        this.email = email;
	    }
	    String getEmail(){
	        return email;
	    }
}
