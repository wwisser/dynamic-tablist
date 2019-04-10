CREATE TABLE IF NOT EXISTS tablist_configs (
  owner       VARCHAR(20),
  header      VARCHAR(1000),
  footer      VARCHAR(1000),
  created     BIGINT,
  last_edited BIGINT,
  PRIMARY KEY (owner)
);

CREATE TABLE IF NOT EXISTS tablist_placeholders (
  key          VARCHAR(255),
  description  VARCHAR(255),
  sample_value VARCHAR(255),
  PRIMARY KEY (key)
);