# FakeDataGeneratorWeb
This web application creates a file with randomly generated data for test uses. 
The project has 3 main package: FileWriters, Generator, and Web.

The classes under FileWriters package are able to create both csv and excel files. There is a sub-package to help with formatting the excel file.


The Generators package contains the generator methods requeired to create the fake random data.
The application generates names, surnames, birth-days, age, Turkish identity number, email, password, phone number, height, weight, and address.
All the data being generated is desigend to be peculiar to Turkey and Turkish population.
The names and surnames are drawn from H2 databases using simple SQL queries. The databases are stored in /resources/databases path.
The Turkish identity number is generated according to its algorithm.
The cities in the addresses are randomly generated with respect to real populariton distribution of Turkey.
The districts are selected randomly from the cities and the neighbourhoods are randomly selected from districts. 
The cities and corresponding districts and neighbourhoods are read from JSON files.
The age is distibuted according to Turkish populations' age.
The heights and weights are distrbuted according to Gaussian distrbution with proper median and staandart deviation for both adults and children.

The web package contains the controller class and its componenets which is responsible for handling incoming HTTP requests and returning HTTP responses to the client. 

HTML, css, and javascript are used for the front-end.
