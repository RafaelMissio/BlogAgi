# 🧪 Testes Automatizados - Blog Agi

Este repositório contém a automação de testes para a funcionalidade de busca do **Blog do Agi**. O projeto utiliza **Java 21**, **Selenium WebDriver** para automação de UI, **JUnit 5** para execução de testes, e **Allure** para relatórios visualmente atraentes. O objetivo é garantir a qualidade da busca de artigos, validando vários cenários, incluindo termos válidos, inexistentes, vazios e com caracteres especiais.

---

## 🎯 Objetivo do Projeto

- **Automação de testes** para a busca de artigos no Blog do Agi.
- Validação de cenários funcionais:
  - Busca por termo válido
  - Busca por termo inexistente
  - Busca com campo vazio
  - Busca com caracteres especiais
- Integração com **CI/CD (GitHub Actions)**.
- Geração de **relatórios Allure** para resultados visualmente atraentes.

---

## 🛠️ Como Executar o Projeto Localmente
▶️ Como Executar o Projeto Localmente
1️⃣ Pré-requisitos

Antes de começar, verifique se você possui:

Java 21 instalado
Git instalado
Navegador Google Chrome instalado

2️⃣ Clonar o repositório
git clone https://github.com/RafaelMissio/blogAgi.git


3️⃣ Baixar dependências e compilar o projeto

comando: ./gradlew build
Esse comando irá:

baixar todas as dependências
compilar o projeto
validar se o ambiente está configurado corretamente



💡 Esse passo é recomendado na primeira execução do projeto.

4️⃣ Executar os testes automatizados

Para rodar todos os testes de automação localmente:

comando: ./gradlew clean test

Esse comando irá:

iniciar o navegador automaticamente
executar todos os cenários de teste
gerar os resultados da execução


5️⃣ Gerar o relatório Allure

Após a execução dos testes, gere o relatório visual do Allure:

comando: ./gradlew allureReport

Esse comando irá:

gerar o relatório visual do Allure


O relatório será gerado no diretório:

build/reports/allure-report

## Execucao local

```bash
./gradlew clean test
./gradlew allureReport
./gradlew allureServe
```

Para forcar modo headless localmente:

```bash
HEADLESS=true ./gradlew clean test allureReport
```

