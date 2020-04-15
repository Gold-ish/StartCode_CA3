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

