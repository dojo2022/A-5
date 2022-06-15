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
    calendar_type CHAR(1),
    lock INT DEFAULT null
);
CREATE TABLE schedules (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    schedule VARCHAR(15) NOT NULL,
    schedule_type CHAR(1) NOT NULL,
    date date NOT NULL,
    time time,
    memo VARCHAR(50),
    calendar_id INT NOT NULL,
    FOREIGN KEY (calendar_id) REFERENCES calendars (calendar_id),
    last_date date NOT NULL,
    is_delete BOOLEAN DEFAULT FALSE NOT NULL,
    is_lock BOOLEAN DEFAULT FALSE NOT NULL
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
)