Drop table PlantStatus;
Drop table SubstationStatus;
Drop table FeederStatus;
Drop table consumerStatus;
Drop table FuelPrice;
Drop table Consumer;
Drop table Feeder;
Drop table Substation;
Drop table Plant;
Drop table EnergySource;





create table EnergySource (
    id integer not null primary key  
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    energySource varchar(20),
    costPerWatt double
);

create table FuelPrice (
    id integer not null primary key  
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    startDate DATE,
    endDate DATE,
    energySource integer references EnergySource(id)
);

create table Plant (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    energySource integer references EnergySource(id),
    fuelLevel double,
    maxCapacity double
);

create table PlantStatus (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    plantHB boolean,
    powerProduced double,
    timeUpdated  timestamp,
    plantId integer references Plant(id)
);

create table Substation (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    maxLoad double    
);

create table SubstationStatus (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    stationHB boolean,
    timeUpdated timestamp,
    stationId integer references Substation(id)
);

create table Feeder (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    stationId integer references Substation(id)
);

create table FeederStatus (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    feederHB boolean,
    timeUpdated timestamp,
    feederId integer references Feeder(id)
);

create table Consumer (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    feeder integer references Feeder(id)
);

create table ConsumerStatus (
    id integer not null primary key
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    consumerHB boolean,
    powerConsumed double,
    timeUpdated timestamp,
    consumerId integer references Consumer(id)
);




