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

--Insert books query
INSERT INTO book (title, author, isbn, available) VALUES 
        ('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', TRUE),
        ('To Kill a Mockingbird', 'Harper Lee', '9780060935467', TRUE),
        ('1984', 'George Orwell', '9780451524935', TRUE),
        ('Pride and Prejudice', 'Jane Austen', '9781503290563', TRUE),
        ('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', TRUE),
        ('Moby Dick', 'Herman Melville', '9781503280786', TRUE),
        ('War and Peace', 'Leo Tolstoy', '9781853260629', TRUE),
        ('The Odyssey', 'Homer', '9780140268867', TRUE),
        ('Ulysses', 'James Joyce', '9780199535675', TRUE),
        ('The Brothers Karamazov', 'Fyodor Dostoevsky', '9780140449242', TRUE);