# pessoas.py
from typing import List

class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade

pessoas: List[Pessoa] = [Pessoa("David", 15), Pessoa("Carla", 20), 
           Pessoa("Elias", 12), Pessoa("Amora", 10), 
           Pessoa("Celia", 13), Pessoa("Josue", 30)]

# Usando programação interativa
nomes: List[str] = []
for pessoa in pessoas:
    if pessoa.idade < 18: # filtragem
        nomes.append(pessoa.nome) # mapeamento
print(nomes)

# Usando Listas de Compreensão
print([pessoa.nome for pessoa in pessoas if pessoa.idade > 18])

