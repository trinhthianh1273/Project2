create database apartment;

create table apartment(
	id int(5) not null auto_increment primary key,
    name varchar(30) not null,
    floor_quanty int(2) not null,
    room_quanty int(3) not null,
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);

create table room(
	id int(5) not null auto_increment primary key,
    apartment_id int(5) not null,
    name varchar(30) not null,
    floor int(2) not null,
    member_max int(1) not null,
    rental int(11) not null,
    status int(1) not null,
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);

alter table room 
add foreign key(apartment_id) references apartment(id);

create table household_good(
	id int(5) not null auto_increment primary key,
    category_id int(5) not null,
    name varchar(30) not null,
    quanty int(3),
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);

alter table household_good 
add foreign key(category_id) references household_category(id);

create table household_category(
	id int(5) not null,
    name varchar(30) not null unique,
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);

create table renter(
	id int(11) not null auto_increment primary key,
    name varchar(30) not null,
    phone int(11) not null unique,
    email varchar(50) not null unique,
    status varchar(30) not null,
    dob timestamp not null,
    province varchar(30) not null,
    district varchar(30) not null,
    commune varchar(30) not null,
    address varchar(30) null,
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);

create table tenancy(
	id int(11) not null auto_increment primary key,
    room_id int(5) not null unique,
    proxy_id int(11) not null unique,
    renter1 int(11) null unique,
    renter2 int(11) null unique,
    renter3 int(11) null unique,
    bed int(1) not null,
    wardrobe int(1) not null,
    fridge int(1) not null,
    titchen_infrared int(1) not null,
    pot int(1) not null,
    desk int(1) not null,
    small_table int(1) not null,
    chair int(1) not null,
    startDate timestamp not null,
    endDate timestamp not null,
    blank int(1) not null,
    status int(1) not null,
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);

alter table tenancy 
add foreign key(room_id) references room(id),
add foreign key(proxy_id) references renter(id),
add foreign key(renter1) references renter(id),
add foreign key(renter2) references renter(id),
add foreign key(renter3) references renter(id);

create table receipt(
	id int(11) not null auto_increment primary key,
    tenacy_id int(11) not null,
    time date not null,
    electric int(11) not null,
    water int(11) not null,
    service int(11) not null,
    total_payment int(11) not null,
    status int(1) not null,
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);

alter table receipt 
add foreign key(tenacy_id) references tenancy(id);

create table manager(
	id int(11) not null auto_increment primary key,
    name varchar(30) not null,
    login_id varchar(30) not null unique,
    pass varchar(30) not null,
    permission int(1) not null,
    createDate timestamp not null default current_timestamp,
    updateDate timestamp default null
);