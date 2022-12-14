create database apartment;
use apartment;
create table apartment(
                          id int(5) not null auto_increment primary key,
                          name varchar(30) not null,
                          floor_quanty int(2) not null,
                          room_quanty int(3) not null,
                          createDate timestamp not null default current_timestamp,
                          updateDate timestamp null
);

insert into apartment(name, floor_quanty, room_quanty)
values("HUD3", 9, 40);

create table room(
                     id int(5) not null auto_increment primary key,
                     apartment_id int(5) not null,
                     name varchar(30) not null,
                     floor int(2) not null,
                     member_max int(1) not null,
                     rental int(11) not null,
                     status int(1) not null,
                     createDate timestamp not null default current_timestamp,
                     updateDate timestamp null
);

alter table room
    add foreign key(apartment_id) references apartment(id);

create table household_good(
                               id int(5) not null auto_increment primary key,
                               not_used int(5) not null,
                               name varchar(30) not null,
                               quanty int(3),
                               createDate timestamp not null default current_timestamp,
                               updateDate timestamp null
);

insert into household_good(name, quanty)
values("bed", 40),
      ("wardrobe",40),
      ("fridge",40),
      ("titchen_infrared",40),
      ("pot",66),
      ("desk",54),
      ("small_table",38),
      ("chair", 58);

-- use apartment;
-- create table household_category(
--                                    id int(5) not null,
--                                    name varchar(30) not null unique,
--                                    createDate timestamp not null default current_timestamp,
--                                    updateDate timestamp null
-- );

-- -- alter table household_good
-- -- add foreign key(category_id) references household_category(id);

use apartment;
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
                       updateDate timestamp null
);

alter table renter
    add column gender int(1) not null;

create table contract(
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
                         createDate timestamp not null default current_timestamp,
                         updateDate timestamp null,
                         startDate timestamp null,
                         endDate timestamp null,
                         blank int(1) not null,
                         status int(1) not null
);

alter table contract
    add foreign key(room_id) references room(id),
add foreign key(proxy_id) references renter(id),
add foreign key(renter1) references renter(id),
add foreign key(renter2) references renter(id),
add foreign key(renter3) references renter(id);

create table receipt(
                        id int(11) not null auto_increment primary key,
                        tenacy_id int(11) not null,
                        year int(5) not null,
                        month int(2) not null,
                        electric int(11) not null,
                        water int(11) not null,
                        service int(11) not null,
                        forfeit int(11) null,
                        total_payment int(11) not null,
                        status int(1) not null,
                        createDate timestamp not null default current_timestamp,
                        updateDate timestamp null
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
                        updateDate timestamp null
);

insert into manager(name, login_id, pass,permission)
values("Trinh Thi Anh", "tta", "12345678", 1),
      ("Pham Duc Huy", "pdh", "12345678", 2),
      ("Ly Bao Anh", "lba", "12345678", 2),
      ("Nguyen Duy Anh", "nda", "12345678", 2);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0201", 2, 4, 5000000),
      (1, "0202", 2, 4, 5000000),
      (1, "0203", 2, 4, 5000000),
      (1, "0204", 2, 4, 5000000),
      (1, "0205", 2, 4, 5000000);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0301", 3, 4, 5000000),
      (1, "0302", 3, 4, 5000000),
      (1, "0303", 3, 4, 5000000),
      (1, "0304", 3, 4, 5000000),
      (1, "0305", 3, 4, 5000000);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0401", 4, 4, 8000000),
      (1, "0402", 4, 4, 8000000),
      (1, "0403", 4, 4, 8000000),
      (1, "0404", 4, 4, 8000000),
      (1, "0405", 4, 4, 8000000);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0501", 5, 4, 8000000),
      (1, "0502", 5, 4, 8000000),
      (1, "0503", 5, 4, 8000000),
      (1, "0504", 5, 4, 8000000),
      (1, "0505", 5, 4, 8000000);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0601", 6, 4, 8000000),
      (1, "0602", 6, 4, 8000000),
      (1, "0603", 6, 4, 8000000),
      (1, "0604", 6, 4, 8000000),
      (1, "0605", 6, 4, 8000000);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0701", 7, 4, 9000000),
      (1, "0702", 7, 4, 9000000),
      (1, "0703", 7, 4, 9000000),
      (1, "0704", 7, 4, 9000000),
      (1, "0705", 7, 4, 9000000);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0801", 8, 4, 9000000),
      (1, "0802", 8, 4, 9000000),
      (1, "0803", 8, 4, 9000000),
      (1, "0804", 8, 4, 9000000),
      (1, "0805", 8, 4, 9000000);

insert into room(apartment_id, name, floor, member_max, rental)
values(1, "0901", 9, 4, 9000000),
      (1, "0902", 9, 4, 9000000),
      (1, "0903", 9, 4, 9000000),
      (1, "0904", 9, 4, 9000000),
      (1, "0905", 9, 4, 9000000);


SET TIME_ZONE = '+00:00';

