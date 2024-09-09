--Create database
Create database libraryDB

-- Create books table
CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) UNIQUE NOT NULL,
    available BOOLEAN DEFAULT TRUE
);

-- Create users table
CREATE TABLE user(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

-- Create transactions table
CREATE TABLE transaction(
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    book_id INT REFERENCES books(id),
    issue_date DATE NOT NULL,
    return_date DATE
);

