INSERT INTO library_user (id, name, address, email, phone_number) VALUES (1, 'Danyal Khalid', '17 close', 'Dkhalid@outlook.com', 0782780922);
INSERT INTO library_user (id, name, address, email, phone_number) VALUES (2, 'Alice Johnson', '123 Oak Street', 'alicej@example.com', 055512345);
INSERT INTO library_user (id, name, address, email, phone_number) VALUES (3, 'John Doe', '456 Pine Street', 'johndoe@example.com', 055598765);
INSERT INTO library_user (id, name, address, email, phone_number) VALUES (4, 'Sarah Smith', '789 Maple Avenue', 'sarahsmith@example.com', 055523456);
INSERT INTO library_user (id, name, address, email, phone_number) VALUES (5, 'Emma Brown', '1012 Birch Road', 'emmabrown@example.com', 055534567);
INSERT INTO library_user (id, name, address, email, phone_number) VALUES (6, 'Michael Davis', '1314 Elm Lane', 'michaeldavis@example.com', 055545678);


INSERT INTO librarian (id, name, address, email, phone_number) VALUES (1, 'Danyal Khalid', '17 close', 'Dkhalid@outlook.com', 0782780922);
INSERT INTO librarian (id, name, address, email, phone_number) VALUES (2, 'Alice Johnson', '123 Oak Street', 'alicej@example.com', 055512345);
INSERT INTO librarian (id, name, address, email, phone_number) VALUES (3, 'John Doe', '456 Pine Street', 'johndoe@example.com', 055598765);
INSERT INTO librarian (id, name, address, email, phone_number) VALUES (4, 'Sarah Smith', '789 Maple Avenue', 'sarahsmith@example.com', 055523456);
INSERT INTO librarian (id, name, address, email, phone_number) VALUES (5, 'Emma Brown', '1012 Birch Road', 'emmabrown@example.com', 055534567);
INSERT INTO librarian (id, name, address, email, phone_number) VALUES (6, 'Michael Davis', '1314 Elm Lane', 'michaeldavis@example.com', 055545678);


INSERT INTO lendable (id, title, library_user_id, librarian_id) VALUES (1, 'Harry Potter', 1,1);
INSERT INTO books (id, author, genre) VALUES (1, 'J.K Rowling', 'fantasy');
INSERT INTO lendable (id, title, library_user_id, librarian_id) VALUES (2, 'The Hobbit', 2,2);
INSERT INTO books (id, author, genre) VALUES (2, 'J.R.R. Tolkien', 'fantasy');


INSERT INTO lendable (id, title, library_user_id, librarian_id) VALUES (3, 'Inception', 3,3;
INSERT INTO movie (id, lead_actor, director, screen_writer, release_date, genre, rating) VALUES (3, 'Leonardo DiCaprio', 'Christopher Nolan', 'Jonathan Nolan', '2010-07-16', 'Science Fiction', 9);
INSERT INTO lendable (id, title, library_user_id, librarian_id) VALUES (4, 'Fight Club', 4,4);
INSERT INTO movie (id, lead_actor, director, screen_writer, release_date, genre, rating) VALUES (4, 'Brad Pitt', 'David Fincher', 'Jim Uhls', '1999-10-15', 'Drama', 8);


INSERT INTO lendable (id, title, library_user_id, librarian_id) VALUES (5, 'The New Yorker', 5,5);
INSERT INTO periodicals (id, publication_date) VALUES (5, '2022-10-01');
INSERT INTO lendable (id, title, library_user_id, librarian_id) VALUES (6, 'National Geographic', 6,6);
INSERT INTO periodicals (id, publication_date) VALUES (6, '2022-09-15');
