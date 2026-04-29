use primo_esempio;

CREATE TABLE Persona (
	id int primary key auto_increment,
    nome varchar(20),
    cognome varchar(20)
); 

drop table persona;
drop table if exists persona;


CREATE TABLE genere(
	id int primary key auto_increment,
    nome varchar(50) not null
);

CREATE TABLE disco(
	id int primary key auto_increment,
	titolo varchar(50) not null,
    autore varchar(50) not null,
    id_genere int,
    constraint fk_genere foreign key (id_genere) references genere (id)
);

drop table disco;
drop table if exists genere;

CREATE TABLE genere(
	id int primary key auto_increment,
    nome varchar(50) not null
);

CREATE TABLE disco(
	id int primary key auto_increment,
	titolo varchar(50) not null,
    autore varchar(50) not null
);


CREATE TABLE disco_genere (
	id int primary key auto_increment,
    id_disco int not null,
    id_genere int not null,
    CONSTRAINT fk_disco foreign key (id_disco) references disco (id),
    CONSTRAINT fk_genere foreign key (id_genere) references genere (id)
);

insert into genere (nome) values("jazz");
insert into genere (nome) values(null);
insert into genere (nome) values("rock");
insert into disco (titolo, autore) values("titolo1", "autore1");

insert into disco_genere (id_disco, id_genere) values (1,1);
insert into disco_genere (id_disco, id_genere) values (1,4);
insert into disco_genere (id_disco, id_genere) values (1,2);

update disco
set titolo = "titoloMod", autore = "autoreMod"
where id = 1;

update disco
set titolo = "titoloMod", autore = "autoreMod"
where id = 2;

delete from genere where id = 1;
delete from disco_genere where id = 1;
delete from genere where id = 1;

select * from disco;
insert into disco (titolo, autore) values ("titolo2", "autore2");

select min(ID), max(id), avg(id), count(*) from disco;

select * from disco inner join disco_genere on disco_genere.id_disco = disco.id;
select * from disco inner join disco_genere on disco_genere.id_disco = disco.id inner join genere on disco_genere.id_genere = genere.id;

set autocommit = 0; #in questa sessione, ho le transazioni abilitate
##################################
start transaction;
insert into disco (titolo, autore) values ("titolo3", "autore3");
rollback; #si annulla la transazione, l'insert non è stato eseguito
##################################
start transaction;
insert into disco (titolo, autore) values ("titolo3", "autore3");
commit; #transazione completata
select * from disco;
##################################

