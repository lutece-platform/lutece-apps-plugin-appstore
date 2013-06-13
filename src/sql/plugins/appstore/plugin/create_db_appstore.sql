
--
-- Structure for table appstore_category
--

DROP TABLE IF EXISTS appstore_category;
CREATE TABLE appstore_category (		
id_category int(11) NOT NULL default '0',
name varchar(50) NOT NULL default '',
category_order int(11) NOT NULL default '0',
PRIMARY KEY (id_category)
);

--
-- Structure for table appstore_application
--

DROP TABLE IF EXISTS appstore_application;
CREATE TABLE appstore_application (		
id_application int(11) NOT NULL default '0',
title varchar(50) NOT NULL default '',
description varchar(50) NOT NULL default '',
id_category int(11) NOT NULL default '0',
application_order int(11) NOT NULL default '0',
id_icon int(11) NOT NULL default '0',
pom_url varchar(50) NOT NULL default '',
webapp_url varchar(50) NOT NULL default '',
sql_script_url varchar(50) NOT NULL default '',
PRIMARY KEY (id_application)
);

--
-- Structure for table appstore_application_category
--

DROP TABLE IF EXISTS appstore_application_category;
CREATE TABLE appstore_application_category (		
id_application int(11) NOT NULL default '0',
id_category int(11) NOT NULL default '0',
PRIMARY KEY (id_application , id_category)
);

--
-- Structure for table appstore_component
--

DROP TABLE IF EXISTS appstore_component;
CREATE TABLE appstore_component (		
id_component int(11) NOT NULL default '0',
group_id varchar(50) NOT NULL default '',
title varchar(50) NOT NULL default '',
description varchar(50) NOT NULL default '',
artifact_id varchar(50) NOT NULL default '',
version varchar(50) NOT NULL default '',
component_type varchar(50) NOT NULL default '',
PRIMARY KEY (id_component)
);

--
-- Structure for table appstore_application_component
--

DROP TABLE IF EXISTS appstore_application_component;
CREATE TABLE appstore_application_component (		
id_application int(11) NOT NULL default '0',
id_component int(11) NOT NULL default '0',
PRIMARY KEY (id_application, id_component)
);
