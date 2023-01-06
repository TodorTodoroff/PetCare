-- some user roles

INSERT INTO user_roles (id, user_role)
values (1, 'ADMIN'),
       (2, 'USER');

-- some test users

INSERT INTO users (id, email, first_name, last_name, is_active, password)
VALUES (1, 'admin@example.com', 'Admin', 'Adminov', 1, '$2a$10$5eAs.pN2nCauHx1ICu6E/.H1mWUOCj10Q/ztD90u6lc3W0Cd8hta.'),
       (2, 'user@example.com', 'User', 'Userov', 1, '$2a$10$5eAs.pN2nCauHx1ICu6E/.H1mWUOCj10Q/ztD90u6lc3W0Cd8hta.'),
       (3, 'test@test', 'test', 'testov', 1, '$2a$10$5eAs.pN2nCauHx1ICu6E/.H1mWUOCj10Q/ztD90u6lc3W0Cd8hta.');




-- some roles to the test users
INSERT INTO users_user_roles (user_entity_id, user_roles_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 1),
       (3, 2);
