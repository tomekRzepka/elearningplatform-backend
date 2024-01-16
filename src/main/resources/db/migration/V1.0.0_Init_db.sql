CREATE TABLE users (
                            id SERIAL PRIMARY KEY,
                            login VARCHAR(255),
                            password VARCHAR(255),
                            email VARCHAR(255),
                            role VARCHAR(255)
);
CREATE TABLE content (
                         id SERIAL PRIMARY KEY,
                         description VARCHAR(255),
                         link VARCHAR(255)
);
CREATE TABLE course (
                              id SERIAL PRIMARY KEY,
                              title VARCHAR(255),
                              author_id BIGINT REFERENCES users(id),
                              price DECIMAL(19, 2),
                              content_id BIGINT REFERENCES content(id)
);
