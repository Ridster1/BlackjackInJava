package blackjackinjava
import java.util.*;
    
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
      System.out.println("Please enter valid amount! (1-"+balance+")");
      return true;
      }
    
     else {return false;}  
  }

}
    
 
 
 
