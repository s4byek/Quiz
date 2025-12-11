
-- ПОЛЬЗОВАТЕЛИ (10 тестовых пользователей с разным рейтингом)
-- ===========================

INSERT INTO users (username, password, rating, experience, level, role) VALUES
 ('AlexPro',      'pass123', 850, 1250, 13, 'USER'),
 ('MarinaQuiz',   'pass123', 720,  980, 10, 'USER'),
 ('DmitryGenius', 'pass123', 650,  750,  8, 'USER'),
 ('OlgaSmart',    'pass123', 580,  620,  7, 'USER'),
 ('IvanMaster',   'pass123', 520,  550,  6, 'USER'),
 ('AnnaBrain',    'pass123', 450,  480,  5, 'USER'),
 ('PeterKnow',    'pass123', 380,  390,  4, 'USER'),
 ('SvetaWise',    'pass123', 310,  310,  4, 'USER'),
 ('NikitaStart',  'pass123', 250,  240,  3, 'USER'),
 ('KaterinaNew',  'pass123', 180,  150,  2, 'USER'),
 ('admin',       '123456', 100,  0,    1, 'ADMIN');



-- ===========================
-- ВОПРОСЫ ПО КАТЕГОРИИ: НАУКА (SCIENCE)
-- ===========================
-- ЛЕГКИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Какая планета является самой большой в Солнечной системе?', 'SCIENCE', 'EASY'),
('Сколько костей в теле взрослого человека?', 'SCIENCE', 'EASY'),
('Что тяжелее: 1 кг железа или 1 кг ваты?', 'SCIENCE', 'EASY'),
('Какой газ необходим человеку для дыхания?', 'SCIENCE', 'EASY'),
('Какая температура замерзания воды в градусах Цельсия?', 'SCIENCE', 'EASY'),
('Сколько планет в Солнечной системе?', 'SCIENCE', 'EASY'),
('Как называется наука о растениях?', 'SCIENCE', 'EASY'),
('Какой орган человека качает кровь?', 'SCIENCE', 'EASY');
-- СРЕДНИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто открыл закон всемирного тяготения?', 'SCIENCE', 'MEDIUM'),
('Какая скорость света в вакууме (км/с)?', 'SCIENCE', 'MEDIUM'),
('Как называется процесс превращения жидкости в пар?', 'SCIENCE', 'MEDIUM'),
('Сколько хромосом в клетке человека?', 'SCIENCE', 'MEDIUM'),
('Какой элемент имеет химический символ Fe?', 'SCIENCE', 'MEDIUM'),
('Кто предложил теорию эволюции?', 'SCIENCE', 'MEDIUM'),
('Как называется самая маленькая единица жизни?', 'SCIENCE', 'MEDIUM');
-- СЛОЖНЫЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Что такое квантовая суперпозиция?', 'SCIENCE', 'HARD'),
('Какова постоянная Планка?', 'SCIENCE', 'HARD'),
('Что описывает уравнение Шредингера?', 'SCIENCE', 'HARD'),
('Кто впервые синтезировал мочевину?', 'SCIENCE', 'HARD'),
('Что такое бозон Хиггса?', 'SCIENCE', 'HARD');
-- ===========================
-- ВОПРОСЫ ПО КАТЕГОРИИ: ИСТОРИЯ (HISTORY)
-- ===========================
-- ЛЕГКИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('В каком году началась Вторая мировая война?', 'HISTORY', 'EASY'),
('Кто был первым президентом США?', 'HISTORY', 'EASY'),
('В каком году человек впервые высадился на Луну?', 'HISTORY', 'EASY'),
('Кто открыл Америку?', 'HISTORY', 'EASY'),
('В каком году пала Берлинская стена?', 'HISTORY', 'EASY'),
('Кто был первым космонавтом?', 'HISTORY', 'EASY'),
('В каком веке жил Наполеон Бонапарт?', 'HISTORY', 'EASY');
-- СРЕДНИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Какая империя была известна своими дорогами и акведуками?', 'HISTORY', 'MEDIUM'),
('Когда была подписана Декларация независимости США?', 'HISTORY', 'MEDIUM'),
('Кто возглавлял СССР во время Второй мировой войны?', 'HISTORY', 'MEDIUM'),
('В каком году произошла Октябрьская революция в России?', 'HISTORY', 'MEDIUM'),
('Как долго продолжалась Столетняя война?', 'HISTORY', 'MEDIUM'),
('Кто был последним императором России?', 'HISTORY', 'MEDIUM');
-- СЛОЖНЫЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Когда был подписан Вестфальский мир?', 'HISTORY', 'HARD'),
('Кто возглавлял Карфаген в войне против Рима?', 'HISTORY', 'HARD'),
('В каком году началась война Алой и Белой розы?', 'HISTORY', 'HARD'),
('Кто был автором "95 тезисов"?', 'HISTORY', 'HARD');
-- ===========================
-- ВОПРОСЫ ПО КАТЕГОРИИ: ГЕОГРАФИЯ (GEOGRAPHY)
-- ===========================
-- ЛЕГКИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Какая самая длинная река в мире?', 'GEOGRAPHY', 'EASY'),
('Столица Франции?', 'GEOGRAPHY', 'EASY'),
('На каком континенте находится Египет?', 'GEOGRAPHY', 'EASY'),
('Какой океан самый большой?', 'GEOGRAPHY', 'EASY'),
('Столица России?', 'GEOGRAPHY', 'EASY'),
('Сколько континентов на Земле?', 'GEOGRAPHY', 'EASY'),
('В какой стране находится Эйфелева башня?', 'GEOGRAPHY', 'EASY');
-- СРЕДНИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Столица Австралии?', 'GEOGRAPHY', 'MEDIUM'),
('Какое самое глубокое озеро в мире?', 'GEOGRAPHY', 'MEDIUM'),
('Какая самая высокая гора в мире?', 'GEOGRAPHY', 'MEDIUM'),
('В какой стране больше всего островов?', 'GEOGRAPHY', 'MEDIUM'),
('Какая пустыня самая большая в мире?', 'GEOGRAPHY', 'MEDIUM'),
('Столица Канады?', 'GEOGRAPHY', 'MEDIUM');
-- СЛОЖНЫЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Какой океан самый глубокий?', 'GEOGRAPHY', 'HARD'),
('Какое государство полностью окружено ЮАР?', 'GEOGRAPHY', 'HARD'),
('Какая река протекает через наибольшее количество стран?', 'GEOGRAPHY', 'HARD'),
('Столица Казахстана?', 'GEOGRAPHY', 'HARD');
-- ===========================
-- ВОПРОСЫ ПО КАТЕГОРИИ: ЛИТЕРАТУРА (LITERATURE)
-- ===========================
-- ЛЕГКИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто написал "Войну и мир"?', 'LITERATURE', 'EASY'),
('Кто автор "Гарри Поттера"?', 'LITERATURE', 'EASY'),
('Как звали главного героя "Евгения Онегина"?', 'LITERATURE', 'EASY'),
('Кто написал "Преступление и наказание"?', 'LITERATURE', 'EASY'),
('Автор "Ромео и Джульетты"?', 'LITERATURE', 'EASY');
-- СРЕДНИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто написал "Мастер и Маргарита"?', 'LITERATURE', 'MEDIUM'),
('В каком году родился А.С. Пушкин?', 'LITERATURE', 'MEDIUM'),
('Кто автор "1984"?', 'LITERATURE', 'MEDIUM'),
('Как называется первый роман Достоевского?', 'LITERATURE', 'MEDIUM');
-- СЛОЖНЫЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто написал "Улисс"?', 'LITERATURE', 'HARD'),
('В каком году была опубликована "Божественная комедия"?', 'LITERATURE', 'HARD'),
('Кто автор "Фауста"?', 'LITERATURE', 'HARD');
-- ===========================
-- ВОПРОСЫ ПО КАТЕГОРИИ: СПОРТ (SPORTS)
-- ===========================
-- ЛЕГКИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Сколько игроков в футбольной команде на поле?', 'SPORTS', 'EASY'),
('В каком виде спорта используется ракетка?', 'SPORTS', 'EASY'),
('Как часто проводятся Олимпийские игры?', 'SPORTS', 'EASY'),
('Сколько периодов в хоккее?', 'SPORTS', 'EASY'),
('В какой стране зародился футбол?', 'SPORTS', 'EASY');
-- СРЕДНИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто выиграл ЧМ по футболу 2018?', 'SPORTS', 'MEDIUM'),
('Сколько сетов в теннисе для победы?', 'SPORTS', 'MEDIUM'),
('Какая длина марафонской дистанции?', 'SPORTS', 'MEDIUM'),
('Сколько очков за тачдаун в американском футболе?', 'SPORTS', 'MEDIUM');
-- СЛОЖНЫЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто первым пробежал 100м менее чем за 10 секунд?', 'SPORTS', 'HARD'),
('В каком году Пеле завершил карьеру?', 'SPORTS', 'HARD'),
('Сколько золотых медалей у Майкла Фелпса?', 'SPORTS', 'HARD');
-- ===========================
-- ВОПРОСЫ ПО КАТЕГОРИИ: РАЗВЛЕЧЕНИЯ (ENTERTAINMENT)
-- ===========================
-- ЛЕГКИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто сыграл Железного человека в Marvel?', 'ENTERTAINMENT', 'EASY'),
('Какой фильм получил больше всего Оскаров?', 'ENTERTAINMENT', 'EASY'),
('Кто режиссер "Титаника"?', 'ENTERTAINMENT', 'EASY'),
('В каком году вышел первый iPhone?', 'ENTERTAINMENT', 'EASY');
-- СРЕДНИЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('Кто композитор музыки для "Звездных войн"?', 'ENTERTAINMENT', 'MEDIUM'),
('Сколько сезонов в "Игре престолов"?', 'ENTERTAINMENT', 'MEDIUM'),
('Какая игра стала самой продаваемой?', 'ENTERTAINMENT', 'MEDIUM');
-- СЛОЖНЫЕ ВОПРОСЫ
INSERT INTO questions (text, category, difficulty) VALUES
('В каком году была основана студия Pixar?', 'ENTERTAINMENT', 'HARD'),
('Кто создал серию игр Metal Gear?', 'ENTERTAINMENT', 'HARD');
-- ===========================
-- ОТВЕТЫ НА ВОПРОСЫ (по 4 варианта на каждый)
-- ===========================
-- Вопрос 1: Какая планета является самой большой в Солнечной системе?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Сатурн', false, 1),
('Юпитер', true, 1),
('Марс', false, 1),
('Земля', false, 1);
-- Вопрос 2: Сколько костей в теле взрослого человека?
INSERT INTO answers (text, is_correct, question_id) VALUES
('215', false, 2),
('206', true, 2),
('187', false, 2),
('198', false, 2);
-- Вопрос 3: Что тяжелее: 1 кг железа или 1 кг ваты?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Железо', false, 3),
('Вата', false, 3),
('Одинаково', true, 3),
('Зависит от объема', false, 3);
-- Вопрос 4: Какой газ необходим человеку для дыхания?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Азот', false, 4),
('Углекислый газ', false, 4),
('Кислород', true, 4),
('Водород', false, 4);
-- Вопрос 5: Какая температура замерзания воды в градусах Цельсия?
INSERT INTO answers (text, is_correct, question_id) VALUES
('0', true, 5),
('10', false, 5),
('-10', false, 5),
('32', false, 5);
-- Вопрос 6: Сколько планет в Солнечной системе?
INSERT INTO answers (text, is_correct, question_id) VALUES
('10', false, 6),
('7', false, 6),
('9', false, 6),
('8', true, 6);
-- Вопрос 7: Как называется наука о растениях?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Зоология', false, 7),
('Геология', false, 7),
('Ботаника', true, 7),
('Биология', false, 7);
-- Вопрос 8: Какой орган человека качает кровь?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Почки', false, 8),
('Легкие', false, 8),
('Сердце', true, 8),
('Печень', false, 8);
-- Вопрос 9: Кто открыл закон всемирного тяготения?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Галилео Галилей', false, 9),
('Исаак Ньютон', true, 9),
('Никола Тесла', false, 9),
('Альберт Эйнштейн', false, 9);
-- Вопрос 10: Какая скорость света в вакууме (км/с)?
INSERT INTO answers (text, is_correct, question_id) VALUES
('150 000', false, 10),
('500 000', false, 10),
('300 000', true, 10),
('200 000', false, 10);
-- Вопрос 11: Как называется процесс превращения жидкости в пар?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Испарение', true, 11),
('Кристаллизация', false, 11),
('Конденсация', false, 11),
('Сублимация', false, 11);
-- Вопрос 12: Сколько хромосом в клетке человека?
INSERT INTO answers (text, is_correct, question_id) VALUES
('46', true, 12),
('44', false, 12),
('48', false, 12),
('23', false, 12);
-- Вопрос 13: Какой элемент имеет химический символ Fe?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Фтор', false, 13),
('Франций', false, 13),
('Железо', true, 13),
('Фосфор', false, 13);
-- Вопрос 14: Кто предложил теорию эволюции?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Луи Пастер', false, 14),
('Грегор Мендель', false, 14),
('Жан-Батист Ламарк', false, 14),
('Чарльз Дарвин', true, 14);
-- Вопрос 15: Как называется самая маленькая единица жизни?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Ткань', false, 15),
('Атом', false, 15),
('Клетка', true, 15),
('Молекула', false, 15);
-- Вопрос 16: Что такое квантовая суперпозиция?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Состояние, когда система находится одновременно в нескольких состояниях', true, 16),
('Скорость света', false, 16),
('Теория о параллельных вселенных', false, 16),
('Явление телепортации', false, 16);
-- Вопрос 17: Какова постоянная Планка?
INSERT INTO answers (text, is_correct, question_id) VALUES
('9.81 м/с²', false, 17),
('1.602 × 10⁻¹⁹ Кл', false, 17),
('6.626 × 10⁻³⁴ Дж·с', true, 17),
('3.14 × 10⁻³⁴ Дж·с', false, 17);
-- Вопрос 18: Что описывает уравнение Шредингера?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Движение планет', false, 18),
('Распространение света', false, 18),
('Химические реакции', false, 18),
('Эволюцию квантового состояния', true, 18);
-- Вопрос 19: Кто впервые синтезировал мочевину?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Дмитрий Менделеев', false, 19),
('Фридрих Вёлер', true, 19),
('Мария Кюри', false, 19),
('Антуан Лавуазье', false, 19);
-- Вопрос 20: Что такое бозон Хиггса?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Черная дыра', false, 20),
('Вид излучения', false, 20),
('Элементарная частица, отвечающая за массу', true, 20),
('Тип галактики', false, 20);
-- Вопрос 21: В каком году началась Вторая мировая война?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1945', false, 21),
('1939', true, 21),
('1941', false, 21),
('1914', false, 21);
-- Вопрос 22: Кто был первым президентом США?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Авраам Линкольн', false, 22),
('Бенджамин Франклин', false, 22),
('Томас Джефферсон', false, 22),
('Джордж Вашингтон', true, 22);
-- Вопрос 23: В каком году человек впервые высадился на Луну?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1961', false, 23),
('1972', false, 23),
('1965', false, 23),
('1969', true, 23);
-- Вопрос 24: Кто открыл Америку?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Васко да Гама', false, 24),
('Фернан Магеллан', false, 24),
('Америго Веспуччи', false, 24),
('Христофор Колумб', true, 24);
-- Вопрос 25: В каком году пала Берлинская стена?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1985', false, 25),
('1991', false, 25),
('1990', false, 25),
('1989', true, 25);
-- Вопрос 26: Кто был первым космонавтом?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Алексей Леонов', false, 26),
('Валентина Терешкова', false, 26),
('Нил Армстронг', false, 26),
('Юрий Гагарин', true, 26);
-- Вопрос 27: В каком веке жил Наполеон Бонапарт?
INSERT INTO answers (text, is_correct, question_id) VALUES
('17 век', false, 27),
('20 век', false, 27),
('18-19 век', true, 27),
('16 век', false, 27);
-- Вопрос 28: Какая империя была известна своими дорогами и акведуками?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Византийская империя', false, 28),
('Римская империя', true, 28),
('Персидская империя', false, 28),
('Монгольская империя', false, 28);
-- Вопрос 29: Когда была подписана Декларация независимости США?
INSERT INTO answers (text, is_correct, question_id) VALUES
('4 июля 1865', false, 29),
('4 июля 1776', true, 29),
('4 июля 1787', false, 29),
('14 июля 1789', false, 29);
-- Вопрос 30: Кто возглавлял СССР во время Второй мировой войны?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Владимир Ленин', false, 30),
('Иосиф Сталин', true, 30),
('Никита Хрущев', false, 30),
('Леонид Брежнев', false, 30);
-- Продолжаем добавлять ответы для остальных вопросов...
-- (для экономии места показываю паттерн, вы можете продолжить)
-- Вопрос 31: В каком году произошла Октябрьская революция в России?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1905', false, 31),
('1914', false, 31),
('1917', true, 31),
('1922', false, 31);
-- Вопрос 32: Как долго продолжалась Столетняя война?
INSERT INTO answers (text, is_correct, question_id) VALUES
('100 лет', false, 32),
('95 лет', false, 32),
('110 лет', false, 32),
('116 лет', true, 32);
-- Вопрос 33: Кто был последним императором России?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Александр III', false, 33),
('Петр I', false, 33),
('Николай II', true, 33),
('Александр II', false, 33);
-- Вопрос 34: Когда был подписан Вестфальский мир?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1648', true, 34),
('1555', false, 34),
('1714', false, 34),
('1618', false, 34);
-- Вопрос 35: Кто возглавлял Карфаген в войне против Рима?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Помпей', false, 35),
('Ганнибал', true, 35),
('Сципион', false, 35),
('Цезарь', false, 35);
-- Вопрос 36: В каком году началась война Алой и Белой розы?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1455', true, 36),
('1399', false, 36),
('1415', false, 36),
('1485', false, 36);
-- Вопрос 37: Кто был автором "95 тезисов"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Жан Кальвин', false, 37),
('Мартин Лютер', true, 37),
('Ян Гус', false, 37),
('Эразм Роттердамский', false, 37);
-- Вопрос 38: Какая самая длинная река в мире?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Амазонка', true, 38),
('Янцзы', false, 38),
('Нил', false, 38),
('Миссисипи', false, 38);
-- Вопрос 39: Столица Франции?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Берлин', false, 39),
('Мадрид', false, 39),
('Париж', true, 39),
('Лондон', false, 39);
-- Вопрос 40: На каком континенте находится Египет?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Европа', false, 40),
('Азия', false, 40),
('Австралия', false, 40),
('Африка', true, 40);
-- Вопрос 41: Какой океан самый большой?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Северный Ледовитый', false, 41),
('Тихий', true, 41),
('Атлантический', false, 41),
('Индийский', false, 41);
-- Продолжение ответов...
-- Вопрос 42: Столица России?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Минск', false, 42),
('Санкт-Петербург', false, 42),
('Москва', true, 42),
('Киев', false, 42);
-- Вопрос 43: Сколько континентов на Земле?
INSERT INTO answers (text, is_correct, question_id) VALUES
('5', false, 43),
('8', false, 43),
('6', false, 43),
('7', true, 43);
-- Вопрос 44: В какой стране находится Эйфелева башня?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Италия', false, 44),
('Германия', false, 44),
('Франция', true, 44),
('Испания', false, 44);
-- Вопрос 45: Столица Австралии?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Сидней', false, 45),
('Мельбурн', false, 45),
('Канберра', true, 45),
('Брисбен', false, 45);
-- Вопрос 46: Какое самое глубокое озеро в мире?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Мичиган', false, 46),
('Танганьика', false, 46),
('Байкал', true, 46),
('Виктория', false, 46);
-- Вопрос 47: Какая самая высокая гора в мире?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Канченджанга', false, 47),
('Эверест', true, 47),
('Эльбрус', false, 47),
('К2', false, 47);
-- Вопрос 48: В какой стране больше всего островов?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Индонезия', false, 48),
('Япония', false, 48),
('Швеция', true, 48),
('Филиппины', false, 48);
-- Вопрос 49: Какая пустыня самая большая в мире?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Гоби', false, 49),
('Аравийская', false, 49),
('Сахара', true, 49),
('Калахари', false, 49);
-- Вопрос 50: Столица Канады?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Монреаль', false, 50),
('Торонто', false, 50),
('Ванкувер', false, 50),
('Оттава', true, 50);
-- Вопрос 51: Какой океан самый глубокий?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Северный Ледовитый океан', false, 51),
('Тихий океан', true, 51),
('Атлантический океан', false, 51),
('Индийский океан', false, 51);
-- Вопрос 52: Какое государство полностью окружено ЮАР?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Зимбабве', false, 52),
('Свазиленд', false, 52),
('Ботсвана', false, 52),
('Лесото', true, 52);
-- Вопрос 53: Какая река протекает через наибольшее количество стран?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Нил', false, 53),
('Амазонка', false, 53),
('Рейн', false, 53),
('Дунай', true, 53);
-- Вопрос 54: Столица Казахстана?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Шымкент', false, 54),
('Астана', true, 54),
('Алматы', false, 54),
('Караганда', false, 54);
-- Вопрос 55: Кто написал "Войну и мир"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Иван Тургенев', false, 55),
('Антон Чехов', false, 55),
('Федор Достоевский', false, 55),
('Лев Толстой', true, 55);
-- Вопрос 56: Кто автор "Гарри Поттера"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Джордж Мартин', false, 56),
('Стивен Кинг', false, 56),
('Джоан Роулинг', true, 56),
('Толкиен', false, 56);
-- Вопрос 57: Как звали главного героя "Евгения Онегина"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Владимир', false, 57),
('Григорий', false, 57),
('Евгений', true, 57),
('Александр', false, 57);
-- Вопрос 58: Кто написал "Преступление и наказание"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Лев Толстой', false, 58),
('Николай Гоголь', false, 58),
('Федор Достоевский', true, 58),
('Иван Бунин', false, 58);
-- Вопрос 59: Автор "Ромео и Джульетты"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Оскар Уайльд', false, 59),
('Джейн Остин', false, 59),
('Уильям Шекспир', true, 59),
('Чарльз Диккенс', false, 59);
-- Вопрос 60: Кто написал "Мастер и Маргарита"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Борис Пастернак', false, 60),
('Михаил Булгаков', true, 60),
('Александр Солженицын', false, 60),
('Максим Горький', false, 60);
-- Вопрос 61: В каком году родился А.С. Пушкин?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1789', false, 61),
('1801', false, 61),
('1799', true, 61),
('1812', false, 61);
-- Вопрос 62: Кто автор "1984"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Олдос Хаксли', false, 62),
('Джордж Оруэлл', true, 62),
('Рэй Брэдбери', false, 62),
('Артур Кларк', false, 62);
-- Вопрос 63: Как называется первый роман Достоевского?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Униженные и оскорбленные', false, 63),
('Бедные люди', true, 63),
('Идиот', false, 63),
('Преступление и наказание', false, 63);
-- Вопрос 64: Кто написал "Улисс"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Фрэнсис Скотт Фицджеральд', false, 64),
('Уильям Фолкнер', false, 64),
('Эрнест Хемингуэй', false, 64),
('Джеймс Джойс', true, 64);
-- Вопрос 65: В каком году была опубликована "Божественная комедия"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1321', true, 65),
('1250', false, 65),
('1300', false, 65),
('1400', false, 65);
-- Вопрос 66: Кто автор "Фауста"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Фридрих Шиллер', false, 66),
('Иоганн Гёте', true, 66),
('Томас Манн', false, 66),
('Генрих Гейне', false, 66);
-- Вопрос 67: Сколько игроков в футбольной команде на поле?
INSERT INTO answers (text, is_correct, question_id) VALUES
('10', false, 67),
('9', false, 67),
('11', true, 67),
('12', false, 67);
-- Вопрос 68: В каком виде спорта используется ракетка?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Баскетбол', false, 68),
('Хоккей', false, 68),
('Футбол', false, 68),
('Теннис', true, 68);
-- Вопрос 69: Как часто проводятся Олимпийские игры?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Каждые 4 года', true, 69),
('Каждые 5 лет', false, 69),
('Каждые 2 года', false, 69),
('Ежегодно', false, 69);
-- Вопрос 70: Сколько периодов в хоккее?
INSERT INTO answers (text, is_correct, question_id) VALUES
('2', false, 70),
('5', false, 70),
('4', false, 70),
('3', true, 70);
-- Вопрос 71: В какой стране зародился футбол?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Бразилия', false, 71),
('Италия', false, 71),
('Англия', true, 71),
('Аргентина', false, 71);
-- Вопрос 72: Кто выиграл ЧМ по футболу 2018?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Германия', false, 72),
('Франция', true, 72),
('Хорватия', false, 72),
('Бразилия', false, 72);
-- Вопрос 73: Сколько сетов в теннисе для победы?
INSERT INTO answers (text, is_correct, question_id) VALUES
('4 из 7', false, 73),
('1 из 2', false, 73),
('2 из 3 или 3 из 5', true, 73),
('5 из 9', false, 73);
-- Вопрос 74: Какая длина марафонской дистанции?
INSERT INTO answers (text, is_correct, question_id) VALUES
('45 км', false, 74),
('50 км', false, 74),
('40 км', false, 74),
('42.195 км', true, 74);
-- Вопрос 75: Сколько очков за тачдаун в американском футболе?
INSERT INTO answers (text, is_correct, question_id) VALUES
('3', false, 75),
('10', false, 75),
('7', false, 75),
('6', true, 75);
-- Вопрос 76: Кто первым пробежал 100м менее чем за 10 секунд?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Карл Льюис', false, 76),
('Усэйн Болт', false, 76),
('Бен Джонсон', false, 76),
('Джим Хайнс', true, 76);
-- Вопрос 77: В каком году Пеле завершил карьеру?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1980', false, 77),
('1982', false, 77),
('1974', false, 77),
('1977', true, 77);
-- Вопрос 78: Сколько золотых медалей у Майкла Фелпса?
INSERT INTO answers (text, is_correct, question_id) VALUES
('19', false, 78),
('23', true, 78),
('15', false, 78),
('28', false, 78);
-- Вопрос 79: Кто сыграл Железного человека в Marvel?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Марк Руффало', false, 79),
('Роберт Дауни младший', true, 79),
('Крис Хемсворт', false, 79),
('Крис Эванс', false, 79);
-- Вопрос 80: Какой фильм получил больше всего Оскаров?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Аватар', false, 80),
('Форрест Гамп', false, 80),
('Крестный отец', false, 80),
('Бен-Гур / Титаник / Властелин колец (по 11)', true, 80);
-- Вопрос 81: Кто режиссер "Титаника"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Кристофер Нолан', false, 81),
('Джеймс Кэмерон', true, 81),
('Мартин Скорсезе', false, 81),
('Стивен Спилберг', false, 81);
-- Вопрос 82: В каком году вышел первый iPhone?
INSERT INTO answers (text, is_correct, question_id) VALUES
('2009', false, 82),
('2007', true, 82),
('2005', false, 82),
('2010', false, 82);
-- Вопрос 83: Кто композитор музыки для "Звездных войн"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Говард Шор', false, 83),
('Джон Уильямс', true, 83),
('Энио Морриконе', false, 83),
('Ханс Циммер', false, 83);
-- Вопрос 84: Сколько сезонов в "Игре престолов"?
INSERT INTO answers (text, is_correct, question_id) VALUES
('10', false, 84),
('7', false, 84),
('6', false, 84),
('8', true, 84);
-- Вопрос 85: Какая игра стала самой продаваемой?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Wii Sports', false, 85),
('Minecraft', true, 85),
('GTA V', false, 85),
('Tetris', false, 85);
-- Вопрос 86: В каком году была основана студия Pixar?
INSERT INTO answers (text, is_correct, question_id) VALUES
('1995', false, 86),
('1990', false, 86),
('1986', true, 86),
('1980', false, 86);
-- Вопрос 87: Кто создал серию игр Metal Gear?
INSERT INTO answers (text, is_correct, question_id) VALUES
('Масахиро Сакурай', false, 87),
('Сигэру Миямото', false, 87),
('Юдзи Нака', false, 87),
('Хидео Кодзима', true, 87);
-- ===========================
-- ИСТОРИЯ РЕЗУЛЬТАТОВ (для демонстрации)
-- ===========================

