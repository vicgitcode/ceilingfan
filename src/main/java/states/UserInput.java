package states;

/**
 * Enum for UserInput:
 *     CHANGE_SPEED - [S]
 *     CHANGE_DIRECTION - [D]
 */
public enum UserInput {
    CHANGE_SPEED("S"),
    CHANGE_DIRECTION("D");

    private final String label;

    private UserInput(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
