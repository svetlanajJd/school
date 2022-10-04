CREATE TABLE car
(
    id    REAL PRIMARY KEY,
    brand TEXT,
    model TEXT,
    price int
)

CREATE TABLE human
(
    id REAL,
    name TEXT PRIMARY KEY,
    age int,
    drive_card BOOLEAN,
    car_id int REFERENCES car (id)
)


SELECT student.name, student.age
FROM student
    LEFT JOIN faculty ON facilty_id = faculty.id

SELECT student.name, student.age
FROM student
         INNER JOIN avatar ON student.id = avatar.student_id