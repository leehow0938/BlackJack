package models.constants;

public enum Suit {
    HEART("heart"),
    SPADE("spade"),
    DIAMOND("diamond"),
    CLUB("club");

    private String displayName;
    Suit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
