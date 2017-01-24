CREATE TABLE user(user_id INTEGER(10) NOT NULL AUTO_INCREMENT, 
				 country VARCHAR(50),
				 email VARCHAR(50),
				 pin_code INTEGER(10),
				 username VARCHAR(50),
				 password VARCHAR(50),
				 PRIMARY KEY(user_id));
				 
CREATE TABLE roles(role_id INTEGER(10) NOT NULL AUTO_INCREMENT,
					role_name VARCHAR(30),
					PRIMARY KEY(role_id));
					
CREATE TABLE user_roles(user_role_id INTEGER(10) NOT NULL AUTO_INCREMENT,
						user_id INTEGER(10),
						username VARCHAR(50),
						role_id INTEGER(10),
						role_name VARCHAR(30),
						PRIMARY KEY(user_role_id),
						FOREIGN KEY(user_id) REFERENCES user(user_id),
						FOREIGN KEY(role_id) REFERENCES roles(role_id));
					