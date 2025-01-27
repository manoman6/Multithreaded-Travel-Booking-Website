# A Multithreaded Travel Booking Web Application Using Spring
Using a travel booking company's spring web app, I integrated multithreaded language translation. In addition to adding multithreaded packages, due to being an internationally oriented web app, timezone integration was added to event notices and booking information. This was a great project to work on multithreading packages in java, particularly integrating them into a Spring Framework. A docker file is also provided for you to try out the website yourself, and to make it even easier, I have uploaded a Docker Image into the packages to simplify the process further. Thank you for looking!


## Getting Started

### <ins>Prerequisites</ins>
* Have Docker installed on your machine. [Click Here For the Download Page](https://www.docker.com/products/docker-desktop/)


### <ins>How to Pull and Run the Docker Image</ins>
* In the commandline/terminal pull the image to your machine:
```commandline/terminal
docker pull ghcr.io/manoman6/multithreaded-travel-booking-website:latest
```
* Run the Container on your local machine:
```commandline/terminal
docker run -p 8080:8080 ghcr.io/manoman6/multithreaded-travel-booking-website:latest
```
* Open your Browser type into the URL
```URL Bar
http://localhost:8080
```


### <ins>How to Build and Run Using the Docker File Without the Image</ins>
-- NOTE --: The prebuilt JAR file in `target/` is provided for convenience. It represents the current stable version of the project. To build your own JAR, use `mvn clean package`.
* Clone this repository using commandline/terminal:
```commandline/terminal
git clone https://github.com/manoman6/Multithreaded-Travel-Booking-Website.git
```
* Then go into the project's directory
```commandline/terminal
cd Multithreaded-Travel-Booking-Website
```
* Build the Docker Image
```commandline/terminal
docker build -t multithreaded-travel-booking-website .
```
* Run the Docker Image
```commandline/terminal
docker run -p 8080:8080 multithreaded-travel-booking-website .
```
* Open your Browser type into the URL
```URL Bar
http://localhost:8080
```