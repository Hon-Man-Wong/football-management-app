-- Drop the existing foreign key constraints
ALTER TABLE Match DROP CONSTRAINT match_home_team_key;
ALTER TABLE Match DROP CONSTRAINT match_away_team_key;

-- Remove the uniqueness constraints from home_team_id and away_team_id columns
ALTER TABLE Match ALTER COLUMN home_team DROP NOT NULL;
ALTER TABLE Match ALTER COLUMN away_team DROP NOT NULL;

INSERT INTO team(description, name) values('Club from Rotterdam', 'Feyenoord')
INSERT INTO team(description, name) values('Club from Rotterdam', 'Sparta')
INSERT INTO team(description, name) values('Club from Rotterdam', 'Excelsior')
INSERT INTO team(description, name) values('Club from Eindhoven', 'PSV')

INSERT INTO player(name, team, position) values('Lutsharel Geertruida', 1, 'RB')
INSERT INTO player(name, team, position) values('Bob', 1, 'RWB')
INSERT INTO player(name, team, position) values('Rob', 2, 'CDM')
INSERT INTO player(name, team, position) values('Luuk de Jong', 4, 'ST')

INSERT INTO match(away_team, home_team, score, start_time) values(1, 2, '2-0','2023-01-13T17:00:00.000')
INSERT INTO match(away_team, home_team, score, start_time) values(4, 3, '3-0','2017-07-23T20:00:00.000')
INSERT INTO match(away_team, home_team, score, start_time) values(3, 4, '4-0','2020-06-01T12:00:00.000')
INSERT INTO match(away_team, home_team, score, start_time) values(3, 1, '4-0','2023-12-29T09:00:00.000')