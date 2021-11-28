# ZendeskTicketViewer
Zendesk 2022 Summer Internship Coding Challenge.

## Installation & Usage Instruction
1. Download the code as Zip file or using git clone to your local file system.
2. Open the project with IntelliJ IDEA, or you could use terminal to locate and go to the directory.
3. Let IntelliJ IDEA to load the dependencies of the Back-End or you could manually use **mvn install** in terminal.
4. Go to the Front-End directory under src\main\frontend in terminal, and run **npm install** to install all Front-End packages.
5. Fill your own data to the **"subdomain", "email", "password"** in \src\main\resources\config.properties before start the server, otherwise you won't able to get any data from Zendesk server.
6. Start the Back-End server by click the Run button of IntelliJ IDEA at src\main\java\ZendeskTicketViewerApplication.java, or you could use terminal command **mvn spring-boot:run**.
7. Start the Front-End webapp using command **npm start** under src\main\frontend 

## Demo ScreenShot
### Home Page: 
![image](https://user-images.githubusercontent.com/62904466/143723504-20361c93-50cc-4781-822a-630ac1b2d305.png)
### View All Tickets(By clicking the button at Home page):
![image](https://user-images.githubusercontent.com/62904466/143723537-6c19d091-22cf-43f2-a8c8-a600ee0e6e3e.png)
### Pagination at the bottom of the page: 
![image](https://user-images.githubusercontent.com/62904466/143723593-6c582ab0-d873-404c-8879-c3be6d0a490f.png)
The default tickets amount to trigger the pagination was set to 25 tickets, you can switch that number to 10 or 50 :
![WeChat Screenshot_20211127154703](https://user-images.githubusercontent.com/62904466/143723662-3ed29d3f-6da1-45c5-bd68-f8516324bc78.png)
<br />E.g. switch to 10 tickets per page:
![image](https://user-images.githubusercontent.com/62904466/143723676-a3627623-e838-43d4-a0a8-d826c391b5f8.png)
### Ticket Detail Page:
![image](https://user-images.githubusercontent.com/62904466/143723688-7bbe8180-c357-469a-be58-52ec38ad3558.png)
By Clicking the "Back-Arrow" button at the top left corner, you will be able to back to the tickets list page.

## Features
- Connect to the Zendesk API
- Get and present all tickets from some Zendesk account in a list(table), with "Status", "Subject", "Requester ID", "Requested"(Date), "Tags", "Priority" as properties.
- Pagination the list(table) if the total number of tickets is above 25
- By clicking one specific ticket subject in the list(table), the program will get and display specific ticket detail("Subject", "Requested"(Date), "Requester ID", "Tags", "Ticket ID", "Ticket Description", "Status") in one page.

## Project Structure
- Back-End: Spring Boot
- Front-End: React.js

![image](https://user-images.githubusercontent.com/62904466/143723148-7cd46c88-3795-499d-b122-0f4e790b36ab.png)
