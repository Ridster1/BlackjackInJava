import java.util.*;

class Deck {

    private enum Suit { SPADES, HEARTS, DIAMONDS, CLUBS };
    
    private enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(10),QUEEN(10), KING(10), ACE(11);
  
        private int value;
        private Rank (int value) {
            this.value = value;
        }
        private int showValue() {
            return value;
        }
    };
    
    private ArrayList<ArrayList<Object>> deckBuilder;
    private ArrayList <Object> cardBuilder;

    public Deck() {
      deckBuilder = new ArrayList<ArrayList<Object>>();  // Make a list of lists
      for (Suit s : Suit.values()) {
          for (Rank r : Rank.values()) {
              cardBuilder = new ArrayList<Object>();
              cardBuilder.add(r);                         //populate deck
              cardBuilder.add(s);
              deckBuilder.add(cardBuilder);
         }
      }
      Collections.shuffle(deckBuilder);                 // Shuffle cards
    } 

    public Object dealCard() {
       return deckBuilder.remove(0);
    }
     
    public Object showCards() {
       return deckBuilder; 
    } 
      
    public int getCardValue(Object obj) {              //  get card value from enum
        int cardVal=0;
        ArrayList aList= (ArrayList) obj;
        Object ob= aList.get(0);                   
        for(Rank match: Rank.values()) {
            if(ob == match) {  
               cardVal = match.showValue(); 
            }
        }
        return cardVal;
    } 
}
     
     
class Hand {
    private int aceCount = 0;
    private int cardSum = 0;
         
    public Hand() {
        this.aceCount = aceCount;
        this.cardSum = cardSum;
    }
          
    public Object addCard(Deck d) {
        return d.dealCard();
    }
         
    public int addCardSum(int cardVal) {
        cardSum = cardSum + cardVal;  
        if (cardVal==11) { 
            cardSum = aceHandler(cardSum);
        }
        return cardSum;  
    }
     
    public int getCardSum() {
        return cardSum;  
    }
         
    public int aceHandler (int cardSm) {
        aceCount= aceCount+1;
        if ((aceCount > 1) ||((aceCount==1) & (cardSm > 21))) { 
            return (cardSm - 10);  
        } 

        else return cardSm;    
    }

}
     
     
    
public class Blackjack {
  private static int pCardValue,dCardValue; 
  private static Object pCard,dCard;
  private static int balance = 100;
  private static char isChoicehit, isChoicePlay;
  private static int bet;
  private static boolean isBetInvalid;
     
  public static void main (String [] args){
    Deck deck = new Deck();
    Output output= new Output();
    Input input= new Input();
    output.getName();
    String name = input.getName();
    output.hello(name);
    
    while ((balance>0)  && (isChoicePlay !='n')) {
        
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
    
        isChoicehit='y';
        output.showBalance(balance);
        do {
           output.enterBet();
           bet= input.getBet();
           
           } while (isBetInvalid(bet));
        output.heading();
    
       for (int k=0; k<=1;k++) {                       
       pCard=playerHand.addCard(deck); 
       dCard=dealerHand.addCard(deck);
       pCardValue= deck.getCardValue(pCard);
       dCardValue= deck.getCardValue(dCard);
       output.out(pCard);
       if ( k==1) 
            { output.str("                     ?"); // Hide dealer's second card
            output.nextln(); 
            } 
            else 
            { output.str("                "); 
            output.out(dCard); 
            output.nextln();
            }
        playerHand.addCardSum(pCardValue);
        dealerHand.addCardSum(dCardValue);
       }
    
    output.nextln();
    output.str("Sum:");
    output.numOut(playerHand.getCardSum()); 
    if (dealerHand.getCardSum() == 21) { isChoicehit='n'; }
    output.nextln();
    output.nextln();
    
    while ((isChoicehit=='y') & (playerHand.getCardSum()<21)) {
        output.hitChoice();
        isChoicehit= input.getChoice();
        if (isChoicehit=='y') {
            pCard=playerHand.addCard(deck); 
            pCardValue= deck.getCardValue(pCard);  
            output.nextln();
            output.str("You drew:");
            output.nextln();
            output.out(pCard);
            output.nextln();
            output.nextln();
            output.str("Sum:");
            output.numOut(playerHand.addCardSum(pCardValue));
            output.nextln();
            output.nextln();
        }
    
    }
    
    output.str("                             Dealer's hidden Card was:");
    output.nextln();
    output.str("                             ");
    output.out(dCard); 
    output.nextln(); 
    output.nextln(); 
    output.str("                             Sum:");
    output.numOut(dealerHand.getCardSum()); 
    output.nextln(); 
    while ((dealerHand.getCardSum()<17) & (playerHand.getCardSum()<21)) {
          dCard = dealerHand.addCard(deck);
          dCardValue= deck.getCardValue(dCard);
          output.nextln();
          output.str("                             Dealer drew:");
          output.nextln();
          output.str("                             ");
          output.out(dCard);
          output.nextln();
          output.nextln();
          output.str("                             Sum:");
          output.numOut(dealerHand.addCardSum(dCardValue));
          output.nextln();
        
    }
    output.nextln();
    
    if (playerHand.getCardSum()==21) {
        output.nextln();
        output.str("BlackJack! You win twice your bet!");
        output.nextln();
        balance = balance + 2 * bet;
    }
    
    if (dealerHand.getCardSum() == 21) {
        output.nextln();
        output.str("Dealer has BlackJack! Dealer wins!");
        output.nextln();
        balance = balance - bet;
    }
    
    if (playerHand.getCardSum()>21) {
            output.str("You Busted! Dealer Wins!");
            output.nextln();
            balance = balance - bet;
    }   
    
    if ((playerHand.getCardSum()< dealerHand.getCardSum()) & (dealerHand.getCardSum()<21)) {
       output.str("Dealer Wins!");
       output.nextln();
       balance = balance - bet;
    }
       
    if (playerHand.getCardSum()==dealerHand.getCardSum()) {
        output.str("It was a Push! You get back your bet!");
        output.nextln();
        
    } 
    
    if ((playerHand.getCardSum()<21) & (playerHand.getCardSum()> dealerHand.getCardSum())) {
       output.str("You Win!"); 
       output.nextln();
       balance = balance + bet;
    }
    
    if ((playerHand.getCardSum()< dealerHand.getCardSum()) & (dealerHand.getCardSum()>21)) {
       output.str("Dealer busted! You Win!"); 
       output.nextln();
       balance = balance + bet; 
    }
    
    if (balance == 0) {
        output.nextln();
        output.str("You're out of cash! ");
    } 
    
    output.playChoice();
    isChoicePlay= input.getChoice();
    output.nextln();
   } 
    
  }   
  public static boolean isBetInvalid(int b) {
      if ((b<1) | (b>balance)) {
      //output.nextln();
      //output.str
      System.out.println("Please enter valid amount! (1-"+balance+")");
      return true;
      }
    
     else {return false;}  
  }

}
    
  

 class Input {
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
     
class Output {
     
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
 
 
 
 
