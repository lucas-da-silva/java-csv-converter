<h1 align="center">Conversor de CSV Java</h1>

## Sobre o projeto

Formata arquivos CSV de entrada para um formato específico de saída.

Formato de entrada:

```csv
Nome completo,Data de nascimento,Email,CPF
IRANI TAPEREBÁ,29/06/2001,tapereba@gmail.com,81627775471
catarina mafra,28/05/1991,cmafra@gmail.com,75157671466
```

Formato de saída:

```csv
Nome completo,Data de nascimento,Email,CPF
IRANI TAPEREBÁ,2001-06-29,tapereba@gmail.com,816.277.754-71
CATARINA MAFRA,1991-05-28,cmafra@gmail.com,751.576.714-66
```

## Tecnologias utilizadas

- [Java](https://www.java.com/pt-BR/) - Linguagem de programação

## Funcionalidades

- Ler arquivos CSV de um diretório específico
- Formatar a data de nascimento para o formato _YYYY-MM-DD_
- Formatar o CPF para o formato _XXX.XXX.XXX-XX_
- Escrever um novo arquivo CSV com os dados formatados em um diretório específico

## Instalação

```bash
# Clonar Projeto
$ git clone git@github.com:lucas-da-silva/java-csv-converter.git

# Entrar no diretório
$ cd java-csv-converter

# Executar a aplicação
java ./src/main/java/com/conversorcsv/Conversor.java
```

## Estrutura do projeto

```
$PROJECT_ROOT
|   # Arquivos de configuração do Maven
├── .mvn
|   # Arquivos CSV de entrada
|── entradas
|   # Código fonte da aplicação
└── src
```

## Autor

- [@lucas-da-silva](https://github.com/lucas-da-silva)
