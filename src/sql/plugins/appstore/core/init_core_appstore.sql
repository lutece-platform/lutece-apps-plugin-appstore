--
-- Dumping data for table core_admin_right
--
DELETE FROM core_admin_right WHERE id_right = 'APPSTORE_MANAGEMENT';
INSERT INTO core_admin_right (id_right,name,level_right,admin_url,description,is_updatable,plugin_name,id_feature_group,icon_url,documentation_url, id_order ) VALUES 
('APPSTORE_MANAGEMENT','appstore.adminFeature.manageappstore.name',1,'jsp/admin/plugins/appstore/ManageApplications.jsp','appstore.adminFeature.manageappstore.description',0,'appstore',NULL,NULL,NULL,4);


--
-- Dumping data for table core_user_right
--
DELETE FROM core_user_right WHERE id_right = 'APPSTORE_MANAGEMENT';
INSERT INTO core_user_right (id_right,id_user) VALUES ('APPSTORE_MANAGEMENT',1);


