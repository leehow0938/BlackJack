package models.constants;

public enum Suit {
    HEART('\u2764'),
    SPADE('\u2660'),
    DIAMOND('\u2666'),
    CLUB('\u2663');

    private char displayName;

    Suit(char displayName) {
        this.displayName = displayName;
    }

    public char getDisplayName() {
        return this.displayName;
    }
}
