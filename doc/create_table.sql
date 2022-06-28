DROP TABLE IF EXISTS schedules;
DROP TABLE IF EXISTS regular_schedules;
DROP TABLE IF EXISTS calendars;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(15) NOT NULL UNIQUE,
    user_password VARCHAR(32) NOT NULL,
    priority_calendar INT DEFAULT 0 NOT NULL,
    is_delete BOOLEAN DEFAULT FALSE NOT NULL
);
CREATE TABLE calendars(
    calendar_id INT AUTO_INCREMENT PRIMARY KEY,
    calendar_name VARCHAR(15) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    is_delete BOOLEAN DEFAULT FALSE NOT NULL,
    calendar_type CHAR(1) NOT NULL DEFAULT 'G',
    lock INT DEFAULT null,
    is_lock BOOLEAN DEFAULT FALSE NOT NULL
);
CREATE TABLE schedules (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    schedule VARCHAR(15) NOT NULL,
    schedule_type CHAR(1) NOT NULL,
    date date NOT NULL,
    time time,
    last_time time,
    memo VARCHAR(50),
    calendar_id INT NOT NULL,
    FOREIGN KEY (calendar_id) REFERENCES calendars (calendar_id),
    last_date date NOT NULL,
    is_delete BOOLEAN DEFAULT FALSE NOT NULL,
    auto_last_date date 
);
CREATE TABLE regular_schedules (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    schedule VARCHAR(15) NOT NULL,
    first_date date NOT NULL,
    last_date date NOT NULL,
    memo VARCHAR(50),
    calendar_id INT NOT NULL,
    FOREIGN KEY(calendar_id) REFERENCES calendars(calendar_id),
    is_delete BOOLEAN DEFAULT FALSE NOT NULL,
    regular_schedule_type CHAR(1) NOT NULL,
    regular_schedule_value VARCHAR(7) NOT NULL
);

INSERT INTO users (user_name,user_password) VALUES ('higuchi' ,'12345678');
INSERT INTO calendars ( calendar_name, user_id) VALUES ('プライベート', 1);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('友達とランチ', 'F',
TO_DATE('22-08-6', 'YY-MM-DD') ,null , null,'渋谷', 1, TO_DATE('22-08-6', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('美容院', 'F',
TO_DATE('22-08-30', 'YY-MM-DD') ,null , null,'自由が丘', 1, TO_DATE('22-08-30', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('掃除', 'A',
TO_DATE('22-08-12', 'YY-MM-DD') ,null , null,'', 1, TO_DATE('22-08-14', 'YY-MM-DD') , TO_DATE('22-08-14', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('掃除', 'A',
TO_DATE('22-08-24', 'YY-MM-DD') ,null , null,'', 1, TO_DATE('22-08-24', 'YY-MM-DD') , TO_DATE('22-08-24', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('課題', 'A',
TO_DATE('22-08-22', 'YY-MM-DD') ,null , null,'プログラミング', 1, TO_DATE('22-08-22', 'YY-MM-DD') , TO_DATE('22-08-22', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-08-5', 'YY-MM-DD') ,null , null,'燃えるゴミ', 1, TO_DATE('22-08-5', 'YY-MM-DD') , TO_DATE('22-08-5', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-08-12', 'YY-MM-DD') ,null , null,'燃えるゴミ', 1, TO_DATE('22-08-12', 'YY-MM-DD') , TO_DATE('22-08-12', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-08-19', 'YY-MM-DD') ,null , null,'燃えるゴミ', 1, TO_DATE('22-08-19', 'YY-MM-DD') , TO_DATE('22-08-19', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-08-26', 'YY-MM-DD') ,null , null,'燃えるゴミ', 1, TO_DATE('22-08-26', 'YY-MM-DD') , TO_DATE('22-08-26', 'YY-MM-DD'));
