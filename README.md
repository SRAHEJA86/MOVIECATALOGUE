# MOVIECATALOGUE
Movie Catalogue API created using spring boot

This is an API created using java using spring boot framework (v4.3.2) using JAVA 8, to fetch the details of movies (name, movieId, description, director) and ratings.

Architecture 
The API has been developed using microservices and there are 3 microservices developed
1. Movie Info service
2. Movie Rating service
3. Movie catalogue service which fetches the information from the above two services to form a movie catalog item using rest template.

Database
At the database end, Postgres DB has been used to store and retrieve the information
There are primarily two tables created movies and rating with a foreign key relationship using movieId

Usage
The API can be used 
1. To fetch the details of the movies in the catalog - name, description, director and rating.
The details can be accessed by uisng URL - http://localhost:8185/v1/catalog/movies (GET request)

2. Search movies which have rating above or equal to certain rating
The details can be accessed by using URL - http://localhost:8185/v1/catalog/movies/ratings/{rating} say http://localhost:8185/v1/catalog/movies/ratings/3 (GET REQUEST)

3. To add the rating of a movie - http://localhost:8185/v1/catalog/movies/rating (POST request)
4. To update the rating of a movie - http://localhost:8185/v1/catalog/movies/rating (PUT request)
5. To delete a rating of a movie - http://localhost:8185/v1/catalog/movies/rating (DELETE request)
6. To add movie including director/name/description - http://localhost:8185/v1/catalog/movies (POST request)
7. To update details of movie (inculding director)-http://localhost:8185/v1/catalog/movies (PUT request)
8. To delete details of a movie - http://localhost:8185/v1/catalog/movies (DELETE request)
9. Search movies on the basis of director name - http://localhost:8185/v1/catalog/movies?director=director name say http://localhost:8185/v1/catalog/movies?director=John Doe

To change the port number (in case 8185 is already used on your machine, kindly change it in application.properties file)

Prerequisites :
1. JAVA (version 8 or above) should be installed on the system.
2. Maven should be installed
3. IDE (Eclipse / Intelli J) should be installed (in case api should be run using an IDE)

Installation
TO install the project, follow the steps below -
clone / download the git project using git clone and git checkout commands. 

USING AN IDE
1. Import the three projects using any IDE (IntelliJ / eclipse). 
2. Open the MovieCatalogApplication.java and right click and run the class.
3. Open the MovieRatingApplication.java and right click and run the class.
4. Open the MovieInfoApplication.java and right click and run the class.

USING A JAR
1. The API can also be run using a jar
2. To run the api using jar - browse to the location where the project has been downloaded / cloned 
3. Run the command mvn clean install , which would create the jar - movie-catalog-service-0.0.1-SNAPSHOT.jar under target folder
4 browse to target and run the command java -jar movie-catalog-service-0.0.1-SNAPSHOT.jar , which would start the application and can be tested using a browser



