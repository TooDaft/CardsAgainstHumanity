package cah.myapplication.app;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * This class defines all of the methods and fields to be used by the activity screens to handle game play.
 */

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class Game{

    public static LinkedList<WhiteCard> whiteDeck;
    public static LinkedList<BlackCard> blackDeck;
    public static ArrayList<Player> players;
    public static int numPlayers;
    public static Scanner sc;
    public static File cleanBlack = new File("CleanBlack.txt");
    public static File cleanWhite = new File("CleanWhite.txt");
    public static File dirtyBlack = new File("DirtyBlack.txt");
    public static File dirtyWhite = new File("DirtyWhite.txt");
    public static Boolean isDirty;
    public static ArrayList<String> howToPlayList;
    public static BlackCard currentBlackCard;
    public static ArrayList<ArrayList<WhiteCard>> submittedCards;   //two dimensional ArrayList for cases when multiple white cards are submitted
    public static int maxAwesomePoints;
    public static int cardCzar;
    public static int winningPlayer;

    /**
     * Reads input; checks if the user is playing the
     * clean or dirty game, and then reads from the
     * appropriate deck
     * @throws FileNotFoundException
     */
    public static void readInput() throws FileNotFoundException {

        blackDeck = new LinkedList<BlackCard>();
        whiteDeck = new LinkedList<WhiteCard>();

        if(isDirty) {
            sc = new Scanner(dirtyBlack);
        }

        else {
            sc = new Scanner(cleanBlack);
        }

        while(sc.hasNext()){
            blackDeck.add(new BlackCard(sc.nextInt(), sc.nextLine()));
        }

        if(isDirty) {
            sc = new Scanner(dirtyWhite);
        }

        else {
            sc = new Scanner(cleanWhite);
        }

        while(sc.hasNext()){
            whiteDeck.add(new WhiteCard(sc.nextLine()));
        }

        Collections.shuffle(whiteDeck);
        Collections.shuffle(blackDeck);
    }

    /**
     * Method to create the list of players
     * Deals the white cards
     * Sets the first player in the list to be Card Czar
     */
    public static void createPlayers(){

        players = new ArrayList<Player>();

        for(int i = 0; i < numPlayers; i++){
            Player temp = new Player(i);
            for(int j = 0; j < 10; j++){
                temp.addPlayerCard(whiteDeck.removeFirst());
                temp.getPlayerCards().get(j).setOwner(j);
            }

            players.add(temp);
            //players.get(0).toggleIsCardCzar();
            cardCzar = 0;
        }
    }

    /**
     * Method to alternate the role of card czar.
     * To be called at the end of each round.
     */
    public static void switchCardCzar(){

        //players.get(cardCzar).toggleIsCardCzar();
        //if we are keeping track of the Card Czar with the int, we really don't need to have a field for it within the player class
        if(cardCzar < numPlayers - 1) {
            cardCzar++;
        }

        else{
            cardCzar = 0;
        }

        //players.get(cardCzar).toggleIsCardCzar();
    }

    /**
     * Method to set the current black card;
     * to be called at the beginning of each round
     */
    public static void setCurrentBlackCard(){

        currentBlackCard = blackDeck.removeFirst();

    }

    /**
     * Increments the awesome points of the owner of the argument WhiteCard
     * To be called when the Card Czar selects a round winning card.
     * The selected card to be used as the parameter
     * @param cd
     */
    public static void selectWhiteCard(ArrayList<WhiteCard> cd){

        players.get(cd.get(0).getOwner()).incAwesomePoints();

    }

    /**
     * Method to check if the target number of Awesome points has been reached.
     * If this target has been reached, return true; otherwise, return false.
     * This will be used to check if the game is over.
     * @return
     */
    public static Boolean checkAwesomePoint(){

        for(int i = 0; i < numPlayers; i++){
            if(players.get(i).getNumAwesomePoints() == maxAwesomePoints){
                winningPlayer = i;
                return true;
            }
        }

        return false;
    }
}
