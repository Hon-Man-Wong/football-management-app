# Football Manager

Welcome to the Football Manager! This application allows you to manage a football team, track
players, matches, and more. Whether you're a football enthusiast or a team manager, this application will help you stay
organized and keep track of all the important details.

## Table of Contents

- [Getting started](#getting-started)

- [Matches](#matches)
    - [Get All Matches](#get-all-matches)
    - [Get Matches by Team ID](#get-matches-by-team-id)
    - [Add a New Match](#add-a-new-match)
    - [Update Match by ID](#update-match-by-id)
    - [Delete Match by ID](#delete-match-by-id)

- [Teams](#teams)
    - [Get All Teams](#get-all-teams)
    - [Get Team by ID](#get-team-by-id)
    - [Get Players by Team ID](#get-players-by-team-id)
    - [Add a New Team](#add-a-new-team)
    - [Update Team by ID](#update-team-by-id)
    - [Delete Team by ID](#delete-team-by-id)

- [Players](#players)
    - [Get All Players](#get-all-players)
    - [Get Player by ID](#get-player-by-id)
    - [Add a New Player](#add-a-new-player)
    - [Update Player by ID](#update-player-by-id)
    - [Delete Player by ID](#delete-player-by-id)

- [Events](#events)
    - [Get All Events](#get-all-events)
    - [Get Events by Match ID](#get-events-by-match-id)
    - [Add a New Event](#add-a-new-event)
    - [Update Event by ID](#update-event-by-id)
    - [Delete Event by ID](#delete-event-by-id)

- [Enumerations](#enumerations)
    - [Get All Leagues](#get-all-leagues)
    - [Get All Countries](#get-all-countries)
    - [Get All Positions](#get-all-positions)

## Getting started

Create a new docker instance with "docker run -d --name football-app -e POSTGRES_USER=postgres -e
POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -p 5432:5432 postgres:13-alpine"

## Endpoints

## Players

### Get All Players

- **Endpoint:** `GET /players`
- **Description:** Retrieve a list of all players.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing player information.

### Get Player by ID

- **Endpoint:** `GET /players/{playerId}`
- **Description:** Retrieve information about a specific player by their ID.
- **Path Parameters:**
    - `playerId` (integer): The unique identifier of the player to retrieve.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing player information.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Player with the specified ID not found.

### Add a New Player

- **Endpoint:** `POST /players`
- **Description:** Add a new player to the database.
- **Request Body:** A JSON object containing player information to be added.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the newly added player's information.

### Update Player by ID

- **Endpoint:** `PUT /players/{playerId}`
- **Description:** Update information about a specific player by their ID.
- **Path Parameters:**
    - `playerId` (integer): The unique identifier of the player to update.
- **Request Body:** A JSON object containing the updated player information.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the updated player's information.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Player with the specified ID not found.

### Delete Player by ID

- **Endpoint:** `DELETE /players/{playerId}`
- **Description:** Delete a player from the database by their ID.
- **Path Parameters:**
    - `playerId` (integer): The unique identifier of the player to delete.
- **Response:**
    - **Status Code:** 204 (No Content)
    - **Response Body:** Player successfully deleted.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Player with the specified ID not found.

## Teams

### Get All Teams

- **Endpoint:** `GET /teams`
- **Description:** Retrieve a list of all teams.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing team information.

### Get Team by ID

- **Endpoint:** `GET /teams/{teamId}`
- **Description:** Retrieve information about a specific team by its ID.
- **Path Parameters:**
    - `teamId` (integer): The unique identifier of the team to retrieve.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing team information.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Team with the specified ID not found.

### Get Players by Team ID

- **Endpoint:** `GET /teams/{teamId}/players`
- **Description:** Retrieve a list of players belonging to a specific team by the team's ID.
- **Path Parameters:**
    - `teamId` (integer): The unique identifier of the team to retrieve players for.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing player information for the team.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Team with the specified ID not found.

### Add a New Team

- **Endpoint:** `POST /teams`
- **Description:** Add a new team to the database.
- **Request Body:** A JSON object containing team information to be added.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the newly added team's information.

### Update Team by ID

- **Endpoint:** `PUT /teams/update-team/{teamId}`
- **Description:** Update information about a specific team by its ID.
- **Path Parameters:**
    - `teamId` (integer): The unique identifier of the team to update.
- **Request Body:** A JSON object containing the updated team information.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the updated team's information.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Team with the specified ID not found.

### Delete Team by ID

- **Endpoint:** `DELETE /teams/{teamId}`
- **Description:** Delete a team from the database by its ID.
- **Path Parameters:**
    - `teamId` (integer): The unique identifier of the team to delete.
- **Response:**
    - **Status Code:** 204 (No Content)
    - **Response Body:** Team successfully deleted.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Team with the specified ID not found.

## Matches

### Get All Matches

- **Endpoint:** `GET /matches`
- **Description:** Retrieve a list of all matches.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing match information.

### Get Matches by Team ID

- **Endpoint:** `GET /matches?team={teamId}`
- **Description:** Retrieve a list of matches associated with a specific team by the team's ID.
- **Query Parameters:**
    - `teamId` (integer): The unique identifier of the team to retrieve matches for.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing match information for the team.

### Add a New Match

- **Endpoint:** `POST /matches`
- **Description:** Add a new match to the database.
- **Request Body:** A JSON object containing match information to be added.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the newly added match's information.

### Update Match by ID

- **Endpoint:** `PUT /matches/{matchId}`
- **Description:** Update information about a specific match by its ID.
- **Path Parameters:**
    - `matchId` (integer): The unique identifier of the match to update.
- **Request Body:** A JSON object containing the updated match information.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the updated match's information.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Match with the specified ID not found.

### Delete Match by ID

- **Endpoint:** `DELETE /matches/{matchId}`
- **Description:** Delete a match from the database by its ID.
- **Path Parameters:**
    - `matchId` (integer): The unique identifier of the match to delete.
- **Response:**
    - **Status Code:** 204 (No Content)
    - **Response Body:** Match successfully deleted.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Match with the specified ID not found.

## Events

### Get All Events

- **Endpoint:** `GET /events`
- **Description:** Retrieve a list of all events.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing event information.

### Get Events by Match ID

- **Endpoint:** `GET /matches/{matchId}/events`
- **Description:** Retrieve a list of events associated with a specific match by the match's ID.
- **Path Parameters:**
    - `matchId` (integer): The unique identifier of the match to retrieve events for.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing event information for the match.

### Add a New Event

- **Endpoint:** `POST /events`
- **Description:** Add a new event to the database.
- **Request Body:** A JSON object containing event information to be added.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the newly added event's information.

### Update Event by ID

- **Endpoint:** `PUT /events/{eventId}`
- **Description:** Update information about a specific event by its ID.
- **Path Parameters:**
    - `eventId` (integer): The unique identifier of the event to update.
- **Request Body:** A JSON object containing the updated event information.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON object containing the updated event's information.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Event with the specified ID not found.

### Delete Event by ID

- **Endpoint:** `DELETE /events/{eventId}`
- **Description:** Delete an event from the database by its ID.
- **Path Parameters:**
    - `eventId` (integer): The unique identifier of the event to delete.
- **Response:**
    - **Status Code:** 204 (No Content)
    - **Response Body:** Event successfully deleted.
    - **Status Code:** 404 (Not Found)
    - **Response Body:** Event with the specified ID not found.

## Enums

### Get All Leagues

- **Endpoint:** `GET /league`
- **Description:** Retrieve a list of all available leagues.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing league enumerations.

### Get All Countries

- **Endpoint:** `GET /country`
- **Description:** Retrieve a list of all available countries.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing country enumerations.

### Get All Positions

- **Endpoint:** `GET /position`
- **Description:** Retrieve a list of all available positions.
- **Response:**
    - **Status Code:** 200 (OK)
    - **Response Body:** A JSON array containing position enumerations.