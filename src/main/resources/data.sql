MERGE INTO users (username, email, password, phone, date_age, role)
KEY (username)
VALUES ('juan122', 'juan2@gmail.com', '1234da', 12345678, '12/10/2022', 'ADMIN');

MERGE INTO users (username, email, password, phone, date_age, role)
KEY (username)
VALUES ('juan', 'juan@gmail.com', '1234da', 12345678, '12/10/2022', 'USER');