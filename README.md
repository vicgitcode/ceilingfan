# Ceiling Fan
The Ceiling Fan Code Test.

## Requirements
In Java, implement a simple ceiling fan with these characteristics:
- The unit has 2 pull cords:   
    - One increases the speed each time it is pulled.  There are 3 speed settings, and an “off” (speed 0) setting.   If the cord is pulled on speed 3, the fan returns to the “off” setting.
    - One reverses the direction of the fan at the current speed setting. Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.
- You can assume the unit is always powered (no wall switch)

## Usage
Run CeilingFanRunner to initialize the Ceiling Fan. Enter 'S' for pulling Speed-change cord and/or 'D' for pulling Direction-change cord. Or 'SD' to pull both cords at the same time.

## Design and Implementation Decisions
- Use Interfaces to achieve Abstractions for Motor and Speed/Direction Controls. This follows the Open-Close Principle (Open for extension, close for modification). So in the future the application could easily support other implementations of Motors or Controls.
- Concurrent design for Motor, Speed cord, Direction cord and User Input, so that all of them can operate in non-blocking manner.
- ConcurrentLinkedQueue is used as input signal channel to pass Speed-change or Direction-change signal from the controls to the motor.
### Potential Improvement
- This application is written in core Java to avoid any framework dependency. However, in real-life project, Spring or Spring-Boot should be used so that we could use dependency injection out-of-the-box and reduce some boilerplate codes, along with other benefits.

## License
[MIT](https://choosealicense.com/licenses/mit/)

