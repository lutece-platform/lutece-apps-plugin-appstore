INSERT INTO appstore_category ( id_category , name , id_order ) VALUES
(1, 'Sites éditoriaux' , 1 ),
(2, 'Sites avec authentification' , 2 ),
(3, 'Sites applicatifs', 3 );


INSERT INTO appstore_application ( id_application, title, description, id_category, id_order, id_icon, pom_url, webapp_url, sql_script_url ) VALUES 
(1,'Site éditorial minimum','Pas de gestion documentaire',1,1,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(2,'Site éditorial simple','Pas de gestion documentaire',1,2,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(3,'Site éditorial riche','Pas de gestion documentaire',1,3,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(4,'Site avec authentification','Pas de gestion documentaire',2,1,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(5,'Forum','Pas de gestion documentaire',3,1,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql');