insert into renter(name, phone, email, status, dob, province, district, commune, address, gender)
values("Trinh Thi Anh", "0941147009", "phungbaokimanh@gmail.com", 1, '2000-04-19',"Nam Dinh", "Xuan Truong", 'Xuan Kien','', 0),
      ("Pham Duc Huy", "0111111111", "phamduchuy@gmail.com", 1,'2000-04-20','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Ly Bao Anh", "0111111112", "lybaoanh@gmail.com", 1,'2000-04-21','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Nguyen Duy Anh", "0111111113", "nguyenduyanhA@gmail.com", 1,'2000-04-22','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '',  1),
      ("Nguyen Duy Anh", "0111111114", "nguyenduyanhB@gmail.com", 1,'2000-04-23', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Tran Bao Trung", "0111111115", "tranbaotrung@gmail.com", 1,'2000-04-24', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Nguyen Minh Vu", "0111111116", "nguyenminhvu@gmail.com", 1,'2000-04-25', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Nguyen Tat Dat", "0111111117", "nguyentatdat@gmail.com", 1,'2000-04-26', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Nguyen Van Thai", "0111111118", "nguyenvanthai@gmail.com", 1,'2000-04-27', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Phan Van Truong", "0111111119", "phanvantruong@gmail.com", 1,'2000-04-28', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Nguyen Ngoc Minh", "0111111120", "nguyenngocminh@gmail.com", 1,'2000-04-29', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Nguyen Thien Hao", "0111111121", "nguyenthienhao@gmail.com", 1,'2000-04-30', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Pham Chi Cuong", "0111111122", "phamchicuong@gmail.com", 1,'2000-05-01', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Le Ngoc Anh Vu", "0111111123", "lengocanhvu@gmail.com", 1,'2000-05-02', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Vuong Huu Hung", "0111111124", "vuonghuuhung@gmail.com", 1,'2000-05-03', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Tran Duc Hung", "0111111125", "tranduchung@gmail.com", 1,'2000-05-04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '',1),
      ("Nguyen Dong Duong", "0111111126", "nguyendongduong@gmail.com", 1,'2000-05-05', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Duong Bach Tuong Quan", "0111111127", "duongbachtuongquan@gmail.com", 1,'2000-05-06', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Tran Quang", "0111111128", "tranquang@gmail.com", 1,'2000-05-07', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Do Thi Ngoc Binh", "0111111129", "dothingocbinh@gmail.com", 1,'2000-05-08', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Vu Thi Thao", "0111111130", "vuthithao@gmail.com", 1,'2000-05-09', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Nguyen Thanh Quyen", "0111111131", "nguyenthanhquyen@gmail.com", 1, '2000-05-10','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Pham Mai Anh", "0111111132", "phammaianh@gmail.com", 1, '2000-05-11','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Do Viet Cuong", "0111111133", "dovietcuong@gmail.com", 1,'2000-05-12','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Le Thi Hoa", "0111111134", "lethihoa@gmail.com", 1, '2000-05-13','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Tran Van Tien", "0111111135", "tranvantien@gmail.com", 1, '2000-05-14','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Ta Thi Hong", "0111111136", "tathihong@gmail.com", 1, '2000-05-15','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Vương Thi Quyen", "0111111137", "vuongthiquyen@gmail.com", 1, '2000-05-16','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Dang Van Hung", "0111111138", "dangvanhung@gmail.com", 1, '2000-05-17','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Tran Duc Xo", "0111111139", "tranducxo@gmail.com", 1, '2000-05-18','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Khuc Thi Thơ", "0111111140", "khucthitho@gmail.com", 1, '2000-05-19','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Nguyen Thi Dao", "0111111141", "nguyenthidao@gmail.com", 1, '2000-05-20','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Nguyen Thanh Long", "0111111142", "nguyenthanhlong@gmail.com", 1, '2000-05-21','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Pham Thi Hoa", "0111111143", "phamthihoa@gmail.com", 1, '2000-05-21','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Do Trong Tu", "0111111144", "dotrongtu@gmail.com", 1, '2000-05-22','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Trinh Thi Luyen", "0111111145", "trinhthiluyen@gmail.com", 1, '2000-05-23','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Nguyen Thi Minh", "0111111146", "nguyenthiminh@gmail.com", 1, '2000-05-24','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Le Thi Thuc", "0111111147", "lethithuc@gmail.com", 1, '2000-05-25','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0),
      ("Nguyen Van Chung", "0111111148", "nguyenvanchung@gmail.com", 1,'2000-05-26','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 1),
      ("Tran Thi Minh", "0111111149", "tranthiminh@gmail.com", 1, '2000-05-27','Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', 0);

insert into contract(room_id, proxy_id, renter1, renter2, renter3, bed, wardrobe, fridge, titchen_infrared, pot, desk, small_table, chair)
values(1, 1, 2, 3, null, 1, 1, 1, 1, 1, 1, 1, 1),
      (2, 4, 5, null, null, 1, 1, 1, 1, 1, 1, 1, 1);