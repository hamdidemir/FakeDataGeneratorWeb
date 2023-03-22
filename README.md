# FakeDataGeneratorWeb
This web application creates a file with randomly generated data for testing purposes. 
The project is divided into three main packages: FileWriters, Generators, and Web.

Under the FileWriters package, there are classes that can create both CSV and Excel files, with a sub-package for formatting the Excel files.

The Generators package contains methods to generate various types of data, such as names, surnames, birth-dates, age, Turkish identity numbers, email addresses, passwords, phone numbers, height, weight, and addresses. The data generated is designed to be specific to Turkey and the Turkish population. The names and surnames are drawn from H2 databases using simple SQL queries, which are stored in /resources/databases. The Turkish identity number is generated according to a specific algorithm, and the cities in the addresses are randomly generated based on the real population distribution of Turkey. The districts and neighborhoods are also randomly selected based on the cities, with the data being read from JSON files. The age, height, and weight are distributed based on the Turkish population's age and Gaussian distribution, with appropriate median and standard deviation for adults and children.

The Web package contains a controller class and its components, which are responsible for handling incoming HTTP requests and returning HTTP responses to the client. The front-end of the web application uses HTML, CSS, and JavaScript.
