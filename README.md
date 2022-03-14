# appian-openlocationcode-plugin
Appian plug-in for the Open Location Code Java API (https://github.com/google/open-location-code/tree/main/java)

## Creating the plug-in JAR
_This assumes you have the Appian SDK installed in your local Maven repo_
1. Clone the repo
2. In a terminal, run the following command:
```
mvn clean compile dependency:copy assembly:single
```