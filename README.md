#FT_5

# Software Architecture 2015-2016
## Lab: Quality Care Robot

## Environment:

* Eclipse
* Maven
* JDK 1.8

## Instructions
Simply pull the repo, you can now run the maven commands. For Eclipse choose File -> Import -> Existing Maven Project. You can then choose which component you want.

## Build Commands	
Open terminal in the root folder (qcrobot) than you can run the following commands:

* Build & test everything: mvn package
* Build & test pipe-filter: mvn package -pl lib/pipe-filter
* Test everything: mvn test
* Test pipe-filter: mvn test -pl lib/pipe-filter
* Clean the project: mvn clean

## Documentation 
We use javadoc to document the source-code, maven will automatically generated this documentation in component/target/site when using the package command. 
