package week7;

import java.util.Scanner;

public class CrazyEights {

    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";

    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    private static final int MAX_CARDS = 5;

    //play eight

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playerHand = "";
        String player1Hand = "";
        String player2Hand = "";

        //user's cards
        for(int i = 0; i < MAX_CARDS; i++){
            playerHand += getCard(playerHand);   
        }
        //get player1 cards
        for(int i = 0; i < MAX_CARDS; i++){
            player1Hand += getCard(playerHand + player1Hand);
        }
        //get player2 cards
        for(int i = 0; i < MAX_CARDS; i++){
            player2Hand += getCard(playerHand + player1Hand + player2Hand);
        }

        //dealt cards
        System.out.println("Player Hand: " + playerHand);
        System.out.println("Computer1 Hand: XX XX XX XX XX " + player1Hand);
        System.out.println("Computer2 Hand: XX XX XX XX XX " + player2Hand);
        String topPileCard = pileCards(playerHand + player1Hand + player2Hand);
        System.out.println("Pile: " + topPileCard);

        String usedCards = playerHand + player1Hand + player2Hand + topPileCard;

        int p = 0;
        int c1 = 0;
        int c2 = 0;
        String result = "";

        while(!gameOver(p, c1, c2)){
            result = playCard(in, playerHand, player1Hand, player2Hand, topPileCard, usedCards);
            p += Integer.parseInt(result.substring(0, result.indexOf("-")));
            c1 += Integer.parseInt(result.substring(result.indexOf("-") + 1, result.indexOf("-", 3)));
            c2 += Integer.parseInt(result.substring(result.indexOf("-", 3)+1));
        }

        in.close();
    }

    private static boolean gameOver(int p, int c1, int c2) {
        if(p>100){
            System.out.println("Player loses!");
            return true;
        }else if(c1>100){
            System.out.println("Computer1 loses!");
            return true;
        }else if(c2>100){
            System.out.println("Computer2 loses!");
            return true;
        }else{
            return false;
        }
    }

    private static String playCard(Scanner in, String playerHand, String player1Hand, String player2Hand, String topPileCard, String usedCards) {
        userPlayCard(in, playerHand, topPileCard, usedCards);
        //playerPlayCard(player1Hand, topPileCard, usedCards);
        //playerPlayCard(player2Hand, topPileCard, usedCards);
        return "2-31-21";
    }

    private static void playerComputerCard(String playerHand, String topPileCard, String usedCards) {
        for(int i = 0; i < playerHand.length(); i++){
            String currCard = playerHand.substring(i, playerHand.indexOf(" ")); //loops through each card
            //starting at i, until indexOf space
            boolean canPlay = canPlay(playerHand, topPileCard);
            if(canPlay){
                //play a card from computer player's hand
            }else{
                playerHand += getCard(usedCards);
                canPlay(playerHand, topPileCard);
                //check is can play
            }
        }
    }

    private static boolean canPlay(String playerHand, String topPileCard) {
        String currRank = "";
        String currSuit = "";
        String pileRank = "";
        String pileSuit = "";
        System.out.println(playerHand);
        System.out.println(topPileCard);

        String topCard = topPileCard.substring(0, topPileCard.indexOf(" "));
        if(topCard.length()==3){
            pileRank = topCard.substring(0, 0+2);
            pileSuit = topCard.substring(0+2, 0+3);
        }else{
            pileRank = topCard.substring(0, 0+1);
            pileSuit = topCard.substring(0+1, 0+2); 
        }

        for(int i = 0; i < playerHand.length(); i+=3){
            String currCard = " ";
            if((playerHand.substring(i, playerHand.indexOf(" ") + i)).length() == 3){
                currCard = playerHand.substring(i, playerHand.indexOf(" ") + i + 1);
            }else{
                currCard = playerHand.substring(i, playerHand.indexOf(" ") + i);
            }
            
            if(currCard.length() == 3){
                currRank = playerHand.substring(i, i+2);
                currSuit = playerHand.substring(i+2, i+3);
                i++;
            }else{
                currRank = playerHand.substring(i, i+1);
                currSuit = playerHand.substring(i+1, i+2);
            }

            if(currSuit.equals(pileSuit)){
                System.out.println(true);
                return true;
            }else if(currRank.equals(pileRank)){
                System.out.println(true);
                return true;
            }
        }
        System.out.println(false);
        return false;
    }

    private static boolean pickUp(Scanner in) {
        boolean validInput = false;
        while(!validInput){
            System.out.println("What would you like to do? ([P]ick Up or [P]lay)");
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

    private static String userPlayCard(Scanner in, String playerHand, String topPileCard, String usedCards) {
        //can the user play?
        
        while(canPlay(playerHand, topPileCard)){
        boolean validInput = false;
        String card= "";
        while(!validInput){
        System.out.print("Please enter the card you want to play (ex. 7D): ");
        try{
        card = in.nextLine();
            if (playerHand.indexOf(card)<=0){
                System.out.println("You do not have that card.");
            }else{
                validInput = true;
            }
        }catch(Exception ex){
            System.out.println("Invalid input.");
        }
        playerHand += discard(in, playerHand, card);
        }
    }
        return playerHand;
    }

    private static String discard(Scanner in, String playerHand, String card) {
        //ask the user how many cards they would like to replace
        //make sure it is between 0-3 (validinput)
        
        String temp = playerHand;
         int space = card.indexOf(" ");
         String card1 = "";
         if (space == -1)
            card1 = card;
         else{
            card1 = card.substring(0, space);

         String card2 = getCard(playerHand + temp);
         playerHand = playerHand.replace(card1, card2);
         }      
      return playerHand;
        //prompt them the cards to replace (if they pick 2 they should enter 3H 7D, if they pick 1, AD - pick 0 or 3 don't get rid of any or all)
        //the user cannot get the same card that they discarded

    }

    /*private static String getCardsToDiscard(Scanner in, String playerHand) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
      boolean validInput = false;
      String cards = "";
      while (!validInput) {
         System.out.println("Please enter the card to replace: (ex. 7H): ");
         cards = in.nextLine().toUpperCase(); //returns card that the user would like to discard
         //check to make sure that the discardCard is in playerHand
         //
         if (playerHand.indexOf(cards) < 0)
            System.out.println("You don't have a " + cards);
         else if (playerHand.indexOf(cards) >= 0)
            validInput = true;
      }
      return cards;

    }*/

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

    private static String pileCards(String cardsUsed) {
        String card = getFace() + getSuit() + " ";
        int count = 0;
        while(card.indexOf("8")>=0 && count == 0){
            card = getFace() + getSuit() + " ";
            count++;
    }
        while(cardsUsed.indexOf(card)>=0){
            card = getFace() + getSuit() + " ";
        }
        return card;
    }

    private static String getCard(String cardsUsed) {
        String card = getFace() + getSuit() + " ";
        while(cardsUsed.indexOf(card)>=0){
            card = getFace() + getSuit() + " ";
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
}
