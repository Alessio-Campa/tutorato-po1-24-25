package it.unive.dais.po.tutorato.suits;

public enum SuitIta {
    BASTONI("Bastoni"),
    COPPE("Coppe"),
    DENARI("Denari"),
    SPADE("Spade");

    private String repr;

    public String getRepr() {
        return repr;
    }

    SuitIta(String rep) {
        this.repr = rep;
    }

}
