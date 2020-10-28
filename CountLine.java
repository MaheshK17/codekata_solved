import java.util.*;
//import IOException class to handle error
import java.io.File;
class CountLine
{
	public static void main(String[] args)
	{
		String str = new String();
		int count = 0;
		int com = 0;
		int p=0;
		try
		{
			//Creating Open File object
			File file = new File("CountLine.java");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				//comment
				str = sc.nextLine();
				//check if any comments are occurring
				if(str.contains("//") )
				{
					com++;
				}
				else if(str.contains("/*") && str.indexOf("/*") == 0)
				{
					// check number of comment line from /* to */ count
					do
					{
						str = sc.nextLine();
						p++;
					}
					while(str == "*/");
				}
				else if(str.contains("*/"))
				{
					com++;
				}
				else
				{
					//increase number of line count
					count++;
				}
			}
			count = count + p + 3;
			System.out.println("Number of Lines in code = "+count);
			System.out.println("Number of Comments found = "+(com+1));
			System.out.println("check point");
			// close File 9
			sc.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception = "+e);
			System.out.println(e);
		}
		/*from here*/
	}
}