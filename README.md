
# Footballer guesser service

This is a Spring appplication created to manage the data needed to use the football guesser mobile app.


## Features

- Downloading and updating players' data from an external api,
- Possibility to receive player data depending on their league,
- URL addresses for pictures of club logos and flags of the countries for which players play,
- Ability to create and log in to user accounts,
- The ability to add and get users' scores,
- Data stored in a MySQL database.


## API Reference

### Authentication

#### Register

```http
  POST /register
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. Player username. Cannot be taken.|
| `email`      | `string` | **Required**. Player email. Cannot be taken. |
| `password`      | `string` | **Required**. Player password. Has to be longer than 6 characters. |

#### Login

```http
  POST /login
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `string` | **Required**. Email of account you want to sign in.|
| `password`      | `string` | **Required**. Password of account you want to sign in.|

### Leagues

#### Get all leauges

```http
  GET /leagues
```

### Footballers

#### Get players in league

```http
  GET /league/{leagueId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `leagueId` | `int` | **Required**. Id of league. |

### Scores

#### Create new score

```http
  POST /scores
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Id of player whose score it is. |
| `leagueId`      | `int` | **Required**. Id of league. |
| `points`      | `int` | **Required**. Score points. |

#### Get scores
```http
  GET /scores
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `time`      | `string` | The time period from which the results are. Can be "weekly" or "monthly".|
| `leagueId`      | `int` | Id of league from which the results are. |

## Related

Here are some related projects

[Footballer Guesser Android Application](https://github.com/GucioWons/footballer-guesser-app)

