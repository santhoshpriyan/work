/*insert into workout_category(category_id, category_name) values(1, 'jogging');
insert into workout_category(category_id, category_name) values(2, 'walking');
insert into workout_category(category_id, category_name) values(3, 'aerobics');


insert into workout_collection(workout_id, workout_title, workout_note, calories_burnt, category_id) values (1, 'jogging at park', 'at voc', '10', 1);
insert into workout_collection(workout_id, workout_title, workout_note, calories_burnt, category_id) values (2, 'morning walk', 'at voc', '12', 2);
insert into workout_collection(workout_id, workout_title, workout_note, calories_burnt, category_id) values (3, 'aerobics at office', 'evening', '15.54', 3);

insert into workout_active(active_workout_id, workout_id, start_date, start_time, end_date, end_time, comment, status) values (1, 1, '2018-04-11', '21:05:00', '2018-04-11', '21:08:00', 'comment1', false);
insert into workout_active(active_workout_id, workout_id, start_date, start_time, end_date, end_time, comment, status) values (2, 2, '2018-04-06', '11:15:00', '2018-04-06', '11:45:00', 'comment2', false);
insert into workout_active(active_workout_id, workout_id, start_date, start_time, end_date, end_time, comment, status) values (3, 3, '2018-01-11', '08:22:00', '2018-01-11', '08:52:00', 'comment3', false);
insert into workout_active(active_workout_id, workout_id, start_date, start_time, end_date, end_time, comment, status) values (4, 1, '2018-03-10', '18:17:00', '2018-03-10', '18:43:00', 'comment4', false);
*/
insert into USER(USER_ID, USER_NAME, PASSWORD, FIRSTNAME, LASTNAME, TOKEN, ROLE) 
	   values(1, 'santhosh', '12345678', 'Santhoshpriyan', 'B', '123456789', 'ADMIN');
	   
insert into USER(USER_ID, USER_NAME, PASSWORD, FIRSTNAME, LASTNAME, TOKEN, ROLE) 
	   values(2, 'jashwin', '12345678', 'Jashwinpriyan', 'S', '123456789', 'USER');
	   
insert into USER(USER_ID, USER_NAME, PASSWORD, FIRSTNAME, LASTNAME, TOKEN, ROLE) 
	   values(3, 'narmatha', '12345678', 'Narmatha', 'S', '123456789', 'USER');

insert into USER(USER_ID, USER_NAME, PASSWORD, FIRSTNAME, LASTNAME, TOKEN, ROLE) 
	   values(4, 'test', '12345678', 'Narmatha', 'S', null, 'USER');
	   