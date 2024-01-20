CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    login    VARCHAR(255),
    password VARCHAR(255),
    email    VARCHAR(255),
    role     VARCHAR(255)
);

CREATE TABLE course
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255),
    author_id   BIGINT REFERENCES users (id),
    price       DECIMAL(19, 2),
    description VARCHAR(255),
    link        VARCHAR(255)
);
CREATE TABLE bought_course (
                               id SERIAL PRIMARY KEY,
                               user_id BIGINT REFERENCES users(id),
                               course_id BIGINT REFERENCES course(id)
);