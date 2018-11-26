CREATE TABLE Sifarnici (
	id_sifarnik int UNSIGNED NOT NULL PRIMARY KEY,
	naziv varchar(50) NOT NULL
);

CREATE TABLE Stavke_sifarnika (
	id_stavka int UNSIGNED NOT NULL PRIMARY KEY,
	id_sifarnik int UNSIGNED NOT NULL,
	naziv varchar(50) NOT NULL
);

ALTER TABLE Stavke_sifarnika (
	
)