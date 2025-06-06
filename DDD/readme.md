# 📘 Domain-Driven Design (DDD)

## O que é DDD?

**DDD (Domain-Driven Design)** é uma abordagem para desenvolvimento de software focada em entender e modelar o **domínio de negócio**, ou seja, o problema que o sistema está resolvendo. 

Foi proposta por **Eric Evans** no livro *Domain-Driven Design: Tackling Complexity in the Heart of Software*.

A ideia central é aproximar o time técnico das regras de negócio, construindo um software que reflita fielmente o mundo real.

---

## 🔍 Etapas / Conceitos principais

### 1. Descoberta do Domínio

Antes de escrever código, é necessário entender profundamente o problema. Isso envolve a colaboração entre desenvolvedores e especialistas do negócio.

**Objetivo:** Capturar a complexidade real do domínio com clareza.

---

### 2. Ubiquitous Language (Linguagem Ubíqua)

É uma linguagem comum usada por todos os envolvidos (devs, analistas, negócio).  
Essa linguagem deve estar presente em:
- Conversas
- Documentação
- Código

> 📌 Exemplo: Se o negócio fala em "Product", "Client", "Billing", o código deve usar esses mesmos nomes.

---

### 3. Modelagem do Domínio

Transformamos o conhecimento do domínio em **modelos de código**, com os seguintes elementos:

- **Domain Entity:** objetos com identidade única (ex: `Customer`, `Product`)
- **Value Objects:** definidos apenas pelos seus atributos (ex: `Address`, `CPF/CNPJ`)
- **Aggregates:** agrupamentos de entidades com regras de consistência
- **Services:** lógica de negócio que não pertence a uma entidade específica
- **Repository:** abstrações para persistência de dados

---

### 4. Bounded Contexts (Contextos Delimitados)

Dividimos o sistema em **contextos isolados**, cada um com seu próprio modelo e linguagem.

> 💡 Exemplo: "Customer" pode significar uma coisa no financeiro e outra no suporte. Cada contexto terá sua definição.

---

### 5. Integração entre Contextos

Os contextos delimitados podem se comunicar através de:

- Eventos de Domínio
- APIs REST
- Mensageria (ex: RabbitMQ, Kafka)

Isso mantém a independência dos contextos sem perder a integração.

---

### 6. Implementação Estratégica

Definimos a arquitetura com base nos contextos:

- Separação de responsabilidades
- Uso (ou não) de microserviços
- Camadas de aplicação
- Estratégias de persistência

DDD não obriga o uso de microserviços, mas ajuda a decidir **quando** e **como** usá-los.

---

### 7. Projeto prático

Na raiz da pasta `DDD`, você encontrará um exemplo de como estruturar uma aplicação utilizando os princípios do Domain-Driven Design. O projeto está implementado em **Java** com **Springboot**, mas os conceitos podem ser aplicados em qualquer linguagem de programação. O importante é entender a **organização do domínio, os contextos e os padrões usados**, não a tecnologia em si.


## ✅ Benefícios do DDD

- Código alinhado com as regras de negócio
- Melhor comunicação entre áreas técnicas e não técnicas
- Modularização e organização do sistema
- Escalabilidade e manutenção facilitadas

---

## 📚 Referência

- *Domain-Driven Design: Tackling Complexity in the Heart of Software* - Eric Evans  
- *Implementing Domain-Driven Design* - Vaughn Vernon

