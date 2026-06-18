# Pluto Port Scanner 

![Logo](logo/Pluto.png)

PLUTO v0.0.1-alpha  Sniffs open ports 
 
 ## description
 Pluto is a Java program that detects open ports on servers
 
 ## About
 Pluto tries to open a tcp connection for each port, if it doesn't open 
 or the 300ms timeout expires the port is closed or filtered
 
 ## usage
 Usage is very simple, just run it and enter the server's IP/hostname, 
 and all open ports will be printed on the screen (from 0 to 1023)
 
 ## Credits
- Logo: Letizia mariano

 ### Known issues
 ** The developer would like to point out that this is only a very first version, which does not use threads, so research takes time, better versions will be developed **