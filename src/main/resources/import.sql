INSERT INTO tb_user (email, name,  password) VALUES ('alex@gmail.com', 'Bob Brown','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name,  password) VALUES ('bob@gmail.com', 'Alex Brown','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name,  password) VALUES ('maria@gmail.com', 'Maria Green','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,2)
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,2)
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,3)