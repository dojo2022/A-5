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
INSERT INTO users (user_name,user_password) VALUES ('rina_tea' ,'12345678');
INSERT INTO calendars ( calendar_name, user_id) VALUES ('仕事用', 1);
INSERT INTO calendars ( calendar_name, user_id) VALUES ('プライベート', 1);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('書類締切', 'F',
TO_DATE('22-07-11', 'YY-MM-DD') ,null , null,'大森', 1, TO_DATE('22-07-11', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('基本情報テスト', 'F',
TO_DATE('22-07-17', 'YY-MM-DD') ,null , null,'四谷', 1, TO_DATE('22-07-17', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('友達とランチ', 'F',
TO_DATE('22-07-8', 'YY-MM-DD') ,null , null,'渋谷', 2, TO_DATE('22-07-8', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('飲み会', 'F',
TO_DATE('22-07-8', 'YY-MM-DD') ,null , null,'渋谷', 2, TO_DATE('22-07-8', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('美容院', 'F',
TO_DATE('22-07-30', 'YY-MM-DD') ,null , null,'自由が丘', 2, TO_DATE('22-07-30', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('友達とランチ', 'F',
TO_DATE('22-07-12', 'YY-MM-DD') ,null , null,'自由が丘', 2, TO_DATE('22-07-12', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('飲み会', 'F',
TO_DATE('22-07-15', 'YY-MM-DD') ,null , null,'麹町', 2, TO_DATE('22-07-15', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('エアコンの掃除', 'A',
TO_DATE('22-07-15', 'YY-MM-DD') ,null , null,'', 2, TO_DATE('22-07-15', 'YY-MM-DD') , TO_DATE('22-07-20', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('部屋の掃除', 'A',
TO_DATE('22-07-24', 'YY-MM-DD') ,null , null,'', 2, TO_DATE('22-07-24', 'YY-MM-DD') , TO_DATE('22-07-24', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-07-8', 'YY-MM-DD') ,null , null,'燃えるゴミ', 2, TO_DATE('22-07-8', 'YY-MM-DD') , TO_DATE('22-07-8', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-07-15', 'YY-MM-DD') ,null , null,'燃えるゴミ', 2, TO_DATE('22-07-15', 'YY-MM-DD') , TO_DATE('22-07-15', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-07-22', 'YY-MM-DD') ,null , null,'燃えるゴミ', 2, TO_DATE('22-07-22', 'YY-MM-DD') , TO_DATE('22-07-22', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('ゴミ出し', 'R',
TO_DATE('22-07-29', 'YY-MM-DD') ,null , null,'燃えるゴミ', 2, TO_DATE('22-07-29', 'YY-MM-DD') , TO_DATE('22-07-29', 'YY-MM-DD'));