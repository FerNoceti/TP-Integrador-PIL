# TP-Integrador-PIL

-----
## This is not the original repository, this is a fork of the original repository.
### Link to the original repository where the project was developed, and you can see the commits:


`https://github.com/Yuliana-Vargas/TP-Integrador-PIL`

-----

## REST API

The REST API to  app is described below.

---

## CRUD of Recycling Zone

    'http://localhost:8080/recycling-zone'
    
## ***Get list of Recycling zones***

### Request

`GET /recycling-zone`

Bring all the recycling zones

### Response

```json
[
    {
        "id": 1,
        "name": "Zone1",
        "occupationCapacity": "EMPTY",
        "stateOfTheZone": "AVAILABLE",
        "classificationType": "BATTERY_DISPOSAL",
        "needsReclassification": true 
    },
    {
        "id": 2,
        "name": "Zone2",
        "occupationCapacity": "EXCEEDED",
        "stateOfTheZone": "DAMAGED",
        "classificationType": "PAPER_DISPOSAL",
        "needsReclassification": true,
        "supervisor": {
            "id": 3,
            "supervisorName": "Romina"
        },
        "location": {
            "id": 1,
            "department": "Capital",
            "neighborhood": "Alberdi",
            "address": "Sta Fe",
            "number": 159,
            "coordinates": {
                "x": -31.0,
                "y": -64.0
            }
        },
        "complaints": [
            {
                "id": 1,
                "typeOfComplaint": "FOR_MISUSE",
                "description": "improper recycling"
            }
        ]
    }
]
```

## ***Create a new Recycling Zone***

### Request

`POST /recycling-zone`

### Body

```json
{
    "name": "Zone3",
    "occupationCapacity": 3,
    "stateOfTheZone": 0,
    "classificationType": 1,
    "needsReclassification": false,
    "typeOfComplaint": 3,
    "supervisor": {
        "supervisorName": "Paula"
    },
    "location": {
        "department": "a",
        "neighborhood": "b",
        "address": "c",
        "number": 10,
        "coordinates": {
            "x": 13424.1231,
            "y": -231.22
        }
    },
    "complaints": [
            {
                "typeOfComplaint": "ANOTHER_REASON",
                "description": "usually excceded"
            }
        ]
}
```

### Response

```json
{
    "id": 3,
    "name": "Zone3",
    "occupationCapacity": "EXCEEDED",
    "stateOfTheZone": "AVAILABLE",
    "classificationType": "NON_RECYCLABLE_GARBAGE_DISPOSAL",
    "needsReclassification": false,
    "supervisor": {
        "id": 8,
        "supervisorName": "Paula"
    },
    "location": {
        "id": 8,
        "department": "a",
        "neighborhood": "b",
        "address": "c",
        "number": 10,
        "coordinates": {
            "x": 13424.0,
            "y": -231.0
        }
    },
    "complaints": [
        {
            "id": 9,
            "typeOfComplaint": "ANOTHER_REASON",
            "description": "usually excceded"
        }
    ]
}
```

## ***Get a Recycling Zone***

### Request

`GET /recycling-zone/{id}`
`GET /recycling-zone/1`

### Response

```json
{
    "id": 1,
    "name": "Zone1",
    "occupationCapacity": "EMPTY",
    "stateOfTheZone": "AVAILABLE",
    "classificationType": "BATTERY_DISPOSAL",
    "needsReclassification": true 
}
```

## ***Get Complaints of a Recycling Zone***

### Request

`GET /recycling-zone/{id}/complaint`
`GET /recycling-zone/2/complaint`

### Response

```json
[
    {
        "id": 1,
        "typeOfComplaint": "FOR_MISUSE",
        "description": "improper recycling"
    }
]
```

## ***Get Recycling Zone by Supervisor***

### Request

`GET /recycling-zone/supervisor/{id}`
`GET /recycling-zone/supervisor/3`

### Response

