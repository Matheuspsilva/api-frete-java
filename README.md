# App de gestão de frete para empresa de Logística

[![SpringBoot](https://img.shields.io/badge/SpringBoot-3.1.5-blue)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17.0.0-blue)](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
[![Maven](https://img.shields.io/badge/Maven-4.0.0-blue)](https://maven.apache.org/download.cgi)
[![H2](https://img.shields.io/badge/H2-all-blue)](https://www.h2database.com/html/main.html)

---

**código fonte:** <a href="https://github.com/Matheuspsilva/api-frete-java" target="_blank">https://github.com/Matheuspsilva/api-frete-java

---

## Instalação
Para instalar as dependências do projeto, utilize o comando abaixo:
```bash
mvn clean install
```

## Execução
Para executar o projeto, utilize o comando abaixo:
```bash
mvn spring-boot:run
```

## Funcionalidade Principal
O aplicativo é desenvolvido para a empresa de logística XPTO e permite
o gerenciamento de transporte de mercadorias entre as filiais de empresas terceirizadas.
Ele estabelece rotas específicas para cada entrega,
o que facilita o agendamento de fretes, como:

- Exemplo 1: Transportar produtos da Coca-Cola da filial de São Paulo para a filial de Minas Gerais.
- Exemplo 2: Levar mercadorias da Unilever da filial de São Paulo para a filial do Rio de Janeiro.

Esses exemplos ilustram o funcionamento central do aplicativo, permitindo que a empresa XPTO planeje e monitore eficazmente o transporte de produtos entre diferentes filiais de empresas terceirizadas por meio de rotas pré-definidas.
O aplicativo é composto por várias classes, incluindo Rota, Frete, Empresa (classe mãe), Remetente (classe filha 1), Destinatário (classe filha 2) e Transportadora (classe filha 3).


### Componentes do Sistema

O aplicativo é composto por várias classes, incluindo:

- **Rota:**: Responsável por definir as rotas de transporte.
- **Frete:**: Encarregado de gerenciar as informações de frete.
- **Empresa:**: Uma classe base para as classes filhas.
- **Remetente:**: Representa a empresa que está enviando a mercadoria.
- **Destinatário:**: Representa a empresa que está recebendo a mercadoria.
- **Transportadora:**: Representa a empresa que está transportando a mercadoria.
- **Status Frete:**: Representa a situação atual do frete.

### Funcionalidades do Sistema:

Os funcionários do sistema têm a capacidade de:

- Cadastrar novos fretes
- Consultar fretes existentes
- Atualizar frete
- Excluir frete

- Cadastrar novas empresas
- Consultar empresas existentes
- Atualizar empresas
- Remover empresas

- Cadastrar Rotas
- Consultar Rotas existentes
- Atualizar Rotas
- Excluir Rotas
