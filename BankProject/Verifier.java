public class Verifier {
	public String password;
	public Integer wrongTries;
	
	public Verifier(String password, Integer wrongTries){
		this.password = password;
		this.wrongTries = wrongTries;
	}
	
	public void accountLock(){
		System.out.println("Your account has been locked");
	}

}
