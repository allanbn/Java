/*
a.
Exceção são erros que podem ou não ser tratados em Java.

b.
Exceções checadas são aquelas das quais há como se precaver utilizando os comandos de try e catch
e as não checadas são as que ocorrem durante a excução do programa. As não checadas são chamadas de RunTimeExceptions.

c.
O bloco finally do try catch atribui uma ação final após o bloco de código que está entre o try catch
ter executado sem erros.

d.
A fato de um try ter vários catchs ocorre da necessidade de se resguardar de possíveis erros
que podem vir a ocorrer na execução do programa.
Os catchs devem seguir uma ordem hierarquica pois do contrário uma exceção de menor/maior "peso" pode vir
a ser tratada sem sabermos qual erro ocorreu de fato, como por exemplo o "catch (Exception e)" sempre será tratado
antes de um "catch (NumberFormatException e)".

e.
"s: ABC
Erro na formatação do número.
s: 123
n: 123
m: 10
s: 0
n: 0
Erromatemática.
s:
Erro na formatação do número.
Acesso fora do array.
Fim."

No primeiro erro (Erro na formatação do número.), o que ocorre é que o método estático não
consegue converter de maneira alguma a String ABC para
um wrapper Integer.
O segundo erro (Erromatemática.) ocorre pois tenta-se dividir um determinado número por 0, o que não é possível
matemáticamente.
O terceiro erro (Erro na formatação do número.) ocorre pelo mesmo motivo do segundo. Não há valores
que representem inteiros para String vazia.
O quarto erro (Acesso fora do array.) ocorre pois o loop ocorre do número 0 ao 4, o array é indexado de 0 a 3
sendo i == 4 inválido como indíce dentro do array.
*/
