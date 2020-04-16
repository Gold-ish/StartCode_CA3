[![Build Status](https://travis-ci.org/Gold-ish/StartCode_CA3_Backend.svg?branch=master)](https://travis-ci.org/Gold-ish/StartCode_CA3_Backend)

# StartCode_CA3
Verry gud start kode. yez.
this is travis test from allan hello

# How to use start code.
Step 1.
In the StupTestUsers.java class edit the passwords to something other than test.  
And then add the file to the git ignore, before the initial commit and push to GitHub.  
**/SetupTestUsers.java  


Force deployment without travis deployment:  
Remember to edit the RemoteServer in the pom.xml file befroe using the mvn command.  
Remember to use the right password.  
mvn clean test -Dremote.user=script_user -Dremote.password=InsertPassword tomcat7:deploy  


Add a new schematic to the database on your droplet.  
Then add all 3 enviorment variables after ssh'ing into the droplet.  
ssh (USER)@(URL)  
The 3 enviorment varables that need to be added are; "User_(Whatever)", "PW_(Whatever)", "Connection_STR_(Whatever)".  
sudo nano /opt/tomcat/bin/setenv.sh  
The connection string has to be the same as the string for the schematic of the DB.  

If you rename the 3 system.getenv from the "/utils/EMF_Creator.java", you also have to remember to rename the 3 variables form the sudo nano /opt/tomcat/bin/setenv.sh  




