CREATE table IF NOT EXISTS users(
    id uuid NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    mobile_number varchar(255) NOT NULL,
    email_id character varying(75),
    password character varying(75) NOT NULL,
    status varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    quantity bigint DEFAULT 0,
    PRIMARY KEY(id)
)