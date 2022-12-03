# Banheiro Unissex

O presente trabalho buscar realizar a solução do problema do banheiro unissex enunciado por:

> Um escritório contém um banheiro que pode ser utilizado tanto por homens quanto por mulheres,mas não por ambos ao mesmo tempo. Se um homem estiver no banheiro, outros homens podementrar, porém eventuais mulheres que desejem utilizar o banheiro devem esperar ele ficar vazio.Se uma mulher estiver no banheiro, outras mulheres podem entrar, porém eventuais homens quedesejem utilizar o banheiro devem esperar ele ficar vazio. Cada pessoa (homem ou mulher) podepassar um determinado tempo utilizando o banheiro, que possui uma capacidade limite de pessoasque podem utilizá-lo ao mesmo tempo.

O problema deve ser solucionado com o uso de concorrência. Para isso, foi utilizada a linguagem java e seus mecanismos para controle de concorrência.

## Estrutura de Diretórios

O presente repositório apresenta alguns repositórios que correspondem a componentes do trabalho solicitado e são definidos como segue:

- doc: Documentação do projeto desenvolvida usando javadoc.

- relatorio: Relatório sobre a solução desenvolvida. O documento em latex ``elsaticle-template.tex`` possui os tópicos solicitados no documento explicativo do projeto.

- src: Diretório que contém arquivos de código-fonte do projeto.

## Compilação e Execução

Para compilar o programa use o seguinte comando.
```
javac -d bin src\Banheiro.java src\Main.java src\Pessoa.java 
```

Para executá-lo use:
```
cd bin
java Main
```

## Autoria

Programa desenvolvido por Lisandra Melo (<mendie73@gmail.com>) e José Victor (jose.victor.ferreira.125@ufrn.edu.br).

&copy; IMD/UFRN 2022.
