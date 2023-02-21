delete from User;
INSERT INTO User VALUES ('Joe','Coyne','jcoyne', 1),
                        ('Fred','Hensen','fhensen', 2),
                        ('Barney','Curry','bcurry', 3),
                        ('Karen','Mack','kmack', 4),
                        ('Dianne','Klein','dklein', 5),
                        ('Dawn','Tillman','dtillman', 6);

delete from Quest;
INSERT INTO Quest VALUES (1, 'A Dying World', 10, 180, 'Silithus', '2 Gold, 57 Silver, 40 Bronze'),
                         (2, 'Just Following Orders', 20, 2750, 'Sholazar Basin', '10 Gold, 50 Silver'),
                         (3, 'Off To Area 52', 25, 860, 'Netherstorm', '2 Gold, 62 Silver, 50 Bronze'),
                         (4, 'Journey To The Timeless Isle', 30, 520, 'Timeless Isle', 'Curious Bronze Timepiece'),
                         (5, 'Heart of Flame', 35, 7200, 'Borean Tundra', '41 Gold, 22 Silver'),
                         (6, 'The Heart of Azeroth', 40, 690, 'Talador', '2 Gold, 57 Silver, 40 Bronze'),
                         (7, 'Armies of Legionfall', 45, 3050, 'Legionfall Campaign', 'Dalaran Portal Stone'),
                         (8, 'Assault: The Black Empire', 50, 10250, 'Vale of Eternal Blossoms', 'Cache of the Black Empire'),
                         (9, 'A Dragons Day Off', 60, 11350, 'The Waking Shores', 'Spyragos'),
                         (10, 'A Ruby Lifecalling', 60, 4550, 'The Waking Shores', '14 Gold, 4 Silver, 50 Bronze');

delete from Favorite;
Insert INTO Favorite VALUES (1, 2),
                            (2, 3),
                            (3, 2),
                            (4, 3),
                            (5, 4),
                            (6, 1),
                            (7, 1),
                            (8, 6),
                            (9, 4),
                            (10, 5),
                            (11, 2);