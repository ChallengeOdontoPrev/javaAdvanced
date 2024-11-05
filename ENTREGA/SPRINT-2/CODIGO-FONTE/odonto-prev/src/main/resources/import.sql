INSERT INTO tb_procedure_status (name, description) VALUES ('Aguardando Validação', 'Procedimento registrado, aguardando início da análise.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Em Análise de Validação', 'Processo de verificação das imagens e dados do procedimento iniciado.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Aprovado sem Irregularidades', 'Procedimento validado com sucesso, sem irregularidades.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Suspeita de Fraude', 'Indícios de possível fraude detectados, como imagens inconsistentes.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Fraude Confirmada', 'Procedimento confirmado como fraudulento.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Inconclusivo', 'Dados insuficientes para validação conclusiva; pode exigir mais informações.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Reanálise Solicitada', 'Nova análise solicitada para revisão do status, seja por pedido do dentista ou da operadora.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Agendada', 'Consulta agendada, aguardando confirmação.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Confirmada', 'Consulta confirmada pelo dentista e/ou paciente.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Em Atendimento', 'Consulta em andamento no consultório.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Concluída', 'Consulta finalizada com sucesso.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Cancelada', 'Consulta cancelada pelo paciente ou pela clínica.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Não Compareceu', 'Paciente não compareceu à consulta.');
INSERT INTO tb_procedure_status (name, description) VALUES ('Reagendada', 'Consulta foi reagendada para outra data.');

INSERT INTO tb_procedure_type (name, description) VALUES ('Instalação de Aparelho Ortodôntico', 'Procedimento de aplicação de aparelho ortodôntico para correção dos dentes.');
INSERT INTO tb_procedure_type (name, description) VALUES ('Remoção de Aparelho Ortodôntico', 'Procedimento de retirada do aparelho ortodôntico após finalização do tratamento.');
INSERT INTO tb_procedure_type (name, description) VALUES ('Restauração Dentária', 'Procedimento de reparo de dentes danificados ou cariados com material restaurador.');
INSERT INTO tb_procedure_type (name, description) VALUES ('Extração de Dentes', 'Procedimento de remoção de um ou mais dentes.');
INSERT INTO tb_procedure_type (name, description) VALUES ('Remoção de Cárie', 'Procedimento de limpeza e retirada de tecido dentário deteriorado por cáries.');
INSERT INTO tb_procedure_type (name, description) VALUES ('Remoção de Tártaro', 'Procedimento de limpeza dos dentes para remoção de tártaro acumulado.');

INSERT INTO tb_address (CITY, NUM, STATE, STREET, ZIP_CODE) VALUES ('São Paulo', '123', 'SP', 'Rua A', '01234-567');
INSERT INTO tb_address (CITY, NUM, STATE, STREET, ZIP_CODE) VALUES ('Rio de Janeiro', '456', 'RJ', 'Avenida B', '23456-789');

INSERT INTO tb_clinic (NAME, CNPJ, PHONE, EMAIL, ADDRESS_ID) VALUES ('Clínica Paulista', '12.345.678/0001-90', '(11) 1234-5678', 'clinica@gmail.com', 1);

INSERT INTO tb_patient (BIRTH_DATE, CREATED_AT, NUM_CARD, NAME, RG) VALUES ('1990-01-15', '2024-10-07', '123456789', 'Ana Souza', 'MG-12.345.678');
INSERT INTO tb_patient (BIRTH_DATE, CREATED_AT, NUM_CARD, NAME, RG) VALUES ('1985-05-20', '2024-10-07', '987654321', 'Carlos Silva', 'SP-23.456.789');