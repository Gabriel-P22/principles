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
- Setup
- Ciclo de vida
- resources
- Modules
- Providers
- Controllers
- Providers
- Middleswares
- Exception filters
- Pipes
- Guards
- Interceptors
- Custom Decorators

Na raiz da pasta **NEST**, vamos ter uma pasta para cada tópico comentado a cima e uma aplicação usando cada recurso.

### CLI:

Inicialmente, vamos instalar a **CLI** do **NEST** para criação de alguns recursos. 

> npm i -g @nestjs/cli

Quais são os beneficios de usar a CLI?

Conseguimos criar modulos, middalware, pipes e outros recursos de forma automatica. Podemos ter a autonomia de criar com as nossas proprias mãos, mas vamos acabar gastando mais tempo e recurso de forma desnecessária.

### Setup da aplicação:

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

### Resource:

O Resource serve para criarmos um **recurso** de forma automatica pelo **cli**. Podemos criar o seguintes recursos:

- REST
- MICROSERVICES
- GrahQL(Schema ou code first)
- WebSockets

Para criarmos um recurso iremos utilizar o seguinte comando:

> nest g resource nome-do-recurso

Quais os beneficios do **resource**?
Podemos criar CRUDs, sockets e outros recursos de forma automatizada. Também é possível gerar e configurar modelos com base nos recursos que estamos desenvolvendo. É claro que será necessário o desenvolvimento da entidade, mas o passo-a-passo repetitivo e totalmente gerado **cli**, assim **sendo necessário** apenas a configuração das **services**, **regras de negocio** e **estrutura de dados**.


### Pipes:

Pipes são providers usados para transformação e validação de dados na aplicação. Eles são acionados principalmente quando recebemos dados via requisições REST, permitindo, por exemplo, transformar um valor em outro tipo de objeto.

Um uso comum dos pipes é a validação de entidades, como verificar se um campo é obrigatório (não nulo), se um valor tem o tipo esperado, entre outros — tudo seguindo um padrão definido, geralmente com decorators do **class-validator**.

## Ciclo de vida da requisição e Pipes

No ciclo de vida da requisição, os pipes são executados logo após o NestJS receber os dados da requisição, mas antes da execução do método no controller. Especificamente, eles entram na etapa 10 do ciclo interno (após middlewares e guards, antes dos interceptors e do controller handler).

Fluxo simplificado da requisição:

```
- Middleware
- Guards
- Pipes
- Interceptors
- Controller Handler
- Service
- Response
```

como instalar:

> pnpm add class-validator class-transformer

## Como instalar as dependências para validação

Os decorators do class-validator não são pipes por si só, mas atuam em conjunto com pipes — como o ValidationPipe — para validar automaticamente os DTOs.

Podemos configurar globalmente o pipe de validação assim:

```ts
  app.useGlobalPipes(
    new ValidationPipe({
      transform: true, // Converte payloads em instâncias de classes
      whitelist: true, // Remove propriedades não definidas no DTO
      forbidNonWhitelisted: true, // Retorna erro se receber propriedades extras
    }),
  );
```

## Exemplo prático

### Suponha que temos a entidade UserEntity:

```ts
    export class UserEntity {
        email: string;
        password: string;
    }

```

Vamos adicionar validações utilizando decorators do class-validator:

- O **email** seja obrigatório e tenha um formato unico.

- o **password** sejá obrigatório

-----

```ts
import { IsEmail, IsNotEmpty } from 'class-validator';
```

```ts
import { IsEmail, IsNotEmpty } from 'class-validator';

    export class UserEntity {
        @IsNotEmpty({ message: 'O e-mail é obrigatório' })
        @IsEmail({}, { message: 'E-mail inválido' })
        email: string;

        @IsNotEmpty({ message: 'A senha é obrigatória' })
        password: string;
    }

```

também podemos usar regex para fazer validações:

```ts
import { IsNotEmpty, Matches } from 'class-validator';

    export class UserEntity {
        @IsNotEmpty({ message: 'O e-mail é obrigatório' })
        @Matches(/^[^\s@]+@[^\s@]+\.[^\s@]+$/, {
            message: 'Formato de e-mail inválido',
        })
        email: string;

        @IsNotEmpty({ message: 'A senha é obrigatória' })
        password: string;
    }

```

### Lista de decorators do class-validator

