DROP SCHEMA IF EXISTS todo CASCADE;
CREATE SCHEMA todo;
SET search_path TO todo;

CREATE TABLE todouser (
    username VARCHAR(15) PRIMARY KEY,
    hash CHAR(64) NOT NULL,
    salt CHAR(32) NOT NULL
);

CREATE TABLE todos (
    id SERIAL,
    todo VARCHAR(25)
);

CREATE TABLE usertodos (
    id SERIAL,
    username VARCHAR(15) NOT NULL,
    todosid INTEGER NOT NULL
);