```json
{
    "id": 2,
    "name": "Zone2",
    "occupationCapacity": "EXCEEDED",
    "stateOfTheZone": "DAMAGED",
    "classificationType": "PAPER_DISPOSAL",
    "needsReclassification": true,
    "supervisor": {
        "id": 3,
        "supervisorName": "Romina"
    },
    "location": {
        "id": 1,
        "department": "Capital",
        "neighborhood": "Alberdi",
        "address": "Sta Fe",
        "number": 159,
        "coordinates": {
            "x": -31.0,
            "y": -64.0
        }
    },
    "complaints": [
        {
            "id": 1,
            "typeOfComplaint": "FOR_MISUSE",
            "description": "improper recycling"
        }
    ]
}
```

## ***Get Recycling Zone by Department***

### Request

`GET /recycling-zone/location/department/{department}`
`GET /recycling-zone/location/department/Capital`

### Response

```json
[
     {
        "id": 2,
        "name": "Zone2",
        "occupationCapacity": "EXCEEDED",
        "stateOfTheZone": "DAMAGED",
        "classificationType": "PAPER_DISPOSAL",
        "needsReclassification": true,
        "supervisor": {
            "id": 3,
            "supervisorName": "Romina"
        },
        "location": {
            "id": 1,
            "department": "Capital",
            "neighborhood": "Alberdi",
            "address": "Sta Fe",
            "number": 159,
            "coordinates": {
                "x": -31.0,
                "y": -64.0
            }
        },
        "complaints": [
            {
                "id": 1,
                "typeOfComplaint": "FOR_MISUSE",
                "description": "improper recycling"
            }
        ]
    }
]
```

## ***Add a new Complaint in a Recycling Zone***

### Request

`PUT /recycling-zone/{id}/complaint`
`PUT /recycling-zone/2/complaint`

### Body

```json
{
    "typeOfComplaint": "FOR_VANDALISM",
    "description": "container with graffiti"
}
```

### Response

```json
"Complaint added to recycling zone with id 2"
```

## ***Get Recycling Zones by Classification Type***

### Request

`GET /recycling-zone/findByClassificationType?classificationType={classificationType}`
`GET /recycling-zone/findByClassificationType?classificationType=PAPER_DISPOSAL`

### Response

```json
[
    {
        "id": 2,
        "name": "Zone2",
        "occupationCapacity": "EXCEEDED",
        "stateOfTheZone": "DAMAGED",
        "classificationType": "PAPER_DISPOSAL",
        "needsReclassification": true,
        "supervisor": {
            "id": 3,
            "supervisorName": "Romina"
        },
        "location": {
            "id": 1,
            "department": "Capital",
            "neighborhood": "Alberdi",
            "address": "Sta Fe",
            "number": 159,
            "coordinates": {
                "x": -31.0,
                "y": -64.0
            }
        },
        "complaints": [
            {
                "id": 1,
                "typeOfComplaint": "FOR_MISUSE",
                "description": "improper recycling"
            },
            {
                "typeOfComplaint": "FOR_VANDALISM",
                "description": "container with graffiti"
            }
        ]
    }
]
```

## ***Get Recycling Zones by Occupation Capacity***

### Request

`GET /recycling-zone/findByOccupationCapacity?occupationCapacity={occupationCapacity}`
`GET /recycling-zone/findByOccupationCapacity?occupationCapacity=EXCEEDED`

### Response

```json
[
    {
        "id": 2,
        "name": "Zone2",
        "occupationCapacity": "EXCEEDED",
        "stateOfTheZone": "DAMAGED",
        "classificationType": "PAPER_DISPOSAL",
        "needsReclassification": true,
        "supervisor": {
            "id": 3,
            "supervisorName": "Romina"
        },
        "location": {
            "id": 1,
            "department": "Capital",
            "neighborhood": "Alberdi",
            "address": "Sta Fe",
            "number": 159,
            "coordinates": {
                "x": -31.0,
                "y": -64.0
            }
        },
        "complaints": [
            {
                "id": 1,
                "typeOfComplaint": "FOR_MISUSE",
                "description": "improper recycling"
            },
            {
                "typeOfComplaint": "FOR_VANDALISM",
                "description": "container with graffiti"
            }
        ]
    }
]
```

