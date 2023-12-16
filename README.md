# mvn clean compile
# mvn install
# mvn spring-boot:run
## SWAGGER: http://localhost:8080/swagger-ui/index.html

## TEST CREATION EXAMPLE
<pre>
{ <br />
  "groupId": 1, <br />
  "teacherId": 1, <br />
  "minRequired": 5, <br />
  "questions": [ <br />
    { <br />
      "text": "Question1", <br />
      "type": "MULTIPLE_CHOICE", <br />
      "score": 3, <br />
      "answers": [ <br />
        { <br />
          "text": "Answer1", <br />
          "correct": true <br />
        }, <br />
        { <br />
          "text": "Answer2", <br />
          "correct": false <br />
        } <br />
      ] <br />
    }, <br />
    { <br />
      "text": "Question2", <br />
      "type": "MULTIPLE_ANSWERS", <br />
      "score": 3, <br />
      "answers": [ <br />
        { <br />
          "text": "Answer1", <br />
          "correct": true <br />
        }, <br />
       { <br />
          "text": "Answer2", <br />
          "correct": true <br />
        }, <br />
       { <br />
          "text": "Answer3", <br />
          "correct": false <br />
        } <br />
      ] <br />
    }, <br />
    { <br />
      "text": "string", <br />
      "type": "OPEN_ANSWER", <br />
      "score": 3, <br />
      "answers": [ <br />
        { <br />
          "text": "", <br />
          "correct": true <br />
        } <br />
      ] <br />
    } <br />
  ] <br />
} <br />
</pre>


## RESULT CREATION EXAMPLE
<pre>
{ <br />
  "studentId": ID_FROM_DATABASE, <br />
  "testId": ID_FROM_DATABASE, <br />
  "testAnswers": [ <br />
    { <br />
      "questionId": ID_FROM_DATABASE, <br />
      "answersIds": [ <br />
        ID_FROM_DATABASE_1, ID_FROM_DATABASE_2, ETC <br />
      ] <br />
    }, <br />
    { <br />
      "questionId": ID_FROM_DATABASE, <br />
      "answersIds": [ <br />
        ID_FROM_DATABASE_1, ID_FROM_DATABASE_2, ETC <br />
      ] <br />
    }, <br />
    { <br />
      "questionId": ID_FROM_DATABASE, <br />
      "answersIds": [ <br />
        
      ] <br />
    } <br />
  ] <br />
}
</pre>