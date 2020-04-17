[![Build Status](https://travis-ci.org/Gold-ish/StartCode_CA3_Backend.svg?branch=master)](https://travis-ci.org/Gold-ish/StartCode_CA3_Backend)

# StartCode_CA3
#### Asignment: [CA3 QuickStart Project](https://github.com/Gold-ish/StartCode_CA3_Backend/blob/master/CA3-QuickStart-project.pdf)
Verry gud start kode. yez.
  
#### Members:
- Allan Bo Simonses
- Nina Lizakowski
- Caroline Lærke Høeg-Iversen
- Tobias Anker Boldt-Jørgensen
  
## Getting Started with the start code.  
- Clone the project  
- Remove ".git" folder and then use "git init"  
- Create a new repository and use the following commands.  
"git add *"  
"git commit -m "initial commit"  
"git remote add origin (repoURL)"  
"git push origin master"  
- In the pom.xml file edit the artifact id and name to something that makes sense for the project.  
- Go to [Travis-ci.com](https://www.travis-ci.com) and activate the new repo.  
- Create a new schematic on your vagrant db.  
- Create a remote schematic on the deployment server, with the same name as the development database.
- SSH into the deployment server. (USER)@(URL)  
- Add 3 enviorment variables to the setenv.sh folder;  
(sudo nano /opt/tomcat/bin/setenv.sh)  
"User_(YOUR_DB_USER)"  
"PW_(YOUR_DB_PASSWORD)"  
"Connection_STR_(jdbc:mysql://localhost:3306/(dbName))"  
- Save the file and run this command to restart tomcat "sudo systemctl restart tomcat"


- The connection string has to be the string that leads us to the right database that we created up above on the dev server.
- If you rename the 3 system.getenv from the "/utils/EMF_Creator.java", you also have to remember to rename the 3 variables form the sudo nano /opt/tomcat/bin/setenv.sh  
  
## Backend setup  
- Find the "config.properties" file in the "Other Sources/src/main/resources/default package/config.property" file.  
- Change the "db.database" to the same database nave we created on the deployment server and on our vagrant db.  
  
## Setup Travis-CI controll (Maven script deploys when travis has full green test)
- Go to [Travis-ci.com](https://www.travis-ci.com) and select the repository from the dashboard menu.  
- Click "More Options" and select "settings".  
- Create 2 new "Enviorment Variables":  
"REMOTE-PW" : (Password for script_user)  
"REMOTE_USER" : "script_user"  
- In the pom.xml file edit the <remote.server>*(You'r deployment serverURL)*/manager/text</remote.server>  
- *Test The pipeline*
- Make a small change in the program, and run "mvn clean test" to make sure it won't break the pipeline.  
- If it is a succes then try pushing the change to github and see travis turn green.
- Last check is to make sure that it was deployed properly to the remote server.
- Try in the browser to reach the url.
  
  
  
## Extras
In the StupTestUsers.java class edit the passwords to something other than "test", and run it once.  
Then add the file to the git ignore, before the initial commit and push to GitHub.  
**/SetupTestUsers.java  


Force deployment without travis:  
Remember to edit the RemoteServer in the pom.xml file befroe using the mvn command.  
Remember to use the right password.  
mvn clean test -Dremote.user=script_user -Dremote.password=RiGhTpAsSwOrDgOeShErE tomcat7:deploy  






