/*
 * By: Natalie Chin
 * For: Computer Science
 * Start Date: November 25
 * End Date: December 19
 * 
 * SHORTFORMS IN THIS PROGRAM WITH DOCUMENTATION
 * 
 * Before Writing (copied or pasted from another program) = BW
 * While Writing = WW
 * After Wrting (After thought) = AW
 * 
 * Note: ALL METHOD DELIMINATORS WERE WRITTEN RIGHT AFTER METHODS WERE CREATED
 */
package aotearoaaccommodation;

import java.io.*; //import for buffered reader
import java.text.*;  //import for reading in and out of a file. 

public class AotearoaAccommodation 
{
    int positionInArray; 
    boolean tracing = false; 

    //Declaration of Buffered Reader - WW
    BufferedReader aa = new BufferedReader (new InputStreamReader (System.in)); 
    
    public static void main(String[] args) throws IOException
    {
        new AotearoaAccommodation();
    } //end of main method
    
    AotearoaAccommodation() throws IOException // WW
    {
      Location accommodation[] = new Location [100]; //Declaration of the Location array. Contains indicies 0-99 and elements 1-100 - WW (documentation AW). 
      
      readFromFile(accommodation); //calling method - WW  
      welcomeScreen(); // calling method - WW
      instruction(); //calling method - WW
      
                String answer;  //declaration of variable - WW
                char choice;  //declaration of variable - WW
                //If the other method ever return values, this makes sure that it redoes itself. 
                do //do this while the user doesn't want to exit - WW
                {
                    //makes sure that the choice is a, A, b, or B - WW
                    do
                    {
                                    //makes sure that the user has to enter a value -WW (documentation AW).
                                    do
                                    {
                                        // ascii - AW (documentation AW too)
                                        System.out.println("                                         __  __                  ");
                                        System.out.println("                                        |  \\/  |                 ");
                                        System.out.println("                                        | \\  / | ___ _ __  _   _ ");
                                        System.out.println("                                        | |\\/| |/ _ \\ '_ \\| | | |");
                                        System.out.println("                                        | |  | |  __/ | | | |_| |");
                                        System.out.println("                                        |_|  |_|\\___|_| |_|\\__,_|");

                                    centreln("Press a) to enter information on accommodation");
                                    centreln("Press b) to display information on accommodation");
                                    centreln("Press x) to exit");
                                    centre("Enter your choice: "); //<-- AW
                                        answer = aa.readLine();

                                        if (answer.length()== 0)  //if the array.length is 0, it means the user didn't enter anything, so the program makes answer equal to an invalid character - WW
                                        {
                                        answer = "e"; //AW because WW, I tried to see if the answer.length()==0, but it came up with an error so I found another way to do it. 
                                        }

                                        choice = answer.charAt(0); //WW

                                        if (choice != 'a' && choice != 'A' && choice != 'b' && choice != 'B' && choice != 'x' && choice != 'X') centreln("Invalid Entry"); //WW

                                        clearScreen(); //WW

                                    } while ((answer.length()==0)|| (choice != 'a' && choice != 'A' && choice != 'b' && choice != 'B' && choice != 'x' && choice != 'X' )); //WW

                            switch (choice) //WW
                            {
                                case 'a': 
                                case 'A': 
                                        getPlace(accommodation);
                                        save(accommodation); 
                                    break; 
                                case 'b': 
                                case 'B': 
                                        displayToUser(accommodation);
                                    break; 
                                case 'x': 
                                case 'X': 
                                        endScreen();
                                    break; 
                            } //end of switch statement. 

                    } while ((choice != 'a' && choice != 'A' && choice != 'b' && choice != 'B' && choice != 'x' && choice != 'X'));
                    
                    //Double the length of the array (WW)
                    if (positionInArray==accommodation.length)
                    {
                        Location aotearoa[] = new Location[2*(accommodation.length)]; //makes a new array that is double the length (WW)
                        for (int index = 0; index<accommodation.length; index++) //goes through the array and copies the contents (WW)
                                aotearoa[index] = accommodation[index]; 
                        accommodation = aotearoa;  //changing the reference of aotearoa to accommodation
                    } //end of if statement (WW)
                    
                } while(choice != 'x' && choice != 'X'); //end of do while loop (WW)
    } //end of accommodation (WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Shows a welcome screen
     * Parameters and Return Type: None. 
     * Pre conditions: None. 
     * Post conditions: Would have showed the welcome screen. 
     * ************************************************************************************************************************************
     */    
    
