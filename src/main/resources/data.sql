/*INSERT INTO app_users (id, name, address, email, phone_number) VALUES (1, 'Danyal Khalid', '17 sunhill close', 'Dkhalid354@outlook.com', 782780922);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (2, 'Alice Johnson', '123 Oak Street', 'alicej@example.com', 55512345);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (3, 'Bob Smith', '456 Maple Avenue', 'bobsmith@example.com', 55523456);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (4, 'Carol White', '789 Pine Road', 'carolw@example.com', 55534567);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (5, 'David Brown', '101 Apple Blvd', 'davidb@example.com', 55545678);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (6, 'Eva Green', '202 Cherry Lane', 'evag@example.com', 55556789);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (7, 'Frank Gray', '303 Birch Street', 'frankg@example.com', 55567890);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (8, 'Grace Hall', '404 Elm Circle', 'graceh@example.com', 55578901);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (9, 'Henry Ford', '505 Cedar Path', 'henryf@example.com', 55589012);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (10, 'Ivy Gold', '606 Daisy Drive', 'ivyg@example.com', 55590123);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (11, 'James Wilson', '707 Lily Street', 'jamesw@example.com', 55501234);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (12, 'Karen Lee', '808 Rose Avenue', 'karenl@example.com', 55512345);
INSERT INTO app_users (id, name, address, email, phone_number) VALUES (13, 'Liam Young', '909 Violet Court', 'liamy@example.com', 55523456);



INSERT INTO Books (title, author, genre, app_users_id) VALUES ('Harry Potter', 'J.K Rowling', 'fantasy',1);
INSERT INTO Books (title, author, genre, app_users_id) VALUES ('The Hobbit', 'J.R.R. Tolkien', 'fantasy',2);
INSERT INTO Books (title, author, genre, app_users_id) VALUES ('1984', 'George Orwell', 'dystopian',3);
INSERT INTO Books (title, author, genre, app_users_id) VALUES ('Pride and Prejudice', 'Jane Austen', 'romance',4);
INSERT INTO Books (title, author, genre, app_users_id) VALUES ('To Kill a Mockingbird', 'Harper Lee', 'classic',5);
INSERT INTO Books (title, author, genre, app_users_id) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'classic',6);
INSERT INTO Books (title, author, genre, app_users_id) VALUES ('Moby Dick', 'Herman Melville', 'adventure',7);
INSERT INTO Books (title, author, genre,app_users_id) VALUES ('The Catcher in the Rye', 'J.D. Salinger', 'classic',8);
INSERT INTO Movie (lead_actor, director, screen_writer, release_date, genre, Rating, app_users_id) VALUES ('Leonardo DiCaprio', 'Christopher Nolan', 'Jonathan Nolan', '2010-07-16', 'Science Fiction', 9,9);
INSERT INTO Movie (lead_actor, director, screen_writer, release_date, genre, Rating, app_users_id) VALUES ('Brad Pitt', 'David Fincher', 'Jim Uhls', '1999-10-15', 'Drama', 8, 10);
INSERT INTO Movie (lead_actor, director, screen_writer, release_date, genre, Rating, app_users_id) VALUES ('Tom Hanks', 'Robert Zemeckis', 'Eric Roth', '1994-07-06', 'Drama', 9, 11);
INSERT INTO Movie (lead_actor, director, screen_writer, release_date, genre, Rating, app_users_id) VALUES ('Keanu Reeves', 'Lana Wachowski', 'Lilly Wachowski', '1999-03-31', 'Action', 8,12);
INSERT INTO Movie (lead_actor, director, screen_writer, release_date, genre, Rating, app_users_id) VALUES ('Matt Damon', 'Ridley Scott', 'Drew Goddard', '2015-10-02', 'Science Fiction', 7,13);*/



INSERT INTO library_user (id, name, address, email, phone_number) VALUES (1, 'Danyal Khalid', '17  close', 'Dkhalid@outlook.com', 0782780922);
INSERT INTO library_user (id, name, address, email, phone_number) VALUES (2, 'Alice Johnson', '123 Oak Street', 'alicej@example.com', 055512345);



INSERT INTO books (id, title, author, genre, library_user_id) VALUES (1, 'Harry Potter', 'J.K Rowling', 'fantasy', 1);
INSERT INTO books (id, title, author, genre, library_user_id) VALUES (2, 'The Hobbit', 'J.R.R. Tolkien', 'fantasy', 2);


INSERT INTO movie (id, title, lead_actor, director, screen_writer, release_date, genre, rating, library_user_id) VALUES (1, 'Inception', 'Leonardo DiCaprio', 'Christopher Nolan', 'Jonathan Nolan', '2010-07-16', 'Science Fiction', 9, 1);
INSERT INTO movie (id, title, lead_actor, director, screen_writer, release_date, genre, rating, library_user_id) VALUES (2, 'Fight Club', 'Brad Pitt', 'David Fincher', 'Jim Uhls', '1999-10-15', 'Drama', 8, 2);



INSERT INTO periodicals (id, title, publication_date, library_user_id) VALUES (1, 'The New Yorker', '2022-10-01', 1);
INSERT INTO periodicals (id, title, publication_date, library_user_id) VALUES (2, 'National Geographic', '2022-09-15', 2);




