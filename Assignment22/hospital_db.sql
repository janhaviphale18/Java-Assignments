CREATE DATABASE hospital_db;

USE hospital_db;

CREATE TABLE hospital_staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    login_id VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

INSERT INTO hospital_staff
(name, role, login_id, password)
VALUES
('Dr. Amit Sharma', 'Doctor', 'doctor01', 'doc123'),
('Priya Patil', 'Nurse', 'nurse01', 'nurse123');

SELECT * FROM hospital_staff;