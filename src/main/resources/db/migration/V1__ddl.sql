create sequence consults_seq start with 1 increment by 1;
create sequence doctors_seq start with 1 increment by 1;
create sequence pathologies_seq start with 1 increment by 1;
create sequence patients_seq start with 1 increment by 1;
create sequence symptoms_seq start with 1 increment by 1;

create table consults
(
    id                 bigint not null,
    consult_speciality varchar(255),
    doctor_id          bigint,
    pathology_id       bigint,
    patient_id         bigint,
    primary key (id)
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
    patient_age  integer,
    patient_name varchar(255),
    primary key (patient_id)
);

create table symptoms
(
    symptom_id          bigint not null,
    symptom_description varchar(255),
    primary key (symptom_id)
);

alter table if exists pathologies_pathology_symptoms
    add constraint UK_bl5dsk6dkg8y9txyeairu7083 unique (pathology_symptoms_symptom_id);

alter table if exists consults
    add constraint FKntgktftnbgp1kwwljw34odnk4
        foreign key (doctor_id)
            references doctors;

alter table if exists consults
    add constraint FK69pmkyujkk1260dypygdctmh5
        foreign key (pathology_id)
            references pathologies;

alter table if exists consults
    add constraint FKalqd3c08uoq8pn0ts9ap6le8e
        foreign key (patient_id)
            references patients;

alter table if exists pathologies_pathology_symptoms
    add constraint FKcw0fjdmyjtlq3fh9iq95byxla
        foreign key (pathology_symptoms_symptom_id)
            references symptoms;

alter table if exists pathologies_pathology_symptoms
    add constraint FK3y1ha8rt6jq8u8ddkn8gqqfxy
        foreign key (pathology_pathology_id)
            references pathologies;
