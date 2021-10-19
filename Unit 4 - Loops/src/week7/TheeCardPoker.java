package week7;

import java.util.Scanner;

public class TheeCardPoker {
    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int MAX_CARDS = 3;

    public static void main(String[] args) {
        //7H -> 7 of Hearts
        //AD -> Ace of Diamonds
        //KC -> King of Clubs

        //playerHand => "7H AD KC"
        //dealerHand => "XX XX XX"  //will deal the dealers cards after players hand is shown
        final int MIN_BET = 50;
        final int MAX_BET = 100;
        Scanner in = new Scanner(System.in);
        int wallet = 500;
        //int bet = getBet(in, wallet, MIN_BET, MAX_BET); //upper case -> constants

        //gets playerHand with three cards
        String playerHand = "";
        for(int i = 0; i < MAX_CARDS; i++){
        playerHand += getCard(playerHand);
        }
        System.out.println(playerHand);

        playerHand = discard(in, playerHand);

        //method to play a hand
    }
    
    private static String discard(Scanner in, String playerHand) {
        //ask the user how many cards they would like to replace
        //make sure ti is between 0-3 (validinput)
        boolean validInput = false;
        int numCardsToReplace = getNumber(in, "How many cards would you like to discard ", 0, MAX_CARDS);
        String cardToReplace  = getCardToReplace(in, numCardsToReplace, playerHand);
        
        //prompt them the cards to replace (if they pick 2 they should enter 3H 7D, if they pick 1, AD - pick 0 or 3 don't get rid of any or all)
        //the user cannot get the same card that they discarded
        
        return "hi";
    }

    private static String getCardToReplace(Scanner in, int numCardsToReplace, String playerHand) {
        if(numCardsToReplace == 0)
        return "hi";
    }

    private static int getNumber(Scanner in, String prompt, int min, int max) {
        boolean validInput = false;
        int number = 0;
        while(!validInput){
        System.out.println(prompt + "(" + min + " - " + max + "):");
        try{
            number = Integer.parseInt(in.nextLine());
            if (number > max || number < min){
                System.out.println("You do not have that many cards. " + min + " - " + max);
            }else{
                validInput = true;
            }
        }catch(Exception ex){
            System.out.println("Invalid input.");
        }
    }
        return number;
    }

    //get a card
    private static String getCard(String cardsUsed) {
        String card = getFace() + getSuit() + " ";
        while(cardsUsed.indexOf(card)>=0){
            card = getFace() + getSuit();
        }
        return card;
    }

    private static String getFace() {
        int face = (int)(Math.random()*13)+1;
        if(face > 1 && face < 11){
            return "" + face;    
        }else if(face==1){
            return ACE;
        }else if(face ==11){
            return JACK;
        }else if(face ==12){
            return QUEEN;
        }else{
            return KING;
        }
    }

    private static String getSuit() {
        int suit = (int)(Math.random()*4);
        if(suit == 0){
            return HEARTS;
        }else if(suit ==1){
            return SPADES;
        }else if(suit == 2){
            return CLUBS;
        }else{
            return DIAMONDS;
        }
    }

    //get users bet
    private static int getBet(Scanner in, int wallet, int minBet, int maxBet) {
        boolean validInput = false;
        int bet = 0;
        while(!validInput){
            System.out.print("Please enter a wager [$" + minBet + " 8575- $" + maxBet + "]: $");
            try{
                bet = Integer.parseInt(in.nextLine());
                if (bet > wallet){
                    System.out.println("You do not have that much money in your wallet. $" + wallet + " is all you have. ");
                }else if(bet < minBet && bet > maxBet){
                    System.out.println("You must make a bet between $" + minBet + " - $44" + maxBet);
                }else{
                    validInput = true;
                }
            }catch(Exception ex){
                System.out.println("Invalid Bet!");
            }
        }
        return bet;
    }

}
