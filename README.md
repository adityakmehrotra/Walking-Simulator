# Walking-Simulator

## Overview

WalkingSim is a Java application that simulates characters, referred to as "Walkers," moving across the screen. Utilizing the Processing library for graphics and animation, this project creates an interactive environment where users can influence the movement of characters through mouse and keyboard inputs.

## Features

- **Dynamic Character Animation**: Characters walk across the screen and respond to user interactions.
- **Interactive Controls**:
  - **Mouse Interaction**: Clicking on a character makes them start walking.
  - **Keyboard Interaction**: Pressing 'A' adds a new character, and pressing 'S' stops a character's movement.

## Technical Setup

The application relies on the Processing library, which simplifies the development of visual applications in Java.

### Prerequisites

- Java Development Kit (JDK) - Java 8 or higher recommended.
- Processing core library (can be downloaded from [Processing](https://processing.org/download/)).

### Directory Structure

- **src/**: Contains the source code files.
  - `walkingsim.java`: Main application file.
- **images/**: Contains image files used for the character animations.
  - `walk-0.png`, `walk-1.png`, ..., `walk-N.png`: Animation frames for walking characters.

### How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/WalkingSim.git
   cd WalkingSim
   ```

2. Compile the Java Code:
Ensure that the Processing core library is included in your classpath.
  ```bash
  javac -cp path/to/core.jar src/walkingsim.java
  ```

3. Run the Application:
```bash
// Replace path/to/core.jar with the actual path to the Processing core library. On Windows, replace : with ; in the classpath.
java -cp .:path/to/core.jar src.WalkingSim
```


## How It Works
- Setup: Initializes the screen, loads images, and creates initial set of Walkers.
- Draw Loop: Continuously updates the screen, moving each Walker and handling interactions.
- Interactions:
  - Mouse: Clicking near a Walker toggles their walking state.
  - Keyboard: Press 'A' to add a new Walker and 'S' to stop all Walkers.
 

## Contributions
Contributions to WalkingSim are welcome! Please fork the repository, make your changes, and submit a pull request for review.

### Last Updated
12/14/2022
