INSERT INTO "accounts" (account_number, account_balance, account_status)
VALUES ('AccNo65827647148812', 800, 'LOCKED'),
       ('AccNo02046614305685', 100, 'ACTIVE'),
       ('AccNo44512291105731', 300, 'ACTIVE'),
       ('AccNo30835714230230', 400, 'ACTIVE'),
       ('AccNo94836701173487', 700, 'ACTIVE'),
       ('AccNo19415712205877', 500, 'ACTIVE'),
       ('AccNo40318911090276', 900, 'ACTIVE'),
       ('AccNo22071048978566', 600, 'ACTIVE');

INSERT INTO "cards" (card_number, card_expiration_date, card_cvv, card_status, accounts_account_id)
VALUES ('Card2522358261698812', '2027-10-03', 502, 'LOCKED', 1),
       ('Card0390908607375069', '2027-10-03', 123, 'ACTIVE', 2),
       ('Card5116249494396470', '2027-10-03', 256, 'ACTIVE', 3),
       ('Card2438654407412244', '2027-10-03', 543, 'ACTIVE', 4),
       ('Card9423283619808905', '2027-10-03', 734, 'ACTIVE', 1),
       ('Card5383247252190595', '2027-10-03', 888, 'LOCKED', 7),
       ('Card4350673517112840', '2027-10-03', 023, 'ACTIVE', 7),
       ('Card1658644711325279', '2027-10-03', 578, 'ACTIVE', 8),
       ('Card9445879124538133', '2027-10-03', 348, 'ACTIVE', 3);