## ***Get Recycling Zones by State Of The Zone***

### Request

`GET /recycling-zone/findByStateOfTheZone?stateOfTheZone={stateOfTheZone}`
`GET /recycling-zone/findByStateOfTheZone?stateOfTheZone=DAMAGED`

### Response

```json
[
    {
        "id": 2,
        "name": "Zone2",
        "occupationCapacity": "EXCEEDED",
        "stateOfTheZone": "DAMAGED",
        "classificationType": "PAPER_DISPOSAL",
        "needsReclassification": true,
        "supervisor": {
            "id": 3,
            "supervisorName": "Romina"
        },
        "location": {
            "id": 1,
            "department": "Capital",
            "neighborhood": "Alberdi",
            "address": "Sta Fe",
            "number": 159,
            "coordinates": {
                "x": -31.0,
                "y": -64.0
            }
        },
        "complaints": [
            {
                "id": 1,
                "typeOfComplaint": "FOR_MISUSE",
                "description": "improper recycling"
            },
            {
                "typeOfComplaint": "FOR_VANDALISM",
                "description": "container with graffiti"
            }
        ]
    }
]
```

## ***Get collection route given a start point***

For example we have the following zones:
* Zone id: 3 with coordinates at Point(17.3, 5.5)
* Zone id: 7 with coordinates at Point(10.5, 24.9)
* Zone id: 11 with coordinates at Point(43.5, 10.7)

But we have to round the coordinates. So then we have:

* Zone id: 3 with coordinates at Point(17, 6)
* Zone id: 7 with coordinates at Point(11, 25)
* Zone id: 11 with coordinates at Point(44, 11)

We want to know the best route to pass through all the zones starting from a point.
In this case the point is going to be (44.3, 24.2). Rounded (44, 24)

