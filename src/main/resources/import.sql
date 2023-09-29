INSERT INTO team(description, name, country) values('Club from Rotterdam', 'Feyenoord', 'NETHERLANDS')
INSERT INTO team(description, name, country) values('Club from Rotterdam', 'Sparta', 'NETHERLANDS')
INSERT INTO team(description, name, country) values('Club from Rotterdam', 'Excelsior', 'NETHERLANDS')
INSERT INTO team(description, name, country) values('Club from Eindhoven', 'PSV', 'NETHERLANDS')
INSERT INTO team(description, name, country) values('Club from Genk', 'KRC Genk', 'BELGIUM')

INSERT INTO player(name, team, position, date_of_birth) values('Lutsharel Geertruida', 1, 'RB', '1998-10-10')
INSERT INTO player(name, team, position, profile_picture) values('Bob', 1, 'RWB', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vecteezy.com%2Ffree-vector%2Fdefault-user&psig=AOvVaw3I42EgUVKy4NQEFV7lpdPG&ust=1695990060129000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCLD0vLqlzYEDFQAAAAAdAAAAABAE')
INSERT INTO player(name, team, position) values('Rob', 2, 'CDM')
INSERT INTO player(name, team, position) values('Luuk de Jong', 4, 'ST')

INSERT INTO match(away_team, home_team, home_score, away_score, start_time) values(1, 2, 2, 0,'2023-01-13T17:00:00.000')
INSERT INTO match(away_team, home_team, home_score, away_score, start_time) values(4, 3, 3, 5,'2017-07-23T20:00:00.000')
INSERT INTO match(away_team, home_team, home_score, away_score, start_time) values(3, 4, 1, 2,'2020-06-01T12:00:00.000')
INSERT INTO match(away_team, home_team, home_score, away_score, start_time) values(3, 1, 17, 2,'2023-12-29T09:00:00.000')

INSERT INTO event(match_id, player_id, type) values(1, 1, 'GOAL')
INSERT INTO event(match_id, player_id, type) values(1, 1, 'YELLOW')
INSERT INTO event(match_id, player_id, type) values(2, 4, 'ASSIST')