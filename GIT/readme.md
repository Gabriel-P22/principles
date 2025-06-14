# GIT 

Neste projeto, vou te ensinar como instalar, criar e usar o **Git** no seu dia a dia. Mais do que isso, o objetivo é desmistificar o Git e o Git Flow, para que você possa começar a usá-los com confiança.

- O que é o GIT?
- Como o git surgiu e por que?
- Como instalar o GIT?
- Como configurar uma chave ssh?
- Como criar um repositório no github e para que serve?
- Comandos básicos do git:
    - git status
    - git add
    - git commit 
    - git branch
    - git checkout
- Comandos avançados do git:
    - git merge
    - git cherry pick
    - git rebase
- git flow
    - O que é Git Flow e por que usar
    - Branches principais: main, develop, feature, release, hotfix
    - Fluxo de trabalho na prática 
- boas praticas
    - Commits pequenos e claros
    - Mensagens de commit descritivas
    - Fazer pull com frequência
    - Evitar force push sem necessidade
    - Usar .gitignore corretamente
    - Nomear branches de forma padronizada
- Documentação oficial

## O que é o GIT?

O **Git** é uma ferramenta de controle de versão distribuído. Mas o que isso quer dizer?

```text
De forma simples: é um sistema que permite que cada desenvolvedor tenha uma cópia completa do projeto no seu próprio computador. Essa cópia inclui todo o histórico de mudanças, o código completo, e os arquivos do projeto.

Isso significa que você pode:

- Trabalhar no projeto mesmo sem internet
- Ver versões antigas do código
- Testar mudanças sem afetar o projeto principal
- Compartilhar suas mudanças com outras pessoas quando quiser

Depois, você pode enviar (push) suas mudanças para um repositório central (como o GitHub) ou receber (pull) mudanças de outras pessoas.
```

Sendo assim, o Git é atualmente a melhor opção do mercado para controle de versionamento. Ele é: **distribuido**, **Rapido e eficiente**, **seguro**, **Rastreável**, **Podemos trabalhar com branchs**

## Como o git surgiu e por que?

O Git foi criado em 2005 por Linus Torvalds, o mesmo desenvolvedor do Linux, para resolver um problema importante: o sistema de controle de versão usado até então, chamado BitKeeper, teve seu uso restringido para o projeto Linux.

Isso gerou a necessidade de um sistema próprio, rápido, seguro e distribuído, que permitisse a colaboração eficiente de milhares de desenvolvedores ao redor do mundo no código do Linux.

Assim, o Git foi desenvolvido com o objetivo de ser:

- Distribuído, para que cada desenvolvedor tivesse uma cópia completa do projeto e pudesse trabalhar offline.

- Rápido, para lidar com grandes volumes de código e múltiplas operações com eficiência.

- Confiável e seguro, garantindo integridade dos dados por meio de hashes criptográficos.

- Flexível, facilitando o trabalho com ramificações (branches) e fusões (merges) de código.

Desde então, o Git se tornou a ferramenta padrão para versionamento em projetos de software, tanto pequenos quanto gigantescos.

## Como instalar o GIT?

Para instalar o git você precisa seguir os seguintes passos: 

```
    Se estiver no linux, basta apenas atualizar os arquivos e instalar o git

    1 - sudo apt update

    2 - apt-get install git
```

Com isso podemos executar comandos do git na nossa maquina.

## Como configurar uma chave ssh

### O que é a chave ssh?

A chave SSH nada mais é do que um arquivo que representa uma **identidade digital**. Ela permite que você se autentique de forma segura entre o seu computador e outro sistema. Um exemplo muito comum e que usaremos aqui é o GitHub.

A chave SSH é formada por duas partes: uma chave **publica(public_key)** e uma chave **privada(private_key)**. Na prática, o que geralmente fazemos é adicionar a chave pública em um serviço como o GitHub, e manter a chave privada guardada com segurança no nosso computador. Quando nos conectamos ao serviço, ele usa a chave pública para verificar se a chave privada que estamos usando é válida e assim a autenticação acontece, de forma segura e automática.

### Como criar e configurar uma chave SSH no seu computador?

Vamos executar o comando:

> ssh-keygen -t ed25519 -C "informe o seu email aqui"

#### O que cada comando faz?

- ssh-keygen
    - Esse é o comando principal usado para gerar um novo par de chaves SSH **uma pública** e **uma privada**.

- -t ed25519
    - Aqui usamos o parâmetro **-t** para definir o tipo de algoritmo que será usado na geração da chave.

    - O valor **ed25519** indica um algoritmo moderno, rápido e seguro, recomendado por plataformas como o GitHub para gerar chaves SSH.

- -C "informe o seu email aqui"
    - Essa opção adiciona um comentário à chave SSH. No caso, usamos o comando **-C** para informar o e-mail logo em seguida.

    - Mas por que usar o e-mail? Porque muitos serviços, como o **GitHub**, utilizam o e-mail como forma de identificar a chave associada à sua conta. Isso facilita a organização e o reconhecimento da chave no futuro.

