USE test;

DROP TABLE IF EXISTS part;
CREATE TABLE part
(
  id       BIGINT AUTO_INCREMENT PRIMARY KEY,
  in_stock INT          NOT NULL,
  name     VARCHAR(255) NULL,
  required BIT          NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO test.part (in_stock, name, required) VALUES (4, 'Материнская плата', true);
INSERT INTO test.part (in_stock, name, required) VALUES (10, 'Звуковая карта', false);
INSERT INTO test.part (in_stock, name, required) VALUES (5, 'Процессор', true);
INSERT INTO test.part (in_stock, name, required) VALUES (1, 'Подстветка корпуса', false);
INSERT INTO test.part (in_stock, name, required) VALUES (10, 'HDD диск', false);
INSERT INTO test.part (in_stock, name, required) VALUES (8, 'SSD диск', true);
INSERT INTO test.part (in_stock, name, required) VALUES (20, 'Корпус', true);
INSERT INTO test.part (in_stock, name, required) VALUES (10, 'Память', true);
INSERT INTO test.part (in_stock, name, required) VALUES (5, 'Видеокарта', false);
INSERT INTO test.part (in_stock, name, required) VALUES (2, 'Мышь', false);
INSERT INTO test.part (in_stock, name, required) VALUES (9, 'Клавиатура', true);
INSERT INTO test.part (in_stock, name, required) VALUES (19, 'Монитор', true);
INSERT INTO test.part (in_stock, name, required) VALUES (1, 'Принтер', false);
INSERT INTO test.part (in_stock, name, required) VALUES (7, 'Кулер для охлаждения корпуса', false);
INSERT INTO test.part (in_stock, name, required) VALUES (0, 'Привод гибких дисков', false);
INSERT INTO test.part (in_stock, name, required) VALUES (1, 'Привод оптических дисков', false);
INSERT INTO test.part (in_stock, name, required) VALUES (3, 'Wi-Fi модуль', false);
INSERT INTO test.part (in_stock, name, required) VALUES (11, 'Блок питания', true);
INSERT INTO test.part (in_stock, name, required) VALUES (5, 'Система охлаждения процессора', true);
INSERT INTO test.part (in_stock, name, required) VALUES (21, 'Bluetooth адаптер', false);
INSERT INTO test.part (in_stock, name, required) VALUES (2, 'USB хаб', false);
INSERT INTO test.part (in_stock, name, required) VALUES (2, 'диск 1', false);
INSERT INTO test.part (in_stock, name, required) VALUES (4, 'диск 2', false);
INSERT INTO test.part (in_stock, name, required) VALUES (82, 'диск 3', false);
INSERT INTO test.part (in_stock, name, required) VALUES (8, 'диск 4', true);
INSERT INTO test.part (in_stock, name, required) VALUES (2, 'диск 5', false);
INSERT INTO test.part (in_stock, name, required) VALUES (9, 'диск 6', false);
INSERT INTO test.part (in_stock, name, required) VALUES (1, 'диск 7', false);