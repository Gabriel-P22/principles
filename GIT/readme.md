# GIT 

Neste projeto, vou te ensinar como instalar, criar e usar o **Git** no seu dia a dia. Mais do que isso, o objetivo é desmistificar o Git e o Git Flow, para que você possa começar a usá-los com confiança.

- O que é o GIT?
- Como o git surgiu e porque?
- Como instalar o GIT
- Como configurar uma chave ssh
- Como criar um repositório no github e para que serve
- Comandos principais do git
    - git status
    - git add
    - git commit 
    - git branch
    - git checkout
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

## Como o git surgiu e porque?