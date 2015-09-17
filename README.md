#FT_5

# Software Architecture 2015-2016
## Lab: Quality Care Robot

## Environment:

* Eclipse
* Maven

## Instructions
Simply pull the repo, you can now run the maven commands. For Eclipse choose File -> Import -> Existing Maven Project. You can then choose which component you want.

## Build Commands	

* Build everything: mvn package
* Build pipe-filter: mvn package -pl lib/pipe-filter
* Test everything: mvn validate
* Test pipe-filter: mvn validate -pl lib/pipe-filter
* Clean the project: mvn clean
