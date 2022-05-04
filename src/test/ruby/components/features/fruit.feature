# language: pt
@test
Funcionalidade: Busca de frutas

#  Cenario de Fundo:
#    Dado q eu estou logado

  Cenario: Busque a familia de uma fruta
    Dado que estou na sessao "busca da fruta manga com sucesso"
    Quando é solicitado a busca da familia da fruta "banana"
    Então status de sucesso 200
    E deve ser retornado a familia "Musaceae"