    private void welcomeScreen() throws IOException
    {
        
        System.out.println("                     ___                                               _       _   _             ");
        System.out.println("                    /  _ \\                                            | |     | | (_)            ");
        System.out.println("                    / /_\\ \\ ___ ___ ___  _ __ ___  _ __ ___   ___   __| | __ _| |_ _  ___  _ __  ");
        System.out.println("                    |  _  |/ __/ __/ _ \\| '_ ` _ \\| '_ ` _ \\ / _ \\ / _` |/ _` | __| |/ _ \\| '_ \\ ");
        System.out.println("                    | | | | (_| (_| (_) | | | | | | | | | | | (_) | (_| | (_| | |_| | (_) | | | |");
        System.out.println("                    \\_| |_/\\___\\___\\___/|_| |_| |_|_| |_| |_|\\___/ \\__,_|\\__,_|\\__|_|\\___/|_| |_|");
        System.out.println("");

        
    } //end of welcomeScreen method. (WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Shows the instructions on how to use the program. 
     * Parameters and Return Type: None. 
     * Pre conditions: None. 
     * Post conditions: Would have shown the instructions screen. 
     * ************************************************************************************************************************************
     */     
    
    private void instruction() throws IOException
    {
         centreln("Welcome to the Aotearoa Accommodation Program.");
         centreln("We'll ask you questions about your accommodation");
         centreln("Information includes date, accommodation name, and whether they replied or not.");
         clearScreen();
    } //end of information method. (WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Ask the user for all the information
     * Parameters and Return Type: Receives the array. 
     * Pre conditions: None. 
     * Post conditions: All the information will be known - the place's name, number, the dates you would be staying, etc. 
     * ************************************************************************************************************************************
     */     
    
    private void getPlace(Location[] accommodation) throws IOException
    {
            char yn;
            String answer; 

            do
            {
                    accommodation[positionInArray] = new Location(); //this initialies the objects when entering location places. (AW)

                    centre("Where are you staying? (Town, City) "); 
                        accommodation[positionInArray].name = aa.readLine(); //inserts the user input into the name bubble in the index at position in array. (AW)

                    centre("What is the name of the place you are staying? (Hilton Inn, Best Western)  "); 
                        accommodation[positionInArray].place = aa.readLine();    //inserts the user input into the place bubble in the index at position in array. (AW)

                    centre("What month are you staying in the place?(January, February, etc) ");
                        accommodation[positionInArray].month = aa.readLine(); //inserts the usre input into the month bubble in the index at position in array. (AW)

                    centre("What is the date you are staying at this place? ");
                            try
                            {
                            String numberString = aa.readLine().trim().toUpperCase(); //program reads the byte value into the program (AW)
                            //accommodation[positionInArray].date = NumberFormat.getInstance().parse(numberString ).byteValue();
                            accommodation[positionInArray].date = Byte.parseByte(numberString);  //puts the value that was read from the string into the byte (AW)
                            } //end of try
                            catch (Exception e)
                            {
                            accommodation[positionInArray].date = 0; //if what they entered wasn't a number, make it equal to 0. (AW)
                            }//end of catch

                    centre("What type of accommodation?(Holiday Park, Cabin, Hotel) "); 
                        accommodation [positionInArray].type = aa.readLine(); //this puts the type of accommodation into the bubble at the position in array  (AW)

                    centre("How much per head? "); 
                        try 
                        {
                        String numberString = aa.readLine().trim().toUpperCase(); //this puts the user input into a string variable and trims it  (AW)
                        accommodation[positionInArray].cost = Double.parseDouble(numberString); //puts it into the bubble of cost at position in array (AW)
                        } //end of try
                        catch (Exception e)
                        {
                        accommodation[positionInArray].cost = 0.0;    //if the user didn't enter something or entered an invalid value, make price = 0.  (AW)
                        } //end of catch

                    centre("Is there any other info (they haven’t replied, etc, etc?) "); 
                        accommodation[positionInArray].info = aa.readLine(); //this puts the user input into the info bubble at position in array (AW)

                        if(accommodation[positionInArray].info == null) //if the user simply pressed the enter key, make the value inside that little box N/A instead of displaying nothing (AW)
                            accommodation[positionInArray].info = "N/A";

                    positionInArray ++; //increase positionInArray ever time the persony user enters a value! :D

                    do
                    {
                    centre("Do you want to enter another entry? "); 
                                    answer = aa.readLine();

                            yn = answer.charAt(0);

                        if (answer.length()==0) centreln("You didn't enter a value. Please re enter.");

                        if (yn != 'y' && yn != 'Y' && yn != 'n' && yn != 'N') centreln("You did not enter a valid entry.");  

                    }while ((yn != 'y' && yn != 'Y' && yn != 'n' && yn != 'N') || (answer.length()==0));


                clearScreen();
                
            } while (yn == 'y' || yn == 'Y'); 

        
        if (tracing) centreln("End of getPlace method positionInArray"+positionInArray);
        
    } //end of getPlace method. (WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Asks the user whether they want to save the values that they entered
     * Parameters and Return Type: Receives the array. 
     * Pre conditions: The array must have values inside it
     * Post conditions: Asks the user whether they want to save the changes or not, and if so, call print to file method. If not, return to the menu. 
     * ************************************************************************************************************************************
     */     
    
