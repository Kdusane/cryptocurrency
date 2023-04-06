CREATE table IF NOT EXISTS accounts(
    id uuid NOT NULL,
    account_number varchar(255) NOT NULL,
    ifsc_code varchar(255),
    branch_code varchar(255),
    branch_name varchar(255),
    user_id uuid NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT accounts_user_fk FOREIGN KEY (user_id) REFERENCES users(id)
)