# Nest

## Aqui vamos ensinar como criar e dar manutenção nas apps em nest. 

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

## Como começar?



Inicialmente, vamos instalar a **CLI** do **NEST** para criação de alguns recursos. 

> npm i -g @nestjs/cli

Quais são os beneficios de usar a CLI?

Conseguimos criar modulos, middalware, pipes e outros recursos de forma automatica. Podemos ter a autonomia de criar com as nossas proprias mãos, mas vamos acabar gastando mais tempo e recurso de forma desnecessária.

## Como criar uma aplicação?

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