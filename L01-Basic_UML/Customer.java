
public class Customer {
	
	private String name;
	private String userID;
	private String password;
	
	public Customer(){
		this.name = "";
		this.userID = "";
		this.password = "";
	}
	
	public Customer(String name, String userID, String password){
		this.name = name;
		this.userID = userID;
		this.password = password;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public void setUserID(String newUserID){
		this.userID = newUserID;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String newPassword)
	{
		this.password = newPassword;
	}
}
