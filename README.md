# Points

Hello! This is a backend project for handling web service requests for a database storing user points.

## Requirements
JDK 11 
Any Maven compatible IDE (I personally used IntelliJ)
Any API platform (I personally used Postman with the Desktop Client installed.)

## Set Up
Download all files directly from the Points folder. Open your IDE and open the Points/Points folder as a project(C:\Users\YourUserName\PointsProject\Points\Points).
This project utilizes SpringBoot, so there shouldn't be any extra configuration or coding needed on your end. All information is stored in an in memory database, 
so stopping the Application **will delete the database & any changes you made**. The database doesn't initially contain any information; so you'll have to supply some via API calls.

## Classes
A breakdown of each class used in this project.
 - PointsApplication : Handles running/start up of the application.
 - Transaction : An Entity class that represents objects in the database.
 - TransactionController : A Controller class that exposes API points & allows users to modify the database.
 
## Start Up
Use you IDE's [Run] command to start the project. As long as there is an active internet connection + the port being used isn't blocked, the project should run fine.
Also start up your API platform of choice.
Within the Console Log you'll need to find out what port the Tomcat server is running on. You should try to find a message that says;
' Tomcat started on port(s): #### (http) with context path '' '
The four numbers are the port the localhost is running from, which you'll need for the URL to make API calls from. Copy the numbers into this URL
http://localhost:####/
And save it to use in your API platform.

## The Controller
All basic CRUD methods are implemented & can be used to access & modify the database. The database doesn't have any data in it initially, so you'll have to use the POST
request to populate it with some data. All HTTP requests must be in JSON format & dates must be in the "yyyy-mm-dd" format.
All requests run off the http://localhost:####/ URL. To access specific resources you'll need to add the mapped keyword to the URL.
For example, to get all Transactions you can submit a GET request to http://localhost:####/transactions.
Here's a list of methods you can utilize.

GET

"/transactions"
getAllTransactions()
Returns every single transaction in the database.

"transaction/{id}"
getTransactionByID(int id)
Returns a single transaction with the same ID specified in the URL. 
An example JSON request; {"id": "3"}

"/payer/{name}"
getTransactionsByPayerName(String name)
Retrieves all transactions in the database that belong to the payer specified in the URL.
An example JSON request; {"payer": "MILLIE"}

PUT

"/transaction"
addNewTransaction(Transaction newTransaction)
Adds a new transaction [newTransaction] to the database. If the transaction already exists, it's updated. When adding a new transaction, the ID does not need to be specified as it's
automatically added by the database.
An example JSON request; {"payer": "Mills", "points": "200", "timestamp": "2021-11-03"}

"/transactions/pointsupdate"
addPoints(int transactionId, int points)
Adds [points] to a single Transaction that has the [transactionId].
An example JSON request; {"transactionId": "2", "points": 200}

POST

"/transactions"
addAllTransactions(List<Transaction> newTransactions)
Adds a list of transactions [List<Transaction>] to the database. IDs do not need to be specified as the database automatically adds them.
An example JSON request; 
[
{"payer": "Mills", "points": "200", "timestamp": "2021-11-03"}, {"payer": "Mills", "points": "500", "timestamp": "2020-11-03"}, {"payer": "Millie", "points": "300", "timestamp": "2021-11-03"}
]

"/transactions/pointsupdate/remove"
removePoints(int points)
Removed points from all Transactions in the database, starting with the oldest transaction first. If there are no more points to subtract, the method stops subtracting.
Returns a list of modified transactions.
An example JSON request; {"points": -500}

DELETE

"/transaction/{id}"
deleteTransactionById(int id)
Deletes a single Transaction that has the ID [id].
An example JSON request; {"id": 30}

"/transaction"
deleteTransaction(String oldPayer,LocalDate oldTimestamp)
Deletes a transaction with the Payer name matching [oldPayer] with the timestamp [oldTimestamp].
An example JSON request; {"payer": "Maya", "timestamp": "2020-04-02"}
