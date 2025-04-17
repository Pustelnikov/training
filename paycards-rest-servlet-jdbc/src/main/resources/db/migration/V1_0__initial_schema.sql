CREATE TABLE "accounts"
(
    "account_id" bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "account_number" varchar(64) UNIQUE NOT NULL,
    "account_balance" numeric NOT NULL,
    "account_status" varchar(32) NOT NULL
);

CREATE TABLE "cards"
(
    "card_id" bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "card_number" varchar(32) UNIQUE NOT NULL,
    "card_expiration_date" date NOT NULL,
    "card_cvv" integer NOT NULL,
    "card_status" varchar(32) NOT NULL,
    "accounts_account_id" bigint NOT NULL REFERENCES "accounts" ("account_id")
);
