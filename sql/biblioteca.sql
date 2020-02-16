/* Who checked out the book 'The Hobbit’? */
SELECT name FROM member, checkout_item, book 
WHERE book.id = checkout_item.book_id 
AND checkout_item.member_id = member.id 
AND book.title = "The Hobbit";

/* How many people have not checked out anything? */
SELECT COUNT(*) FROM member 
WHERE id NOT IN (
	SELECT member_id FROM checkout_item);


/* What books and movies aren't checked out? */
SELECT title FROM book WHERE id NOT IN (
	SELECT id FROM book INNER JOIN checkout_item ON book.id = checkout_item.book_id)
UNION
SELECT title FROM movie WHERE id NOT IN (
	SELECT id FROM movie INNER JOIN checkout_item ON movie.id = checkout_item.movie_id);

/* 4 */
INSERT INTO book VALUES (11, "The Pragmatic Programmer");
INSERT INTO member VALUES (43, "Qinyun Wang");
INSERT INTO checkout_item (member_id, book_id) VALUES (43, 11);

SELECT name FROM member, checkout_item, book 
WHERE book.id = checkout_item.book_id 
AND checkout_item.member_id = member.id 
AND book.title = "The Pragmatic Programmer";

/* 5 */
SELECT name FROM member, checkout_item 
WHERE member.id = checkout_item.member_id GROUP BY member.id HAVING COUNT(name) > 1;