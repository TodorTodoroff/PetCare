-- some test users

INSERT INTO users (id, email, first_name, last_name, is_active, user_roles, password)
VALUES (1, 'admin@example.com', 'Admin', 'Adminov',true, 'ADMIN', '$2a$10$5eAs.pN2nCauHx1ICu6E/.H1mWUOCj10Q/ztD90u6lc3W0Cd8hta.'),
       (2, 'user@example.com', 'User', 'Userov',true , 'USER', '$2a$10$5eAs.pN2nCauHx1ICu6E/.H1mWUOCj10Q/ztD90u6lc3W0Cd8hta.');



