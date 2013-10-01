
public class LastTransaction implements java.io.Serializable{
	public String typeOfTransaction;
	public String lastTypeOfTransaction(){
		return typeOfTransaction;
	}
	
	public void setLastTypeOfTransaction(String type){
		typeOfTransaction = type;
	}
}
