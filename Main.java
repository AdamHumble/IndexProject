/*
import any necessary classes
*/
import java.io.*;
import java.util.Scanner;
/**
* <H1>Main Indexing Program</H1>
* 
* The Indexing Program will ask the user to input a file path for
* the program to read in, insert each word into the binary search
* tree, then print the word with its corresponding page number and
* line number.
*  
* INPUT: User entered path to text file
* PROCESSING: Breaking down each word from the text file, adding them
* to the binary search tree, writing the results to a new text file and
* to the console
* OUTPUT: Writing the results to a new text file and to the console
*
* @author  Adam Humble
* @version 1.8  
* 
* This is today's date
* @since   2022-11-23 
*/
public class Main {
  /** 
    Method name: main()
    This is the main function for a program.
    Asks the user for a filename and writes an index to the
    screen and to a file.
    @param args which is a String
    @throws Exception to catch incorrect file names
    No explicit parameters or return statements.
  */
  public static void main(String[] args) throws Exception {
      try {
        String line;
        String[] lineWords;
 
        Scanner in = new Scanner(System.in); // create scanner for user input
        System.out.println("Please enter the file path: ");
        String filepath = in.nextLine();
        Scanner scn = new Scanner(new File(filepath)); // create scanner for file read

        /* New BST created called tree */
        BST<String> tree = new BST<>();

        /* this while loop scans each line of the text file, converts to lowercase,
           splits the words into individual elements, then adds them to tree */
        while (scn.hasNextLine()) {
          line = scn.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
          lineWords = line.split("\\s+");
          for (String word : lineWords) {
            if (word.length() > 0)
            tree.add(word.replace("\\n", ""));
          }
        
        }
        in.close(); // close input scanner
        scn.close(); // close file reading scanner

        /* open a printstream to create a file that begins with index- and the 
           user file name, then prints to file instead of console */
        PrintStream indexFile = new PrintStream(new File("index-" + filepath));
        PrintStream console = System.out;
        System.setOut(indexFile);
      
        System.out.printf("\n%-15s %-5s %-5s\n", "Word", "Page", "Line");
        System.out.printf("%-15s %-5s %-5s\n", "----", "----", "----");
        tree.inOrder();

        /* sets the print to go back to console instead of file */
        System.setOut(console);

        System.out.printf("\n%-15s %-5s %-5s\n", "Word", "Page", "Line");
        System.out.printf("%-15s %-5s %-5s\n", "----", "----", "----");
        tree.inOrder();
      
      }
      /* when invalid file name is entered */
      catch (IOException e) {
        System.out.println("Invalid file name.");
        System.out.println(e.getMessage());
        System.out.println("Please try again.");
      }
      finally {}
    
  } 
}

