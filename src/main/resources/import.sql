INSERT INTO tb_user (email, name,  password) VALUES ('pedro@gmail.com', 'Pedro Eduardo','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name,  password) VALUES ('alex@gmail.com', 'Alex Green','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name,  password) VALUES ('maria@gmail.com', 'Maria Brown','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (1,2)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,2)