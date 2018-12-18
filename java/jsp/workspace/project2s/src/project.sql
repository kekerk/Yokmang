SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS allboard;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS series;




/* Create Tables */

CREATE TABLE actor
(
	no int NOT NULL,
	actorname varchar(30) NOT NULL,
	actorimg varchar(500),
	seriesname varchar(50),
	birthdate date,
	birthplace varchar(50),
	actseries varchar(500),
	PRIMARY KEY (no)
);


CREATE TABLE allboard
(
	no int NOT NULL,
	boardtype int(10) NOT NULL,
	id varchar(30) NOT NULL,
	title varchar(100),
	content varchar(5000),
	file1 varchar(500),
	regdate datetime,
	readcnt int(50),
	seriesno int NOT NULL,
	PRIMARY KEY (no, boardtype)
);


CREATE TABLE comments
(
	no int NOT NULL,
	ref_no int NOT NULL,
	id varchar(30) NOT NULL,
	boardtype int(10) NOT NULL,
	ref int(200),
	reflevel int(200),
	refstep int(400),
	content varchar(4000) NOT NULL,
	PRIMARY KEY (no, ref_no)
);


CREATE TABLE members
(
	id varchar(30) NOT NULL,
	nickname varchar(40) NOT NULL,
	password varchar(30) NOT NULL,
	name varchar(30) NOT NULL,
	gender int NOT NULL,
	tel varchar(20),
	email varchar(50),
	domi varchar(30) NOT NULL,
	grade int NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (nickname)
);


CREATE TABLE series
(
	seriesno int NOT NULL,
	posname varchar(40) NOT NULL,
	poscontent varchar(4000),
	posimage varchar(500),
	posscore int DEFAULT 0 NOT NULL,
	onlinescore int DEFAULT 0 NOT NULL,
	moviedirector varchar(100),
	outline varchar(200),
	PRIMARY KEY (seriesno)
);



/* Create Foreign Keys */

ALTER TABLE comments
	ADD FOREIGN KEY (no, boardtype)
	REFERENCES allboard (no, boardtype)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE allboard
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE comments
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE allboard
	ADD FOREIGN KEY (seriesno)
	REFERENCES series (seriesno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



