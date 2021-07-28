import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		File test = new File("Test.txt"); 
		FileWriter fileW = new FileWriter("output.txt");
		FileWriter fileO = new FileWriter("ForSyntax.txt");
		
		Scanner scan = new Scanner(test);
		String sb = "";						
		
		String s; 
		s=scan.nextLine();
		StringTokenizer st = new StringTokenizer(s);					//reads in all tokens must be delimited with only a space. 
		while(st.hasMoreTokens()) {
			
			sb = st.nextToken();
			
			System.out.print(sb + " ");
			
			if (Pattern.matches("[-]?[0-9]+", sb)) {					//regex for int, including negative ints
				fileW.write("Integer ");
				fileO.write("10 \n");
			}
			
			else if (Pattern.matches("[-]?[0-9]*\\.[0-9]++", sb)) {		//regex for float, including negative float
				fileW.write("Float ");
				fileO.write("11 \n");
			}
			
			else if (Pattern.matches("^[a-zA-Z_][a-zA-Z_0-9]*$", sb)) {	//regex for identifiers, must start with letter or underscore and can contain numbers, underscores, and other letters
				switch (sb) {											
					case "for": 										//switch to recognize keywords, all keywords have their own token number as they mean different operations would follow.
						fileW.write("Keyword ");								
						fileO.write("27 \n");
						break;
					case "if": 
						fileW.write("Keyword ");								
						fileO.write("28 \n");
						break;
					case "else": 
						fileW.write("Keyword ");								
						fileO.write("29 \n");
						break;
					case "while": 
						fileW.write("Keyword ");								
						fileO.write("30 \n");
						break;
					case "do": 
						fileW.write("Keyword ");								
						fileO.write("31 \n");
						break;
					case "int": 
						fileW.write("Keyword ");								
						fileO.write("32 \n");
						break;
					case "float": 
						fileW.write("Keyword ");								
						fileO.write("33 \n");
						break;
					case "switch": 
						fileW.write("Keyword ");								
						fileO.write("34 \n");
						break;
					case "class": 
						fileW.write("Keyword ");								
						fileO.write("35 \n");
						break;
					case "void": 
						fileW.write("Keyword ");								
						fileO.write("36 \n");
						break;
					case "bool": 
						fileW.write("Keyword ");								
						fileO.write("37 \n");
						break;
					default : 
						fileW.write("Identifier ");								
						fileO.write("12 \n");
				}
				//fileW.write("Identifier ");								
				//fileO.write("12 \n");
			}
			else {
				switch (sb) {											//switch statement for all valid symbols
					case "{":
						fileW.write("leftBrace ");
						fileO.write("13 \n");
						break;
					case "}":
						fileW.write("rightBrace ");
						fileO.write("14 \n");
						break;
					case "(":
						fileW.write("leftPar ");
						fileO.write("15 \n");
						break;
					case ")":
						fileW.write("rightPar ");
						fileO.write("16 \n");
						break;
					case "=":
						fileW.write("equals ");
						fileO.write("17 \n");
						break;
					case "*":
						fileW.write("mulOp ");
						fileO.write("18 \n");
						break;
					case "/":
						fileW.write("divOp ");
						fileO.write("19 \n");
						break;
					case ">":
						fileW.write("greOp ");
						fileO.write("20 \n");
						break;
					case "<":
						fileW.write("lesOp ");
						fileO.write("21 \n");
						break;
					case "-":
						fileW.write("subOp ");
						fileO.write("22 \n");
						break;
					case "+":
						fileW.write("addOp ");
						fileO.write("23 \n");
						break;
					case ";":
						fileW.write("semic ");
						fileO.write("24 \n");
						break;
					case "%":
						fileW.write("modOp ");
						fileO.write("25 \n");
						break;
					case "!=":
						fileW.write("notEq ");
						fileO.write("26 \n");
						break;
					default : 
						System.exit(0);								//Exits the program if there is an undefined token
						
				}	
			}
			fileW.write(sb + " " + "\n");							//This is to quickly check for issues, such as only partial parsing caused by improper delimiting
		}
		fileW.close();
		fileO.close();
		scan.close();
	}
}