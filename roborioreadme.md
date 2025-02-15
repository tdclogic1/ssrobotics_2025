# RoboRIO and SSD Setup Guide

## Prerequisites
- USB A to USB B cable
- Ethernet cable
- SSD drive (properly formatted)
- FRC Game Tools installed
- roboRIO Imaging Tool
- WPILib VS Code
- FRC Driver Station
- Your team number

## Part 1: Initial RoboRIO Setup

### 1. Format the SSD Drive
1. Connect the SSD to your computer
2. Open Disk Management (Windows) or Disk Utility (Mac)
3. Format the drive as:
   - File System: ext4 (Linux) or FAT32 (Windows/Mac)
   - Label: "FRC_Code"
   - Allocation unit size: Default

### 2. Image the roboRIO
1. Connect roboRIO to your computer via USB
2. Open roboRIO Imaging Tool
3. Select your team number
4. Click "Reformat" if this is a new setup
5. Select the latest image version
6. Click "Image roboRIO"
7. Wait for imaging to complete (~5-10 minutes)

### 3. Configure Network Settings
1. Set your computer's network settings:
   ```
   IP Address: 10.TE.AM.5
   Subnet Mask: 255.255.255.0
   ```
   Replace TE.AM with your team number (e.g., 10.47.90.5)

2. Configure roboRIO network:
   ```
   Static IP: 10.TE.AM.2
   Subnet: 255.255.255.0
   Gateway: 10.TE.AM.1
   ```

## Part 2: SSD Drive Setup

### 1. Mount SSD to roboRIO
1. Power down the roboRIO
2. Connect SSD to roboRIO USB port
3. Power up roboRIO
4. SSH into roboRIO:
   ```bash
   ssh admin@10.TE.AM.2
   ```
   Password: blank (just press Enter)

### 2. Configure SSD Mount Point
1. Create mount directory:
   ```bash
   sudo mkdir -p /media/sda1
   ```

2. Add to fstab for auto-mounting:
   ```bash
   sudo sh -c 'echo "/dev/sda1 /media/sda1 vfat defaults 0 0" >> /etc/fstab'
   ```

3. Mount the drive:
   ```bash
   sudo mount -a
   ```

4. Verify mount:
   ```bash
   df -h
   ```

## Part 3: Code Deployment

### 1. Update build.gradle
1. Open your project's build.gradle
2. Add/modify the deploy configuration:
   ```gradle
   deploy {
       targets {
           roboRIO("roborio") {
               team = TEAM_NUMBER
               directory = "/media/sda1"
           }
       }
   }
   ```

### 2. Deploy Code
1. Build the project:
   ```bash
   ./gradlew build
   ```

2. Deploy to SSD:
   ```bash
   ./gradlew deploy
   ```

3. Verify deployment:
   - Check Driver Station for robot connection
   - Look for "Robot Code" indicator to turn green
   - Check roboRIO web dashboard (http://10.TE.AM.2)

### 3. Configure Auto-Start
1. SSH into roboRIO
2. Create startup script:
   ```bash
   sudo nano /home/lvuser/robotInit
   ```

3. Add the following:
   ```bash
   #!/bin/bash
   cp -r /media/sda1/* /home/lvuser/
   ```

4. Make script executable:
   ```bash
   sudo chmod +x /home/lvuser/robotInit
   ```

## Part 4: Testing

### 1. Basic Connection Test
1. Open Driver Station
2. Verify connection to roboRIO
3. Check for green "Robot Code" indicator
4. Enable the robot in teleop mode

### 2. Code Verification
1. Check that all subsystems initialize
2. Verify sensor readings
3. Test basic movements
4. Run through autonomous routines

### 3. SSD Performance Check
1. Monitor deployment times
2. Check code execution performance
3. Verify file access speeds

## Troubleshooting

### Common Issues

1. SSD Not Mounting
   ```bash
   # Check USB devices
   lsusb
   # Check drive status
   sudo fdisk -l
   ```

2. Code Not Running
   - Verify permissions on deployed files
   - Check roboRIO system logs:
   ```bash
   tail -f /var/log/syslog
   ```

3. Network Connection Issues
   - Verify static IP configuration
   - Check network cable connections
   - Ping test:
   ```bash
   ping 10.TE.AM.2
   ```

### Recovery Steps

1. If SSD fails to mount:
   ```bash
   sudo umount /media/sda1
   sudo mount -a
   ```

2. If code doesn't auto-start:
   ```bash
   sudo systemctl restart robotInit
   ```

3. To reset network settings:
   ```bash
   sudo /usr/local/frc/bin/frcconf --reset-network
   ```

## Regular Maintenance

1. Weekly Checks
   - Verify SSD mount status
   - Check available space on SSD
   - Review roboRIO logs
   - Update network configuration if needed

2. Competition Preparation
   - Backup SSD contents
   - Test deployment process
   - Verify auto-start functionality
   - Check network settings
   - Update roboRIO firmware if necessary