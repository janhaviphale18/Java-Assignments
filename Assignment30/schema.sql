CREATE DATABASE IF NOT EXISTS jspcrud;
USE jspcrud;

CREATE TABLE employees (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary INT NOT NULL
);

CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    disease VARCHAR(60) NOT NULL,
    treatment_status VARCHAR(30) NOT NULL
);