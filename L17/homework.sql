-- Database: otus

-- DROP DATABASE IF EXISTS otus;

CREATE DATABASE otus_l17
    WITH
    OWNER = otus
    ENCODING = 'UTF8'
    
-- Создаем таблицы вопросов и ответов
-- Questions <--*--*--> Answers

------------------------------------
-- Questions, Answers, Relationship
------------------------------------

CREATE TABLE answers
(
    answers_id      SERIAL          PRIMARY KEY,
    answer          VARCHAR(100)    NOT NULL UNIQUE      
);
SELECT * FROM answers

CREATE TABLE questions
(
    question_id             SERIAL          PRIMARY KEY,
    question                VARCHAR(200)    NOT NULL UNIQUE,
    correct_answer_id       SERIAL          REFERENCES answers (answers_id)
);
SELECT * FROM questions

CREATE TABLE question_to_answer
(
question_id     SERIAL      REFERENCES questions (question_id),
answer_id       SERIAL      REFERENCES answers (answers_id)   
);
SELECT * FROM question_to_answer

-- Filling

INSERT INTO answers(answer)
VALUES      ('Амитабх Баччан'),
            ('Анил Капур'),
            ('Шахрукх Кхан'),
            ('Мадхур Миттал'),
            ('Только правда побеждает'),
            ('Только торжество лжи'),
            ('Только триумфы моды'),
            ('Только деньги торжествуют'),
            ('Цветок'),
            ('Меч'),
            ('Ребенок'),
            ('Лук и стрела'),
            ('Сурдас'),
            ('Тулсидас'),
            ('Мирабай'),
            ('Кабир'),
            ('Джордж Вашингтон'),
            ('Франклин Рузвельт'),
            ('Бенджамин Франклин'),
            ('Абрахам Линкольн'),
            ('Сэмюэл Кольт'),
            ('Брюс Браунинг'),
            ('Дэн Вессон'),
            ('Револьвер Джеймса'),
            ('Оксфорд'),
            ('Лидс'),
            ('Кембридж'),
            ('Лондон'),
            ('Сачин Тендулкар'),
            ('Рики Понтинг'),
            ('Майкл Слейтер'),
            ('Джек Хоббс'),
            ('Арамис'),
            ('Кардинал Ришелье'),
            ('Д Артаньян'),
            ('Планше');

SELECT * FROM answers  

INSERT INTO questions(question, correct_answer_id)
VALUES      ('Кто был звездой фильма 1973 года «Занджир»?', 1),
            ('На национальной эмблеме Индии изображены три льва. А что написано под ними?', 5),
            ('Что он традиционно держит в правой руке в изображениях бога Рамы?', 12),
            ('Песня Даршан До Гханшьям - произведение великого индийского поэта; как зовут этого поэта?', 13),
            ('На 100-долларовой купюре есть портрет известного американского государственного деятеля?', 19),
            ('Кто изобретатель револьвера?', 21),
            ('В каком городе находится Кембриджский цирк?', 28),
            ('Какой игрок в крикет забил больше всего «сотен» в официальных матчах?', 32),
            ('В шедевре Александра Дюма «Три мушкетера» двух мушкетеров зовут Атос и Портос . Как зовут третьего мушкетера?', 33);

-- DELETE FROM questions
--    WHERE question = 'Кто был звездой фильма 1973 года «Занджир»?';

SELECT * FROM questions 

DO
$f$
BEGIN
    FOR q IN 1..9 LOOP        
        FOR a IN REVERSE 3..0 LOOP
            INSERT INTO question_to_answer (question_id, answer_id)
            VALUES (q, q * 4 - a);
        END LOOP;    
    END LOOP;
END;
$f$;

SELECT * FROM question_to_answer
    
-- Update

UPDATE answers
SET answer = 'Д Артаньян'
WHERE answer = 'Д''Артаньян';

-- Search

SELECT * FROM answers
WHERE answer LIKE '%ян';

-- Декартово произведение

SELECT q.*, a.*
FROM questions AS q
CROSS JOIN answers a

-- Вывод ответов/правильный ответ 
SELECT questions.question, answers.answer
FROM answers
JOIN questions ON questions.correct_answer_id = answers.answers_id;


