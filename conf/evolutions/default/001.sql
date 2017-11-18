# --- !Ups

CREATE TABLE applied_evolutions_log (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    filename varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO applied_evolutions_log (filename) VALUES ('001.sql');

# --- !Downs

DROP TABLE applied_evolutions_log;
