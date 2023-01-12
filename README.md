# conserve-it-room-controls

The basic requirements are pretty clear for this project

Some parts that I think may do more improvements is:

- Heater and Air Conditioner can be separated into single class, hence to increase their scalability. For example specific mode changes and air volume
etc.

- In order to make it approach to reality, some dependencies that able to obtain the real temperature outside can be exploited.

- If this is oriented to the normal user who has no technical background, a simple GUI(Swing or JavaFX) can be implemented to make it user-friendly

- In real-life situations, because there are many environmental factor to influence temperature, each room obviously would not change at the same time,
therefore threading must be implemented in order to obtain the dynamic temperature information.

- there should be adding more error checking requirements in terms of user input in this project, for instance, when adding rooms, Room type can only
have 3 types, requested temperature should not exceed or lower to certain level, etc. But I already included them for error-prevention.
