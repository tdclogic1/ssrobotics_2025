# ssrobotics_2025

This repository contains the robot code for the SS Robotics team's 2025 FRC season robot.

## Table of Contents
- [Documentation](#documentation)
- [Prerequisites](#prerequisites)
- [Development Setup](#development-setup)
- [Build](#build)
- [Simulation](#simulation)
- [Deploy](#deploy)
- [Code Structure](#code-structure)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)

## Documentation
- [2025 Game Manual](https://firstfrc.blob.core.windows.net/frc2025/Manual/2025GameManual.pdf)
- [WPILib Documentation](https://docs.wpilib.org/en/stable/index.html)
- [Command-Based Programming Guide](https://docs.wpilib.org/en/stable/docs/software/commandbased/index.html)

## Prerequisites
1. Install the following software:
   - [WPILib VS Code](https://github.com/wpilibsuite/allwpilib/releases)
   - [Git](https://git-scm.com/downloads)
   - [FRC Game Tools](https://www.ni.com/en-us/support/downloads/drivers/download.frc-game-tools.html)
   - [FRC Radio Configuration Utility](https://docs.wpilib.org/en/stable/docs/zero-to-robot/step-3/radio-programming.html)

2. Ensure Java 17 or newer is installed:
   ```bash
   java -version
   ```

## Development Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-team/ssrobotics_2025.git
   cd ssrobotics_2025
   ```

2. Open the project in WPILib VS Code:
   - File → Open Folder → Select the project directory
   - Allow VS Code to import the project

## Build
Build the robot code:
```bash
./gradlew build
```

Common build options:
- Clean and build: `./gradlew clean build`
- Build without tests: `./gradlew build -x test`

## Simulation
1. Start the simulation:
   ```bash
   ./gradlew simulateJava
   ```

2. The simulation GUI will open with:
   - Field visualization
   - Robot state display
   - Joystick/gamepad input simulation
   - Network Tables viewer

3. Control the simulated robot:
   - Use the keyboard/mouse to simulate joystick inputs
   - View sensor readings and subsystem states in real-time
   - Test autonomous routines in the simulated environment

4. Stop the simulation:
   - Close the simulation window
   - Or press Ctrl+C in the terminal

## Deploy
1. Connect to the robot:
   - Ensure the robot is powered on
   - Connect to the robot's network (either via USB or WiFi)
   - Verify connection with `ping roborio-TEAM-frc.local`

2. Deploy the code:
   ```bash
   ./gradlew deploy
   ```

3. Alternative deployment methods:
   - Using VS Code: Press Ctrl+Shift+P, select "WPILib: Deploy Robot Code"
   - With specific settings: `./gradlew deploy -PteamNumber=XXXX`

## Code Structure
```
src/main/java/frc/robot/
├── commands/      # Command classes for robot actions
├── subsystems/    # Subsystem classes for robot components
├── Constants.java # Robot-wide constants and port mappings
├── Robot.java     # Main robot class
└── RobotContainer.java # Robot configuration and command bindings
```

## Testing
1. Run unit tests:
   ```bash
   ./gradlew test
   ```

2. Run specific test classes:
   ```bash
   ./gradlew test --tests "frc.robot.subsystems.DrivetrainTest"
   ```

3. View test results:
   - Results are stored in `build/reports/tests/test/index.html`

## Troubleshooting
Common issues and solutions:

1. Build Failures
   - Check Java version compatibility
   - Run `./gradlew clean` and try rebuilding
   - Verify all dependencies in `build.gradle`

2. Deployment Issues
   - Confirm robot connection (ping test)
   - Check team number in `build.gradle`
   - Verify RoboRIO firmware version
   - Review driver station logs

3. Simulation Problems
   - Ensure graphics drivers are up to date
   - Check for Java runtime errors in the console
   - Verify simulator configuration in `build.gradle`

For additional help:
- Check the [Chief Delphi Forums](https://www.chiefdelphi.com/c/technical/programming/16)
- Review [WPILib GitHub Issues](https://github.com/wpilibsuite/allwpilib/issues)
- Contact your team's programming mentors
