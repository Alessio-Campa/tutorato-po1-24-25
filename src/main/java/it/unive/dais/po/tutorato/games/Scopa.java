package it.unive.dais.po.tutorato.games;

import it.unive.dais.po.tutorato.cards.*;

import java.util.ArrayList;
import java.util.List;

public class Scopa {
    private Deck<CardIta> deck;
    private Table<CardIta> table;
    private ScopaPlayer player1, player2;
    private ScopaPlayer lastPicker;
    private ScopaPlayer winner;

    public Scopa(ScopaPlayer player1, ScopaPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private void giveCards(){
        for(int i = 0; i < 3; i++){
            player1.addCard(deck.getTopCard());
            player2.addCard(deck.getTopCard());
        }

    }

    private void playGame(){
        while ((player1.getPoints() < 21 && player2.getPoints() < 21) || player1.getPoints() == player2.getPoints()){
            player1.init();
            player2.init();
            playTurn();

            System.out.println(player1.getName() + " got has " + player1.getPoints() + " point" + (player1.getPoints() == 1 ? "" : "s"));
            System.out.println(player2.getName() + " got has " + player2.getPoints() + " point" + (player2.getPoints() == 1 ? "" : "s"));

            ScopaPlayer temp = player1;
            player1 = player2;
            player2 = temp;
        }
        if (player1.getPoints() > player2.getPoints()){
            winner = player1;
        } else {
            winner = player2;
        }
    }

    private void playTurn(){
        this.deck = new DeckIta();
        this.table = new Table<>();
        for(int i = 0; i < 4; i++){
            table.add(deck.getTopCard());
        }

        System.out.println(table);
        while (!deck.isEmpty()){
            giveCards();
            playHand();
        }
        lastPicker.addStash(table.getCards());
        calcPoints();
    }

    private void playHand(){
        while (!(player1.isHandEmpty() && player2.isHandEmpty())){
            playTurn(player1, player2);
            playTurn(player2, player1);
        }
    }

    private void playTurn(ScopaPlayer player, ScopaPlayer watcher){
        CardIta placedCard = player.playTurn(table.getCards());
        watcher.inform(placedCard);

        List<List<CardIta>> matches = new ArrayList<>();
        checkSum(placedCard.getValue(), 0, new ArrayList<>(), matches);
        if (matches.isEmpty()){
            table.add(placedCard);
        } else {
            int chosen = 0;
            if (matches.size() > 1) {
                chosen = player.chooseCards(matches);
            }
            player.addStash(matches.get(chosen));
            player.addStash(placedCard);
            table.remove(matches.get(chosen));
            lastPicker = player;

            if (table.isEmpty()){
                System.out.println("SCOPA!");
                player.addScopa();
            }
        }

        System.out.println(player.getName() + " played:");
        System.out.println(placedCard);
        System.out.println("Table status: ");
        System.out.println(table);
    }

    private void checkSum(int target, int pos, List<CardIta> prev, List<List<CardIta>> matches){
        if (target == 0){
            matches.add(prev);
            return;
        }
        if (pos == table.size() || target < 0) return;
        List<CardIta> temp = new ArrayList<>(prev);
        checkSum(target, pos +1, temp, matches);
        temp.add(table.getCards().get(pos));
        checkSum(target - table.getCards().get(pos).getValue(), pos +1, temp, matches);
    }

    private void calcPoints(){
        player1.addPoints(player1.calcTurnPoints());
        player2.addPoints(player2.calcTurnPoints());

        int primiera1 = player1.getPrimieraPoints();
        int primiera2 = player2.getPrimieraPoints();
        if (primiera1 > primiera2){
            System.out.println(player1.getName() + " got 1 'Primiera' point");
            player1.addPoints(1);
        } else if (primiera1 < primiera2){
            System.out.println(player2.getName() + " got 1 'Primiera' point");
            player2.addPoints(1);
        }

    }

    private ScopaPlayer getWinner(){
        return winner;
    }


    public static void main(String[] args) {
        ScopaPlayer p1 = new ScopaPlayer("Player 1");
        ScopaPlayer p2 = new ScopaPlayer("Player 2");
        Scopa match = new Scopa(p1, p2);

        match.playGame();
        System.out.println(match.getWinner().getName());
    }

}
