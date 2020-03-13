import java.util.*; 
 
public class Output {
     
     public void getName() {
         System.out.print("Hi! Please enter your name: " ) ;
     }
     
     public void hello (String userName) {
         System.out.println("Hello "+ userName +"! Let's play a game of blackjack!" ) ;
         System.out.println();
         System.out.println("Here's some cash to start!");
         
     }
     
     public void showBalance(int bal) {
     System.out.println("You have $"+ bal+"." ) ;
     System.out.println();
     }
     
     public void enterBet() {
        System.out.print("Please enter your bet $ ") ;
     }
     
     public void heading() {
         System.out.println();
         System.out.println();
         System.out.println("Your hand" +  "                     Dealer's hand" ) ;
         System.out.println("*********" +  "                     *************" ) ;
         System.out.println();
     }
     
    public void out(Object obj) {
         System.out.print(obj);
    }
    
    public void hitChoice() {
         System.out.print("Hit ? (Y/N): ");
    }
    
    public void hide() {
        System.out.println("                     ?");
    }
 
    public void space() {
      System.out.print("                ");
    }
    
    public void nextln() {
      System.out.println();
    }
 
    public void numOut(int num) {
        System.out.print(num);
    }
        
    public void str(String s) {
    System.out.print(s);
    }
    
    public void playChoice() {
         System.out.println();
         System.out.print("Continue? (Y/N): ");
         
    }

 }
 
 
 
 