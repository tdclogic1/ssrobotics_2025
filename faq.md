#Failing to run Simulation

# FRC Simulation Setup Guide

## Common Simulation Error
If you encounter this error when running simulation:
```
Exception in thread "main" edu.wpi.first.util.MsvcRuntimeException: Invalid MSVC Runtime Detected.
Expected at least 14.40, but found 14.36
```

Follow these steps to resolve the issue:

## Step 1: Update Visual C++ Redistributable

### Uninstall Current Version (Recommended)
1. Open Windows Control Panel
2. Navigate to Programs and Features
3. Find "Microsoft Visual C++ 2015-2022 Redistributable"
4. Right-click and select Uninstall
5. Follow uninstallation prompts

### Install Latest Version
1. Visit the [Official Microsoft Visual C++ Downloads](https://learn.microsoft.com/en-us/cpp/windows/latest-supported-vc-redist)
2. Download both versions:
   - vc_redist.x64.exe (64-bit version)
   - vc_redist.x86.exe (32-bit version)
3. Install both versions (even on 64-bit Windows)
4. Restart your computer

## Step 2: Java Configuration

WPILib works best with Java 17. Current setup:
1. Download [Java 17 (LTS)](https://adoptium.net/temurin/releases/?version=17)
2. Install for all users
3. Update Environment Variables:
   - Open System Properties → Advanced → Environment Variables
   - Set JAVA_HOME to Java 17 installation path
   - Example: `C:\Program Files\Eclipse Adoptium\jdk-17.0.9.9-hotspot`
4. Restart your IDE and terminal

## Step 3: Test Simulation

Basic test:
```bash
./gradlew simulateJava
```

If issues persist, try cleaning the build:
```bash
./gradlew clean
./gradlew simulateJava
```

For detailed error information:
```bash
./gradlew simulateJava --debug
```

## Verification

To verify correct setup:
1. Check Visual C++ Redistributable version in Control Panel
2. Verify Java version:
   ```bash
   java -version
   ```
   Should show Java 17.x.x

## Additional Resources
- [WPILib Documentation](https://docs.wpilib.org/)
- [Microsoft Visual C++ Downloads](https://learn.microsoft.com/en-us/cpp/windows/latest-supported-vc-redist)
- [Java Installation Guide](https://adoptium.net/installation/)