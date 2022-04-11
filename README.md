# Judicial Records Manager

This is the API responsible for simulating the situation where a person has any judicial record assigned to it. It is a cloud native api and is currently deployed on Heroku. The complete documentation was defined according to Open API documentation:
https://aw-judicial-records-api.herokuapp.com/swagger-ui/index.html

# JudicialRecordsManager deployment process to Heroku

The JudicialRecordsManager was deployed to Heroku according to the following steps:

The cloud provider chosen is Heroku because its configurattion its simple and with not cost. The database chosen is Postgresql because it's provided as default database.
However we have to change some implementation details on our entities classes and the application.yaml file to allow a correct integration between our application and Postgresql service provided by Heroku.

# Changes applied to entities classes:

Since Postgresql doesn't have the auto increment concept, we need to define the GenericGenerator that will get the latest index and increment it by 1. The example is displayed below:
```package com.addi.challenge.externalsystem.judicialrecordssystem.judicialrecordsmanager.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="JUDICIALRECORD")
@Getter
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class JudicialRecord {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    private String nationalIdentificationNumber;
}
```

# Changes applied to application.yaml

```
spring:
  jpa:
    show-sql: true
    generate-ddl: true
  datasource:
    url: ${JDBC_DATASOURCE_URL}
    
 ```
 
 # Steps to deploy "JudicialRecordsManager" to Heroku.

1- Create a Heroku account by going to:
```
https://dashboard.heroku.com/apps
```

2- Push all your code to github repository;

3- Login to Heroku:
```
heroku login
```

4- Create a new app at Heroku environment:

```
heroku create aw-judicial-records-api
```

5- Assign a Postgresql database to your app
```
heroku addons:create heroku-postgresql:hobby-dev
```

6- Push your application to Heroku repository
```
git push heroku main
```

7- In case you want to check the logs, type:
```
heroku logs --tail
```

8- In order to open your Heroku app, type:
```
heroku open
```

