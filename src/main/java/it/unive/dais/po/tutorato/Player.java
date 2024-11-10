package it.unive.dais.po.tutorato;

import it.unive.dais.po.tutorato.cards.CardIta;
import it.unive.dais.po.tutorato.suits.SuitIta;

public class Player {
    Hand hand;


    public static void main(String[] args) {
        Player p = new Player();
        p.hand = new Hand(new CardIta[]{
                new CardIta(1, SuitIta.DENARI),
                new CardIta(2, SuitIta.SPADE),
                new CardIta(2, SuitIta.COPPE),
        });

        System.out.println(p.hand.play(0).toString());
        System.out.println(p.hand.play(0).toString());
    }
}