    private void save(Location[] aotearoa) throws IOException
    {
        String answer; 
        char option; 
        
        do
        {
        centre("Do you want to save your changes? ");
            answer = aa.readLine();
            
            option = answer.charAt(0);
            
            if (answer.length()==0) centreln("Invalid entry");
            
            if (option != 'y' && option != 'Y' && option != 'n' && option != 'N') centreln("Invalid entry");
            
        } while ((option != 'y' && option != 'Y' && option != 'n' && option != 'N') || answer.length()==0); //end of while (WW)
        
        switch (option)
        {
            case 'y': 
            case 'Y': 
                printToFile(aotearoa); 
                centreln("We have saved your input!");
                centreln("We will direct you back to the menu where you can view your previous inputs along with the newly inputted ones.");
                clearScreen();
                return; 
            case 'n': 
            case 'N': 
                //if you do not want to add one to positionInArray, positionInArray will have an extra value, so we have to decrease it.  (AW)
                positionInArray--; 
                centreln("We have not saved your changes.");
                clearScreen();
                return; 
        } //end of switch (WW)
        
        return; 
        
    } //end of save method (WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Print to the File
     * Parameters and Return Type: Receives the Location array 
     * Pre conditions: None. 
     * Post conditions: Would have printed to the file already (if the user wanted to save the information)
     * ************************************************************************************************************************************
     */     
    private void printToFile(Location[] aotearoa) throws IOException
    {
        String fileName = "Accommodation.txt";
        
        PrintWriter outfile = new PrintWriter (new FileWriter(fileName)); //declares the print to file line of code (AW)
        outfile.println(positionInArray);      //print the positionInArray as the first step (AW)
        if (tracing) 
        {
            System.out.println(positionInArray);
            
        }
        try
        {
                for (int index = 0; index<positionInArray; index++)
                {

                if (tracing)
                {
                centreln("Name: " +aotearoa[index].name);
                centreln("Place: " +aotearoa[index].place);
                centreln("Month: " + aotearoa[index].month);
                centreln("Date: " +aotearoa[index].date);
                centreln("Cost: " + aotearoa[index].cost); //quotes make it into a string.  (AW)
                centreln("Type: " +aotearoa[index].type);
                centreln("info: " +aotearoa[index].info);            
                } //end of tracing

                /**Display all the information into the file in the following order, and therein going through the array and printing all the information out at positionInArray:  (AW)
                 * 
                 * Name
                 * Place
                 * Month
                 * Date
                 * Type
                 * Cost
                 * Info
                 * 
                 */
                
                outfile.println(aotearoa[index].name);
                outfile.println(aotearoa[index].place);
                outfile.println(aotearoa[index].month);
                outfile.println(aotearoa[index].date);
                outfile.println(aotearoa[index].type);
                outfile.println(aotearoa[index].cost);
                outfile.println(aotearoa[index].info);

                } //end of for loop (WW)
        }// end of try (WW)
        
        catch(Exception e) //if all else fails, print 0.  (WW)
        {
        outfile.println("0");
        } //end of catch (WW)
        
                outfile.close();
        if (tracing) centreln("End of printToFile method positionInArray"+positionInArray);
    } //end of print to file method. (WW)
    
     /**************************************************************************************************************************************
     * Description of Method: Reads from the File
     * Parameters and Return Type: Receives an array
     * Pre conditions: None. 
     * Post conditions: Should have read from the file already 
     * ************************************************************************************************************************************
     */ 
    