Here is an image in order to make it easier to imagine:
![alt text](https://i.imgur.com/Q01PSRo.jpg)

### Request

`GET /recycling-zone/recollection-route/x{x}/y{y}`
`GET /recycling-zone/recollection-route/x44/y24`

### Body

```json
[3, 7, 11]
```

### Response

```json
"Starting from point: (44.0, 24.0) the best route is:\n1?? Zone name: Zone 11, coordinates: (44.0, 11.0).\n2?? Zone name: Zone 3, coordinates: (17.0, 6.0).\n3?? Zone name: Zone 7, coordinates: (11.0, 25.0)."
```

To check that the algorithm works well. You can calculate by yourself each distance and see
And if you want to see the algorithm go to `src\main\java\com\pil\group4\utilities\BestRoute.java`

## ***Update a Recycling Zone***

### Request

`PUT /recycling-zone/{id}`
`PUT /recycling-zone/1`

### Body

```json
{
    "name": "zona3 edited"
}
```

### Response

```json
{
    "id": 3,
    "name": "zona3 edited",
    "occupationCapacity": "EXCEEDED",
    "stateOfTheZone": "AVAILABLE",
    "classificationType": "NON_RECYCLABLE_GARBAGE_DISPOSAL",
    "needsReclassification": false,
    "supervisor": {
        "id": 8,
        "supervisorName": "Paula"
    },
    "location": {
        "id": 8,
        "department": "a",
        "neighborhood": "b",
        "address": "c",
        "number": 10,
        "coordinates": {
            "x": 13424.0,
            "y": -231.0
        }
    },
    "complaints": [
        {
            "id": 9,
            "typeOfComplaint": "ANOTHER_REASON",
            "description": "usually excceded"
        }
    ]
}
```

## ***Delete a Recycling Zone***

### Request

`DELETE /recycling-zone/{id}`
`DELETE /recycling-zone/1`

### Response

```json
"The Recycling Zone with id: 1, was removed"
```

## ***Delete All Complaints***

### Request

`DELETE /recycling-zone/{id}/complaint`
`DELETE /recycling-zone/5/complaint`

### Response

```json
"Complaints deleted from recycling zone with id 5"
```

## ***Delete Supervisor***

### Request

`DELETE /recycling-zone/{id}/supervisor/{idSupervisor}`
`DELETE /recycling-zone/1/supervisor/1`

### Response

```json
"Supervisor with id 1 deleted from recycling zone with id 1"
```

---

## CRUD of Supervisor

    'http://localhost:8080/supervisor'

## ***Get list of Supervisors***

### Request

`GET /supervisor`

Bring all the supervisors

### Response

```json
[
    {
        "id": 1,
        "supervisorName": "maria"
    },
    {
        "id": 2,
        "supervisorName": "juan"
    },
    {
        "id": 3,
        "supervisorName": "diego"
    },
    {
        "id": 4,
        "supervisorName": "camila"
    }
]
```
## ***Create a new Supervisor***

### Request

`POST /supervisor`

### Body

```json
{
  "supervisorName": "esteban"
}
```

### Response

```json
{
  "id": 5,
  "supervisorName": "esteban"
}
```

## ***Get a Supervisor***

### Request

`GET /supervisor/{id}`
`GET /supervisor/1`

### Response

```json
{
"id": 1,
"supervisorName": "maria"
}
```

## ***Update a Supervisor***

### Request

`PUT /supervisor/{id}`
`PUT /supervisor/1`

### Body

```json
{
  "supervisorName": "laura"
}
```


### Response

```json
{
  "id": 1,
  "supervisorName": "laura"
}
```

## ***Delete a Supervisor***

### Request

`DELETE /supervisor/{id}`
`DELETE /supervisor/1`

### Response

```json
"The Supervisor with the id: 1, was removed"
```

---

## CRUD of Location

    'http://localhost:8080/location'

## ***Get list of Locations***
    
### Request

`GET /location`

Bring all the locations

### Response

```json
[
 {
    "id": 1,
    "department": "a",
    "neighborhood": "b",
    "address": "c",
    "number": 1,
    "coordinates": {
      "x": 13424,
      "y": -231
    }
  }
]
```

## ***Create a new Location***

### Request

`POST /location`

### Body

```json
{
  "department": "Department",
  "neighborhood": "The Neighborhood",
  "address": "Address",
  "number": 120,
  "coordinates": {
    "x": 200,
    "y": 200
  }
}
```

### Response

```json
{
  "id": 1,
  "department": "Capital",
  "neighborhood": "Centro",
  "address": "Montevideo",
  "number": 123,
  "coordinates": {
    "x": -314216005,
    "y": -641907307
  }
}
```

## ***Get a Location***

### Request

`GET /location/{id}`
`GET /location/1`

### Response

```json
{
  "id": 1,
  "department": "Capital",
  "neighborhood": "Centro",
  "address": "Montevideo",
  "number": 123,
  "coordinates": {
    "x": -314216005,
    "y": -641907307
  }
}
```

## ***Update a Location***

### Request

`PUT /location/{id}`
`PUT /location/1`

### Body

```json
{
  "department": "New Capital",
  "neighborhood": "Alberdi",
  "address": "Arturo Orgaz",
  "number": 510,
  "coordinates": {
    "x": -314033216, 
    "y": -642089571
  }
}
```

### Response

```json
{
  "id": 1,
  "department": "New Capital",
  "neighborhood": "Alberdi",
  "address": "Arturo Orgaz",
  "number": 510,
  "coordinates": {
    "x": -314033216,
    "y": -642089571
  }
}
```

## ***Delete a Location***

### Request

`DELETE /location/{id}`
`DELETE /location/1`

### Response

```json
"The Location with the id: 1, was removed"    
```

---

## CRUD of Complaints

    'http://localhost:8080/complaint'

## ***Get list of Complaints***

### Request

`GET /complaint`

Bring all the complaints

### Response

```json
[
    {
        "id": 1,
        "typeOfComplaint": "FOR_MISUSE",
        "description": "improper recycling"
    },
    {
        "id": 2,
        "typeOfComplaint": "FOR_VANDALISM",
        "description": "broken"
    }
]
```
## ***Create a new Complaint***

### Request

`POST /complaint`

### Body

```json
{
    "typeOfComplaint": "ANOTHER_REASON",
    "description": "always full"
}
```

### Response

```json
{
    "id": 3,
    "typeOfComplaint": "ANOTHER_REASON",
    "description": "always full"
}
```

## ***Get a Complaint***

### Request

`GET /complaint/{id}`
`GET /complaint/1`

### Response

```json
{
    "id": 1,
    "typeOfComplaint": "FOR_MISUSE",
    "description": "improper recycling"
}
```

## ***Update a Complaint***

### Request

`PUT /complaint/{id}`
`PUT /complaint/2`

### Body

```json
{
    "typeOfComplaint": "FOR_VANDALISM",
    "description": "broken container"
}
```


### Response

```json
{
    "id": 2,
    "typeOfComplaint": "FOR_VANDALISM",
    "description": "broken container"
}
```

## ***Delete a Complaint***

### Request

`DELETE /complaint/{id}`
`DELETE /complaint/1`

### Response

```json
"The Complaint with id: 1, was removed"
```

---

## CRUD of Idea

    'http://localhost:8080/idea'

## ***Get list of Ideas***

### Request

`GET /idea`

Bring all the ideas

### Response

```json
[
    {
        "id": 1,
        "ideaName": "botle",
        "description": "collect bottles"
    },
    {
        "id": 3,
        "ideaName": "botle",
        "description": "decorate with plastic bottles"
    },
    {
        "id": 4,
        "ideaName": "paper",
        "description": "decorations with paper"
    }
]
```
## ***Create a new Idea***

### Request

`POST /idea`

### Body

```json
{
    "ideaName":"glass",
    "description":"make glass cups"
}
```

### Response

```json
{
    "id": 5,
    "ideaName": "glass",
    "description": "make glass cups"
}
```

## ***Get a Idea***

### Request

`GET /idea/{id}`
`GET /idea/5`

### Response

```json
{
    "id": 5,
    "ideaName": "glass",
    "description": "make glass cups"
}
```

## ***Update a Idea***

### Request

`PUT /idea/{id}`
`PUT /idea/3`

### Body

```json
{
    "ideaName": "plastic",
    "description": "decorate with plastic bottles"
 }
```


### Response

```json
{
    "id": 3,
    "ideaName": "plastic",
    "description": "decorate with plastic bottles"
}
```

## ***Delete a Idea***

### Request

`DELETE /idea/{id}`
`DELETE /idea/5`

### Response

```json
"The Idea with id: 5, was removed"
```

---

## Authors

[<img src="https://avatars.githubusercontent.com/u/81372862?v=4" width=115><br><sub>Fernando Jos?? Noceti</sub>](https://github.com/FerNoceti) |  [<img src="https://avatars.githubusercontent.com/u/101755881?v=4" width=115><br><sub>Milena Mu??oz</sub>](https://github.com/milemunoz10) |  [<img src="https://avatars.githubusercontent.com/u/101777026?v=4" width=115><br><sub>Martin Maciel</sub>](https://github.com/MartinMaciel110916) |  [<img src="https://avatars.githubusercontent.com/u/72422271?v=4" width=115><br><sub>Yuliana Vargas</sub>](https://github.com/Yuliana-Vargas) |
| :---: | :---: | :---: | :---: |
