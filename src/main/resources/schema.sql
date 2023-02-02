  create table account(
      id int auto_increment primary key,
      firstname varchar(200) NOT NULL,
      lastname varchar(200) NOT NULL,
      username varchar(200) NOT NULL,
      password varchar(200) NOT NULL
  );

  create unique index pk_unique_firstname_lastname_combo on account(firstname,lastname);
  create unique index pk_unique_username on account(username);

  create table role(
       id int auto_increment primary key,
       name varchar(200),
       account int,
       foreign key (account) references account(id)
  );