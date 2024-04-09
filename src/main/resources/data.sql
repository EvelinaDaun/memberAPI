INSERT INTO address (street, postal_code, city)
VALUES ('gatangatan 1', 11111, 'stad1' ),
       ('gatangatan 2', 22222, 'stad2' ),
       ('gatangatan 3', 33333, 'stad3' ),
       ('gatangatan 4', 44444, 'stad4' ),
       ('gatangatan 5', 55555, 'stad5' );


INSERT INTO member (first_name, last_name, email, phone, date_of_birth, address_id)
VALUES ('Sven', 'Sjögren', 'sjogren@gmail.com', '0498-452718', '1910-07-12', 1),
       ('Sture', 'Ika', 'grodanboll1@gmail.com', '018-891267', '1980-04-10', 1),
       ('Loppan', 'Efternamn', 'LoppansMail@gmail.se', '+46-7889912xxx', '1978-10-19', 3),
       ('Manfred', 'Östen', 'osten@gmail.com', '0982-287277', '1960-03-29', 4),
       ('Huda', 'Fila', 'grodanboll4@gmail.com', '0766234349', '1902-01-18' ,5);