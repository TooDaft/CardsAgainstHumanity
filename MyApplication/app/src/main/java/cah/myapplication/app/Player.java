package cah.myapplication.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with fields and methods for each player of the game.
 */

public class Player{

    private Integer playerNum;
    private ArrayList<WhiteCard> playerCards = new ArrayList<WhiteCard>();
    private Integer numAwesomePoints;
    private Boolean cardCzar;

    public Player(){
        numAwesomePoints = 0;
        cardCzar = false;
    }

    public Player(Integer n){
        playerNum = n;
        numAwesomePoints = 0;
        cardCzar = false;
    }

    public Integer getPlayerNum(){
        return playerNum;
    }

    public ArrayList<WhiteCard> getPlayerCards(){
        return playerCards;
    }

    public Integer getNumAwesomePoints(){
        return numAwesomePoints;
    }

    public void incAwesomePoints(){
        this.numAwesomePoints++;
    }

    public Boolean isCardCzar(){
        return cardCzar;
    }

    public void addPlayerCard(WhiteCard card){
        playerCards.add(card);
    }

    public void toggleIsCardCzar(){
        if(cardCzar)
            cardCzar = false;
        else
            cardCzar = true;
    }

    public void setPlayerNum(Integer val){
        playerNum = val;
    }

    public WhiteCard pickWhiteCard(WhiteCard cd){
        playerCards.remove(cd);
        return cd;
    }
}
