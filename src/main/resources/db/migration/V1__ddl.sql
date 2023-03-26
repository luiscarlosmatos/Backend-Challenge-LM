

create sequence consults_seq start with 1 increment by 1;
create sequence doctors_seq start with 1 increment by 1;
create sequence pathologies_seq start with 1 increment by 1;
create sequence patients_seq start with 1 increment by 1;
create sequence specialities_seq start with 1 increment by 1;
create sequence symptoms_seq start with 1 increment by 1;

create table consults
(
    id            bigint not null,
    consult_date  timestamp(6) with time zone,
    doctor_id     bigint,
    patient_id    bigint,
    speciality_id varchar(255),
    primary key (id)
);
create table consults_consult_pathologies
(
    consult_id                       bigint not null,
    consult_pathologies_pathology_id bigint not null
);
create table doctors
(
    doctor_id   bigint not null,
    doctor_name varchar(255),
    primary key (doctor_id)
);
create table pathologies
(
    pathology_id   bigint not null,
    pathology_name varchar(255),
    primary key (pathology_id)
);
create table pathologies_pathology_symptoms
(
    pathology_pathology_id        bigint not null,
    pathology_symptoms_symptom_id bigint not null
);
create table patients
(
    patient_id   bigint not null,
    patient_name varchar(255),
    patient_age  bigint,
    primary key (patient_id)
);
create table specialities
(
    speciality_id   varchar(255) not null,
    speciality_name varchar(255),
    doctor_id       bigint,
    primary key (speciality_id)
);
create table symptoms
(
    symptom_id          bigint not null,
    symptom_description varchar(255),
    primary key (symptom_id)
);
-- alter table if exists consults_consult_pathologies
--     add constraint UK_byucc2ftd4u1w0xg5siwxuyc5 unique (consult_pathologies_pathology_id);
-- alter table if exists pathology_pathology_symptoms
--     add constraint UK_92c7c3s2h4mcwlq5100yj93ta unique (pathology_symptoms_symptom_id);
alter table if exists consults
    add constraint FKntgktftnbgp1kwwljw34odnk4 foreign key (doctor_id) references doctors;
alter table if exists consults
    add constraint FKalqd3c08uoq8pn0ts9ap6le8e foreign key (patient_id) references patients;
alter table if exists consults
    add constraint FK46gn4sn3yowwsx9t76c5vgsvb foreign key (speciality_id) references specialities;
alter table if exists consults_consult_pathologies
    add constraint FKenvbojbfhog0uu6uxvk0d2cks foreign key (consult_pathologies_pathology_id) references pathologies;
alter table if exists consults_consult_pathologies
    add constraint FKipll3j43vk1h66lv9433xaqfn foreign key (consult_id) references consults;
alter table if exists pathologies_pathology_symptoms
    add constraint FKv8pl7t4y9miy3dwti3ueuhk1 foreign key (pathology_symptoms_symptom_id) references symptoms;
alter table if exists pathologies_pathology_symptoms
    add constraint FKgxwdrxvrfqgkcanngjcs574xm foreign key (pathology_pathology_id) references pathologies;
alter table if exists specialities
    add constraint FK8l1stqxuiu01v0re82rr3rofq foreign key (doctor_id) references doctors;
