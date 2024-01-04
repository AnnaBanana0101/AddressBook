
-- UC1
create database address_book_service;
show databases;
use address_book_service;

-- UC2
create table address_book(
	user_name varchar(30),
    address varchar(50),
    city varchar(30),
    state varchar(30),
    zip int,
    phone_no int,
    email varchar(50)
);

-- UC3
  insert into address_book(user_name, address, city, state, zip, phone_no, email) values 
  ("Anika Shukla", "B-903", "Mumbai", "Maharashtra", 400053, 915425142, "abc@gmail.com"),
  ("Dnyanada Khile", "A-803", "Mumbai", "Maharashtra", 400053, 893421382, "bcd@gmail.com"),
  ("Rohan Kamath", "D-009", "Pune", "Maharashtra", 411014, 673828392, "xyd@gmail.com"),
  ("Rohan Voda", "E-905", "Bangalore", "Karnataka", 409037, 783645273, "ghi@gmail.com"),
  ("Aditya Rao", "F-009", "Chennai", "Tamil Nadu", 509394, 983828392, "xzy@gmail.com")
  ;

-- desc address_book;

-- select * from address_book;

-- UC4
SHOW VARIABLES LIKE 'sql_safe_updates';
SET sql_safe_updates = 0;
SHOW VARIABLES LIKE 'sql_safe_updates';
 
 
update address_book set zip = 499039 where user_name = "Rohan Voda";
 
select * from address_book;

-- UC5
delete from address_book where user_name = "Rohan Voda";


--  UC6
select * from address_book where city = "Mumbai";
select * from address_book where state = "Maharashtra";

-- UC7
select count(*) from address_book where state = "Maharashtra";

-- UC8
select * from address_book where city = "Mumbai" order by user_name;

-- UC9
alter table address_book add type varchar(30) after user_name;
desc address_book;

update address_book set type = "Family" where user_name = "Anika Shukla";
update address_book set type = "Family" where user_name = "Dnyanada Khile";
update address_book set type = "Friend" where user_name = "Rohan Kamath";
update address_book set type = "Professional" where user_name = "Aditya Rao";

-- UC10
select type, count(*) from address_book group by type;

-- UC11
insert into address_book (user_name, type, address, city, state, zip, phone_no, email) values 
("Brian Thomas", "Friend", "G-908", "Bangalore", "Karnataa", 230998, "suv@gmaiil.com"),
("Brian Thomas", "Family", "G-908", "Bangalore", "Karnataa", 230998, "suv@gmaiil.com");

select * from address_book;
