<!-- DDL -->
CREATE TABLE `COMMENT` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(32) NOT NULL,
    `reg_date` datetime NOT NULL DEFAULT NOW(),
    `content` mediumtext,
    PRIMARY KEY (`id`)
);

CREATE TABLE `REPLY` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT,
    `comment_id` bigint(19) NOT NULL,
    `user_id` varchar(32) NOT NULL,
    `content` mediumtext,
    `reg_date` datetime DEFAULT NOW(),
    PRIMARY KEY (`id`)
);

CREATE TABLE `USER` (
    `id` varchar(32) NOT NULL,
    `name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
);

<!-- DML -->
INSERT INTO COMMENT (`user_id`, `content`)
VALUES ('test1', 'test1 content');