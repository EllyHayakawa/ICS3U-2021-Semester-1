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
    private static final int PLAYER_WINS = 1;
    private static final int DEALER_WINS = 2;
    private static final int TIE = 3;

    private static final int HIGH_CARD = 1;
    private static final int PAIR = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int STRAIGHT = 4;
    private static final int FLUSH = 5;
    private static final int STRAIGHT_FLUSH = 6;


    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
        while(!validInput){
            System.out.println("Do you want to play again? ([Y]es or [N]o)");
            String answer = in.nextLine().toUpperCase();
            if(answer.equals("YES")||answer.equals("Y")){
                return true;
            }else if(answer.equals("NO") || answer.equals("N")){
                return false;
            }else{
                System.out.println("Invalid Input: Yes or No only!");
            }
        }
        return false;
    }

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
        boolean playAgain = true;
        
        while(playAgain){
            wallet = playPokerHand(in, wallet, MIN_BET, MAX_BET); //play a hand
            if(wallet > MIN_BET * 2){ //playAgain while player has enough money to bet twice (i.e. $100)
                playAgain = playAgain(in);
            }else{
                System.out.println("You don't have enough money to play again!");
            }
        }
        
    }
    
    //method to play a hand
    private static int playPokerHand(Scanner in, int wallet, int MIN_BET, int MAX_BET) {
        //make the bet
        int bet = getBet(in, wallet, MIN_BET, MAX_BET); //upper case -> constants

        String playerHand = "";
        String dealerHand = "";

        //gets playerHand with three cards
        for(int i = 0; i < MAX_CARDS; i++){
            playerHand += getCard(playerHand);
        }
        String temp = playerHand;
        //get dealer
        for(int i = 0; i < MAX_CARDS; i++){
            playerHand += getCard(playerHand+dealerHand);
        }

        System.out.println("Player: " + temp);
        System.out.println("Dealer: " + "XX XX XX");
        //ask if the player wants to fold, otherwise make them make a bet
        if(!fold(in)){
            bet += getBet(in, wallet, MIN_BET, MAX_BET);
            playerHand = discard(in, temp);
            System.out.println(playerHand);
        }else{
            System.out.println("Player folds. ");
            wallet -= bet;
            return wallet;
        }

        if(compareHands(playerHand, dealerHand) == PLAYER_WINS){
            System.out.println("Player Wins!");
            wallet += bet;
        }else if(compareHands(playerHand, dealerHand) == DEALER_WINS){
            System.out.println("Dealer Wins!");
            wallet -= bet;
        }else{
            System.out.println("Tie");
        }

        return wallet;
    }

    private static int compareHands(String playerHand, String dealerHand) {
        if(getHand(playerHand) > getHand(dealerHand)){ //getHand will return the number value of sets
            return PLAYER_WINS;
        }else if(getHand(playerHand) < getHand(dealerHand)){
            return DEALER_WINS;
        }else{
            //check high card
            if(getHighCard(playerHand) > getHighCard(dealerHand)){
                return PLAYER_WINS;
            }else if(getHighCard(playerHand) < getHighCard(dealerHand)){
                return DEALER_WINS;
            }else{
                return TIE;
            }
        }
    }

    private static int getHand(String cards) {
        if(isFlush(cards) && isStraight(cards)){
            return STRAIGHT_FLUSH;
        }else if(isFlush(cards)){
            return FLUSH;
        }else if(isStraight(cards)){
            return STRAIGHT;
        }else if(isThreeOfAKind(cards)){
            return THREE_OF_A_KIND;
        }else if(isPair(cards)){
            return PAIR;
        }else{
            return HIGH_CARD;
        }
    }

    private static boolean isPair(String cards) {
        //9D QS 9H
        String card1 = cards.substring(0, 2);
        String card2 = cards.substring(3, 5);
        String card3 = cards.substring(6);
        if(card1.equals(card2) || card2.equals(card3) || card3.equals(card1)){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isThreeOfAKind(String cards) {
        String card1 = cards.substring(0, 2);
        String card2 = cards.substring(3, 5);
        String card3 = cards.substring(6);
        if(card1.equals(card2) && card2.equals(card3)){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isStraight(String cards) {
        //consecutive numbers
        //convert A, J, Q, K to int
        //rearrange cards in order of smallest to greatest
        //if the cards are consecutive return true
        String straight = "A 2 3 4 5 6 7 8 9 10 J Q K ppA";
        String num1 = cards.substring(0, 1);
        String num2 = cards.substring(3, 4);
        String num3 = cards.substring(6, 7);
        int J = 11;
        int Q = 12;
        int K = 13;
        int lA = 1;
        int hA = 14;

        
        return false;
    }

    private static boolean isFlush(String cards) {
        //same suit
        String suit1 = cards.substring(1, 2);
        String suit2 = cards.substring(4, 5);
        String suit3 = cards.substring(7);
        if(suit1.equals(suit2) && suit2.equals(suit3)){
            return true;
        }else{
            return false;
        }
    }

    private static int getHighCard(String cards) {
        return 0;
    }

    private static boolean fold(Scanner in) {
        boolean validInput = false;
        while(!validInput){
            System.out.println("What would you like to do? ([F]old or [D]iscard)");
            String answer = in.nextLine().toUpperCase();
            if(answer.equals("FOLD")||answer.equals("F")){
                return true;
            }else if(answer.equals("DISCARD") || answer.equals("D")){
                return false;
            }else{
                System.out.println("Invalid Input: Fold or Discard only!");
            }
        }
        return false;
    }

    private static String discard(Scanner in, String playerHand) {
        //ask the user how many cards they would like to replace
        //make sure it is between 0-3 (validinput)
        int numCardsToReplace = getNumber(in, "How many cards would you like to discard: ", 0, 3);
      String temp = playerHand;
      if (numCardsToReplace == 0)
         return playerHand;
      else if (numCardsToReplace == 3) {
         playerHand = getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
      } else {
         String cardToReplace = getCardsToDiscard(in, numCardsToReplace, playerHand);
         int space = cardToReplace.indexOf(" ");
         String card1 = "";
         if (space == -1)
            card1 = cardToReplace;
         else
            card1 = cardToReplace.substring(0, space);

         String card = getCard(playerHand + temp);
         playerHand = playerHand.replace(card1, card);
         if (numCardsToReplace == 2) {
            String card2 = cardToReplace.substring(space + 1);
            card = getCard(playerHand + cardToReplace + temp);
            playerHand = playerHand.replace(card2, card);
         }
      }
      return playerHand;

        //prompt them the cards to replace (if they pick 2 they should enter 3H 7D, if they pick 1, AD - pick 0 or 3 don't get rid of any or all)
        //the user cannot get the same card that they discarded

    }

    private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
      boolean validInput = false;
      String cards = "";
      while (!validInput) {
         System.out.println("Please enter the cards to replace: (ex. 7H KD): ");
         cards = in.nextLine().toUpperCase();
         if (countOccurences(cards, " ") != numCardsToReplace - 1) {
            System.out.println("You must choose " + numCardsToReplace + " cards.");
         } else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) < 0))
            System.out.println("You don't have a " + cards);
         else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) >= 0))
            validInput = true;
         else if (numCardsToReplace == 2) {
            int space = cards.indexOf(" ");

            String card1 = cards.substring(0, space);
            String card2 = cards.substring(space + 1);
            if (VALID_CARDS.indexOf(card1) < 0)
               System.out.println("Not a valid card: " + card1);
            else if (VALID_CARDS.indexOf(card2) < 0)
               System.out.println("Not a valid card: " + card2);
            else if (playerHand.indexOf(card1) < 0)
               System.out.println("You don't have a " + card1);
            else if (playerHand.indexOf(card2) < 0)
               System.out.println("You don't have a " + card2);
            else if (playerHand.equals(card2))
               System.out.println("You cannot discard the same card.");
            else
               validInput = true;
         }

      }

      return cards;

    }


    private static int countOccurences(String str, String str2) {
        int count = 0;
        if(str2.length()>str.length()){
            return 0;
        }else{
        for(int i = 0; i < str.length(); i++){
            String substr = str.substring(i, i + str2.length());
            if(str2.equals(substr)){
                count++;
            }
        }
    }
        return count;
    }

    private static int getNumber(Scanner in, String prompt, int min, int max) {
        boolean validInput = false;
        int number = 0;
        while(!validInput){
        System.out.print(prompt + "(" + min + " - " + max + "):");
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
            System.out.print("Please enter a wager [$" + minBet + " - $" + maxBet + "]: $");
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
