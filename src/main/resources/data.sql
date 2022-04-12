insert into roles
values (1, "rola 1"),
       (2, "rola 2"),
       (3, "rola 3");

insert into group_entity
values (4, "grupa 1"),
       (5, "grupa 2"),
       (6, "grupa 3");

insert into event_places
values (7, "city1", "local_number1", "RESTAURANT", "postcode1", "street1", "street_number1"),
       (8, "city2", "local_number2", "RESTAURANT", "postcode2", "street2", "street_number2"),
       (9, "city3", "local_number3", "RESTAURANT", "postcode3", "street3", "street_number3");

insert into events_entity
values (10, "2038-01-19 03:14:07.999999", "desc1", "2038-01-19 03:14:07.999999", "ACTIVE", 3, 3,
        "2038-01-19 03:14:07.999999", "title1", 7),
       (11, "2038-01-19 03:14:07.999999", "desc2", "2038-01-19 03:14:07.999999", "ACTIVE", 4, 4,
        "2038-01-19 03:14:07.999999", "title2", 8),
       (12, "2038-01-19 03:14:07.999999", "desc3", "2038-01-19 03:14:07.999999", "ACTIVE", 5, 123,
        "2038-01-19 03:14:07.999999", "title3", 9);

insert into users
values (13, "HR", "email1", "firstname1", "lastname1", "password1", "phone1"),
       (14, "HR", "email2", "firstname2", "lastname2", "password2", "phone2"),
       (15, "DEVELOPER", "email3", "firstname3", "lastname3", "password3", "phone3");

insert into users_groups
values (13, 4),
       (14, 5),
       (15, 6);

insert into users_roles
values (13, 1),
       (14, 2),
       (15, 3);

insert into event_participants
values (16, "YES", "HOST", 13, 10),
       (17, "YES", "HOST", 14, 11),
       (18, "YES", "HOST", 15, 12);

insert into posts
values (19, "2038-01-19 03:14:07.999999", "desc1", "file1", 13, 10),
       (20, "2038-01-19 03:14:07.999999", "desc2", "file2", 14, 11),
       (21, "2038-01-19 03:14:07.999999", "desc3", "file3", 15, 12);

insert into post_comments
values (22, "2038-01-19 03:14:07.999999", "desc1", 13, 19),
       (23, "2038-01-19 03:14:07.999999", "desc2", 14, 20),
       (24, "2038-01-19 03:14:07.999999", "desc3", 15, 21);

insert into comment_answers
values (22, "2038-01-19 03:14:07.999999", "desc1", 13, 22),
       (23, "2038-01-19 03:14:07.999999", "desc2", 14, 23),
       (24, "2038-01-19 03:14:07.999999", "desc3", 15, 24);

insert into feedbacks
values (25, "2038-01-19 03:14:07.999999", "desc1", 5, 13, 10),
       (26, "2038-01-19 03:14:07.999999", "desc2", 420, 14, 11),
       (27, "2038-01-19 03:14:07.999999", "desc3", 69, 15, 12);