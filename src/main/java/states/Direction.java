package states;

/**
 * Enum for Direction state:
 *     CLOCKWISE - [Clockwise]
 *     COUNTERCLOCKWISE - [Counterclockwise]
 */
public enum Direction {
    CLOCKWISE("Clockwise"),
    COUNTERCLOCKWISE("Counterclockwise");

    private final String label;

    private Direction(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
