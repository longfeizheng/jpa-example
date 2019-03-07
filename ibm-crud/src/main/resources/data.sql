INSERT INTO client (id,name,address,city,telephone) VALUES (1, 'tom','am','beijing','1333333');
INSERT INTO card (id,number,ccv,type,client_id) VALUES (1, '1234567890123456','123','xinyongka',1);
INSERT INTO consumption_his (id,client_id,card_id,consumption_date,description,amount) VALUES (1,1,1,'2019-02-21 00:05:00','testing','100');
INSERT INTO bank_advisors (id,consumption_his_id,name,specialty) VALUES (1,1, 'jerry','i dontt no');