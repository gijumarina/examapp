# mvn clean compile
# mvn install
# mvn spring-boot:run
## SWAGGER: http://localhost:8080/swagger-ui/index.html

## TEST CREATION EXAMPLE
<pre>
{
  "groupId": 1,
  "teacherId": 1,
  "minRequired": 5,
  "questions": [
    {
      "text": "Question1",
      "type": "MULTIPLE_CHOICE",
      "score": 3,
      "answers": [
        {
          "text": "Answer1",
          "correct": true
        },
        {
          "text": "Answer2",
          "correct": false
        }
      ]
    },
    {
      "text": "Question2",
      "type": "MULTIPLE_ANSWERS",
      "score": 3,
      "answers": [
        {
          "text": "Answer1",
          "correct": true
        },
       {
          "text": "Answer2",
          "correct": true
        },
       {
          "text": "Answer3",
          "correct": false
        }
      ]
    },
    {
      "text": "string",
      "type": "OPEN_ANSWER",
      "score": 3,
      "answers": [
        {
          "text": "",
          "correct": true
        }
      ]
    }
  ]
}
</pre>


## RESULT CREATION EXAMPLE
<pre>
{
  "studentId": ID_FROM_DATABASE,
  "testId": ID_FROM_DATABASE,
  "testAnswers": [
    {
      "questionId": ID_FROM_DATABASE,
      "answersIds": [
        ID_FROM_DATABASE_1, ID_FROM_DATABASE_2, ETC
      ]
    },
    {
      "questionId": ID_FROM_DATABASE,
      "answersIds": [
        ID_FROM_DATABASE_1, ID_FROM_DATABASE_2, ETC
      ]
    },
    {
      "questionId": ID_FROM_DATABASE,
      "answersIds": [
        
      ]
    }
  ]
}
</pre>

## CREATE USER EXAMPLE
<pre>
{
  "userType": "STUDENT",
  "firstName": "Student1",
  "lastName": "Student1",
  "age": 21,
  "groupId": 102,
  "cnp": "123456789012",
  "email": "student1@test.com",
  "password": "student1"
}
</pre>


## LOGIN USER EXAMPLE
<pre>
{
  "password": "student1",
  "type": "STUDENT",
  "email": "student1@test.com"
}
</pre>