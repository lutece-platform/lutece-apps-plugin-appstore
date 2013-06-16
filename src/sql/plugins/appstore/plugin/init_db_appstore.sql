INSERT INTO appstore_category ( id_category , name , id_order ) VALUES
(1, 'Sites éditoriaux' , 1 ),
(2, 'Sites avec authentification' , 2 ),
(3, 'Sites applicatifs', 3 );


INSERT INTO appstore_application ( id_application, title, description, id_category, id_order, id_icon, pom_url, webapp_url, sql_script_url ) VALUES 
(1,'Site éditorial minimum','Pas de gestion documentaire',1,1,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(2,'Site éditorial simple','Gestion documentaire',1,2,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(3,'Site éditorial riche','Gestion documentaire et autres fonctions',1,3,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(4,'Site avec authentification','Authentification base de données',2,1,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql'),
(5,'Forum','Pas de gestion documentaire',3,1,1,'pom.xml','site-edito-mini.war','site-edito-mini.sql');

--
-- Dumping data for table `appstore_icon`
--
INSERT INTO appstore_icon (id_icon, name, mime_type, file_value, width, height) VALUES 
(1,'website','image/jpeg',0xFFD8FFE000104A46494600010200006400640000FFEC00114475636B7900010004000000470000FFEE000E41646F62650064C000000001FFDB008400040303030303040303040604030406060504040506070606060606070A0708080808070A0A0B0C0C0C0B0A0C0C0C0C0C0C111111111113131313131313131313010404040807080E0A0A0E140E0E0E1414131313131413131313131313131313131313131313131313131313131313131313131313131313131313131313131313FFC000110800F000F003011100021101031101FFC400B300010001050101000000000000000000000006010304050702080101000105010100000000000000000000000301020405060708100001030303010505050605040301000001000203110405211206314151611307718191A122B1C132141542526292A2237282B24316D1532444C28374171100020103020305040804040505000000000102110304120521310641516191137181B122A1C1D13242521407F0E1627282233324F192251617B2C2435315FFDA000C03010002110311003F00FBF90040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401004010040100401014739AC697BC86B1A097389A0007524AA374069FF00E4505CCDF96C3C4721352BE631CD8E0A769F35FF008878C61CB577B735EA7A7696B9FB525E7F62665C711E9D537A57F1FC71A1990C391748D96EAE5AC68FFD7B78C6DF639F26E71F706ACBB50BBCE725EC8AE1E6F8FC086728728AF331F29C8F0D876937B74D127410C7FDC949EE0C6D4AD4EEBD518383C2EDC5ABF2C7E69792FAE865626D97EFBF923C3BDF05E645C7A8D656BB186CAEDF1927FB970E8D9211DFB3B971993FB870C4A6BB1768F96A947535DFA7B3DE6ED74E4EE55A9C7FC356BCCDCDA738C1DC462595CFB58C8277CC1B4F67D0E71AFB96FB6EEBCC1C8B7EA49FA4BFA9C7EA6DFD06BAF6C57E12D296A7E1FCE85A773BC079E0B6F99F950DFA87933190BEA741A00B165FB89B729FFAAB453F2CB557E05EBA7F269C61C7DB1A143EA171A0F0D334A0134DDE53A94EFF0062BBFF00246D7F9E5FF2977FDB9954E4BCC91D9DEDA5FC0DB9B29993C0EE8F8DC08F61EE3E05765859F672A0A7666A71EF4CD35EB13B52D334D3F12FACB22080200802008020080200802008020080200802008020080202D5C5B5BDD33CBB98C4B17531BF561FF134E87DEA924A9C411ACAF21B3C66C9ECAD447797373140E73E02D92785A407C8C0DFA9CD68D1A5D41DCB85DDFA9618F18CB1E1F3DCB897183ACA3F8A715CDA5C93744FB2A6EF0B6C95D6D49F0516F9F27D898E4BC9F08CB2BAC68B932DD4B1B98196EE78A388E86467E1F1D563755759EDD6EC5CB1AF5CDC7946BCFB9C972F12FDAF6ABEE71B9A6893FC5F63E642ED6EB8863B271656D59752793B5D0D8EC6B5AD91A00DE6473893AEA02F34B1BA6CB8D931C9B71B8DC68D5BE494976EA726DAAF1F89D25CB39B76D3B5271E3CE5E1DD4A1A7CFDFB73F917E42581903DDA011820B9A0FD3BCFEF01A542E7BA83A8A7B8DF95D718C6BDCB8D3B2AFBFB2A6C76EC5FD2DBD09D7F8ECF030034001B5E8B9C6D99952B4011143C38550B91958ECA64311702EB1B33A197A39B5AC6FF000737A15B7DAB7AC8C1B9EA599B8BFA1FB572641938B6EFC74DC49AFA7CCEA7C639AD9E736DA5D016B94E9E59FC1291D4C64F6FF095EFDD29D776772A5BB94B777BBF0CBFB7EC384DD7629E37CD1F9A1F4AF6FDA4A977C6842008020080200802008020080200802008020080200802035F94CE62F0DE5FEA3702132D7CB6ED7389A7534682568F79EA3C3DBB4FEA27A5CB92A55F923331702EDFAFA71AD0E77C8F273F29CB450F1B6DCDCC4D6064D4DCC8838B8EA6B4A0A7525790750E75EDF72E9B7FA9282494BF0C6BF52EFAF33AFDB71638565BC8D3175AAED6625EF06E41656CDB9731924408F3A2B7264958CED2069BBDCB559BFB719B8D695D9FCEABF3461F34A2BBE9C2BEE326C6FF008D725A6AD3EC72E0ABF518392C0BACAD9F92C7DCB72387653CCB88C81242E269B648C9AB755AADDFA5BD383BF8D3576CC695972717CA928F35C7970E265636E0AE495B9C7D3B8FB1F27EC7DA699B2B5D4347069D4388345CBCB1A6A3A9A74F670F3362E342B5AA800440A2A9529440792E2D21CD25AE69DCD70243811D28474535BB8E324D706BB8AD2A751E13CCCE503313957819268FECCC74F3DADEC3FC607C57BEF42F5B7EB298D90FFCD5F765F9FDBFD5F1F69C36FBB27A35BB6D7C9DABF2FF002270BD40E5C200802008020080200802008020080200802008020080E5DCC5B89BFE47FF00919874313226B646C7019C46456AC6969A027AF45E0FD651DBB237293BD9125A524D286AA53F0A75A78F2E0773B2BBD6B1BE5B49B6FB5E9AF897EDF9E62B0D0B6C70B8C73ED9800F3659044F91C342E700D7124F8A971FF717136FB6ACE163FC8BB64E8DBEF7452F891DCE9FBB912D77AE717D89569F4926E2BC9A6E4115C4F711436CC8DED8E26365DEF7388A9A8207851775D21D5B2DD23395C8C6DA8B514B5716DFB7E8F79A4DDB6B58AE2A2DCAAAAF81B7971F8B6C578E9E18DB0DE0ADE975036401BB6AE27C174B7B6DC48C2EB9C22A377FD4AF27D9C4D74322EB71A3758FDDF0F61A88F88E126C0370CC3E6414FA2EDA5A65DDBB70707014D0F62D243A6312FED8B0D4F5DBEC9269BAD6B55D9FC8CE96ED7A392EF5292ED468A5F4C2D5913DCDC8CBB9AD25B56303741A5571D73F69F1E107277E5C137F751B68F554DBFF004D79B39C31D56D6B5D48AFB1788DD8A8C9A47692454B80EAA3A0A14DE128285A255C912211C92452B2685C639A376F648DD1CD70D41056459BB28494A2DA6B8A128A9269F14CED9C3F91B39162C4B2505FC148EED834FAA9A3C0EE72FA6BA3BA923B9E2A72FF00521C26BFF77BFE2798EF3B63C5BB45F765C63F67B890AEB8D40401004010040100401004010040100401004010106E65CC208219F0F8D7EFBC7563B999BF8620747341ED776782F25EBBEB8B76EDCF131DD6E3F96525CA3DEBDBD8FBBDA753B26CB294A376E2F979A5DFFC8E67D01A745E0F5676C501F1547C4AD0A01421C090E04104120823A1D15D19B8F27406DE7E4D9CBAC6C98AB9BA335A4940EF3181D210D3BA81FD48D174D7BABB3EEE2BC6B973541F7D1BA776AE66BEDED58F0BAAE463492EEE5E4605A642FB1CEDF617525B13D7CB79683ED0345A6C2DD323165AACDC941F83A1977B1ADDD549C54BDA8CC8F3D9ABCBAF2EEF2B71141703CA9A4DE4B035DA7D4D1A53BE8B798BD41977EF69BD9338C67F2CA556F87B0C59EDF66DC2B0B71728F14BF99857F63778ABA7D95F47E5C8C3F411AB1EC3D1CD3DA0AC0DFB63BBB7DFF4EE71E158C972947B1A323132A1910D70F7F832C44626CD1C9333CD85AF69921DDB0BDA0EA01EA345ADC59C21722E71D51AF15E04F34F4B49D1D39F71B1BDC53EEDD36438F44E9F18D01D2C269E6DA1A54B5E2B5205347742176B3E9786E0A57F01AF4D719424F4CADF6FBE3DD23590DC7D1A4323849F292E52FB0C038FC8FD1FF8731F346E8CB63716BC1D6A0814A2E71EC797A947D293AAAAA2AD577AA73363FA9B5C7E75C39F1E46238D0961FA5ED2439A450823AAD75DB13B527192A35D8F99911A3555C51B9E299D7E0B3505CB89FCA4A7C9BB6F6794E3F8BFCA755D2F486F92DBB32371BF924F4CFD8FECE66BB77DBD64D871FC4B8C7DBFCCEEC08700E69AB48A823A1057D451926AAB91E56D50AAA9408020080200802008020080200802008020239CDF2D36230523ED8EDB9B97B6DE378EADDF52E23DC0AE27AFB789E0EDF276DD2737A53EEAF37E46E762C38DFC84A5CA2AA71A2E2BE6368F48A14DE942B405E941A4A6F4A0D2370ED4A0A14DDAF82AD0AD06E0411D9DA3BD5628509962DAFE6985930B2B58327898D8FC7DC6E357B2A5BB1F5F600BD67649BDFB6F961C947D5B093B72ED6B935F5791CCE5A5B7E42BC9BD171D26BEBF8910B8B7B8B499F6D77198AE623B648DDA1042F32CEC3BB8F7656EE474CA2F8A3A3B5763722A50754CF31CF3421E2099F1B666964823246E69EAD7508A83DCADB17EE5BAA8C9AD4A8E8E9545D2B71952A93A779D47D33B8C8CF8DB86DCCAF7D8C2E645661E2A0002AE0D7F6815029D8BDD7F6BF232AEE34FD593708B51826B878D1F970386EA9B76A3763A52526AB2FF0080E69C0E2CC3A4CC62CF93966C6E2F880FA2E5CD156D7B9DD9BBE2BA0EA8E8FB1B9A52AE99AED5DBE0CC3DA37B9E2D62FE68BECEEF1398F1FB06E6B27638F977B05D3F6CBB455CD6ED25C4FB1782ED3B4BBF9F0C59A6AB3D2E9CD539FD07A066E5FA5625763D8AABEA3AF701C9DD5EE15F8FC937665B0B712E36F595AFD501FEDBC7F0BE32D737C17D1BD3CE50B2EC4DD6561E8AF7C79C1FFCB4F23CD3734A573D48AA2B8B57DBF49295BE35A10040100401004010040100401004010040735F54324E33D9624368C6B4DD39DDE49746D1EEA15E25FBADB9B772DE32E496B7ED754BE076BD298CB4CEE76FDDFACE7BBBB178E50EBE852A8545556850552856852A5285685372AD050A5554AD0CAC7646E7137B0E42CCD2E2176E0093B5C2942D753A82B63B56E5730AFC6F5B7F345F9F83F0EF441938D1BF6DC27C99BECD5D0E67776F7787B47FEAFB36DEDA820EE0D1A3DA4D2A0745DC6F5763BFCA177160FF00514A5C8782E525DEBB3B0D3E0DB7B7C650BD25E9FE197D4FC4DCF1EF4DE595ECB9E40EF2E207E9B2611B9E3F8DC3A0F00B73D3DFB6726D4F35D176413E2FDAFEA46BF71EA78A5A6C2ABFCCFB3D8BED3A5C10436D0B20B7636286301AC8DA28D681D8005ECB631E1660A104A318F0491C55CB929B7293AB65C53161C9ECF1C78CFAA4CB7DBFF8192335C599D28DF3DA77B0776D92BEE21796E56DAB07A82CDE8AF96FEA5EC934EBF51D85BC9FD4ED738B7F35AA795781D0ADF12CB3E437B9580ED6E4EDE16DCC7D866B525AD93DA58F0DFF00285E951B2A375C97E25C7DA8E4DCEB14BB8DB2C823080200802008020080200802008020151F1E88020219EA5580B8C10BE645BE6B391AE73C0FA844EAB5DEEA90BCE3F72F6CF5B055E8C56AB72557DBA5D53F7559D274C6469C8D0DF092FA4E4755F3C50F42A1E0C8D27683AFBD491B4DF61769ED2B5D2B5F62B680F3B9528568577A50A50A6E0942B429B82AD0506E55A0A1936393BEC5CC6E31F3BADA7734B1D2329B8B4EA46A0F72D86DDBA5FC29EBB32D12A52A437F16DDE8E99AD4894704FD4F37CA21BBB9BB9A7658B1F34CE95E5DABC16B401D35DCBBDE87965EE1B946E5CB9292B6B53ABF725EF668BA83D2C7C4718C52D6E8A88EC6BDF8F39080D2F22C0B7316FE75BB84198B664BFA75DFFDA95EDA0269D42D76E3811C88AAFDE8D5C1FE59529532B1725DA6FBA5F7977A322EEE85A498B174E0249E716E5C3A191F03DD41ED2D537A8E2A2A5C5F222A275A72364B2C88200802008020080200802008020080B338065B624D292120779F29E1017901E26862B889F04EC1243234B5EC70A8734E841515FB10BB0709AD5192A35DE8BA137169A746889FFF00CD38BF985FE5CFB49AF97E7BB68F0EFF009AE13FF1AED9AAB49FB3570F857E93A0FF00BA32E94AAF236F8CE2B81C4078B2B260749A3DF2564711DD57D745D2EDDD398587171B5692AF3AF16FDECD6E56EB917DD6727C3BB87C08EE6BD3AE3DE4DEE462F36091B14B2B58C7FF006DAE6B4BB40474F05C7EF5FB7DB7AB576F454A2D4652493E09A4DFF08DCE0F52E4EA85B746AA972E27210FA8049EA015E02D1E87A46EF14A15A14DE1348D279F315DA4AE91E6515348D264595ADD64AEA2B2B28CCB7529DAC601D7BC93D802CCC1DBEEE4DD8DBB71729488AFDD85A839CDD228EE1C3F8BC7C66C1D1B9E25BEB821F7320E950346B7C02FA3FA4FA6E1B5D9D35D539D353F6767B11E5FBD6EAF32E552A463CBED246BACD48D314AAB5CD15A1E4BC0514AE955135597B786FBF231BDDB7CABCB6B86B811F8A27EE03DFD3DEA25F335EDA9224D266E166908401004010040100401004010040101A0E6391BAC461C656D4FD569716CF95A750E85D2B63907F2B8AD0F51664B16CC6F27C21386AFED6F4BF89B2DAB195FBAEDBE728CA9ED4AABE06FD6F8D68401004060E62C64C9E2EEAC219CDBC9711BA36CCDD4B6BF71E856BB76C2965635CB51969734D57F8ECEF32B0B2159BB19B5A945D687CF591B0BAC4DECD8EBD8F65CDBBB63856A0F6820F711D17CB5B9EDD770EFCACDC54947F8AAF03D7F1B2217E0AE41D5330CBBC56050C8A14DC154AD0F3BD285680BE9A8ECEC574515D276DE03C623C1E3DB7B380EC8DE31AF7BA83FB6C76A180FB3AAFA0BA37608E063A9B5FE6DC556FB93EC3CC3A877579375C23F722FCDF7931DE3BD766EE9CED0F0E99A3B558EE972816DD7235D559EA17AB4624B7A056855359268A162DCC57F7714733448D88899A0F63E33569F71A15358E322CBBC8DEACE318200802008020080200802008020080D472AB0393E3994B102AF96DA5D8075DED6EE6FCC05A9DFB116461DDB7DF17F471FA8CEDB6FFA57E13EE66763E56CF616B334D5B2431BC1EF0E602B65665AA09F7A4625C8D24D78992A42C080201556B90397FAB78A688AD339134091A7F2F707B4B4D5CC3EE350BC8FF73769528432A2A8D3D12F7F18FD6773D1F96F54ACBE4FE65F59CA4BD78E50EF544F06403B55544BD44F266F1572895D078329A69F1F9ABA312E503BB70BE48ECCE06DE797E99621E4C9AF5747F4D7DEBE87E9DDC9E561DB9BE74D2FFC3C0F26DE36F5632651F7F9F1375364E18DCD6BE40D738D1A09D5C7C3BD6EBD546B55A3C3AF99D6AADD65CA28C29B240547DE9ACAE935F36445695D55CA451C4DBF1679B99EE6E3F6636B583C4BCD4FFA56762AE6CC5BE49D6698C100401004010040100401004010040101ACC1C4EB4B37635DFF00A323E18EA6B586BBE1F831CD07C4158D8B0708697F87E1D9F412DE96A96AEF366B24882029556B902DBA500D3B5412912281CBBD5ECC4B1D9596319411DC48E964778420507C5CBCCBF71F35C71EDD9EC9CAAFFC3CBE2769D1D8A9DD9DCFCAA9E672274C076AF1BD353D1134587DCEBD5491B62A5A75D81DAAF5686B2D3AF2AE6B055D23C80D6345493DC029ED62CA6E915565B2BAA2AADD0EA1C7AFFF00E29C5FF31903B5CC0E9A6675A39E6A02F6BD871FF458518CFB2ADF85789E65BA5E59392F471AD179119C5728BEE59CB60BD92B158D907491C20E8D14DA2BE2495A9C5DD25B8E75BD29C616AB2F6B3657B016162CB551CAE7D0744972E03451DAAECB51CC50C09730083AEA55E99430E5CAEF701BB5255F12D6752E1D68FB6C2432CA292DD1339AFEEBB46FF48056E6C469135F7A5566FD4C4410040100401004010040100401004010168C5B66370DD373436414EA1A6AD3EEA95407BDEDEF54D40A39ED03AAB1B2E48C792E69D0AB645FA4C19AE753AA86448881FA89897E73141F6DADF59974B00FDF14FAD9EF0051725D57B2BCEC67A7EFC3E65E3DE8DEEC3B97E96F7CDF76744FEAFE67087DD686B504751D355E1FE8D1D0F505230E4BD03A95246C94D662BEFC03A9D14F1B352C7728895F05B9B491D77712303A763981921EC041240F7AF41E8EC68A8CE7A7E65449F871E4721D4B765AA304F876AF232B9E66DC3092C31B886B9CD69A775755BFDF64FF004928AE6E88D4ED093C98D78246BB844E6D2C64BB94ED92E8FD3D8444DD07C4EAB0BA6707D1B4E4D51CDFD065EFF97EA5EA27551F8922973BA68EE8BA5A1A0661FEB65C48055E8B4DDF13B59F9266AD71ACAF9723B7DC387EC42CD5E7EE1E256563DBD5222BB35147D16C63236363600D63006B5A3400014002DD1AD3D20080F124B142DDF33DB1B3A6E7B83457DA54772EC6DAAC9A4BC7817460E4E8954D74FC978FDB1227C9DB348EA3CD6B8FC1A4AD2E4753EDD65D277E1E75F854CCB7B5E44F95B9791AC9FD41E290682FBCE70EC8A391DF700B4F7FF70B6BB7CAE397F6C5FF00233ADF4E664BF053DAD1E2CFD43E2F76F319B97DB1EC37119634FF0098547C55B89FB87B65E951CDC3FB953E152EBDD3797055D2A5EC7523BCCFD5EB3E31968B17696ACBE6C9032775D365FA01792034068D74153F52C4EA0EB778D351C750BAA95AEAAAFA0CDDA7A625930739B70A3A529C4D45A7AC591BE901820B5207588B656B88F6972E2EEFEE66E31926EDC29DD47F1D46E25D1F662BEF4BDBC3EC3D72AF5173591C3320E3E3F4CCAB6663E49BCC6BDAE85AD3B9A096E849A767BD49B87EE64B26CA84232B53AF1945D7F9966DDD356ED5ED571AB90A72A1CCECFD4AE417EE02EEFE79240EA544F2328E07B0034EAB96CDCCCD93D4EFDC7DBF799D45BDA31A9F2DB8AF7227361CFB915A35A5B7EF95940764ED6CBFD4E15F9AA61F5AEEB8EE8AEB92FEAF9BE3C4D56474F634DFDC4BD9C0EC580BDBAC961ACAFEF18D65CDC46247B580868DDA8A024F6517D0DB0665DC9C3B576EA4A738D5D39787D079CEE36216AFCE10755174364B6E610401018172E7C0FA7EC3B569FBBDAA368AA2C1BADC15A5E6349702BD55197761AFB9BB6806854122F4692EAF43DA5A1435A12AE47CFDCC2C27C3E52679A1B3BB91F25BBC7B77169F1155E3BD47B2CB1EFB9A5F24DF03D1F64DC637ED28FE28AA10FB8BD20E9D5692DDA36BACC037534EF641155D2C876B5A3AACFC5C37726A297331EFE42845B6F8227F63750636D990420318D02BE2683527DABD4B171A36A0A1154A1E7F917E5726E4DD4B575968E5FC643875A152BA11712D45717B7A4B6C607CA1BD446341DDDCB0B2F74C7C5A2BB38C7B9327B58976EA6E31725DE6533179F9853C811D7F7E460FB095A6BBD69B743FF91BF64599B1D8B225D897B599B06032847F765899DFB77BCFD802D6DDFDC4C48FDD84E5E48C98F4DDD7CE491D1FD3DCE58F0E130B9B475CDC5D38365BB638073226F463187A8AEA75FB15B89FBA36E13A4AC3D2FB54B8F9508EFF004ACA4AAAE2AFB381D3AFB9C61DBC6B299CC7DCB5EFB0B59AE3C9782D7B5CD69DA1CC3434DD40BBBB5D5B89938D72E589A72845BD2FEF2EEAA7E26856CB7A17E16EE4784A4957B3CCE2D67EB1727C9B5ACBABD303CE84DBC51B454FB891F15E49B87566ECDF0BD45E0A2BE08F42874C61AE50AFF737F69BCB3E69C92CA5F3DB947CC1DA98EE0F9AC3EE234F7516930FAD373B137257652F097CCBC9FD4437F63C5B8B4FA697F6F023FEAEF3FBCCCE07176D240D81D15DF9934B13CED73844E6B000751D4F6AE9B2FABEE6EF6559B90519478BA3E0FDDD845B5EC71C4BAE69D53E1C7B088F1CCE5E5C48C86594CAD77EFEA68477F55C5E7E2462AA950E99DB4D78A25E25D68D681D8B474315C0D0F1BE46FCE0CA48D236D9DFDCDA47403F042FD8DF982B69B960AB0E0BF34232F32908A6BCCC3E75348CC3C33D6A22B8603E1BC169F9D14BB2C6B71AF025824996F88CBE7B5F28E8D6E8ABBAC74BA3EF322ECAB1252345A86CC6672EB673E1E53778DFDCBB7003F85CEDE3E4575D75278F19FF00499369D59D46363A4D90B7F13CB58D1E2480172B6E0E5349736CC694A956CFA52D206DADA416ADFC3046C8C7B18D0DFB97D73838FE8D885BFC918C7C950F15BD735CDCBBDB65E59446100405AB88197113A27E80F470EA0F610808CDCBA5B495D04E3EBAFD269A387EF34A89A2E461CB76295AFC55B2E4486A323928A089D2CE4B63E8682A755A7DD773B38365DEBB55154E49BE66662625CBF350852BE2462EB3903891107BABDB4DBF6AE1727F72B0A2DE884E5E497F1EE37F6FA62F76CA2BCC88F29C70E4160E81BFDBB861125BBDDA80F1A1069D84755A2C9EB5C6DC1FA572DFA4BF0CEB5A3F1E544FB5AE26D71369B988F5C65AFBE3CB87878AEC397CFC5F2AD91CDB87C70B5BD4D4BCFD816DB1BA62ECD2939468FB5712B7B7FB70AAA3AF712BE3D82C0DAB58D7DB896F5CD01F70E7171713A9D2B41EE5C266EE9958F766ACDCA24E955DC8E8E7810BB6D4A515DF4256CC6D9474A43101DC5ACFBC2D2DEDEF2EE7DEB927EF208635A8F282F2227CAF8BDB43637395C6CBE54B0B4C92DB0D6378EDA53F09A6ABB6E97EB1BD2BB1C7BFF3464E8A5DABED469373DA21A5CE0B4D38918C1E464B78D843DCD7BDE5D504034140B27ABEDEBCAD2E9F2C52363D32BFDBD7F33674EC5DDBAE6CD93482AF7768D2B4EF5E67916F4CDA46DEF428F80CBE48633137F92200659DB4F72EF6431B9FF72AE1E3FA97630FCCD2F36413F9537DC6BB88672E33BC5F179795C0CD756F1BE6A7FDCA7D5F3595BB61C6C64CEDF7362D527152EF479E6379756FC63292C4F2D06268988ED884AD73C7C9646C7271BE92FC558975CB516B8F671207C4EEDD77790307473857DCB73B95AD106CC9B32E075427B3B9720474235CF6DCCFC52FDEC1592D432E9BEC89C0BBFA6AB6DB24F4E4C53FC5F2F996CF911BF4EA7FCDCFE656A18DAD56CF7E86854EF2684AB03A35CDCB6D2DA7BC9346411C92B8F846D2E3F62E66D5A739282ED642F91CA7D0FC83EE6C324D94FF0072698DD381EF98971FB5763D636693835D8B4F9187B7CAB07ED269EA034BF88645EDFC5008E61FFD72B49F92D0EC4FFDD43C6BF03327C133C7018E984170EFF75D51FE10ABBD3ADDA7712DC7C11266CAC9247C6D35747B4B8776E0485AAD1449F796344165B32DF52C903E8B8B686E81F168311F9B57451BDFF4FF0063712B07497B8EABC4ECFF003DC93176D4AB7CF648F1FC317F70FF00A543D2F8BEBEE1661D9AD3F2E3F51ACDE2F7A78B725FD34F3E07D08BEA73C8420080A120752A8D82CC97713075D553515A1A7CA4D6F79098A61E2C78FC4D3DE152A0855F4D2D93F64A44911AED9474F876156B45DA8D264A765D5A4F00754BDA69DF51A85A2EA1DBD65615DB7FD2DAF6AE28D8ED595E8E4427DCF8FB3B48AC37156005A091A1257CB372DD19EB33B7C4B86770D0347BA8ACD08B55B445B92CE63797BCD7736A49D01A2F6EE8FCFF00FA4CDF6DA725EEA557D871BBBE27FBD824BEFD3E3C4D5718BC37B7B406AD06BEE0BCDF71B5A63C4F42D54832735EF5CEA308B72C6C9A2920905592B4B1C3BC38514D66E4ADCE328F38B4D16CE0A49A7C99C167BC758E58E31C6925B3DD13C7F135C42F50CF92C993BCB94D26BC8C5DBADFA36D5B7D953B661016E32D47696077C5799E5FFAB2F69B2BBCC8DFAB37EEB1F4EB3EF61A493DB8B561F1B891B19FE9256DBA5ECAB99F693E49D7C954D7E7CB4DA6D1ADF45AFF00F35C2E1B526AEB479653B9BA5165756D9D396E5F98BB05D6D47C09AE76D3F3F83C9D9D2A67B59DA078F9669F35A2C0B9A2F41F7491932E472BF48CBEF6E44CFE90B093EDE8BADEA64A11A2ED65B8D2AC1B3B04B247130BE476D682054FF11A0F995C4C62DBA22448B7796ACBEB3B9B197F05CC5240EF648D2DFBD4962EB84E325D8D3292E4737F47E19196D7BE78224B777E5DC0F5DCC25A7E61751D5325AA34E4F8F996D9FB94F1253EA1DEFE4385E6E769DAE75B3A069F1B8708B4F7396A361B5AF2EDAF1AF911E4CA96D9CD7D19B8FCBE4E4B5068D9A13A78B5751D570D56D4BB998BB7BE68EB7C8ADFF39C7F2B6B4A996D2E0347F108CB87CC2E376E9E8BF6E5DD246C26AA8F1C52DCDB71EC6C274798232E07F79E01FBD5DB9CF5644DF8B2E93341C2B3E72FC8795B77EE863BDD96FDC2385A21D3DEDAAD9EF386ACD8B345F87E3C4C6B17356AF0648E6B06BB3F69941F8A3B59ADCFBDED7B7EF5AC85FA58707DB24CCA51E0D9D2FD2EB4FCC72592E7F66D2191E0FF0013E91FDE5769FB6789EA6E1AFF00241BF3F97EB395EABBDA71547F335F4713B3AFA08F36284A8E532B42D493060513997C6260CF7B4E87456EA2FD2696F72040EAAAA43491BBECBBC57FEAAEA96E921F98CF3A36915246BA2BEA5B420390E6B2D838B8B4BE31AED3A1F71554976F22956B91B2C2E4E0CBD9C57F055B14E090D3D4104820FBD7CB9D4D83FA5CEBB6FB149D3D8F8A3D876DC8F5B1A13F0F81B3AAE7E8665083FA9D7471F856DF743B8C24F655E2A3EC2BB9E91CCA5BBD8FFF00D8A3F43E3E68D666636ABB6EE7E4AFD26A7D2A71BA64F744D431A1A0F8B961F527C948A36D6E5581D3093FF55CA22DA141DE80E03EA2D93F1BEA7C65A08B7CB450DCC54ED757CA93FA9A17A56C573D5DBBC60DC7EB4614B85D5E2778B28FC9B3823E9B2368F83579D5D7AA6FC599F27C4817AD70CB3F089238CFD0DB981F30EF636BF612175DD138D295F9DD4B8423FF00A9D0D4EE97528C62FF0013F871233E865EF94EBEC6389FAD82468F16E87E4B2BAC6D27A66BBCBF6E97CAD1DA5A5B5683A8E87D87AAE0AB4364CE71E95621D8D6E7192376BE0BFB8B56FB22908FB0AEA7A9727D476E9DB14FCD1163C6917ED323D58CFBB0781C7B627ED9AFB25691D2BA98E27F9D27C9A15BD3383EADE9B7C5460FE954443997B425E2D138B79C5C5BC33B0FD32B5B234F83802B9D9434B69F61986938EE27F48BCCED0519757CFBA8E9FBB3344847F312B63B8E57AD0B5E114BC846145ED345EB0FE67FE12E7C0DAC26F6D5970EEE69DE5B5F690B6FD258FAAFCA74E118FC4D6EE7774C547B64CE69E9D5D0B4E4164FAE85FB0EB4A8768BA2DF2DEBB3220C29FCC8FA11D4735CD774782D23C082179A274753774312F6EE2C3E22E6F09A43616D2495EEF2A3247CC2C9C6B6EFDE8C7B652FACB2F4A89B38AFA31907C7999A298FD57AC73A4AF6BC9DFF006AEEFAB2CA95A54FC26AB6DB9C5F89DDAB5F6AF3946E28757F482D696D94BE73685F2450B4FF0081A5CEFB42F66FDABC55185EBAFBD457D2DFD4705D6777E6B70EE4DF99D317AE54E20F056348B9189387EB4565099346AEE43DC3A2AA8872349750BE87EF572896B911EBFB473B750555F429521799C7CAE07E92AE2CA9CF735829240EFA4D75ECAF62A84CBBC323971F6F2D8CD5DAC9B7C55EC6C83503DE2ABC53F737034E4C2F5384E34F7C7F9347A1F47E46AB12B7F95D7DCC9957B97949D5909F576CE4BCF4FB32E8813359B1B79181D7FB32073BFA6ABA1E96BAA19D0AFE2F97CF818D94BFCB74EEF8181E8DDB9671365E3BADC3AAD3DED6E9553755CFFDCE9EE25C775B5124DCDB37FF001DE219ACDFED59DAC8E8C1D2B23C6C60FE6705ABD9B0FF0051956EDFE665B9177D38397719B83C8332986B0C8C66ACB982292BE25A2BF358D9B65DBBD28BEC6C9A32D4ABDE437D4DC17EA190E29978DB592CF22DB5988EBE4DD0D09F00F60F8ADF74F66FA76EFDB7F8A155ED8FFC482E5AACE2FB99D02BA06F8507C28B993288DF35B1FD57057F63F89CFB695CD6FF00137EA1FE95EB7FB7D875C3C89FE6A25FE15538DEA3C8D391697771F3E071CF4BEF7F4FE4F6C1C691CD58CF67E2140B07A86CFA98EFC389B7C09D267D0C4AF313786258D9C764FBB74400FCD4EEB8701DAE7B457E6164DFBDAF4D7B150694B91C47D7CC89933581C5B0FD36914B76F1DCF99FE5B6BEE61F8AF40E8BB1A6CDD9FE669791A1DDAE7CF15DC752E0593FD4B8AD84CE357C6CF29DED62E377BC7F4F264BB1B3718F2D504C9255A2A476F55ABAB27341EA1B5971E9D67A0343235B0DD307FF009E40E3F2AAF4EE88C5FF00677A74FBCD2F2E2729BEDFA5FB71EE4FE93E79E397E23BF86461A1648D235F159D9F66B06BC0BB16ED1A3E9F86613431CC3A3DAD70F78AAF269C28DA3AA8F1443FD55BD9EDF846421B5697CD7862B50D6F5DAF7873CFF2B4AE8BA570DDDCB8BFCA9C8D6EEF7D5AB357DBC0E37E9EE4859E76D1CFAC723640D735C083F569D176BBF6249DA9268D4ED97E3AD519F4B19581A5E4ED6F79E9F12BCA55B6DF23A96763F4DEE1F06022631BA4D24931777D4EDFB97B9F44C25630229AA3949CBEA3CD7A9297325F724913F8A42E152BB9B7759CBCE342F5166B8548EA787C7556E8A154CC396D89068150B8D74F625C2B45506A2EB1EE757E940692F30DE657E940476FB8F0757E807DCA95A0488D64F8FF00E5237DD44DA3A3A1D3B970FF00B8389EB6DFAD73B5252F73E0FEA3A6E95C8F4F2B4F65C54F2E2588DDB98D3DBD0AF9F26A8D9E90CB392B28F258DBCC6CA2B1DDC1340E1E1230B7EF5262DE76EEC66B9C5A64738EA54EF347C0B18EC3F0FC4E3E51496185AD93FC43AACFDF323D6CBB935C9B2B6EDE88A8F7234FEB05A4B91E0591B1B73F5B8C72BDA3F6990B84847C82DE744E339E54AE2E56E2E5E7C3EB359BC5D51B6A2FF1BD2617A2D9637DC3A1B191D59F1EEF2687F70EA141D598AADE539AE53E2656DF7355A5E04FEE6DD975188A41A35F1C8DF0746F0F14F785CE5BBAE0EBE1433D702F6EFABE6A248A50D35ECC05DC81C6AC00308F0035FB57BEF43D8F4B6E87F5EA979F03CDFA8A7AB2DFF4A47CF3039D87E4F2C3D1D6776E0DFF000B64FA7E4B4FB963F0947DA6EB06ED54647D2F6F7027B78666D0B64635D51E22ABC7AE5BA49A3B08F1E25C0EA2B522B43E7BF5C7C97721B4BF88D488BF2D391D8E85D515F6872F67D8B01D9C1B5FD4B579F1388CCC9D791717E574265E8C64C4D8AB8B171ABA3707B7D8742B87EABC7A5C533A4DAEE6A81D43781D5725436B422BC99B90CB45738CB56136D2B1D0CA3B1E1E28E1F35EDFD1F63D3DBA09AFBFA9FD3F61E75BF5CD5952A7E1A1C7E6F4A797632E0CF89B67DDC35DDE41A873475A071EAB6995B729A7431F1F3DC799DE78ED9720B9C4D9C3FA45D9BC6C4D12C6E8F66D7014A6E90B42F2CBFD299772F4A9149579B3B386F76230557C7C0DF37D36CCE7D91B7316ECB4B7638B991191B23DCE229A86E8345D874CEC2F065294DA6E6A8A873DBD6E91CA8A8C53493AF136307A13C62674725DD8B5F2B087324692D7348D742085D75EB30BA9A94799A3B77E56E555CC9AE2FD32E376D2B277D88B895BF85D72F926DBEC0F242C1B3B3D8B7FE9C12F7225BDB8DC9FDE937EF2796560DB76363898191B7A340000F705B8B36DC781A9BB7AA6D18DA0A2D85A461499796D88C202842B5A05A923690740A368BD33065B604927A2A54BCD65C5B475E9F051EA2AA26A6E2D9A7B001E2AD722BA4D25FD9327826B70D14918E683EE583B8588E4599DA7F8E2D1938973D2B919FE5699CCA025BBA377E261208F10687E6BE5CC8B6E1369F63A1EC55AA4FBCB84EAA24E81228C01A1AC68A34694EE15AAAB752AFBCD4E5990DD31D6D380E81F1BA391BDFE67D247C17ADFEDE622562ECDFE37A7DC93FB4E33AA2F3F52115F878BFE3DC723F4AE77E0795DFE027346C8E92303BDD1B8D0FBD6AFAB715CAD6AED8336FB4DE4FDE76E2E2BCE749BE48F3BABA13A155512AF8712117F9CB78DF3485DBAAE71D0F895F47EDB6BD0C5B56FF2C523CAB31EBBF3977C99C5B964864E413E56D5A5B0CE5A5EDEE700013EFA2C1DC719C9B92E467605FD31D2CEF7C2B242FF008CD8CD5AB9ACF2C8EDAB34A2F15DDF1BD3C892EF67A061CF55B4CDDCD74C8585EF70000240240AD3B02C2B18B2BB3518AAD5D09EEDC508B6FB11CB66F4AF35C95F25CDDB1C1D70E73CEFAE9B893AFC57D1366D28C147B124BC8F29B93AC9BF164A7837A3BC9F8DDEBAE2D67864B791A5A6195CE6904F4D403A2E6F7CE9E5971A45E9E26E76DDE3D17F32D4757B3F4DB2D70D0EBEC9B20AF565B43BCD3BB7CA7FF8AD3D8E8AC783F9DB9FD08CCB9D47724BE58A892BC7701C759C6D635A657FED4B25373BC4D001F25DA625B56A118455145517B8E7322EFA927293E2DD59BC878C5B4628D60F82CE4DB316A91B2B7C3B63A0A5405476AA53D648D8C78E68EC0AAB1C865926532CDA3A853C6C104AFB2FB20637A053C2C113B8D974300E8B2218E58E47A0D5950B542DA9E94E5020080F2E504D95463CADA82A164B13593C6493D8144E44AA26AAEA3A02AC732E5134773A74D0A8DDC689144E5B9667E4F3B7500D18F7798C1E128AFDABC07ABB0559CCB94E4DEA5EC67A86CB91EAE345BE6B832DD57266D28792FA2B922B439B67B9ADBDBE46EEDE1064744F316834AB343F35EEFD2D67D1C0B5DF25A9FBD9E77BCCFD4C99BEC5C0E733E5268F95C1C8638CC7BA56BA602B41D1B5F6151EF7B7FAB6E74ED4646D595A2514CFA0E2BB6CF032E1A6B1C8D0F07B28755E293B2E3268EFE2EAAA633EFA29C4905AC826B92D735B1C5F5BB71141F86B4F7AD9EDDB4DFBD723A60DC6AAAE9C0C3CBCCB7084AB255A7798161E985FCEC6BAE9841342411DEBDFA94E079749BF337717A378DBA6ECBB86A0F5A2AD17696D5926E3FE8EE1B1907E5619AE9B67BB79B66CC5AD24F8815A7B0AD164EC58B76EFA928272F1E46D6DEED7E305152E04DB1FE9EF1AB222483150F9C3FDE95BE73FF9A4A9591670E36F8422A3EC5431EEE64A5F7A4DFBCDF4580B714A4634E9A2CE8C1988EEA3322C346DA519F2532B6D91BBE8CE8B1DB7B15D1B0452C9329964D1D54D1B2412BE643616346814D1B242E6CB81807629E360B5C8F41AA656116D4A86A9636514A95A2915B4854AABD2281540401004050851CA254B6F66E58D34CBE3230E58434958D2278CAA6AEE62D1DA57B963C99911446B2514DB488DBF258F39325491CB395595E4172DC8B9AE718C6D90D3F601AFC9713D59B4BC9B5EA457CD0FA51D2EC39EACCF44BEECBE26AE7C9D8C2D6BE5B88D9BC02D05ED0483DC3A9F82F23B38576E3A462DFB11DB4EEC21F79A42037F7F4FD2EC2EAE89FC323207B6307B097BC34516F713A5B2EEB5F2695E260DFDE71E09FCD566BF13E8A5CB9EE9F27574F2B9D24806A373DC5C457DEBDAF1EDA842315F852479EDDB9AA4E5DE4B2CFD1BC29019756BE630F507C54AD2227275F612EC67A5DC62DD91B64C73676B006B193BDF246D0DE8031C76FC96B2DED966DB6E1049BF032A79B724A8E4FCC965971BB1B3608ED6D62B78C746C51B5807F280B2A36598D2BC8CF661A2E9B053D8B2236A8412BC8CA8F0F137411A9D4191BBC8CA8F1CD6D28D0149E891BC832996AD6F62BD592177AA5E6C4D1D8A48D8237367B0C1DCA78D92CA9EB6A96364A54AED52AB28A54AD14AAD8A95A2B945140AB40154040100401004010040508514ADD4AD4F2E8C3BAA86562A5548B4EB68CF50A1963122BACB4EC7DBBBF136AA278A5EB224587E131D2692DBB246F739A08F9A8E58BC2857F51230E2E21C72DE4335B62ED6198FFB8C8181DF1A5562FF00F9EA1F7569F670F8123CDB8F9B6CC9388B7A51A283BBB159FA3A3A95597229FA4443A01F057C71A857F56CF6DC644DF6FB15DFA72D794CBECB2637B148B1C8DDF6CBADB760EC522B058EE33D88C0EC5246C16391E8354AAC14A95DAA5568A54AD148AD14A95A2BFD3152B457E928156802A8080200802008020080200802008020080200A94012880A04D280A0EE54D0BB80A0EE4D0BB814A0EE4D0BB815A04D2BB80A04D2BB8055A2012802A80802008020080200802008020080200802008020080200802008020080200802008020080200802008020080200802008020080200802008020080200802008020080200802008020080200802008020080200802008020080203FFFD9,240,240);


--
-- Dumping data for table `appstore_component`
--
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (2,'fr.paris.lutece.plugins','Document','Gestion documentaire','plugin-document','3.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (3,'fr.paris.lutece.plugins','SEO','Optimisations pour les moteurs de recherche','plugin-seo','2.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (4,'fr.paris.lutece.plugins','Contact','Formulaire de contact','plugin-contact','3.0.1','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (5,'fr.paris.lutece.plugins','Extend','Extensions des contenus','plugin-extend','1.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (6,'fr.paris.lutece.plugins','Portlet Pages filles','Portlet de liens vers les pages filles','plugin-childpages','3.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (7,'fr.paris.lutece.plugins','Extend - Commentaires','Extension pour ajouter des commentaires','module-extend-comment','1.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (8,'fr.paris.lutece.plugins','Extend - Feedback','Extension pour donner un avis','module-extend-feedback','1.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (9,'fr.paris.lutece.plugins','Extend - Réseau sociaux','Extension pour partager sur les réseaux sociaux','module-extend-opengraph','1.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (10,'fr.paris.lutece.plugins','Outils Google','Google Analytics - Webmaster tools','plugin-gtools','1.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (11,'fr.paris.lutece.plugins','Portlet HTML','Portlet de contenu HTML','plugin-html','3.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (12,'fr.paris.lutece.plugins','Captcha ','Captcha pour les formulaires','plugin-jcaptcha','2.1.4','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (13,'fr.paris.lutece.plugins','Moteur de recherche','Moteur de recherche Lucene','library-lucene','1.0.5','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (14,'fr.paris.lutece.plugins','Statistiques des recherches','Statistiques des recherches faites sur le site','plugin-searchstats','3.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (15,'fr.paris.lutece.plugins','Informations système','Informations du système','plugin-systeminfo','3.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (16,'fr.paris.lutece.plugins','Nuage de tags','Nuage de tags','plugin-tagcloud','3.0.0','plugin');
INSERT INTO appstore_component (id_component, group_id, title, description, artifact_id, version, component_type) VALUES (17,'fr.paris.lutece.plugins','Gestion des Thèmes','Gestion des thèmes graphiques','plugin-theme','2.0.0','plugin');

--
-- Dumping data for table `appstore_application_component`
--
INSERT INTO appstore_application_component (id_application, id_component) VALUES (1,2);
INSERT INTO appstore_application_component (id_application, id_component) VALUES (1,3);
INSERT INTO appstore_application_component (id_application, id_component) VALUES (1,4);
INSERT INTO appstore_application_component (id_application, id_component) VALUES (2,1);
INSERT INTO appstore_application_component (id_application, id_component) VALUES (2,2);
INSERT INTO appstore_application_component (id_application, id_component) VALUES (2,3);
INSERT INTO appstore_application_component (id_application, id_component) VALUES (5,4);
INSERT INTO appstore_application_component (id_application, id_component) VALUES (5,5);