| Decorator              | Descrição                                                                                      |
|------------------------|------------------------------------------------------------------------------------------------|
| `@IsNotEmpty()`        | Verifica se o valor não está vazio (não é `null`, `undefined`, string vazia, etc)              |
| `@IsEmpty()`           | Verifica se o valor está vazio                                                                 |
| `@IsString()`          | Verifica se o valor é uma string                                                               |
| `@IsNumber()`          | Verifica se o valor é um número                                                                 |
| `@IsInt()`             | Verifica se o valor é um inteiro                                                                |
| `@IsBoolean()`         | Verifica se o valor é um booleano                                                               |
| `@IsDate()`            | Verifica se o valor é uma data válida                                                           |
| `@IsEmail()`           | Verifica se o valor é um e-mail válido                                                          |
| `@IsUrl()`             | Verifica se o valor é uma URL válida                                                            |
| `@IsUUID()`            | Verifica se o valor é um UUID válido                                                            |
| `@IsEnum(enum)`        | Verifica se o valor pertence a um enum                                                          |
| `@Min(value)`           | Verifica se o número é maior ou igual a um valor mínimo                                          |
| `@Max(value)`           | Verifica se o número é menor ou igual a um valor máximo                                          |
| `@MinLength(length)`    | Verifica se uma string tem comprimento mínimo                                                   |
| `@MaxLength(length)`    | Verifica se uma string tem comprimento máximo                                                   |
| `@Length(min, max)`     | Verifica se uma string tem comprimento entre `min` e `max`                                      |
| `@Matches(regex)`       | Verifica se uma string corresponde a uma expressão regular (regex)                              |
| `@IsOptional()`        | Permite que o campo seja opcional (ignora validações se campo não enviado)                      |
| `@IsArray()`           | Verifica se o valor é um array                                                                   |
| `@ArrayNotEmpty()`     | Verifica se o array não está vazio                                                              |
| `@ArrayMinSize(size)`  | Verifica se o array tem pelo menos `size` elementos                                             |
| `@ArrayMaxSize(size)`  | Verifica se o array tem no máximo `size` elementos                                              |
| `@ValidateNested()`    | Executa validações em objetos aninhados (nested objects)                                        |
| `@IsPositive()`        | Verifica se o número é positivo                                                                  |
| `@IsNegative()`        | Verifica se o número é negativo                                                                  |
| `@IsDateString()`      | Verifica se o valor é uma string representando uma data no formato ISO                           |
| `@IsDivisibleBy(num)`  | Verifica se o número é divisível por `num`                                                      |
| `@IsLatitude()`        | Verifica se o número é uma latitude válida                                                      |
| `@IsLongitude()`       | Verifica se o número é uma longitude válida                                                    |
| `@IsMilitaryTime()`    | Verifica se o valor é um horário no formato militar (HH:mm:ss)                                  |

----

### Lista de todos os pipes:

Esses Pipes já vêm prontos no NestJS para transformação de dados simples:

| Pipe               | Descrição                                                                 |
|--------------------|---------------------------------------------------------------------------|
| `ParseIntPipe`     | Converte `string` para `number` inteiro (`parseInt`)                      |
| `ParseFloatPipe`   | Converte `string` para número decimal (`parseFloat`)                      |
| `ParseBoolPipe`    | Converte `"true"` / `"false"` em `boolean`                                |
| `ParseEnumPipe`    | Verifica se o valor está presente em um `enum`                            |
| `ParseArrayPipe`   | Converte string separada por vírgula em array (`"1,2"` → `[1, 2]`)        |
| `DefaultValuePipe` | Define um valor padrão caso nenhum valor seja fornecido                   |
| `ValidationPipe`   | Realiza validações em objetos com base em classes (usando `class-validator`) |

---

### Pipes personalizados

O `ValidationPipe` é amplamente usado para validar e transformar dados em DTOs.

### Exemplo de configuração global (em `main.ts`):

Podemos criar um pipe para transformar uma String em maiusulas

```ts
import { PipeTransform, Injectable } from '@nestjs/common';

@Injectable()
export class UppercasePipe implements PipeTransform {
  transform(value: any) {
    if (typeof value === 'string') {
      return value.toUpperCase();
    }
    return value;
  }
}

```

Como usar o pipe **UppercasePipe**:

```ts
@Get('hello/:name')
greet(@Param('name', UppercasePipe) name: string) {
  return `Hello, ${name}!`;  // sempre em maiúsculas
}
```


### link da documentação do nest:
> https://docs.nestjs.com/