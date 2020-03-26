create sequence hibernate_sequence;
CREATE TABLE public.article (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	"type" varchar(255) NULL
);