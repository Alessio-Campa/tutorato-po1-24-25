package it.unive.dais.po.tutorato.suits;

public enum SuitFra {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Hearts");

    private String repr;

    public String getRepr() {
        return repr;
    }

    SuitFra(String rep) {
        this.repr = rep;
    }

}
