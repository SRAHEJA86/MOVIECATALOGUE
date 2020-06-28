CREATE TABLE rating
(
 movieId varchar(100) DEFAULT NULL,
 rating varchar(100) DEFAULT NULL,
 PRIMARY KEY (movieId),
 FOREIGN KEY (movieId) REFERENCES movies(movieId)
);