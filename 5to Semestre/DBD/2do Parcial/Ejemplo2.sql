create table tabla1(
s1 int, 
primary key (s1));

create table tabla2(
s1 int, 
key (s1),
foreign key (s1) references tabla1 (s1));