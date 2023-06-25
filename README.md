# Server and Application Information Management

### Key features:
- Server management: Logging information such as IP, name, memory, disk, processor, location, and operating system.
- Application management: Registration of applications associated to the servers with name and version.
- RESTful API: Endpoints for CRUD operations on servers and applications.
- Security: HTTP Basic authentication with "User" and "Admin" roles to control access.


### Json request structures:
#### Server creation:

```
{
    "ip": "192.xxx.x.x",
    "name": "server name",
    "memory":"10GB",
    "disk":"100GB",
    "processor":"x processor",
    "location":"x location",
    "operatingSystem" : "Windows"
}
```

#### Application creation:

```
{
    "name": "name",
    "version": "1.x.x",
    "server": {
        "id": server_id
    }
}
```

### Roles and protected routes: 

Roles: 
```
  username: "user"
  password: "password"
```
```
  username: "admin"
  password: "password"
```
The user "user" has read-only permissions on the following paths:

    GET /api/v1/servers
    GET /api/v1/serversWithMultipleApplications
    GET /api/v1/servers/{id}

The user "admin" has read and write permissions on the following paths:

    GET /api/v1/servers
    GET /api/v1/serversWithMultipleApplications
    GET /api/v1/servers/{id} 
    GET /api/v1/servers/{id}
    POST /api/v1/servers
    DELETE /api/v1/servers/{id}
    PUT /api/v1/servers/{id}



### URL endpints:
![endpoints](https://lh3.googleusercontent.com/fife/APg5EOYsfvpg0iEvXCnJF9o9x1sk8WGv9edWyMEk_GveKmw3BLRa59juy-DFfrXeNrDcIcy0lDbtxMPvn6gXai-KI-Au9vTNUajMc_WOIGcWZ5l_1WDixfaXaE9Qb3JxJgTpa5FJaDFK_f9AZlOGG8nBXunvo8T0YVKSFw-QL3NZZqR2DBH0WzXV9lFtDgKnBtrUY6_Tao1O8rblRu7-NuThm6L7JC91Jp7YO3yUVOHg0IVPXdbPeaWXv2KfNy__qrd4HPSJf_Io5-o6B-XLYUvDmP5PgUbZUgF-KpjxUWnF9fQB1zpA5Nbuzl6F9G8fUYpt3aYYjRGNtaZYn4zt1Hid1LkAMIJ2gsLkc1xQp0rTDBHVsmkUeJUwq1XBm6X9xchh42xp6R-lfA8EEMQ0RFhA8MK5Z21lRhB6W6Wi_oT074HloVXxtJ0-R7QzIg5EyEHEZbP1fdByp5fuuG7E1wHsomriipIo1BB0FBDlTJiBi2iJXPAOftRgWCMAk2T4bX7NjxK0OaaJOm5LPlZrvGFCQFLRRUFfLZ3LDnkU8FGBcD0FOaEFRwwqnclk8Vm8eC4kqRned04IbP1rPMeL1mtbjjIIGuFZMzWxQuLjOKMif9O9JVm-yDFC50l-iqg5Tj5Yo5bb5zyLvCbEQYjA6n1LrmITN1CI6jHCW4Vey9D0u01YcdaQPWtz8b1L847HV_hdk4r8Jhs99Ue6OWbBwiEBPP4Cma742VBK9V9azIJUZUvyfc8KcKb8-2UycUcHGjYtgl4Kyb7MFHQ14DKru-gcEmgN3acK3qQ5yrvf0HDto6O-NZVI9kNl7oOBlBz7F2IS16eXaE3zKmxd2-mjBhWs4v20I1jmbu67Xo0zMgxsWDKvfFKwHYfCXROcCqStsBvyghFeYwOnC6vKvo7_7FBa6oSzNHJiuEiHhXGqtx0LppNTxVLp__8MhiOswUImKU37FCst1RRUvjIGSfbZW7YeLDXAjiM0WYwef13DYLud0sWAdqbJNjdsCSo7klFWUgrnSIZaLhK65NnQNA1xB75GG4LYd5nK8GHu9pg0v6bBBhvaoQjrp_tvoST7_IC4O3itJCaQJLkgqbZQp9Mt5LO84SWsiK2HdzjGhZjUGV1JmB2JtoTNN9kVo-xksAWJFxPuH686iwUKqWEKAP4q92lkkOl88IZOB2RedawCBl9zQKOQs9_PkrBEl-HmEbye9IYcxFZKt9TEyOp0JPD7xcHDAgwX3dNM3jqBGt-gCSzUicSJcf5eT0fsduoRS3xrIKjdEg7Civ4eEM1IOHJ8UAIUz01q5pkqCMSRWdz92NSw9kEg4CEXynmhbinZH_yilIbXSeQZWpvSP1oHZSbn2BKdnXr3R2FT4BK-4ymMe4LgILyxSGzGXLohybrHc550V9TCrGFNJ4qo1wEslmHwJQcWCBDAOxNVItgouDXWp9fsJOYMYnEhnri8J2FS71rbOga1GTpMigE8pj1ErxG5hVDXSjeuQz1jmiG2MYAKIBBx45PKcdo-VEfcebbCFxCbMOQz-jI5-q4343z4W1nOv4Y9rHKloG6U8sdvmjBnZhlSSI4cZkxhRVEPGv46PpMylvgBFFYKStCRLh23RngEqQFucA=w1366-h683)



