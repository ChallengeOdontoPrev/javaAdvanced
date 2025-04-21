-- PROCEDURE VALIDATION
INSERT INTO tb_procedure_status (name, description, code) VALUES ('Em Analise para Validacao', 'Processo de verificacao das imagens e dados do procedimento iniciado.', 'EM_ANALISE');
INSERT INTO tb_procedure_status (name, description, code) VALUES ('Aprovado sem Irregularidades', 'Procedimento validado com sucesso, sem irregularidades.', 'APROVADO');
INSERT INTO tb_procedure_status (name, description, code) VALUES ('Reanalise Solicitada', 'Nova analise solicitada para revisao do status, seja por pedido do dentista ou da operadora.', 'REANALISE_SOLICITADA');
INSERT INTO tb_procedure_status (name, description, code) VALUES ('Reprovado por Inconsistência', 'Imagens analisadas e inconsistências detectadas, procedimento reprovado.', 'REPROVADO');

INSERT INTO tb_procedure_type (name, description, class_initial, class_final) VALUES ('Instalação de Aparelho Ortodôntico', 'Procedimento de aplicação de aparelho ortodôntico para correção dos dentes.', 'SEM_APARELHO', 'APARELHO');
INSERT INTO tb_procedure_type (name, description, class_initial, class_final) VALUES ('Remoção de Aparelho Ortodôntico', 'Procedimento de retirada do aparelho ortodôntico após finalização do tratamento.', 'APARELHO', 'SEM_APARELHO');

INSERT INTO tb_address (CITY, NUM, STATE, STREET, ZIP_CODE) VALUES ('São Paulo', '123', 'SP', 'Rua A', '01234-567');
INSERT INTO tb_address (CITY, NUM, STATE, STREET, ZIP_CODE) VALUES ('Rio de Janeiro', '456', 'RJ', 'Avenida B', '23456-789');

INSERT INTO tb_clinic (NAME, CNPJ, PHONE, EMAIL, ADDRESS_ID) VALUES ('Clínica Paulista', '12.345.678/0001-90', '(11) 1234-5678', 'clinica@gmail.com', 1);

INSERT INTO tb_user (BIRTH_DATE, CREATED_AT, CLINIC_ID, CRO, EMAIL, NAME, PASSWORD, RG, ROLE) VALUES ('2004-01-15', '2025-06-01', 1, '465345634', 'dentista@gmail.com', 'Dr. João', '$2a$10$te6Zkq5IGAw9y7g6MRhFG.0bXQ5Fq79q2/QdkHjbpxAgqsL0YIVfa', '56375463564', 'DENTISTA');
INSERT INTO tb_user (BIRTH_DATE, CREATED_AT, CLINIC_ID, EMAIL, NAME, PASSWORD, RG, ROLE) VALUES ('2004-01-15', '2025-06-01', 1, 'atendente@gmail.com', 'Naryeli Helen', '$2a$10$te6Zkq5IGAw9y7g6MRhFG.0bXQ5Fq79q2/QdkHjbpxAgqsL0YIVfa', '45678318130', 'ATENDENTE');

INSERT INTO tb_patient (BIRTH_DATE, CREATED_AT, NUM_CARD, NAME, RG) VALUES ('1990-01-15', '2024-10-07', 123456789L,'Ana Souza', '12.345.678');
INSERT INTO tb_patient (BIRTH_DATE, CREATED_AT, NUM_CARD, NAME, RG) VALUES ('1985-05-20', '2024-10-07', 987654321L, 'Carlos Silva', '23.456.789');