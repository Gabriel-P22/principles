# Nest

## Aqui vamos ensinar como criar e dar manutenção nas apps em nest. 

### O que é o Nest?

O Nest é uma **framework** baseada no **NODE**, escrito em **Typescript**. Ele foi criado com o objetivo de oferecer uma estrutura robusta escalável e organizada para desenvolver APIS com **Typescript**.

O **Nest** melhora os conceitos da Programação orientada a objeto (**POO**), Programação funcional (**FP**) e Programação Reativa(**FRP**).

Ele foi criado em 2017, principalmente para resolver a desorganização das aplicações em frameworks **Javascript/Typescript**. Embora o **NODE** com **Express** seja leve e flexivel, ele não oferece um guia claro de padrões, arquiteturas e escalabilidade.

A proposta do **NEST** é preencher essa lacuna, oferecendo uma base sólida com boas praticas embutidas desde o incio, permitindo que desenvolvedores individuais ou times construam **aplições modernas**, **seguras** e **fáceis de escalar**.

Hoje o **Nest** é utilizado por grandes empresas para conseguir trazer todas essas qualidades baseadas em **Javascript/Typescript**.

### Vamos abordar alguns temas como:

- CLI
- Modules
- Controllers
- Providers
- Middleswares
- Exception filters
- Pipes
- Guards
- Interceptors
- Custom Decorators

Na raiz da pasta **NEST**, vamos ter uma pasta para cada tópico comentado a cima e uma aplicação usando cada recurso.

### Como começar?

Inicialmente, vamos instalar a **CLI** do **NEST** para criação de alguns recursos. 

> npm i -g @nestjs/cli

Quais são os beneficios de usar a CLI?

Conseguimos criar modulos, middalware, pipes e outros recursos de forma automatica. Podemos ter a autonomia de criar com as nossas proprias mãos, mas vamos acabar gastando mais tempo e recurso de forma desnecessária.

### Como criar uma aplicação?

Para criar um projeto vamos usar um **comando** do proprio **nest** para gerar o projeto.

> nest new coloque-o-nome-do-projeto

Com isso, vamos gerar um projeto em nest. Geralmente uma estrutura do projeto segue essa hierarquia de pastas:

```
src/
├── main.ts
├── app.module.ts
├── app.controller.ts
├── app.controller.spec.ts
└── app.service.ts

```
### link da documentação do nest:

> https://docs.nestjs.com/