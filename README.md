## _MASTERCARD CODE CHALLENGE_
### Problem Statement : 
Create a spring boot application that determines if two cities are connected or not. Two cities are considered connected if there’s a series of roads that can be travelled from one city to another.
##### Given - 
The comma-separated file i.e "city.txt" containing the list of connected cities.

##### Expectations -

   - "http://localhost:8080/connected?origin=city1&destination=city2" this endpoint should print **"yes"** or **"no"** based on the connection cities persist.
   
   -  Any unexpected input should result in a **"no"** as a response. **Ex.** - If the content of the comma-separated file is -
   `Boston, New York
      Philadelphia, Newark
      Newark, Boston 
     Trenton, Albany` then "http://localhost:8080/connected?origin=Boston&destination=Newark" should return **"yes"** &
"http://localhost:8080/connected?origin=Philadelphia&destination=Albany" should return **"no"**


### Solution : 
##### Approach -
  - Read the data from the file i.e "city.txt".
  - Parsed the data the file into java objects.
  - Created a **GET** endpoint that takes 2 query parameter origin and destination cities and responds with either **"yes"** or **"no"**.
##### Prerequisites -
  - JDK 1.8 or higher
  - Intellij IDE
  - Maven latest
##### Steps to run the Application -
  - Clone the github repository with command `git clone <REPO_URL>`
  - Open the cloned folder in intellij.
  - Inside intellij: **Edit configuration** --> **add new maven configuration** --> write `spring-boot:run` in command line agrument.
  - Or you can just run `mvn clean install` and `mvn spring-boot:run` in terminal.
  - Then hit the endpoint "http://localhost:8080/connected?origin=city1&destination=city2" in the browser.
  
### Outputs : 
  - Case 1 Output (Where origin=Boston, destination=Philadelphia)
  
  ![Screenshot](positive_response.png)
  
 - Case 2 Output (Where origin=Newark, destination=Albany)
 
  ![Screenshot](negative_response.png)