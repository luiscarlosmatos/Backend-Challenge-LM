-- Insert Doctors

insert into doctors
VALUES ((select nextval('doctors_seq')), 'António');
insert into doctors
VALUES ((select nextval('doctors_seq')), 'Maria');
insert into doctors
VALUES ((select nextval('doctors_seq')), 'Carlos');
insert into doctors
VALUES ((select nextval('doctors_seq')), 'Gabriela');
insert into doctors
VALUES ((select nextval('doctors_seq')), 'Paulo');

-- Insert Patients

insert into patients
VALUES ((select nextval('patients_seq')), 53, 'Manuel');
insert into patients
VALUES ((select nextval('patients_seq')), 32, 'Joana');
insert into patients
VALUES ((select nextval('patients_seq')), 25, 'Ana');
insert into patients
VALUES ((select nextval('patients_seq')), 33, 'Diogo');
insert into patients
VALUES ((select nextval('patients_seq')), 33, 'Catarina');
insert into patients
VALUES ((select nextval('patients_seq')), 40, 'Miguel');


-- Insert Pathologies

insert into pathologies
values ((select nextval('pathologies_seq')), 'Pathology 1');
insert into pathologies
values ((select nextval('pathologies_seq')), 'Pathology 2');
insert into pathologies
values ((select nextval('pathologies_seq')), 'Pathology 3');
insert into pathologies
values ((select nextval('pathologies_seq')), 'Pathology 4');
insert into pathologies
values ((select nextval('pathologies_seq')), 'Pathology 5');
insert into pathologies
values ((select nextval('pathologies_seq')), 'Pathology 6');
insert into pathologies
values ((select nextval('pathologies_seq')), 'Pathology 7');

-- Insert Symptoms

insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 1 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 2 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 3 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 4 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 5 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 6 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 7 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 8 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 9 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 10 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 11 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 12 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 13 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 14 Description');
insert into symptoms
VALUES ((select nextval('symptoms_seq')), 'Symptom 15 Description');

-- Insert Consults

insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')), 'DERMATOLOGY', 1, 1, 1);
insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')), 'DERMATOLOGY', 1, 2, 1);
insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')), 'OPHTHALMOLOGY', 2, 3, 1);
insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')), 'OPHTHALMOLOGY', 2, 3, 2);
insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')), 'RADIOLOGY', 3, 4, 3);
insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')), 'FAMILY_MEDICINE', 4, 5, 4);
insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')),'PEDIATRICS', 5, 6, 5);
insert into consults(id, consult_speciality, doctor_id, pathology_id, patient_id)
VALUES ((select nextval('consults_seq')), 'OPHTHALMOLOGY', 3, 7, 6);


-- Insert Symptoms in pathologies

insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (1, 1);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (1, 2);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (2, 3);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (2, 4);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (2, 5);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (3, 6);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (3, 7);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (4, 8);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (5, 9);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (5, 10);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (5, 11);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (6, 12);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (6, 13);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (7, 14);
insert into pathologies_pathology_symptoms(pathology_pathology_id, pathology_symptoms_symptom_id)
values (7, 15);
