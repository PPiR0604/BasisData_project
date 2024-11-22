use TestProjekAhir

CREATE TABLE Apotek (
    ID_Apotek VARCHAR(20) PRIMARY KEY,
    Nama_apotek VARCHAR(100),
    Alamat VARCHAR(100)
);

CREATE TABLE Obat (
    No_reg VARCHAR(20) PRIMARY KEY,
    Nama_obat VARCHAR(100),
    Produsen VARCHAR(100)
);

CREATE TABLE Memiliki (
    ID_Apotek VARCHAR(20),
    No_reg VARCHAR(20),
    Stok INT,
    PRIMARY KEY (ID_Apotek, No_reg),
    FOREIGN KEY (ID_Apotek) REFERENCES Apotek(ID_Apotek),
    FOREIGN KEY (No_reg) REFERENCES Obat(No_reg)
);

CREATE TABLE Pengiriman (
    ID_pengiriman VARCHAR(20) PRIMARY KEY,
    Tanggal DATE,
    Jumlah_obat INT,
);