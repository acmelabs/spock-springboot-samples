CREATE TABLE IF NOT EXISTS some_table (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(16) NOT NULL,
    longText VARCHAR(65000),
    someTime TIMESTAMP,
    recordType VARCHAR(9),

    PRIMARY KEY (id)
);

CREATE INDEX idx_some_table ON some_table(trn);