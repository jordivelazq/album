# Test project for IES Systems

## Install

    mvn install

## Run the app

    mvn spring-boot:run

# REST API

## Create an album

### Request

`POST /album`

    curl --location 'http://localhost:8080/album' \ --header 'Content-Type: application/json' \ --data '{"name": "Album"}'

### Response

    HTTP/1.1 200 Ok

    {"id":1,"name":"Album","creationDate":"2023-08-04T04:42:54.907+00:00"}

## Delete an album

### Request

`DELETE /album/id`

    curl --location --request DELETE 'http://localhost:8080/album/1' \ --header 'Content-Type: application/json'

### Response

    HTTP/1.1 200 OK

    {"Deleted":true}

## Insert a photo into an album

### Request

`POST /photo/album/id`

    curl --location 'http://localhost:8080/photo/album/1' --header 'Content-Type: application/json' --data '{
	    "url": "/home/photo",
      "description": "test"
    }'

### Response

    HTTP/1.1 200 Ok

    {
    "id": 1,
    "album": 1,
    "url": "/home/photo",
    "description": "test",
    "creationDate": "2023-08-04T04:43:17.490+00:00"
    }
