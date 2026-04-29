create schema shoppingCart;
use shoppingcart;

create table if not exists articolo(
	nome varchar(20) primary key,
    prezzo float
);
