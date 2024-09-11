INSERT INTO tb_user (email, name, password) VALUES ('alex@gmail.com', 'Bob Brown', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES ('bob@gmail.com', 'Alex Brown', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES ('maria@gmail.com', 'Maria Green', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp HTML', 'https://www.needpix.com/photo/download/1282532/training-course-training-online-courses-learning-course-icons-education-class-educational-courses-study', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ASwitch-course-book-grey.svg&psig=AOvVaw1My9yHAE-B5eq4Uu96BR7M&ust=1725777576997000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCODntMycsIgDFQAAAAAdAAAAABAE');

INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-07-13T03:00:00Z', TIMESTAMP WITH TIME ZONE '2021-07-13T03:00:00Z', 1);
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2021-07-13T03:00:00Z', TIMESTAMP WITH TIME ZONE '2022-07-13T03:00:00Z', 1);

INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://www.needpix.com/photo/download/1282532/training-course-training-online-courses-learning-course-icons-education-class-educational-courses-study', 1, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Forum', 'Tire suas duvidas', 2, 'https://www.needpix.com/photo/download/1282532/training-course-training-online-courses-learning-course-icons-education-class-educational-courses-study', 2, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas para turma', 3, 'https://www.needpix.com/photo/download/1282532/training-course-training-online-courses-learning-course-icons-education-class-educational-courses-study', 0, 1);

INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 1', 'Neste capitulo vamos começar', 1, 'https://www.needpix.com/photo/download/1282532/training-course-training-online-courses-learning-course-icons-education-class-educational-courses-study', 1, null);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 2', 'Neste capitulo vamos continuar', 2, 'https://www.needpix.com/photo/download/1282532/training-course-training-online-courses-learning-course-icons-education-class-educational-courses-study', 1, 1);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 3', 'Neste capitulo vamos finalizar', 3, 'https://www.needpix.com/photo/download/1282532/training-course-training-online-courses-learning-course-icons-education-class-educational-courses-study', 1, 2);

INSERT INTO  tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2020-11-13T13:00:00Z', null, true, false);
INSERT INTO  tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2020-11-13T13:00:00Z', null, true, false);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 1 capitulo 1', 1, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (1, 'Material de apoio', 'https://www.youtube.com/watch?v=D4frmIHAxEY');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 2 capitulo 1', 2, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (2, 'Material de apoio', 'https://www.youtube.com/watch?v=D4frmIHAxEY');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 3 capitulo 1', 3, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (3, 'Material de apoio', 'https://www.youtube.com/watch?v=D4frmIHAxEY');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Tarefa do capitulo 1', 4, 1);
INSERT INTO tb_task (id, description, question_Count, approval_Count, weight, due_Date) VALUES (4, 'Fazer tarefa', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2020-05-25T13:00:00Z');

INSERT INTO  tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO  tb_lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1);
