CREATE TABLE users (
  username varchar(128) NOT NULL PRIMARY KEY,
  passwd char(64) NULL,
  role enum('GM','USER') NOT NULL default 'USER',
  obj_id bigint NULL,
  decision TEXT NULL DEFAULT NULL
);

CREATE TABLE objects (
  obj_id bigint NOT NULL PRIMARY KEY,
  classname varchar(128) NOT NULL,
  room bigint NOT NULL,
  obj_value BLOB
);

CREATE TABLE rooms (
  id bigint NOT NULL PRIMARY KEY,
  long_path varchar(256) NOT NULL,
  room_value BLOB,
  prenarration TEXT NULL DEFAULT NULL
);

CREATE TABLE actions (
  id bigint NOT NULL PRIMARY KEY,
  room bigint NOT NULL,
  narration TEXT NULL DEFAULT NULL,
  publish_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  published boolean NOT NULL DEFAULT FALSE
);

CREATE TABLE witness_action (
  action bigint NOT NULL,
  username varchar(128) NOT NULL,
  PRIMARY KEY (action, username)
);

CREATE TABLE current_ids (
  obj bigint NOT NULL DEFAULT 0,
  room bigint NOT NULL DEFAULT 0,
  action bigint NOT NULL DEFAULT 0
);

INSERT current_ids (obj, room) VALUES (0,0);

ALTER TABLE users
ADD CONSTRAINT fk_users_objects FOREIGN KEY (obj_id) REFERENCES objects(obj_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE objects
ADD CONSTRAINT fk_objects_rooms FOREIGN KEY (room) REFERENCES rooms(id)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE witness_action
ADD CONSTRAINT fk_witness_action FOREIGN KEY (action) REFERENCES actions(id) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT fk_witness_user FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE;