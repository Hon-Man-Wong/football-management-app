INSERT INTO team(description, name) values('Club from Rotterdam', 'Feyenoord')
INSERT INTO team(description, name) values('Club from Rotterdam', 'Sparta')
INSERT INTO team(description, name) values('Club from Rotterdam', 'Excelsior')
INSERT INTO team(description, name) values('Club from Eindhoven', 'PSV')

INSERT INTO player(name, team, position, date_of_birth) values('Lutsharel Geertruida', 1, 'RB', '1998-10-10')
INSERT INTO player(name, team, position) values('Bob', 1, 'RWB')
INSERT INTO player(name, team, position) values('Rob', 2, 'CDM')
INSERT INTO player(name, team, position) values('Luuk de Jong', 4, 'ST')

INSERT INTO match(away_team, home_team, score, start_time) values(1, 2, '2-0','2023-01-13T17:00:00.000')
INSERT INTO match(away_team, home_team, score, start_time) values(4, 3, '3-0','2017-07-23T20:00:00.000')
INSERT INTO match(away_team, home_team, score, start_time) values(3, 4, '4-0','2020-06-01T12:00:00.000')
INSERT INTO match(away_team, home_team, score, start_time) values(3, 1, '4-0','2023-12-29T09:00:00.000')

INSERT INTO event(match_id, player_id, type) values(1, 1, 'GOAL')
INSERT INTO event(match_id, player_id, type) values(1, 1, 'YELLOW')
INSERT INTO event(match_id, player_id, type) values(2, 4, 'ASSIST')