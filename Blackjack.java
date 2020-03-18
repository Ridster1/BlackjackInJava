
package blackjackinjava;
public class Blackjack {
  private static int pCardValue,dCardValue; 
  private static Object pCard,dCard;
  private static String pRank, pSuit;
  private static String dRank, dSuit;
  private static int balance = 100;
  private static char isChoiceHit, isChoicePlay;
  private static int bet;
  private static boolean isBetInvalid;
     
  public static void main (String [] args){
    Deck deck = new Deck();
    Output output= new Output();
    Input input= new Input();
    output.getName();
    String name = input.getName();
    output.hello(name);
    output.showBalance(balance);
    while ((balance>0)  && (isChoicePlay !='n')) {
        
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
    
        isChoiceHit='y';
        
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
       pRank=(deck.getCardRank(pCard));
       pSuit=(deck.getCardSuit(pCard));
       dRank=(deck.getCardRank(dCard));
       dSuit=(deck.getCardSuit(dCard));
       output.outStr(pRank, pSuit);
       
       if ( k==1) 
            { output.str("                     ?"); // Hide dealer's second card
            output.nextln(); 
            } 
            else 
            { output.str("                "); 
            output.outStr(dRank, dSuit); 
            output.nextln();
            }
        playerHand.addCardSum(pCardValue);
        dealerHand.addCardSum(dCardValue);
       }
    
    output.nextln();
    output.str("Sum:");
    output.numOut(playerHand.getCardSum()); 
    if (dealerHand.getCardSum() == 21) { isChoiceHit='n'; }
    output.nextln();
    output.nextln();
    
    while ((isChoiceHit=='y') & (playerHand.getCardSum()<21)) {
        output.hitChoice();
        isChoiceHit= input.getChoice();
        if (isChoiceHit=='y') {
            pCard=playerHand.addCard(deck); 
            pRank=(deck.getCardRank(pCard));
            pSuit=(deck.getCardSuit(pCard));
            pCardValue= deck.getCardValue(pCard);  
            output.nextln();
            output.str("You drew:");
            output.nextln();
            output.outStr(pRank, pSuit);
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
    output.outStr(dRank, dSuit);
    output.nextln(); 
    output.nextln(); 
    output.str("                             Sum:");
    output.numOut(dealerHand.getCardSum()); 
    output.nextln(); 
    while ((dealerHand.getCardSum()<17) & (playerHand.getCardSum()<21)) {
          dCard = dealerHand.addCard(deck);
          dRank=(deck.getCardRank(dCard));
          dSuit=(deck.getCardSuit(dCard));
          dCardValue= deck.getCardValue(dCard);
          output.nextln();
          output.str("                             Dealer drew:");
          output.nextln();
          output.str("                             ");
          output.outStr(dRank, dSuit);;
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
    output.showBalance(balance);
    
    if (balance == 0) {
        output.nextln();
        output.str("You're out of cash! Thanks for Playing! ");
    } 
    
    if (balance !=0) {
        output.playChoice();
        isChoicePlay= input.getChoice();
        output.nextln();
    }
   
   } 
    
  }   
  public static boolean isBetInvalid(int b) {
      if ((b<1) | (b>balance)) {
      System.out.println("Please enter valid amount! (1-"+balance+")");
      return true;
      }
    
     else return false;  
  }

}
    
  
 
