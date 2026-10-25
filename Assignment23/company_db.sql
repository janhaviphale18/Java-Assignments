CREATE DATABASE company_db;

USE company_db;

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL
);

INSERT INTO employees (emp_id, emp_name, department, salary)
VALUES
(101, 'Amit', 'IT', 45000),
(102, 'Neha', 'HR', 40000),
(103, 'Rahul', 'Finance', 50000),
(104, 'Priya', 'IT', 55000);

SELECT * FROM employees;