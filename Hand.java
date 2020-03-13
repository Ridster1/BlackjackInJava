import java.util.*; 

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
     