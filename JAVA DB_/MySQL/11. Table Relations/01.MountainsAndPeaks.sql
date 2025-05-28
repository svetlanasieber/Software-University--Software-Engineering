CREATE TABLE `mountains` (
	`id` int auto_increment primary key,
    `name` varchar(100) not null


);

create table peaks(
	id int auto_increment primary key,
    name varchar(100) not null,
    mountain_id int not null,
    constraint fk_peaks_mountain_id_mountains_id
    foreign key (mountain_id)
    references mountains(id)
);
