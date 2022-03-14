# appian-openlocationcode-plugin
Appian plug-in for the Open Location Code Java API (https://github.com/google/open-location-code/tree/main/java)

## Building
_This assumes you have the Appian SDK installed to your local Maven repo_
1. Clone the repo
2. In a terminal, run the following commands:
```
mvn clean
mvn compile
mvn dependency:copy
mvn assembly:single
```