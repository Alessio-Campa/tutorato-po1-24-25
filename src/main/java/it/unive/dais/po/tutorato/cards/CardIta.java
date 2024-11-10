package it.unive.dais.po.tutorato.cards;

import it.unive.dais.po.tutorato.suits.SuitIta;

public final class CardIta extends Card<SuitIta> {

    private static final int[] PRIMIERA = new int[]{16, 12, 13, 14, 15, 18, 21, 10, 10, 10};

    /** Constructor of the card
     * @param val the value of the card, from 1 to 10;
     * @param suit the suit of the card, see...
     * */
    public CardIta(int val, SuitIta suit) {
        super(val, suit);
    }

    private CardIta(CardIta c){ // copy constructor
        this(c.value, c.suit);
    }

    private String getValueRepr(){
        if(this.value == 8) return "f";
        if(this.value == 9) return "c";
        if(this.value == 10) return "r";
        return String.valueOf(this.value);
    }

    private char getSuitRepr(){
        return this.suit.getRepr().charAt(0);
    }

    @Override
    public int getValue(){
        if (super.value > 10 || super.value < 0){
            throw new CardValueException();
        }
        return super.value;
    }

    @Override
    public String toString(){
        String topLine = "+----+\n";
        String rightLeftLine = "|" + getValueRepr() + getSuitRepr() + "  |\n";
        String emptyLine = "|    |\n";
        String leftRightLine = "|  " + getSuitRepr() + getValueRepr() + "|\n";
        String botLine = "+----+";

        return topLine + rightLeftLine + emptyLine + leftRightLine + botLine;
    }

    public SuitIta getSuit() {
        return suit;
    }

    public int getPrimieraValue(){
        return CardIta.PRIMIERA[this.value-1];
    }

    static private int method(){
        Card<SuitIta> card = new CardIta(2, SuitIta.BASTONI);
        try {
            System.out.println(card.getValue());
            return card.getValue();
        }catch (CardValueException e){
            System.out.println("CHEATER!");
            return -1;
        }
        finally {
            System.out.println("Back to the game");
        }
    }

    public static void main(String[] args) {
        System.out.println(method());

        CardIta setteBello = new CardIta(7, SuitIta.DENARI);
        CardIta reBello = new CardIta(10, SuitIta.DENARI);
        CardIta fakeCard = new CardIta(11, SuitIta.DENARI);

        // System.out.println(setteBello.getPrimieraValue());
        // System.out.println(fakeCard.getValue());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof CardIta otherCard){
            return otherCard.getValue() == this.getValue() && otherCard.getSuit() == this.getSuit();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.value + this.suit.ordinal() * 10;
    }
}