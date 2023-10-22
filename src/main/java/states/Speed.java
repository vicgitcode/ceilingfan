package states;

/**
 * Enum for Speed state:
 *     SPEED_0 - [Off]
 *     SPEED_1 - [Speed 1]
 *     SPEED_2 - [Speed 2]
 *     SPEED_3 - [Speed 3]
 */
public enum Speed {
    SPEED_0("Off"),
    SPEED_1("Speed 1"),
    SPEED_2("Speed 2"),
    SPEED_3("Speed 3");

    private final String label;

    private Speed(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
