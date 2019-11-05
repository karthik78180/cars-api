DROP TABLE IF EXISTS Cars;

CREATE TABLE Cars(
    VIN VARCHAR(250) PRIMARY KEY,
    Make varchar(250) NOT null,
    Model VARCHAR (250) NOT NULL,

);

INSERT INTO Cars(VIN, Make, Model) VALUES  ('1234', 'Dodge    ', 'Durango'),
                                            ('1235', 'Kia   ', 'Optima'),
                                            ('1236', 'Honda   ','Accord'),
                                            ('5674', 'abcd    ', 'Durango'),
                                            ('9853', 'jhed   ', 'Optima'),
                                            ('3748', 'ehjdfwe   ','Accord');
