CREATE TABLE checker (
    id     varchar         PRIMARY KEY,
    code   varchar         NOT NULL
);

CREATE TABLE homework (
    id                   varchar         PRIMARY KEY,
    name                 varchar         NOT NULL,
    publication_date     timestamp       NOT NULL,
    task_description     varchar         NOT NULL,
    deadline             timestamp       NOT NULL,
    checker_id           varchar         NOT NULL REFERENCES checker (id)
);

CREATE TABLE attempt (
    id            varchar         PRIMARY KEY,
    homework_id   varchar         NOT NULL REFERENCES homework (id),
    date_time     timestamp       NOT NULL,
    mark          varchar,
    comment       varchar
);

INSERT INTO checker VALUES ('test-checker-id', 'test-checker-code');
INSERT INTO homework VALUES ('test-homework-id', 'test-homework-name', '2022-10-05 14:01:10-08', 'test-task-description', '2023-10-05 14:01:10-08', 'test-checker-id');
INSERT INTO attempt VALUES ('test-attempt-id', 'test-homework-id', '2022-12-05 14:01:10-08', 'YES', 'Ok');