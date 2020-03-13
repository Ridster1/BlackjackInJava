 import java.util.*; 
 
 public class Input {
     Scanner sc= new Scanner(System.in);
     
     public String getName() {
         String name = sc.nextLine(); 
         return name;
     }
     
     public int getBet() {
     int bet = sc.nextInt();   
     return bet; 
     }
     
     public char getChoice() {
     char choice = sc.next().charAt(0);
     choice = Character.toLowerCase(choice);
     return choice;
     }
       
 } 
     
