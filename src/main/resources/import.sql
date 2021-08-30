# drop table if exists tva;
INSERT INTO tva VALUES (1,0.06);
INSERT INTO tva VALUES (2,0.21);

# drop table if exists article;
INSERT INTO article VALUES (1,'Motherboard', 100, 5, 2);
INSERT INTO article VALUES (2,'CPU', 150, 8, 2);
INSERT INTO article VALUES (3,'De l esprit des lois', 20, 3,1);

# drop table if exists client;
INSERT INTO client  VALUES (1,'bastogne', 'hanse', '220498', 1000);
INSERT INTO client  VALUES (2,'bastogne', 'steven', '220498', 1000);
INSERT INTO client  VALUES (3,'bastogne', 'malashuy', '220498', 1000);

drop table if exists spring_session_attributes;
