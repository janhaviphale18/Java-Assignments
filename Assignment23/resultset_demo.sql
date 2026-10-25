CREATE DATABASE resultset_demo;

USE resultset_demo;

CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    course VARCHAR(50) NOT NULL,
    marks DOUBLE NOT NULL
);

INSERT INTO students (roll_no, name, course, marks)
VALUES
(1, 'Amit', 'CSE', 85),
(2, 'Neha', 'IT', 90),
(3, 'Rahul', 'ENTC', 78);

SELECT * FROM students;