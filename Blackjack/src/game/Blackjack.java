package game;
//special message for blackjak
//correct grammar
//error when bet isnt a number
//other Ai
import java.util.*;
public class Blackjack {
public static void main(String[]args){
    int[] money = {250};
    int[] bett= new int[1];
    play(money, bett);
}
public static void play(int[] money, int[] bett) {
        Deck deck = new Deck();
        Collections.shuffle(deck);
        if (money[0] != 0){
        ArrayList <Card> hand = new ArrayList <Card>();
        ArrayList <Card> dealer = new ArrayList <Card>();
        System.out.println("you have $" + money[0]);
        bet(money, bett);
        game(deck, hand, dealer, money, bett);
        replay(money, bett);
    } else {
        System.out.println("You're out of money");
    }
}
public static void deal(Deck deck, List hand, List dealer) {
    hand.set(0, deck.get(0));
    dealer.set(0, deck.get(1));
    hand.set(1, deck.get(2));
    dealer.set(1, deck.get(3));
}
public static void determine(int total, int totald, int[] money, int[]bett){
    boolean win = false;
    if(total > 21){
        System.out.println("You Busted");
        totald = 21;
    } else if(total > totald && total <=21){
        System.out.println("dealer has " + totald +".  You Win!");
        win = true;
      } else if(totald <= 21){
          System.out.println("dealer has " + totald +" . You lose.");
      } else {
          System.out.println("Dealer busted, you win,");
          win = true;
        }
    winnings(money, bett, win);
}
public static void replay(int[] money, int[] bett) {
    Scanner replay = new Scanner(System.in);
    System.out.println("Would you like to play again?");
    String g = replay.next();
    char s = g.charAt(0);
    if (s == 'y'){
        play(money, bett);
    }
}
public static void game(Deck deck, List hand, List dealer, int[] money, int[] bett) {
    deal(deck, hand, dealer);
    String q = "";
    char s = 'h';
    int k = 0;
    int total = 0;
    int totald = 0;
    Scanner console = new Scanner(System.in);
    int n = 0;
    int count = 0;
    int c = 1;
    while(n == 0){
        while(count<21) {
            c++;
            total = 0;
            count = total;
            totald = 0;
            for(int i = 0; i < 52; i++) {
                total += ((Card) hand.get(i)).getNumber();
            }
              for(int i = 0; i < 52; i++) {
            	  /* if(hand.get(i).getNumber() == 11 && total > 21){ //aces**********************************************************************************************************************************
                    hand.get(i) = 1;
                    total = total - 10;
                    q = "";
                  */  for(int p = 0; p < c; i++){
                        q = q + hand.get(p);
                    	
                    }
                }
            } 
              q = "";
              k = 0;
            while(((Card) hand.get(k)).getNumber() != 0) {
                if(((Card) hand.get(k + 1)).getNumber() == 0) {
                	q = q + " and a ";
                } else if(k != 0) {
                	q = q + ", ";
                }
            	if(((Card) hand.get(k)).getNumber() == 11 || ((Card) hand.get(k)).getNumber() == 1) {
        		q = q + "ace";
        	} else {
                q = q + hand.get(k);
        	}
                k++;

            }
            if(total >= 21){
                n = 87346;
                count = 89732456;
            } else {
                System.out.println("You have a "+ q + " for a total of " + total + " would you like to hit or stay");
                String g = console.next();
                g = g + " ";
                s = g.charAt(0);
                if (s == 'h') {
                    hand.get(c)=deck.get(c+1);
                    count++;
                } /* else if(g.charAt(1) == 'p' && hand.get(0) == hand.get(1) && money.get(0) >= bett.get(0)){
                    int[] hand2 = new int.get(52);
                    hand2.get(0) = hand.get(1);
                    hand.get(1)= deck.get(c);
                    c++;
                    hand2.get(1) = deck.get(c);
                    game2(deck, hand2, dealer, money, bett, c);
                    } */else if (s == 's'){
                   n = 387;
                   count = 3345;
                } /*else if(s == 'd' && count == 0 && money.get(0) >= bett.get(0)){ //split and double down******************************************************************************************
                    money.get(0) = money.get(0) - bett.get(0);
                    bett.get(0) = bett.get(0) * 2;
                    hand.get(c)=deck.get(c);
                    total = total + deck.get(c);
                    System.out.println("your bet is now" + bett.get(0));
                    n = 338745;
                    count = 979459;
                }*/
                
            }
        }
        System.out.println("you have " + total);
        int j = 2;
        while (totald < 17){
            dealer .get(j) = deck.get(c);
            totald = 0;
            for(int i = 0; i < 52; i++) {
                totald += dealer.get(i).getNumber();
            }
            for(int i = 0; i < 52; i++) {
             /*   if(hand.get(i).getNumber() == 11 && total > 21){ // dealers ace ****************************************************************************************************************
                    hand.get(i) = 1;
                    total = total - 10;*/
                }
            } 
            j++;
            c++;
            determine(total, totald, money, bett);
        }
        

public static void bet(int[] money, int[]bett){
   if(money.get(0) > 0){
       Scanner bet = new Scanner(System.in);
       System.out.println("How much do you want to bet?");
       bett.get(0) = bet.nextInt();
       money.get(0) = money.get(0) - bett.get(0);
    }
}
public static void winnings(int[] money, int[] bet, boolean win){
    if(win == true){
        money.get(0) += bet.get(0) * 2;
    }
}
public static void game2(Deck deck, List hand2, List dealer, int[] money, int[] bett, int c) {
    deal(deck, hand2, dealer);
    String q = "";
    char s = 'h';
    int k = 0;
    int total = 0;
    int totald = 0;
    Scanner console = new Scanner(System.in);
    int n = 0;
    int count = 0;
    c++;
    while(n == 0){
        while(count<21) {
            c++;
            total = 0;
            count = total;
            totald = 0;
            for(int i = 0; i < 52; i++) {
                total += hand2.get(i).getNumber();
            }
              for(int i = 0; i < 52; i++) {
               /* if(hand2.get(i).getNumber() == 11 && total > 21){ // why is there a third ace thing******************************************************************************************************************
                    hand2.get(i) = 1;
                    total = total - 10;
                    q = ""; */
                    for(int p = 0; p < c; i++){
                        q = q + hand2.get(p);
                    }
                }
            }
            while(hand2.get(k).getNumber() != 0) {
            	if(hand2.get(k + 1).getNumber() == 0) {
                	q = q + " and a ";
                } else if(k != 0) {
                	q = q + ", ";
                }
            	if(hand2.get(k).getNumber() == 11 || hand2.get(k).getNumber() == 1) {
        		q = q + "ace";
        	} else {
                q = q + hand2.get(k);
        	}
                k++;
            }
            if(total >= 21){
                n = 87346;
                count = 89732456;
            } else {
                System.out.println("You have a "+ q + " for a total of " + total + " would you like to hit or stay");
                String g = console.next();
                s = g.charAt(0);
                if (s == 'h') {
                    hand2.get(c)=deck.get(c);
                    count++;
                } 
                if (s == 's'){
                   n = 387;
                   count = 3345;
                }
            }
        }
        System.out.println("you have " + total);
        int j = 2;
        while (totald < 17){
            dealer .get(j) = deck.get(c);
            totald = 0;
            for(int i = 0; i < 52; i++) {
                totald += dealer.get(i).getNumber();
            }
            for(int i = 0; i < 52; i++) {
              /*  if(hand2.get(i) == 11 && total > 21){ //aces again*******************************************************************************************************************************************************
                    hand2.get(i) = 1;
                    total = total - 10;*/
                } 
            }
            j++;
            c++;
            determine2(total, totald, money, bett);
        }


public static void determine2(int total, int totald, int[] money, int[]bett){
boolean win = false;
if(total > 21){
    System.out.println("You Busted");
    totald = 21;
} else if(total > totald && total <=21){
    System.out.println("dealer has " + totald +".  You Win!");
    win = true;
  } else if(totald <= 21){
      System.out.println("dealer has " + totald +" . You lose.");
  } else {
      System.out.println("Dealer busted, you win,");
      win = true;
    }
winnings2(money, bett, win);
}
public static void winnings2(int[] money, int[] bet, boolean win){
if(win == true){
    money.get(0) += bet.get(0);
}
}
}
