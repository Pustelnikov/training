CREATE TABLE "home_device"
(
  "id" bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  "description" varchar(128) NOT NULL,
  "power" int NOT NULL
);

CREATE TABLE "user"
(
  "id" bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  "username" varchar(128) NOT NULL,
  "password" varchar(128) NOT NULL
);
