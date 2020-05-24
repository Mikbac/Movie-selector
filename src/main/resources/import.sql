INSERT INTO Movie(pk, id, name) VALUES (default, 'tt5180504', 'The Witcher');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0138704', 'Pi');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0120737', 'The Lord of the Rings: The Fellowship of the Ring');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt3116198', 'Snow White and the Huntsman');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0898266', 'The Big Bang Theory');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt4412198', 'Week 9 Eviction');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt2282829', 'Kac Wawa');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0363029', 'Rick');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0087803', '1984');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt6520930', 'Blinded by the Lights');

INSERT INTO Question(pk, description, base_movie_variable, variable_name, poor_variable, fair_variable, good_variable) VALUES (default, 'Czy masz dużo wolnego czasu?', 'TOTAL_SEASONS','freeTimeBySeasons', 1, 3, 8);
INSERT INTO Question(pk, description, base_movie_variable, variable_name, poor_variable, fair_variable, good_variable) VALUES (default, 'Czy lubisz nowości?', 'RELEASED','newestByRelease', 1990, 2000, 2019);