Apos informamos o valor nos campos, o terminal vai solicitar:

- O local onde a chave será salva:
    - Por padrão ela será salva no diretório:
        - > Enter file in which to save the key (/home/seu_usuario/.ssh/id_ed25519):
    - Você pode apenas pressionar Enter para aceitar o caminho padrão, ou digitar um nome personalizado (caso queira ter múltiplas chaves).

- Senha (passphrase) para proteger sua chave privada (opcional):
    - O terminal vai perguntar:
        - > Enter passphrase (empty for no passphrase):
        - A qui você pode deixar em branco (Assim não informando senha) ou figitar uma senha para a sua chave ssh.
            - Se informar uma senha, será necessário informar ela toda vez que for utilizar a sua chave ssh

Ao final, vamos ter dentro da pasta **.ssh** dois novos arquivos. A **chave publica(id_ed25519.pub)** e uma **chave privada(id_ed25519)**.

Uma vez com a sua chave criada, podemos copiar o conteudo da **chave ssh publica**, ir ao **GITHUB**, acessar configurações, SSH, registrar uma nova chave e informar o **nome da chave ssh** e a **chave ssh**.

## Como criar um repositório no github e para que serve?

Um **repositório** é um local onde guardamos o nosso código de forma digital. Em outras palavras, é como uma **pasta digital** organizada para guardar todos os arquivos do projeto.

### Como podemos cria-lá?

Vamos acessar o nosso perfil do **GITHUB**, clicar em **repositórios** e clicar no botão verde escrito new. Uma vez feito isso, podemos informar o nome do repositório, se ele vai ser publico ou privado, se vai ter um **readme.md** e outros arquivos de configuração.

### Como podemos enviar arquivos para o GITHUB?

Podemos enviar esses arquivos de algumas formas. Uma delas é arrastar a pasta do projeto para a área de drag-and-drop, **mas isso não é recomendado**.

**A forma recomendada** e usada por praticamente 100% da comunidade é através do **Git** e vamos aprender como fazer isso em breve.

## Comandos básicos do git

- git status:
    - O git status serve para mostrar o estado atual do repositório. Quais arquivos foram modificados, adicionados ou removidos.
        - Quando um arquivo não estiver adicionado ao stage para envio, ele aparecerá em vermelho.
        - Depois que o arquivo for adicionado ao stage, ele ficará em verde.
        - E quando não houver arquivos modificados para commit, a mensagem mostrada será: `othing to commit, working tree clean"`.
        - O comando é bem simples: `git status`.
        
- git add:
    - Adiciona arquivos à área de preparação(`staging area`), ou seja, indica quais mudanças você quer incluir no proximo commit.
    - Podemos usar o comando de duas formas:
        - git add com o `.`, assim informando que vamos adicionar todos os arquivos para a `area de staging`.
        - informando o local do arquivo: `git add ./users/index.ts`, assim, adicionando um unico arquivo ou o conteudo da pasta:  `git add ./users/index`.
- git commit:
    - Com esse comando, você **captura todas as alterações que estão na área de staging** e as salva como um registro no repositório, junto com uma mensagem descritiva sobre o que foi feito.

    - Podemos usar ele da seguinte forma:
        - git commit -m "Meu primeiro commit"
            - aqui usamos o `-m` para informar uma mensagem no nosso commit `Meu primeiro commit`. Usando esse parâmetro, quando o  `commit` for enviado ao `github`, vamos ter essa mensagem e todo o nosso conteudo adicionado a area de staging junto.
        - git commit --amend
            - Esse comando serve para editar o último commit que você fez.
            - O comando `--amend` serve para atualizar o commit anterior com o conteudo que está na nossa `area de staging` ao inves de criar um novo. **NÃO RECOMENDADO USAR ESSE COMANDO SEM SABER O QUE ESTÁ FAZENDO**

- git branch:
    - O `git branch` server para listar, criar ou deletar alguma branch da ramificação.
        - O `git branch` lista todas as branchs locais do repositório clonado.
        - O `git branch nome-da-sua-branch` cria uma nova ramificação localmente da branch que você estava, porem, com o nome `nome-da-sua-branch`
        - O `git branch -D nome-da-sua-branch` deleta a ramificação com o nome que você informou, caso a branch não exita, você ira receber um erro.

- git checkout 
    - O `git checkout` serve para navegar entre as ramificações locais do seu repositório.
        - O `git checkout nome-da-branch` com esse comando, você consegue sair da branch que você está e entrar na branch com o nome `nome-da-branch`
        - O `git checkout -b nome-da-branch`, assim como o comando branch, conseguimos criar `ramificações` com o comando checkout apenas informando o paramêtro `-b` antes do nome da branch.