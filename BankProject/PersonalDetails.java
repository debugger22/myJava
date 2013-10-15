
public class PersonalDetails implements java.io.Serializable{
	public String name,address;
	
	public void setName(String username){
		name = username;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAddress(String userAddress){
		address = userAddress;
	}
	
	public String getAddress(){
		return address;
	}
}
