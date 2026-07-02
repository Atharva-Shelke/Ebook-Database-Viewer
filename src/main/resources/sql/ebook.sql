-- name: create_ebook_table
CREATE TABLE IF NOT EXISTS ebook (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    price INT,
    quantity INT
);

-- name: insert_ebook_records
MERGE INTO ebook KEY(id) VALUES
(1, 'Java Basics', 'James Gosling', 500, 10),
(2, 'Spring Boot', 'Craig Walls', 700, 5);

-- name: find_all_ebooks
SELECT * FROM ebook;