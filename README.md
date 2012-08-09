WarExec
===
WarExec makes existing war file executable by updating the war file with a an embedded Jetty instance. 

# Getting Started
1. Install [gradle](http://www.gradle.org)
2. Clone WarExec
3. Open a command prompt in the WarExec root directory
4. type 'gradle executable -Pwar=path-to-war-file

To run the war file type 'java -jar <path-to-war-file>'

# JSP Support
The project I developed this for doesn't use JSPs. If your project does, then add the jars into the lib directory.
This goes for other jars that are normally provided by the app server too.