package service;

import states.Direction;
import states.Speed;

/**
 * Interface for Motor component
 */
public interface Motor {
    void changeSpeed(Speed speed);
    void changeDirection(Direction direction);
    Speed getCurrentSpeed();
    Direction getCurrentDirection();
}
