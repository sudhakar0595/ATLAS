
public class Testt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank obj1= new Bank();
        obj1.setAccNum(123212323L);
        obj1.setName("sudhakar");
        obj1.setPhoneNum(9876543210L);
        obj1.setEmail("abc@abc.c");
        obj1.setGender("male");
        System.out.println("Account Number " + obj1.getAccNum());
        System.out.println("Name " + obj1.getName());
        System.out.println("Phone Number " + obj1.getPhoneNum());
        System.out.println("Email ID " + obj1.getEmail());
        System.out.println("Gender " + obj1.getGender());
	}

}
