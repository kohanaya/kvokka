- Update all dependencies: `ncu -u`


GET http://localhost:8080/api/profile
{
"username": "admin",
"password": "qwerty123"
}

```json
{
    "id": 1,
    "fullName": "John Johnson",
    "username": "admin",
    "createdAt": "2021-12-13T01:39:37Z",
    "enabled": true,
    "authorities": [
        {
            "authority": "ROLE_USER"
        }
    ],
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true
}
```

POST http://localhost:8080/login

