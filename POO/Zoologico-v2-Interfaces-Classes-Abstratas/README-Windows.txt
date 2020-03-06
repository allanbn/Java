### Como gerar o .jar da aplicação e executar via linha de comando:

0) Na raiz do projeto via linha de comando, faça os passos a seguir.

1) Compilar classes com o seguinte comando:

$ dir /s /B *.java > sources.txt
$ javac -encoding UTF-8 -cp libs\xstream\xmlpull-1.1.3.1.jar;libs\xstream\xpp3_min-1.1.4c.jar;libs\xstream\xstream-1.4.11.1.jar;libs\genson\genson-1.4.jar -d bin @sources.txt
$ del sources.txt

2) Gerar o jar:

$ jar -cvf zoo.jar -C bin/ .

3) Executar a aplicação:

$ java -cp zoo.jar;libs\xstream\xmlpull-1.1.3.1.jar;libs\xstream\xpp3_min-1.1.4c.jar;libs\xstream\xstream-1.4.11.1.jar;libs\genson\genson-1.4.jar br.edu.ifpb.Main
