CREATE TABLE users (
  username varchar(128) NOT NULL PRIMARY KEY,
  passwd varchar(32) NOT NULL DEFAULT '',
  admin tinyint NOT NULL default 0,
  obj_id bigint NULL
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
  room_value BLOB
);

CREATE TABLE current_ids (
  obj bigint NOT NULL DEFAULT 0,
  room bigint NOT NULL DEFAULT 0
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
