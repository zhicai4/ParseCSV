
import java.sql. *;
import java.util.List;  



public class SQLdb {  
	
	private String url;
	private Connection conn;
	private Statement state;
	public SQLdb(String url)
	{
		this.url= url;
	}
	
    public void ConnectDB(String fileName) {  
   
        try {  
            conn = DriverManager.getConnection(url);
            state = conn.createStatement();
            
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    public void createTable() 
    {
    	try {
    	String sql = "CREATE TABLE Data " +
                "(first VARCHAR(255), " +
                " last VARCHAR(255), " + 
                " email VARCHAR(255), " + 
                " gender VARCHAR(255), " + 
                " card VARCHAR(255)," +
                "pic VARCHAR(255)," +
                "value VARCHAR(255)," +
                "bool1 VARCHAR(255)," +
                "bool2 VARCHAR(255)," +
                "city VARCHAR(255))"; 
    	

    	state.executeUpdate(sql);
    	}catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    public void addDB(List<String> data) 
    {
    	try {
    	String sql = "INSERT INTO Data" + "(first,last,email,gender,card,pic,value,bool1,bool2,city)" +  "VALUES (?,?,?,?,?,?,?,?,?,?)";
    	PreparedStatement prep = conn.prepareStatement(sql);
    	
    	for(int i =0; i<10; i++)
    	{
    	prep.setString(i+1, data.get(i));
    	}
    	
    	prep.executeUpdate();
    	
    	}catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
  
   
}  