    private void readFromFile(Location[] aotearoa) throws IOException
    {
        
        
        BufferedReader infile = new BufferedReader(new FileReader("Accommodation.txt")); //tells the program to read from accommodation.txt (AW)
        
        positionInArray = Integer.parseInt(infile.readLine());
            //making positionInArray into the first number in the file
        
            if (tracing) centreln("" + positionInArray); //displaying positionInArray because positionInArray kept messing up
            
        for (int index = 0; index<positionInArray; index++) //this line of code goes through the loop and makes new objects. I had originally forgot about this step causing a lot of logical errors. As noted, this was written while developing the program. (AW)
              aotearoa[index] = new Location();            
            
        for (int index = 0; index<positionInArray; index++)
        {
            
            String temp = infile.readLine(); //make the thing on the first line equal to a string (AW)
            if (tracing) centreln(temp);           
                aotearoa[index].name = temp; //puts the string into the thing at positionInArray (name bubble) (AW)
            if (tracing)         centreln(aotearoa[index].name);
            
            temp = infile.readLine(); //make the same string equal to th 2nd line in the file (AW)
            if (tracing) centreln(temp);
            aotearoa[index].place = temp; //puts the string into the thing at positionInArray (place bubble) (AW)
            if (tracing)         centreln(aotearoa[index].place);
            
            temp = infile.readLine(); //makes string equal to the 3rd line in the file (AW)
            if (tracing) centreln(temp);
            aotearoa[index].month = temp; //puts the string into the thing at positionInArray (month bubble) (AW)
            if (tracing) centreln(aotearoa[index].month);  
            
            byte day = Byte.parseByte(infile.readLine()); //makes the byte equal to the 4th line in the file  (AW)
            if (tracing)        System.out.println(day);
                aotearoa[index].date = day;  //puts the byte into the thing at positionInArray (date bubble) (AW)
            if (tracing)         System.out.println(aotearoa[index].date);
            
            temp  = infile.readLine(); //makes temp equal to the 5th line in the file (AW)
            if (tracing) centreln(temp);
            aotearoa[index].type = temp;  //puts the type into the thing at positionInArray (type bubble) (AW)
            if (tracing)         centreln(aotearoa[index].type);            

            double cost = Double.parseDouble(infile.readLine()); //makes double equal to the 6th line in the file (AW)
            if (tracing) centreln("" + cost);
            aotearoa[index].cost = cost;          //puts the double into the thing at positionInArray (cost bubble) (AW)
            if (tracing)         centreln("" + aotearoa[index].cost); //quotes make it into a string.  (AW)
            
            temp = infile.readLine(); //makes the string equal to the 7th line.  (AW)
            if (tracing) centreln(temp);
            aotearoa[index].info = temp; //puts the string into the thing at positionInArray (info bubble) (AW)
            if (tracing)         centreln(aotearoa[index].info);     
           
        } //end of for loop
        
        infile.close();
        
        if (tracing) centreln("End of readFromFile method positionInArray"+positionInArray);
    } //end of print to file method. (WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Ends the screen 
     * Parameters and Return Type: None. 
     * Pre conditions: None. 
     * Post conditions: Would have displayed the end screen already 
     * ************************************************************************************************************************************
     */        
    
    private void endScreen() throws IOException
    {
        System.out.println("                     _______ _                 _                        ");
        System.out.println("                    |__   __| |               | |                       ");
        System.out.println("                       | |  | |__   __ _ _ __ | | __  _   _  ___  _   _ ");
        System.out.println("                       | |  | '_ \\ / _` | '_ \\| |/ / | | | |/ _ \\| | | |");
        System.out.println("                       | |  | | | | (_| | | | |   <  | |_| | (_) | |_| |");
        System.out.println("                       |_|  |_| |_|\\__,_|_| |_|_|\\_\\  \\__, |\\___/ \\__,_|");
        System.out.println("                                                       __/ |            ");
        System.out.println("                                                      |___/             ");
        System.out.println("                    ");
        
        centreln("Thanks for using the program. ");
        
        centre("Press the enter key to exit.");
            aa.readLine();
        
    } //end of end screen method.(WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Displays Output to the user
     * Parameters and Return Type: Receives aotearoa array. 
     * Pre conditions: None. 
     * Post conditions: Would have displayed the information already 
     * ************************************************************************************************************************************
     */     
    //This method was an afterthought cause I had to think of a way that the user could view their previous inputs without being too confusing to get to (AW)
    
