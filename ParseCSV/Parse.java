import java.io. *;
import java.util.ArrayList;
import java.util.List;

public class Parse {

	//private String text;
	private static int received;
	private static int fail;
	private static int success;
	public Parse()
	{
		Parse.received = 0;
		Parse.fail = 0;
		Parse.success=0;
	}
	public static int getReceived(){return received;}
	public static int getfail(){return fail;}
	public static int getsuccess(){return success;}
	
	public static void TestParse(String text,SQLdb db)
	{
		Parse.received++;
		List<String> result = new ArrayList<>();
		char[] charArray = text.toCharArray();
		StringBuffer current = new StringBuffer();
	
		boolean quotes = false;
		boolean valid = true;
		for(char c: charArray)
		{
			if(c == '"')
			{
				quotes = !quotes;
			}
			if(c == ',')
			{
				if(quotes)
				{
					current.append(c);
				}
				else
				{
					result.add(current.toString());
					if(current.length() == 0) valid = false;
					current = new StringBuffer();
				}	
			}
			else
			{
				current.append(c);	
			}
		}
		//last entry
		result.add(current.toString());
		if(current.length() == 0) valid = false;
		
		
		
		if(valid) Parse.success++;
		else Parse.fail++;
		if(!valid) writeFile("data-bad",text);
		
		if(valid) db.addDB(result);	
	}
	public static void CreateFile(String name)
	{
		try {
		      File myObj = new File(name +"-bad"+ ".csv");
		      
		      
		        System.out.println("File created: " + myObj.getName());	        
		        FileWriter writer = new FileWriter(name +"-bad"+ ".csv");
		        writer.write("A,B,C,D,E,F,G,H,I,J\n");
		        writer.close();
		        
		      
		     
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void writeFile(String name,String text)
	{
		try {
		      FileWriter writer = new FileWriter(name+ ".csv",true);
		      writer.write(text+ "\n");
		      writer.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
