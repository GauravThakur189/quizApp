Quiz Application Backend

This is the backend implementation of a quiz application. It is built using Spring Boot and uses an H2 in-memory database for simplicity. The application supports the following functionalities:

Start a new quiz session.

Get a random multiple-choice question from the database.

Submit an answer and validate it.

Retrieve the user's quiz statistics (total questions answered, correct answers, and incorrect answers).

Technologies Used

Java

Spring Boot

H2 Database

Maven

Assumptions

The database is pre-seeded with a single user and some quiz questions using a DataSeeder class.

Each question has a correct answer, which is validated during the quiz.

User sessions are simplified, and the same user is used for all interactions.

APIs

1. Start Quiz Session

Endpoint: POST /api/quiz/start

Starts a new quiz session for the user. Resets the user's statistics.

Response:

{
  "message": "Quiz session started!"
}

2. Get Random Question

Endpoint: GET /api/quiz/question

Fetches a random question from the database.

Response:

{
  "id": 1,
  "text": "What is 2+2?",
  "optionA": "1",
  "optionB": "3",
  "optionC": "4",
  "optionD": "5"
}

3. Submit Answer

Endpoint: POST /api/quiz/validate?questionId={id}&selectedOption={option}

Validates the user's answer to the given question.

Response:

For a correct answer:

{
  "message": "Correct answer!"
}

For an incorrect answer:

{
  "message": "Incorrect answer."
}

4. Get User Stats

Endpoint: GET /api/quiz/stats

Retrieves the user's quiz statistics.

Response:

{
  "totalQuestions": 5,
  "correctAnswers": 3,
  "incorrectAnswers": 2
}

Database

The application uses an H2 in-memory database. The DataSeeder class pre-seeds the database with the following data:

User

ID

Name

1

Test User

Questions

ID

Text

OptionA

OptionB

OptionC

OptionD

Correct Answer

1

What is 2+2?

3

4

5

6

4

2

Which language is used for Android?

Java

Python

C++

Swift

Java

Steps to Run the Application

Clone the repository.

Navigate to the project directory.

Run mvn spring-boot:run to start the application.

Access the APIs via Postman or any other API client.

Notes

H2 database console can be accessed at http://localhost:8080/h2-console (default username: sa, password: empty).

All seed data will reset when the application restarts, as H2 is an in-memory database.

Future Enhancements:

Adding authentication to support multiple users.

Enhancing question categorization and difficulty levels.

Adding a leaderboard feature for user rankings.

