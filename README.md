# CurrencyAnalyzer

**Description:**

The application for analysing currency data taken from http://api.nbp.pl/en.html. 
Program allows to plot bid and sale price of chosen currency (handled by external NBP api), 
as well as their differences, on given date range (any valid range between 2005 and now).

**Backend libraries:**

- Spring Boot
- Jackson
- Lombok

**Frontend libraries:**

- Angular
- Plotly.js

**Setup local:**

- Boot up main function from CurrencyAnalyzerBackendApplication.java
- Execute "ng serve --proxy-config proxy.conf.json" command from CurrencyAnalyzerFrontend directory

**Build backend:**

- Execute "mvn clean install" command from CurrencyAnalyzerBackend directory

**Ports:**

- Backend on 8080
- Frontend on 4200
