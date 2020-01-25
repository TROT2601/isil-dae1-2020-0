create table tbl_dae1_teacher
(
    id int not null,
    name varchar(50) null,
    last_name varchar(50) null,
    constraint tbl_dae1_teacher_pk
        primary key (id)
);

create table tbl_dae1_course
(
    id int not null,
    name varchar(50) null,
    teacher_id int null,
    constraint tbl_dae1_course_pk
        primary key (id)
);

create table tbl_dae1_student
(
    id int not null,
    name varchar(50) null,
    last_name varchar(50) null,
    birth_date date null,
    constraint tbl_dae1_student_pk
        primary key (id)
);

create table tbl_dae1_enrollment
(
    id int not null,
    course_id int null,
    student_id int null,
    created_date date null,
    credit int null,
    constraint tbl_dae1_enrollment_pk
        primary key (id)
);
