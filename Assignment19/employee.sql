CREATE DATABASE IF NOT EXISTS college_db;

USE college_db;

CREATE TABLE IF NOT EXISTS employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    department VARCHAR(50),
    salary DOUBLE
);

INSERT IGNORE INTO employee VALUES
(101, 'Amit', 'IT', 45000),
(102, 'Neha', 'HR', 40000),
(103, 'Rahul', 'Finance', 50000);

SELECT * FROM employee;