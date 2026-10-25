CREATE DATABASE login_db;

USE login_db;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

INSERT INTO users (username, password)
VALUES
('admin', 'admin123'),
('student', 'student123');

SELECT * FROM users;