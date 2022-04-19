# CurrencyAnalyzer

Application for analysing currency data taken from http://api.nbp.pl/en.html. 
Program allows to plot bid and sale price of chosen currency (handled by external NBP api), 
aswell as their differences, on given date range (any valid range between 2005 and now). 
Its backend was written using Java on Spring framework, together with Jackson and Lombok.
Frontend was made using Typescript on Angular framework, including plotly.js library(https://plotly.com/javascript/).

The application consists of two separate internal projects (one for frontend and one for backend).
To boot up, two internal maven projects have to be clean-installed, and then booted separetly.
Locally web page is located on port 4200. (http://localhost:4200).
