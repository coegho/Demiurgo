CREATE TABLE users (
  username varchar(128) NOT NULL PRIMARY KEY,
  passwd char(64) NULL,
  mail varchar(256) NULL,
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

CREATE TABLE classes (
  classname varchar(128) NOT NULL PRIMARY KEY,
  code TEXT NOT NULL
);

CREATE TABLE locations (
  id bigint NOT NULL PRIMARY KEY
);

CREATE TABLE rooms (
  id bigint NOT NULL PRIMARY KEY,
  long_path varchar(256) NOT NULL,
  room_value BLOB,
  prenarration TEXT NULL DEFAULT NULL
);

CREATE TABLE inventories (
  id bigint NOT NULL PRIMARY KEY,
  varname varchar(128) NOT NULL,
  obj_id bigint NOT NULL
);

CREATE TABLE actions (
  id bigint NOT NULL PRIMARY KEY,
  room bigint NULL,
  narration TEXT NULL DEFAULT NULL,
  publish_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  published boolean NOT NULL DEFAULT FALSE
);

CREATE TABLE witness_action (
  action bigint NOT NULL,
  username varchar(128) NOT NULL,
  decision text NULL,
  PRIMARY KEY (action, username)
);

CREATE TABLE current_ids (
  obj bigint NOT NULL DEFAULT 0,
  room bigint NOT NULL DEFAULT 0,
  action bigint NOT NULL DEFAULT 0
);

INSERT current_ids (obj) VALUES (0);

ALTER TABLE users
ADD CONSTRAINT fk_users_objects FOREIGN KEY (obj_id) REFERENCES objects(obj_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE rooms
ADD CONSTRAINT fk_rooms_locations FOREIGN KEY (id) REFERENCES locations(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE objects
ADD CONSTRAINT fk_objects_rooms FOREIGN KEY (location) REFERENCES locations(id) ON DELETE RESTRICT ON UPDATE CASCADE,
ADD CONSTRAINT fk_objects_classes FOREIGN KEY (classname) REFERENCES classes(classname) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE witness_action
ADD CONSTRAINT fk_witness_action FOREIGN KEY (action) REFERENCES actions(id) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT fk_witness_user FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE inventories
ADD CONSTRAINT fk_inventories_locations FOREIGN KEY (id) REFERENCES locations(id) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT fk_inventories_objects FOREIGN KEY (obj_id) REFERENCES objects(obj_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE actions
ADD CONSTRAINT fk_actions_locations FOREIGN KEY (room) REFERENCES locations(id) ON DELETE SET NULL ON UPDATE CASCADE;

/*first user, with pass: 1234*/
INSERT INTO users VALUES('gm', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', NULL, 'GM', NULL, NULL);
