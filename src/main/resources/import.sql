--
-- Created by MikBac on 21.05.2020
--
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt5180504', 'The Witcher');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0898266', 'The Big Bang Theory');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt6520930', 'Blinded by the Lights');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt2861424', 'Rick and Morty');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt2085059', 'Black Mirror');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt1856010', 'House of Cards');

INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0138704', 'Pi');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0120737', 'The Lord of the Rings: The Fellowship of the Ring');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0167261', 'The Lord of the Rings: The Two Towers');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0167260', 'The Lord of the Rings: The Return of the King');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0363771', 'The Chronicles of Narnia: The Lion, the Witch and the Wardrobe');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt2358891', 'The Great Beauty');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt2282829', 'Kac Wawa');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0363029', 'Rick');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0087803', '1984');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt1959409', 'Imaginaerum ');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0126029', 'Shrek');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0298148', 'Shrek 2');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0413267', 'Shrek the Third');
INSERT INTO Movie(pk, id, name) VALUES (default, 'tt0892791', 'Shrek Forever After');

INSERT INTO Question(pk, description, base_movie_variable, variable_name, start_variable, end_variable, good_value_range) VALUES (default, 'Jak dużo masz wolnego czasu?', 'RUN_TIME','freeTimeBySeasons', 25, 200, 30);
INSERT INTO Question(pk, description, base_movie_variable, variable_name, start_variable, end_variable, good_value_range) VALUES (default, 'Jak bardzo lubisz nowości?', 'RELEASED','newestByRelease', 1990, 2019, 5);
INSERT INTO Question(pk, description, base_movie_variable, variable_name, start_variable, end_variable, good_value_range) VALUES (default, 'Jak bardzo lubisz robić sobie długie przerwy w nauce?', 'TOTAL_SEASONS','lengthByRunTime', 1, 6, 2);
INSERT INTO Question(pk, description, base_movie_variable, variable_name, start_variable, end_variable, good_value_range) VALUES (default, 'Jak bardzo lubisz to co jest popularne?', 'IMDB_VOTES','popularByIMDBVotes', 50000, 300000, 25000);
INSERT INTO Question(pk, description, base_movie_variable, variable_name, start_variable, end_variable, good_value_range) VALUES (default, 'Jak bardzo zgadzasz się z ocenami innych ludzi?', 'METASCORE','scoreByMetascore', 0, 100, 15);
INSERT INTO Question(pk, description, base_movie_variable, variable_name, start_variable, end_variable, good_value_range) VALUES (default, 'Jak bardzo lubisz inne języki?', 'QUANTITY_LANGUAGES','languagesByQuantityOfLanguages', 1, 3, 1);
INSERT INTO Question(pk, description, base_movie_variable, variable_name, start_variable, end_variable, good_value_range) VALUES (default, 'Jak bardzo lubisz globalizację?', 'QUANTITY_COUNTRIES','globalizationByQuantityOfCountries', 1, 3, 1);