CREATE TABLE member (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL
);
ALTER TABLE ONLY member
    ADD CONSTRAINT member_pkey PRIMARY KEY (id);

CREATE TABLE arisan (
    id character varying(36) NOT NULL,
    keterangan character varying(255),
    kode character varying(10) NOT NULL,
    nominal_ambil bigint NOT NULL,
    nominal_dapat bigint NOT NULL,
    tanggal_ambil timestamp without time zone NOT NULL,
    tanggal_dapat timestamp without time zone NOT NULL,
    id_member character varying(255),
    CONSTRAINT arisan_nominal_ambil_check CHECK ((nominal_ambil >= 0)),
    CONSTRAINT arisan_nominal_dapat_check CHECK ((nominal_dapat >= 0))
);
ALTER TABLE ONLY arisan
    ADD CONSTRAINT arisan_pkey PRIMARY KEY (id);
ALTER TABLE ONLY arisan
    ADD CONSTRAINT fkpu8fdqgpi9yximk9e0kaiw0yu FOREIGN KEY (id_member) REFERENCES member(id);

