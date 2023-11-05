# Citybike application

This is a fullstack application that will show information about journeys with the
citybikes in the Helsinki region. It can be freely cloned, used and modified. The backend
has been written in Java with the Spring framework. The frontend has been written in React.

# Technical requirements for the backend
The requirements for a successful setup of the backend are the following:
-Java 17 (might work with other versions, but not guaranteed)
-Docker desktop (in the development process i used version 4.19.0)
-Apache Maven (for this project version 3.8.6 is used)
-PostgreSQL (I used version 16.0)

# How to run the backend
The first time you run this application, you need to set up the docker container.
Navigate to the directory /backend of this application and run:

docker compose up --build --renew-anon-volumes -d

If you need to rebuild the docker images you can run:

docker-compose build

Then the docker container will be setup and the database initialised. You can now log in 
to the PostgreSQL database at the url http://localhost:8080. The username and password are
found in the docker-compose.yml file.

Now you can install the dependencies. Again, navigate to /backend and run:

mvn clean install

The dependencies for Springboot and other dependencies are installed, 
and the tests are also run, and the backend is build. Now you can start the
backend. In the /backend directory, run:

mvn spring-boot:run

You can also run it from the main method in the class CityBikeApplication, however i recommend
the mvn-command for better control in case you intend to develop this application further.

Now the backend is up and running. If you navigate to http://localhost:8888/stations You
will see the names of all the citybikestations displayed. You can view an info about
a single station by navigating to http://localhost:8888/stations/{stationName}

# How to run the frontend

Navigate to /frontend. To install the dependencies, run:

npm install

And then to start the frontend run:

npm start

Now the frontend is running. You can navigate to the starting page at: http://localhost:3000/stations/

# Testing at the frontend

In order to run all the unit tests, you can run 

npm test


