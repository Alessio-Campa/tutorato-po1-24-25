package it.unive.dais.po.tutorato;

public class Player {
    Hand hand;


    public static void main(String[] args) {
        Player p = new Player();
        p.hand = new Hand(new Card[]{
                new Card(1, Suit.DENARI),
                new Card(2, Suit.SPADE),
                new Card(2, Suit.COPPE),
        });

        System.out.println(p.hand.play(0).display());
        System.out.println(p.hand.play(0).display());
    }
}
