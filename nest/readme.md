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

Para começar, vamos precisar configurar o cli do nest. Podemos criar tudo no modo padrão, criando com as proprias mãos, mas isso tem um custo de tempo muito maior. Para evitar esse problema, vamos instalar a **CLI** do **NEST**.


> npm i -g @nestjs/cli

Quais são os beneficios de usar a CLI?

Conseguimos criar modulos, middalware, pipes e outros recursos de forma automatica.

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