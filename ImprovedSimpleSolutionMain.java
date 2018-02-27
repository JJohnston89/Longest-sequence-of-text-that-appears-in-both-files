import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImprovedSimpleSolutionMain {
	
	public static void main(String[] args) throws IOException{
		
		long startTime = 0, endTime = 0;
		
		if(args.length < 2){                                               //Checking if there is two files or not
			System.out.println("ERROR: not enough arguments");             //if not then print error message and exit program
			System.out.println("needs to be in the format: file1 file2");
			System.exit(1);
		}
		String x = getData(args[0]);                      //Getting the string from the first file
		String y = getData(args[1]);                      //Getting the string from the 2nd file
		
		startTime = System.currentTimeMillis();           //starting time		
		
		String longest = longestSequence(x, y);           //Finding the longest string that is in both strings from above
		
		endTime = System.currentTimeMillis();             //end time
		
		
		
		System.out.println("This program finds the longest sequence that is in both files");
		System.out.println("The longest sequence length is " + longest.length());
		System.out.println("The run time in milliseconds is " + (endTime - startTime));		
		System.out.println("The longest string is " + longest); 		
		
	}//end of main()
//-----------------------------------------------------------------------------		
	public static String getData(String fileName) throws IOException{	
		
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName)); //creating a BufferReader object to read the file
		StringBuilder sBuild = new StringBuilder();                          //creating a StringBuilder object to build the final string
		String finalString = null;
		
		try {
			while((finalString = reader.readLine()) != null){                //Reading the file line by line to the end
				
				sBuild.append(finalString);				                     //appending each string
			}
		} catch (IOException e) {
			System.out.println("Error: Can't read file");                    //If exception occurs print error message 
			System.out.println("Shutting down");                             //Then exit the program
			System.exit(2);
			e.printStackTrace();
		}
		
		reader.close();                                                       //closing the BufferedReader object
		finalString = sBuild.toString();                                      //Get the final string from StringBuilder
	        finalString = finalString.replaceAll("\\s+","");                      //Getting rid of white spaces
		
		
		return finalString;		                                              //return the final string
		
	}//end of getData()
//-----------------------------------------------------------------------------	
public static String longestSequence(String string1, String string2){
		
		ArrayList<String> list1;
		String longest;
		
		list1 = subStrings(string1, string2);        //Getting the sub-strings that are in both strings 		
		longest = maxOut(list1);                     //Getting the longest string from the list above
		
		return longest;		
	}//end of longestSequence()
//-----------------------------------------------------------------------------	
	private static ArrayList<String> subStrings(String string1, String string2){
		
		String subS;		
		ArrayList<String> setOfSubStrings = new ArrayList<>();
		
		
		for(int i = 0; i < string1.length(); i++){                //Starting at first character in the string to string length
			for(int j = 1; j <= (string1.length() - i); j++){     //Taking sub-strings from i to i + j
				
				subS = string1.substring(i, i + j);	
				if(!(setOfSubStrings.contains(subS)) && string2.contains(subS))	    //Getting rid of duplicates
					setOfSubStrings.add(subS);			                           //Adding a sub-string into the list 	
			                                                                       //if the sub-string is in both strings
			}//end of inner loop
		}//end of outer loop		
		
		return setOfSubStrings;
		
	}//end of subStrings()	
//-----------------------------------------------------------------------------	
	private static String maxOut(ArrayList<String> string1){	
	
		String longest = "";                     //setting the longest string to empty   
	
		for(int i = 0; i <string1.size(); i++){     
		
			if(string1.get(i).length() >longest.length()){    //if a string is greater then the longest
				longest = string1.get(i);                      //that string becomes the longest
			}//if
		
		}//for
	return longest;
	}//end of maxOut()
//-----------------------------------------------------------------------------	
}//end of SimpleSolutionMain Class
///////////////////////////////////////////////////////////////////////////////
