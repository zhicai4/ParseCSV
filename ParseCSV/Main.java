import java.io. *;

public class Main {

	public static void main(String[] args) {
		
			
			
			String FileName = "data";
			String url = "jdbc:sqlite:C:/sqlite/" + FileName;  
			
			SQLdb myDB = new SQLdb(url + ".db" );
			
		 	String csvFile = FileName + ".csv"; 	
		 	myDB.ConnectDB(FileName + ".db");
		 
		 	myDB.createTable();
		 	
		 	
	        BufferedReader br = null;
	        String line = "";
	        int test = 0; 
	        
	        System.out.println("Working Directory = " +
	                System.getProperty("user.dir"));
	        Parse.CreateFile("data");
	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                
	            	test ++;
	            	if(test == 1) continue;
	                Parse.TestParse(line,myDB);

	            }
	            

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        System.out.println("Received : " + Parse.getReceived());
	        System.out.println("success : " + Parse.getsuccess());
	        System.out.println("fail : "  + Parse.getfail());
	       

	    }
}