    private void displayToUser(Location[] aotearoa) throws IOException
    {
        if (tracing) 
            centreln("" + positionInArray);
        
        /*Displaying to the user (AW)
         * 
         * Displays - Name, Place, Date, Type, Cost, Extra Information
         * 
         * These go through the array and display everything.
         * 
         */
        
        for (int index = 0; index<positionInArray; index++)
        {
            centreln("Name: " +aotearoa[index].name + ".");
            centreln("Place: " +aotearoa[index].place + ".");
            centreln("Date: " +aotearoa[index].month + " " +aotearoa[index].date + ".");
            centreln("Type: " +aotearoa[index].type + ".");
            centreln("Cost: $" +aotearoa[index].cost + ".");
            centreln("Extra Information: " +aotearoa[index].info + ".");
            centreln("\n");
            
            clearScreen();
            
            
        } //end of for loop (WW)
        
        return; 
        
    } //end of display to user method. (WW)
    
    /**************************************************************************************************************************************
     * Description of Method: Clears the screen (with 32 backslashes)
     * Parameters and Return Type: None 
     * Pre conditions: None. 
     * Post conditions: Would have cleared the screen already 
     * ************************************************************************************************************************************
     */        
    
    private void clearScreen() throws IOException
    { //Start of clearScreen method (BW)

            centre("Press the enter key to continue");
            aa.readLine();
             System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }    //End of clearScreen method  (BW)
    
    /**************************************************************************************************************************************
     * Description of Method: Centres the code automatically
     * Parameters and Return Type: Must recieve a string.. 
     * Pre conditions: None. 
     * Post conditions: would have centred the code already (in a System.out.println();) 
     * ************************************************************************************************************************************
     */     
    
    private void centreln(String s)     
    {         
            for(int count=0; count<(97-s.length())/2; count++)        
            {             
                    System.out.print(" ");         
            }//End of for loop   (BW)
        System.out.println(s);     
    } //End of centreln method (BW) 
      
    
    /**************************************************************************************************************************************
     * Description of Method: Centres the code automatically. 
     * Parameters and Return Type: Must receive a string. 
     * Pre conditions: None. 
     * Post conditions: Would have centred the code already but with a system.out.print - leaving the cursor at the line. 
     * ************************************************************************************************************************************
     */     
    
    private void centre(String s)     
    {     
            for(int count=0; count<(97-s.length())/2; count++)      
            {     
                System.out.print(" ");      
            } //End of for loop  (BW)     
    System.out.print(s);     
    } //End of centre method   (BW) 
    
    
}//end of class. 
 
/*PROBLEMS AND ERRORS!
 * 
 * Problem: The program crashed constantly while reading from the file (while writing code).
 * Solution: I never initialized the objects which was a logical error. I just (well..technically Ryk) wrote a line of code that created a variable that went through the array
 *           made it equal to "new Location". 
 * 
 * Problem: When displaying the information out to the screen, the "positionInArray" was being double it's original value (for example, if there were only 20 things in the array, 
 *          the program made positionInArray = 40 instead so the loop crashed with an OUT OF BOUNDS. (while writing the code)
 * Solution: Get rid of the "positionInArray++" in the loop for getting user input (in getInput method)
 * 
 * Problem: Logical error - what would happen if the user was going away for more than 99 nights? (after writing the code)
 * Solution: if the position in array is equal to the length of the array, then make a temp array that is double the size and change the reference point.
 *
 * Problem: Another logical error - I hadn't included "if choice!= 'x' && choice != 'X'" and so if the user got to the menu and wanted to exit, it would loop back to the beginning of the method (found out after writing)
 * Solution: include choice != 'x' && choice != 'X'in the do while loop.
 * 
 * Problem: Java Number Format Exception if the file is empty because the first thing that the file must read in is the positionInArray (while writing)
 * Solution: NO ONE TOUCH THE FILE! DO NOT EDIT ANYTHING!
 * 
 * Problem: When I was writing out to the file, I included a blank line of code to separate each accommodation, but didn't accommodate that in the readFromFile method. (while writing)
 * Solution: I got rid of the line of code because the user shouldn't be fooling around with the output file anyways, so, I thought that formatting the file wasn't necessary. My original thought
 *           was for the user to read the file itself, but I thought it would be inconvenient. 
 * 
 */