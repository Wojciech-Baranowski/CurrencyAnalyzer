# CurrencyAnalyzer

Description:
The application for analysing currency data taken from http://api.nbp.pl/en.html. 
Program allows to plot bid and sale price of chosen currency (handled by external NBP api), 
aswell as their differences, on given date range (any valid range between 2005 and now).

Backend libraries:
-Spring Boot,
-Jackson,
-Lombok.

Frontend libraries:
-Angular,
-Plotly.js.

Setup local:
-boot up main funcition from CurrencyAnalyzerBackendApplication.java,
-execute "ng serve --proxy-config proxy.conf.json" command from CurrencyAnalyzerFrontend directory.

Build backend:
-execute "mvn clean install" command from CurrencyAnalyzerBackend directory.

Ports:
-backend on 8080,
-frontend on 4200.
