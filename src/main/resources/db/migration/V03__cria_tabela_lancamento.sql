CREATE TABLE lancamento (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    descricao VARCHAR(50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE NULL,
    valor NUMERIC(8,2) NOT NULL,
    observacao VARCHAR(50) NULL,
    tipo VARCHAR(50) NOT NULL,
    categoria_id INT NOT NULL,
    pessoa_id INT NOT NULL,
    foreign key (categoria_id) references categoria(id),
    foreign key (pessoa_id) references pessoa(id)
);
