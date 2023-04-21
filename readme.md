Получение REST запроса с пользовательскими данными как триггер для старта процесса
1. REST API клиент, например Postman, выполняет POST-запрос
   
    http://localhost:8080/engine-rest/process-definition/key/registration/submit-form

   Содержащий данные о пользователе - почту и пароль    

    Headers:
        Content-Type: application/json

    Body:
       (raw)
   {
   "variables": {
   "email":{"value":"userEmail","type":"String"},
   "password":{"value":"userPassword","type":"String"}
   }
   }
![img.png](img.png)
![img_1.png](img_1.png)