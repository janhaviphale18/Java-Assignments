CREATE DATABASE book_issue_db;

USE book_issue_db;

CREATE TABLE book_issues (
    book_id INT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    issue_date DATE NOT NULL,
    return_date DATE
);

INSERT INTO book_issues VALUES
(101, 'Amit Sharma', '2026-10-01', '2026-10-15'),
(102, 'Priya Patil', '2026-10-05', '2026-10-20');

SELECT * FROM book_issues;