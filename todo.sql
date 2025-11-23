DROP SCHEMA IF EXISTS todo CASCADE;
CREATE SCHEMA todo;
SET search_path TO todo;

CREATE TABLE todo_user (
    username VARCHAR(25) PRIMARY KEY,
    hash CHAR(64) NOT NULL,
    salt CHAR(32) NOT NULL
);

CREATE TABLE todo (
    id SERIAL,
    todo VARCHAR(25),
    username VARCHAR(15) REFERENCES todo_user(username)
);