package it.unive.dais.po.tutorato;

public class Card {
    private int value;
    private Suit suit;

    private static final int[] PRIMIERA = new int[]{16, 12, 13, 14, 15, 18, 21, 10, 10, 10};

    /** Constructor of the card
     * @param val the value of the card, from 1 to 10;
     * @param suit the suit of the card, see..
     * */
    public Card(int val, Suit suit) {
        this.value = val;
        this.suit = suit;
    }

    private Card(Card c){ // copy constructor
        this(c.value, c.suit);
    }

    private String getValueRepr(){
        if(this.value == 8) return "f";
        if(this.value == 9) return "c";
        if(this.value == 10) return "r";
        return String.valueOf(this.value);
    }

    private char getSuitRepr(){
        return this.suit.repr.charAt(0);
    }

    public String display(){
        String topLine = "+----+\n";
        String rightLeftLine = "|" + getValueRepr() + getSuitRepr() + "  |\n";
        String emptyLine = "|    |\n";
        String leftRightLine = "|  " + getSuitRepr() + getValueRepr() + "|\n";
        String botLine = "+----+";

        return topLine + rightLeftLine + emptyLine + leftRightLine + botLine;
    }

    public int getValue(){
        return this.value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getPrimieraValue(){
        return Card.PRIMIERA[this.value-1];
    }

    public static void main(String[] args) {
        Card setteBello = new Card(7, Suit.DENARI);
        Card reBello = new Card(10, Suit.DENARI);

        System.out.println(setteBello.getPrimieraValue());
    }
}