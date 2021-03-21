[TOC]

# Account Management

### 1.1 Register

#### Description

create a new account

#### Method

POST

#### URL

127.0.0.1:8080/register **or** localhost:8080/register

#### Header

Content-Type: application/json

#### Body

```kotlin
{
    "username": "xixi", 
    "password": "1234", 
    "dateOfBirth":"2000-04-30", 
    "sex":"true"
}
```

#### Response

```kotlin
{
    "msg": "successfully registered"
}
```

```kotlin
{
    "msg": "empty username or password"
}
```

```kotlin
{
    "msg": "username already exists"
}
```















