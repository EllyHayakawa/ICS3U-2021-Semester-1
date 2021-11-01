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
    private static String topCard = "0";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playerHand = "";
        String computer1Hand = "";
        String computer2Hand = "";

        int p = 0;
        int c1 = 0;
        int c2 = 0;
        String result = "";

        System.out.println();
        System.out.println("Let's Play Crazy 8s!");

        while(!gameOver(p, c1, c2)){

            for(int i = 0; i < MAX_CARDS; i++){
                playerHand += getCard();   
            }
            //get player1 cards
            for(int i = 0; i < MAX_CARDS; i++){
                computer1Hand += getCard();
            }
            //get player2 cards
            for(int i = 0; i < MAX_CARDS; i++){
                computer2Hand += getCard();
            }
    
            //GAME SETUP
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Computer1 Hand: XX XX XX XX XX ");
            System.out.println("Computer2 Hand: XX XX XX XX XX ");
            String topPileCard = pileCards(playerHand + computer1Hand + computer2Hand);
            topCard = setTopCard(topPileCard);
            System.out.println("Pile: " + topCard);
 
            System.out.println();
            result = playRound(in, playerHand, computer1Hand, computer2Hand);
            p += Integer.parseInt(result.substring(0, result.indexOf("-")));
            c1 += Integer.parseInt(result.substring(result.indexOf("-") + 1, result.indexOf("-", 3)));
            c2 += Integer.parseInt(result.substring(result.indexOf("-", 3)+1));
            System.out.println("Player points: " + p);
            System.out.println("Computer1 points: " + c1);
            System.out.println("Computer2 points: " + c2);
            System.out.println();
            System.out.println("______________________________________");
            System.out.println();

            if(!gameOver(p, c1, c2)){
            System.out.println("Let's Play Again");
            }

            playerHand = "";
            computer1Hand = "";
            computer2Hand = "";
        }

        getWinner(p, c1, c2);
        System.out.println();

        in.close();
    }

    /**
     * Method that calls the playTurn method in which a round takes place
     * @param in
     * @param playerHand
     * @param computer1Hand
     * @param computer2Hand
     * @return - String of point results from that round in the format "p-c1-c2"
     */
    private static String playRound(Scanner in, String playerHand, String computer1Hand, String computer2Hand) {
        String result = playTurn(in, playerHand, computer1Hand, computer2Hand);
        return result;
    }

    /**
     * Method that checks to seeif any player's points exceed 100 in which case the game is over
     * @param p
     * @param c1
     * @param c2
     * @return - boolean value (whether the game is over or not)
     */
    private static boolean gameOver(int p, int c1, int c2) {
        if(p>100){
            return true;
        }else if(c1>100){
            return true;
        }else if(c2>100){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method that allows each player to play their turns
     * @param in
     * @param playerHand
     * @param computer1Hand
     * @param computer2Hand
     * @return
     */
    private static String playTurn(Scanner in, String playerHand, String computer1Hand, String computer2Hand) {
        String computer1 = computer1Hand;
        String computer2 = computer2Hand;
        String player = playerHand;
        String result = "";
        topCard = setTopCard(topCard);

        while(player.length()>0 && computer1.length()>0 && computer2.length()>0){
        player = (userPlayCard(in, player)); 
        System.out.println();
        System.out.println("PlayerHand: " + player);
        if(player.length()>0){
            computer1 = computerPlayCard(computer1, player, computer2);
            System.out.println("Computer1 Hand: " + displayX(computer1));
            if(computer1.length()>0){
                computer2 = computerPlayCard(computer2, player, computer1);
                System.out.println("Computer2 Hand: " + displayX(computer2));
            }
        }
        System.out.println();
        System.out.println("Pile: " + setTopCard(topCard));
        System.out.println();
    }
        int pp = getPoints(player);
        int c1p = getPoints(computer1);
        int c2p = getPoints(computer2);
        getWinnerRound(pp, c1p, c2p);
        result = pp + "-" + c1p + "-" + c2p;        
        return result;
    }

    /**
     * Method that displays Xs to represent the computer's cards
     * @param computer1
     * @return
     */
    private static String displayX(String computer1) {
        String result = "";
        for(int i = 0; i < computer1.length(); i++){
            String curr = computer1.substring(i, i+1);
            if(curr.equals(" ")){
                result += "XX ";
            }
        }
        return result;
    }

    /**
     * Method that gets the winner of each round
     * @param pp
     * @param c1p
     * @param c2p
     */
    private static void getWinnerRound(int pp, int c1p, int c2p) {
        if(pp<c1p && pp<c2p){
            System.out.println("Player WINS THIS ROUND!");
        }else if(c1p<pp && c1p<c2p){
            System.out.println("Computer1 WINS THIS ROUND");
        }else if(c2p<pp && c2p<c1p){
            System.out.println("Computer2 WINS THIS ROUND");
        }else{
            System.out.println("TIE");
        }
    }

    /**
     * Method that checks to see who has the least points in which case that player is the winner
     * @param pp
     * @param c1p
     * @param c2p
     */
    private static void getWinner(int pp, int c1p, int c2p) {
        if(pp<c1p && pp<c2p){
            System.out.println("Player WINS!");
        }else if(c1p<pp && c1p<c2p){
            System.out.println("Computer1 WINS");
        }else if(c2p<pp && c2p<c1p){
            System.out.println("Computer2 WINS");
        }else{
            System.out.println("TIE");
        }
    }

    /**
     * Method that adds up the points a player gets in that round
     * @param hand
     * @return
     */
    private static int getPoints(String hand) {
        int points = 0;
        if(hand.length()==0){
            return 0;
        }
        for(int i = 0; i<hand.length()-1; i+=3){
            String currRank = "";
            String currCard = " ";
            int space = (hand.substring(i)).indexOf(" ");
            if(space == 0){
                i++;
                space = (hand.substring(i)).indexOf(" ");
            }

            currCard = hand.substring(i, space + i);
            currRank = (cardRank(currCard));
            if(currRank.equals("A")){
                points += 1;
            }else if(currRank.equals("10") || currRank.equals("J") || currRank.equals("Q") || currRank.equals("K")){
                points += 10;
            }else if(currRank.equals("8")){
                points += 50;
            }else if(((Integer.parseInt(currRank))>=2 && (Integer.parseInt(currRank))<=7)||(Integer.parseInt(currRank))==9){
                int rank = Integer.parseInt(currRank);
                points += rank;
            }
        }
        return points;
    }

    /**
     * Method that updates and gets the top pile card
     * @param newTopCard
     * @return
     */
    private static String setTopCard(String newTopCard){
        String topCard = newTopCard;
        if(topCard.indexOf(" ")<0){
            return topCard + " ";
        }else{
            return topCard;
        }
    }

    /**
     * Method that processes the computer's play
     * @param computerHand
     * @param playerHand
     * @param otherCHand
     * @return - new String of computer's hand (after they play or pick up cards)
     */
    private static String computerPlayCard(String computerHand, String playerHand, String otherCHand) {
        topCard = setTopCard(topCard);
        if(canPlay(computerHand)){
                computerHand = cPlay(computerHand, playerHand, otherCHand);
                    return computerHand;

        }else{
            computerHand = pickUp(computerHand);
            if(canPlay(computerHand)){
                computerHand = cPlay(computerHand, playerHand, otherCHand);
                return computerHand;
            }else{
                return computerHand;
            }
        }
    }

    /**
     * Method that plays a card from the computer's hand 
     * @param computerHand
     * @param playerHand
     * @param otherCHand
     * @return - new String of computer's hand (after they play a card)
     */
    private static String cPlay(String computerHand, String playerHand, String otherCHand) {
        String currRank = "";
        String currSuit = "";
        topCard = setTopCard(topCard);
        String topPileCard = topCard.substring(0, topCard.indexOf(" "));
        String pileRank = cardRank(topPileCard);
        String pileSuit = cardSuit(topPileCard);

        //code so that 8 is NOT played first just because it is at the front of the pile
    
        for(int i = 0; i < computerHand.length(); i+=3){
            String currCard = " ";   
            int space = (computerHand.substring(i)).indexOf(" ");
            if(space == 0){
                i++;
                space = (computerHand.substring(i)).indexOf(" ");
            }
            currCard = computerHand.substring(i, space + i);
            currRank = cardRank(currCard);
            currSuit = cardSuit(currCard);
                         
            if(playerHand.indexOf(" ")<2 || otherCHand.indexOf(" ")<2){
                if(currSuit.equals(pileSuit)){
                    computerHand = discard(computerHand, currCard);
                    return computerHand;
                }else if(currRank.equals("8")){
                    if(!(currSuit.equals(pileSuit))){
                        computerHand = discard(computerHand, currCard);
                        topCard = setTopCard("8" + pileSuit);
                        return computerHand;
                    }  
                }
            }else if(currRank.equals("8") && !(currSuit.equals(pileSuit))){
                    computerHand = discard(computerHand, currCard);
                    pileSuit = getPileSuit(computerHand, currCard);
                    topCard = setTopCard("8" + pileSuit);
                    return computerHand;
            }else if(currRank.equals(pileRank)){
                computerHand = discard(computerHand, currCard);
                topCard = setTopCard(currCard);
                return computerHand;
            }else if(currSuit.equals(pileSuit)){
                computerHand = discard(computerHand, currCard);
                topCard = setTopCard(currCard);
                return computerHand;
            }
        }
        return computerHand;
    }

    /**
     * Method that returns the suit of the first card in computerHand
     * @param computerHand
     * @param currCard
     * @return 
     */
    private static String getPileSuit(String computerHand, String currCard) {
        String fCard = computerHand.substring(0, computerHand.indexOf(" "));
        String suit = cardSuit(fCard);
        return suit;
    }

    /**
     * Method that checks if the player can play (i.e. if any suit or rank matches that of the pile's suit or rank, or if the player has an 8)
     * @param playerHand
     * @return
     */
    private static boolean canPlay(String playerHand) {
        String currRank = "";
        String currSuit = "";
        topCard = setTopCard(topCard);
        String topPileCard = topCard.substring(0, topCard.indexOf(" "));
        String pileRank = cardRank(topPileCard);
        String pileSuit = cardSuit(topPileCard);
    
        for(int i = 0; i < playerHand.length(); i+=3){
            String currCard = " ";
            int space = (playerHand.substring(i)).indexOf(" ");
            if(playerHand.substring(i).equals(" ")){
                space = (playerHand.substring(i+1).indexOf(" "));
            }
            if(space<0){
                if(playerHand.length()==2)
                    space = 2;
                else
                    space = 3;
            playerHand += " ";
            }
            currCard = playerHand.substring(i, space + i);

            if(currCard.length()<2){
                return false;
            }
            if(currCard.length()==3){
                i++;
            }

            currRank = cardRank(currCard);
            currSuit = cardSuit(currCard);

            if(currRank.equals("8"))
                return true;
            if(currSuit.equals(pileSuit)){
                return true;
            }else if(currRank.equals(pileRank)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns the rank of the given card (parameter card)
     * @param card
     * @return
     */
    private static String cardRank(String card) {
        String rank = "";
        if(card.length()==3){
            rank = card.substring(0, 0+2);
        }else{
            rank = card.substring(0, 0+1);
        }
        return rank;
    }

    /**
     * Method that returns the suit of the given card (parameter card)
     * @param card
     * @return
     */
    private static String cardSuit(String card) {
        String pileSuit = "";
        if(card.length()==3){
            pileSuit = card.substring(2, 3);
        }else{
            pileSuit = card.substring(1, 2);
        }
        return pileSuit;
    }

    /**
     * Method for the player/user to play (play a card or pick up cards)
     * @param in
     * @param playerHand
     * @return
     */
    private static String userPlayCard(Scanner in, String playerHand) {
        String hand = "";
        topCard = setTopCard(topCard);
        if(canPlay(playerHand)){
            hand = uPlay(in, playerHand);
            return hand;
            
        }else{
            System.out.println("You cannot play. You picked up.");
            playerHand = pickUp(playerHand);
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Pile: " + setTopCard(topCard));
            if(canPlay(playerHand)){
                hand = uPlay(in, playerHand);
            }
            return hand;
        }
    }

    /**
     * Method that checks to see if what the user wants to play is valid
     * @param in
     * @param playerHand
     * @return
     */
    private static String uPlay(Scanner in, String playerHand) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
        boolean validInput = false;
        boolean valid = false;
        topCard = setTopCard(topCard);
            String card= "";
            String suit = "";
            while(!validInput){
            System.out.print("Please enter the card you want to play (ex. 7D): ");
                try{
                card = in.nextLine().toUpperCase();
                boolean cP = canPlay(card);
                if (VALID_CARDS.indexOf(card) < 0){
                    System.out.println("Not a valid card: " + card);
                }else if (playerHand.indexOf(card)<0){
                    System.out.println("You do not have that card.");
                }else if(!cP){
                    System.out.println("You cannot play that card. ");
                }else{
                    while(!valid){
                        if(card.indexOf("8")>=0){
                        System.out.print("Pick the suit to change to ([H]earts, [D]amonds, [S]pades, [C]lubs): ");
                        suit = in.nextLine().toUpperCase();
                        if(suit.equals("H")||suit.equals("HEARTS")||suit.equals("HEART")){
                            playerHand = discard(playerHand, card);
                            card = ("8H");
                            validInput = true;
                            valid = true;
                        }else if(suit.equals("D")||suit.equals("DIAMONDS")||suit.equals("DIAMOND")){
                            playerHand = discard(playerHand, card);
                            card = ("8D");
                            validInput = true;
                            valid = true;
                        }else if(suit.equals("S")||suit.equals("SPADES")||suit.equals("SPADE")){
                            playerHand = discard(playerHand, card);
                            card = ("8S");
                            validInput = true;
                            valid = true;
                        }else if(suit.equals("C")||suit.equals("CLUBS")||suit.equals("CLUB")){
                            playerHand = discard(playerHand, card);
                            card = ("8C");
                            validInput = true;
                            valid = true;
                        }else{
                            System.out.println("Invalid Input!");
                        }
                    }else{
                        playerHand = discard(playerHand, card);
                        validInput = true;
                        valid = true;
                    }
                   }
                 }
                }catch(Exception ex){
                System.out.println("Invalid input.");
                }
            }
            //System.out.println();
            topCard = setTopCard(card);
            return playerHand;
    }

    /**
     * Method that adds cards to player's hands when they pick up cards
     * @param playerHand
     * @return
     */
    private static String pickUp(String playerHand) {
        int count = 0;
        while(!canPlay(playerHand) && count < 5){
            playerHand += getCard();;
            count++;
        }
        return playerHand;
    }

    /**
     * Method that removes/discards the card that the player plays from their hand onto the pile
     * @param playerHand
     * @param card
     * @return
     */
    private static String discard(String playerHand, String card) {
        if(playerHand.indexOf(card) ==0 && card.length() == 3){
            playerHand = playerHand.substring(playerHand.indexOf(" ")+1);
        }else if(card.length()==3){
            playerHand = playerHand.substring(0, playerHand.indexOf(card)-1) + playerHand.substring(playerHand.indexOf(card)+3);
        }else if(playerHand.indexOf(card) ==0){
            playerHand = playerHand.substring(playerHand.indexOf(" ")+1);
        }else{
            playerHand = playerHand.substring(0, playerHand.indexOf(card)-1) + playerHand.substring(playerHand.indexOf(card)+2);
        }
        return playerHand;
    }

    /**
     * Method that generates the first pile card (cannot be an 8)
     * @param cardsUsed
     * @return
     */
    private static String pileCards(String cardsUsed) {
        String card = getFace() + getSuit() + " ";
        while(card.indexOf("8")>=0){
            card = getFace() + getSuit() + " ";
        }
        return card;
    }

    /**
     * Method that returns a card in the format "FaceRank "
     * @return
     */
    private static String getCard() {
        return getFace() + getSuit() + " ";
    }

    /**
     * Method that returns the rank/face value of a card
     * @return
     */
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

    /**
     * Method that returns the suit of a card
     * @return
     */
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