-- Результаты для пользователя AlexPro (id=1)
INSERT INTO results (user_id, question_id, user_answer_id, is_correct, rating_change, experience_gained, date_played) VALUES
(1, 1, 1, true, 10, 10, '2024-12-01 10:30:00'),
(1, 9, 9, true, 30, 25, '2024-12-01 10:45:00'),
(1, 16, 16, true, 65, 50, '2024-12-01 11:00:00'),
(1, 21, 21, true, 10, 10, '2024-12-01 11:15:00'),
(1, 28, 28, true, 30, 25, '2024-12-01 11:30:00');

-- Результаты для пользователя MarinaQuiz (id=2)
INSERT INTO results (user_id, question_id, user_answer_id, is_correct, rating_change, experience_gained, date_played) VALUES
(2, 2, 5, true, 10, 10, '2024-12-01 09:00:00'),
(2, 10, 13, false, 0, 0, '2024-12-01 09:15:00'),
(2, 22, 22, true, 10, 10, '2024-12-01 09:30:00'),
(2, 38, 38, true, 10, 10, '2024-12-01 09:45:00');

-- Результаты для пользователя DmitryGenius (id=3)
INSERT INTO results (user_id, question_id, user_answer_id, is_correct, rating_change, experience_gained, date_played) VALUES
(3, 3, 9, true, 10, 10, '2024-12-02 14:00:00'),
(3, 11, 41, true, 30, 25, '2024-12-02 14:20:00'),
(3, 23, 23, true, 10, 10, '2024-12-02 14:40:00');

-- Результаты для пользователя OlgaSmart (id=4)
INSERT INTO results (user_id, question_id, user_answer_id, is_correct, rating_change, experience_gained, date_played) VALUES
(4, 4, 13, true, 10, 10, '2024-12-02 16:00:00'),
(4, 12, 45, true, 30, 25, '2024-12-02 16:20:00'),
(4, 39, 39, true, 10, 10, '2024-12-02 16:40:00');

-- Результаты для пользователя IvanMaster (id=5)
INSERT INTO results (user_id, question_id, user_answer_id, is_correct, rating_change, experience_gained, date_played) VALUES
(5, 5, 17, true, 10, 10, '2024-12-03 10:00:00'),
(5, 13, 49, true, 30, 25, '2024-12-03 10:20:00'),
(5, 55, 55, true, 10, 10, '2024-12-03 10:40:00');