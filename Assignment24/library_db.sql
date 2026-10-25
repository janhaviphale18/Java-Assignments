CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    price DOUBLE
);

INSERT INTO books VALUES
(101, 'Java Programming', 'James Gosling', 450),
(102, 'Database Systems', 'Korth', 500);

SELECT * FROM books;