
/*data for user*/

insert into user (user_id, country, email, pin_code, username,password) 
values (1, 'INDIA', 'ddontha@nisum.com', 506002, 'Dinesh','Dinesh');	

insert into user (user_id, country, email, pin_code, username,password) 
values (2, 'INDIA', 'sraju@nisum.com', 506002, 'Raju','Raju');	

insert into user (user_id, country, email, pin_code, username,password) 
values (3, 'INDIA', 'raja@nisum.com', 506002, 'Raja','Raja');

/*data for roles: consider these roles as seeded data
SuperAdmin can still add roles on demand
As of now, we are not using GUEST role.
*/

insert into roles(role_id, role_name)
values(1, 'USER');

insert into roles(role_id, role_name)
values(2, 'ADMIN');

insert into roles(role_id, role_name)
values(3, 'SUPERADMIN');

//data for user_roles 
//pending is : in user_roles adding only one role??? - need to solve this.

insert into user_roles(user_role_id, user_id, username, role_id, role_name)
values(1,1,'Dinesh',1,'USER');


insert into user_roles(user_role_id, user_id, username, role_id, role_name)
values(2,1,'Dinesh',2,'ADMIN');


insert into user_roles(user_role_id, user_id, username, role_id, role_name)
values(3,2,'Raju',1,'USER');


insert into user_roles(user_role_id, user_id, username, role_id, role_name)
values(4,3,'Raja',1,'USER');