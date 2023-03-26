-- Insert Doctors

insert into doctors VALUES ((select nextval('doctors_seq')),'António');
insert into doctors VALUES ((select nextval('doctors_seq')),'Maria');
insert into doctors VALUES ((select nextval('doctors_seq')),'Carlos');
insert into doctors VALUES ((select nextval('doctors_seq')),'Gabriela');
insert into doctors VALUES ((select nextval('doctors_seq')),'Paulo');


--Insert Specialities

insert into specialities VALUES ( (select nextval('specialities_seq')), 'DERMATOLOGY', 1);
insert into specialities VALUES ( (select nextval('specialities_seq')), 'OPHTHALMOLOGY', 2);
insert into specialities VALUES ( (select nextval('specialities_seq')), 'RADIOLOGY', 3);
insert into specialities VALUES ( (select nextval('specialities_seq')), 'FAMILY_MEDICINE', 4);
insert into specialities VALUES ( (select nextval('specialities_seq')), 'PEDIATRICS', 5);

-- Insert Patients

insert into patients VALUES ( (select nextval('patients_seq')), 'Manuel', 53);
insert into patients VALUES ( (select nextval('patients_seq')), 'Joana', 32);
insert into patients VALUES ( (select nextval('patients_seq')), 'Ana', 25);
insert into patients VALUES ( (select nextval('patients_seq')), 'Diogo', 33);
insert into patients VALUES ( (select nextval('patients_seq')), 'Catarina', 33);
insert into patients VALUES ( (select nextval('patients_seq')), 'Miguel', 40);


-- Insert Pathologies

insert into pathologies values ( (select nextval('pathologies_seq')), 'Pathology 1');
insert into pathologies values ( (select nextval('pathologies_seq')), 'Pathology 2');
insert into pathologies values ( (select nextval('pathologies_seq')), 'Pathology 3');
insert into pathologies values ( (select nextval('pathologies_seq')), 'Pathology 4');
insert into pathologies values ( (select nextval('pathologies_seq')), 'Pathology 5');
insert into pathologies values ( (select nextval('pathologies_seq')), 'Pathology 6');
insert into pathologies values ( (select nextval('pathologies_seq')), 'Pathology 7');

-- Insert Symptoms

insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 1 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 2 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 3 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 4 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 5 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 6 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 7 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 8 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 9 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 10 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 11 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 12 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 13 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 14 Description');
insert into symptoms VALUES ((select nextval('symptoms_seq')), 'Symptom 15 Description');

-- Insert Consults

insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '1 day')), 1, 1, 1 );
insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '2 day')), 1, 1, 1 );
insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '3 day')), 2, 1, 2 );
insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '4 day')), 2, 2, 2 );
insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '5 day')), 3, 3, 3 );
insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '6 day')), 4, 4, 4 );
insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '7 day')), 5, 5, 5 );
insert into consults VALUES ((select nextval('consults_seq')), (select (now() - interval '8 day')), 3, 6, 2 );


-- Insert Pathologies in consults

insert into consults_consult_pathologies VALUES (1,1);
insert into consults_consult_pathologies VALUES (2,2);
insert into consults_consult_pathologies VALUES (3,3);
insert into consults_consult_pathologies VALUES (4,3);
insert into consults_consult_pathologies VALUES (5,4);
insert into consults_consult_pathologies VALUES (6,5);
insert into consults_consult_pathologies VALUES (7,6);
insert into consults_consult_pathologies VALUES (8,7);

-- Insert Symptoms in pathologies

insert into pathologies_pathology_symptoms values (1, 1);
insert into pathologies_pathology_symptoms values (1, 2);
insert into pathologies_pathology_symptoms values (2, 3);
insert into pathologies_pathology_symptoms values (2, 4);
insert into pathologies_pathology_symptoms values (2, 5);
insert into pathologies_pathology_symptoms values (3, 6);
insert into pathologies_pathology_symptoms values (3, 7);
insert into pathologies_pathology_symptoms values (4, 8);
insert into pathologies_pathology_symptoms values (5, 9);
insert into pathologies_pathology_symptoms values (5, 10);
insert into pathologies_pathology_symptoms values (5, 11);
insert into pathologies_pathology_symptoms values (6, 12);
insert into pathologies_pathology_symptoms values (6, 13);
insert into pathologies_pathology_symptoms values (7, 14);
insert into pathologies_pathology_symptoms values (7, 15);

--select (now() - interval '1 day');
