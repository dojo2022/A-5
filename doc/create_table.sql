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

INSERT INTO users (user_name,user_password) VALUES ('test' ,'test0000');
INSERT INTO calendars ( calendar_name, user_id) VALUES ('テストカレンダー', 1);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('てすと', 'F',
TO_DATE('22-06-16', 'YY-MM-DD') ,null , null,'aaaa', 1, TO_DATE('22-06-18', 'YY-MM-DD') , null);
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('てすと', 'A',
TO_DATE('22-06-26', 'YY-MM-DD') ,null , null,'aaaa', 1, TO_DATE('22-06-26', 'YY-MM-DD') , TO_DATE('22-06-29', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('てすと', 'A',
TO_DATE('22-06-29', 'YY-MM-DD') ,null , null,'aaaa', 1, TO_DATE('22-06-29', 'YY-MM-DD') , TO_DATE('22-07-02', 'YY-MM-DD'));
INSERT INTO schedules ( schedule, schedule_type, date, time, last_time, memo , calendar_id,last_date,auto_last_date) VALUES ('てすと', 'A',
TO_DATE('22-06-17', 'YY-MM-DD') ,null , null,'aaaa', 1, TO_DATE('22-06-20', 'YY-MM-DD') , TO_DATE('22-06-20', 'YY-MM-DD'));
INSERT INTO regular_schedules (schedule , first_date , last_date , memo , calendar_id , regular_schedule_type ,regular_schedule_value)
VALUES('定期てすと' , TO_DATE('22-02-11', 'YY-MM-DD') , TO_DATE('22-02-12', 'YY-MM-DD') ,'めもてすと',1,'W','1,6')