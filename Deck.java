
package blackjackinjava;
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
        
    public String getCardRank(Object c) {
        ArrayList rank= (ArrayList) c;
        String sRank = rank.get(0).toString();  
        return sRank;
    }
   
        
   public String getCardSuit(Object d) {
        ArrayList suit= (ArrayList) d;
        String sSuit = suit.get(1).toString();  
        return sSuit;
   }    
           
}
     

     
