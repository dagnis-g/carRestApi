--liquibase formatted sql

--changeset dagnis:1

create table Car
(
    vin_number          VARCHAR(17) PRIMARY KEY,
    make                VARCHAR(50)        NOT NULL,
    model               VARCHAR(50)        NOT NULL,
    car_year            INT                NOT NULL,
    registration_number VARCHAR(20) UNIQUE NOT NULL
);

insert into Car (vin_number, make, model, car_year, registration_number)
values ('JTHBE5C25A5514367', 'GMC', 'Sierra 1500', 2013, 'ZB6414');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('YV1960BW9A1413905', 'Pontiac', 'Firebird Trans Am', 1986, 'VZ4910');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('3GYT4MEF4DG476978', 'Jaguar', 'XJ', 2009, 'ZD4203');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WBA6A0C5XFD841661', 'Lotus', 'Elise', 2008, 'QL7079');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WAUEF78EX6A255509', 'Bentley', 'Continental', 2008, 'AZ3053');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('1G6DX67D680461775', 'Ford', 'Explorer', 1991, 'DR7021');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('5FNYF3H30FB992071', 'Pontiac', 'Grand Prix', 1975, 'VU9852');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('2FMDK3AK6CB324711', 'Mercedes-Benz', 'CLK-Class', 2001, 'OC4929');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('JTHBP5C21B5320897', 'Pontiac', 'Sunfire', 2002, 'DY1342');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WA1WMAFPXEA966859', 'Porsche', 'Boxster', 2013, 'AA1240');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('3D73M4CL4BG107166', 'Mercedes-Benz', '500SEC', 1993, 'UA1792');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WBAEA53538C601059', 'Isuzu', 'i-Series', 2007, 'EL1400');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('3N1AB6AP1BL143805', 'Dodge', 'Dakota Club', 2004, 'WV5270');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WVWAA7AJ7BW625917', 'Rambler', 'Classic', 1963, 'JL6443');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WAUWMAFC2FN182718', 'Mercedes-Benz', '400SE', 1992, 'MN0298');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('1C4RDHEG1EC675328', 'Porsche', '928', 1995, 'YH7688');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('3D7TP2CTXBG526988', 'Mercedes-Benz', 'GLK-Class', 2012, 'PJ1689');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('JN1BJ0HP4DM452722', 'Plymouth', 'Grand Voyager', 1996, 'PO2347');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WBA3R5C55EK143087', 'Volkswagen', 'R32', 2008, 'CJ1798');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('3D7TP2CT2BG114323', 'Chevrolet', 'Suburban 2500', 2002, 'NX6930');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WAUSF78K59A059927', 'Lexus', 'LS', 2011, 'MN4294');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('1B3CB2HA5AD314318', 'Dodge', 'Neon', 2004, 'HF4766');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WAUEFBFL9DN915324', 'BMW', 'X6 M', 2010, 'PA5247');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('WAUDH74FX6N762634', 'GMC', 'Envoy', 2006, 'HA9162');
insert into Car (vin_number, make, model, car_year, registration_number)
values ('KMHGC4DD0EU419391', 'Lexus', 'IS', 2006, 'RO7488');