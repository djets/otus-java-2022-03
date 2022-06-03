-- Database: otus

-- DROP DATABASE IF EXISTS otus;

CREATE DATABASE otus_l17
    WITH
    OWNER = otus
    ENCODING = 'UTF8'
    
-- Создаем таблицы вопросов и ответов
-- Questions --1--*--> Answers

------------------------------------
-- Questions
------------------------------------

CREATE TABLE questions
(
    question_id     SERIAL          PRIMARY KEY,
    question        VARCHAR(200)    NOT NULL UNIQUE
);

DROP TABLE questions

-- Заполняем таблицу вопросов

INSERT INTO questions(question)
VALUES      ('Кто был звездой фильма 1973 года «Занджир»?'),
            ('На национальной эмблеме Индии изображены три льва. А что написано под ними?'),
            ('Что он традиционно держит в правой руке в изображениях бога Рамы?'),
            ('Песня Даршан До Гханшьям - произведение великого индийского поэта; как зовут этого поэта?'),
            ('На 100-долларовой купюре есть портрет известного американского государственного деятеля?'),
            ('Кто изобретатель револьвера?'),
            ('В каком городе находится Кембриджский цирк?'),
            ('Какой игрок в крикет забил больше всего «сотен» в официальных матчах?'),
            ('В шедевре Александра Дюма «Три мушкетера» двух мушкетеров зовут Атос и Портос . Как зовут третьего мушкетера?');

SELECT * FROM questions

DELETE FROM questions
    WHERE question = 'Кто был звездой фильма 1973 года «Занджир»?';


------------------------------------
-- Answers
------------------------------------

CREATE TABLE answers
(
    answers_id      SERIAL          PRIMARY KEY,
    answer          VARCHAR(100)    NOT NULL,
    question_id     SERIAL          REFERENCES questions (question_id),
    correct         BOOLEAN         DEFAULT FALSE  
);

SELECT * FROM answers

INSERT INTO answers(answer, question_id, correct)
VALUES      ('Амитабх Баччан', 3, true),
            ('Анил Капур', 3, false),
            ('Шахрукх Кхан', 3, false),
            ('Мадхур Миттал', 3, false),
            ('Только правда побеждает', 4, true),
            ('Только торжество лжи', 4, false),
            ('Только триумфы моды', 4, false),
            ('Только деньги торжествуют', 4, false),
            ('Цветок', 5, false),
            ('Меч', 5, false),
            ('Ребенок', 5, false),
            ('Лук и стрела', 5, true),
            ('Сурдас', 6, true),
            ('Тулсидас', 6, false),
            ('Мирабай', 6, false),
            ('Кабир', 6, false),
            ('Джордж Вашингтон', 7, false),
            ('Франклин Рузвельт', 7, false),
            ('Бенджамин Франклин', 7, true),
            ('Абрахам Линкольн', 7, false),
            ('Сэмюэл Кольт', 8, true),
            ('Брюс Браунинг', 8, false),
            ('Дэн Вессон', 8, false),
            ('Револьвер Джеймса', 8, false),
            ('Оксфорд', 9, false),
            ('Лидс', 9, false),
            ('Кембридж', 9, false),
            ('Лондон', 9, true),
            ('Сачин Тендулкар', 10, false),
            ('Рики Понтинг', 10, false),
            ('Майкл Слейтер', 10, false),
            ('Джек Хоббс', 10, true),
            ('Арамис', 11, false),
            ('Кардинал Ришелье', 11, false),
            ('Д Артаньян', 11, false),
            ('Планше', 11, false);

SELECT * FROM answers  

-- Обновляем

UPDATE answers
SET answer = 'Д Артаньян'
WHERE answer = 'Д''Артаньян';

-- Ищем совпадения по части

SELECT * FROM answers
WHERE answer LIKE '%ян';

-- Декартово произведение

SELECT q.*, a.*
FROM questions AS q
CROSS JOIN answers a

-- Вывод ответов/вопрос 

SELECT answers.*, questions.*
FROM answers
JOIN questions ON questions.question_id = answers.question_id;
            
-- Вывод вопрос/правильный ответ

SELECT q.question, a.answer AS question
FROM answers AS a
JOIN questions q ON q.question_id = a.question_id
WHERE correct = true;
