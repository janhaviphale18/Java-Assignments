CREATE DATABASE IF NOT EXISTS college_db;

USE college_db;

CREATE TABLE IF NOT EXISTS student (
    roll_no INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    marks DOUBLE
);

INSERT IGNORE INTO student VALUES
(1, 'Amit', 'CSE', 85),
(2, 'Neha', 'IT', 90),
(3, 'Rahul', 'ENTC', 78);

SELECT * FROM student;