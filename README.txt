FIS calculates driving time between major cities in South Africa 

This is Spring boot REST APIs that is consumed by the Angular application (fisweb)
This application uses internal h2 database for data storage and JPa for ROM. 
The application calculates the driving time between the major cities in South Africa
The end user is able to enter the average speed and see the resulting estimated travel time on the screen. 
The application also takes into account that for every 2 hours that the driver drives he/she must take a 20 minute break. No authentication\security is done. Code is Unit tested Maven and Java 8 are used.

Note:
The initial intention was to integrate with Google Map Distance Matrix apis but the api has given me a very limited number of requests per day pay the extra requests after my daily limits. So i ended up doing a mathematical algorithim that uses a straight line calculation between two cities without taking care of gps maping and driving routes.
