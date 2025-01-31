-- PROCEDURE VALIDATION
INSERT INTO tb_procedure_status (name, description) VALUES ('Em Analise para Validacao', 'Processo de verificacao das imagens e dados do procedimento iniciado.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Aprovado sem Irregularidades', 'Procedimento validado com sucesso, sem irregularidades.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Reanalise Solicitada', 'Nova analise solicitada para revisao do status, seja por pedido do dentista ou da operadora.');

INSERT INTO tb_procedure_type (name, description, class_initial, class_final) VALUES ('Instalação de Aparelho Ortodôntico', 'Procedimento de aplicação de aparelho ortodôntico para correção dos dentes.', 'SEM_APARELHO', 'APARELHO');
INSERT INTO tb_procedure_type (name, description, class_initial, class_final) VALUES ('Remoção de Aparelho Ortodôntico', 'Procedimento de retirada do aparelho ortodôntico após finalização do tratamento.', 'APARELHO', 'SEM_APARELHO');

INSERT INTO tb_address (CITY, NUM, STATE, STREET, ZIP_CODE) VALUES ('São Paulo', '123', 'SP', 'Rua A', '01234-567');
INSERT INTO tb_address (CITY, NUM, STATE, STREET, ZIP_CODE) VALUES ('Rio de Janeiro', '456', 'RJ', 'Avenida B', '23456-789');

INSERT INTO tb_clinic (NAME, CNPJ, PHONE, EMAIL, ADDRESS_ID) VALUES ('Clínica Paulista', '12.345.678/0001-90', '(11) 1234-5678', 'clinica@gmail.com', 1);

INSERT INTO tb_patient (BIRTH_DATE, CREATED_AT, NUM_CARD, NAME, RG) VALUES ('1990-01-15', '2024-10-07', '123456789', 'Ana Souza', 'MG-12.345.678');
INSERT INTO tb_patient (BIRTH_DATE, CREATED_AT, NUM_CARD, NAME, RG) VALUES ('1985-05-20', '2024-10-07', '987654321', 'Carlos Silva', 'SP-23.456.789');