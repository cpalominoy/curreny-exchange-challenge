-- registro de monedas
INSERT INTO TB_CURRENCY (CURRENCY_ID, CODE, DESCRIPTION)
values (1, 'USD', 'Dólar estadounidense');

INSERT INTO TB_CURRENCY (CURRENCY_ID, CODE, DESCRIPTION)
values (2, 'PEN', 'Nuevo sol');

-- registro del valor del tipo de cambio
INSERT INTO TB_EXCHANGE_RATE (SOURCE_CURRENCY_ID, TARGET_CURRENCY_ID, RATE)
values (1, 2, 3.98);

INSERT INTO TB_EXCHANGE_RATE (SOURCE_CURRENCY_ID, TARGET_CURRENCY_ID, RATE)
values (2, 1, 0.27);


-- registro de usuarios y role

-- Role

insert into TB_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION)
values (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
insert into TB_ROLE (ROLE_ID, ROLE_NAME, DESCRIPTION)
values (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted (bcrypt) password: challenge-jwt
insert into TB_USER (USER_ID, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME)
values (1, 'Ronaldo', 'Sai', '$2y$12$QLEYc.0ekF0FPqNGN2m9quGmbQaWHobH71zEnpa5V42TXew.HakP.',
        'ronaldo.sai');
insert into TB_USER (USER_ID, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME)
values (2, 'Admin', 'Admin', '$2y$12$QLEYc.0ekF0FPqNGN2m9quGmbQaWHobH71zEnpa5V42TXew.HakP.',
        'admin.admin');

-- registro de asociaciones
insert into USER_ROLE(USER_ID, ROLE_ID)
values (1, 1);
insert into USER_ROLE(USER_ID, ROLE_ID)
values (2, 1);
insert into USER_ROLE(USER_ID, ROLE_ID)
values (2, 2);
