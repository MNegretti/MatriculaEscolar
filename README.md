# Sistema de Matricula Escolar
Disciplina de Programação Orientada a Objetos - Projeto 3

# Sobre o projeto

O Sistema de Matricula Escolar tem como objetivo automatizar o processo da matricula dos alunos em suas respectivas escolas, de acordo com a localização. O projeto foi desenvolvido em JAVA utilizando Spring Boot. Na fase atual de desenvolvimento, foi criada uma API, onde os dados inseridos serão armazenados em um banco de dados na memório do computador e disponibilizados na rede local (localhost), será possível acessar os dados dos alunos e das escolas. Em futuras atualizações, o sistema será automatizado, de forma que a matricula seja feita de acordo com a proximidade do aluno com a escola.

Público-Alvo:
O sistema atende aos administradores responsáveis por realizar a matricula de alunos em escolas públicas municipais.


## Nome do desenvolvedor e RA
Matheus Campos Negretti  - RA 202108365


# Tecnologias empregadas

Java: É uma linguagem de programação versátil e orientada a objetos, conhecida por sua segurança, portabilidade e ampla aplicação em desenvolvimento de software.

Spring Boot: É um framework de desenvolvimento em Java que simplifica a criação de aplicativos robustos e escaláveis, facilitando a configuração e fornecendo convenções prontas para o uso.

List: É  uma estrutura de dados utilizada para armazenar e manipular conjuntos de objetos.

CRUD: São as operações responsáveis pela manipulação de dados em um banco de dados: Create (Criar), Read (Ler), Update (Atualizar) e Delete (Excluir).


# Descrição da arquitetura

## Estrutura das Classes:
Aluno:
Representa o aluno que deseja frequentar uma escola.
Atributos: id, nome, idade e endereço.
Métodos: Construtor, getters e setters e CRUD.

Escola:
Representa uma escola que deseja receber um aluno.
Atributos: id, nome e endereço.
Métodos: Construtor, getters e setters e CRUD.



## Operações CRUD para Aluno:
Create (cadastrarAluno): Permite cadastrar um novo aluno.

Read (verificarAluno): Permite verificar os dados de um aluno com base em seu ID, além de obter uma lista de todos alunos cadastrados.

Update (atualizarAluno): Permite atualizar os dados de um aluno já cadastrado com base em seu ID.

Delete (excluirAluno): Permite realizar a exclusão de um aluno cadastrado.


## Operações CRUD para Escola:
Create (cadastrarEscola): Permite cadastrar um nova escola.

Read (verificarEscola): Permite verificar os dados de uma escola com base em seu ID, além de obter uma lista de todas escolas cadastradas.

Update (atualizarEscola): Permite atualizar os dados cadastrais de uma escola com base em seu ID.

Delete (excluirEScola): Permite realizar a exclusão de uma escola cadastrada.
