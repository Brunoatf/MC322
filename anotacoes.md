# Anotações de aulas
 
### Métodos e atributos estáticos:
 
- Métodos estáticos não podem ter acesso a atributos e métodos de instância.
- Contudo, métodos de instância podem usar atributos e métodos estáticos.

### Encapsulamento: 
 
- Meta: maximizar a coesão (interações internas de uma classe) e minimizar o acoplamento (interações externas entre classes).
- Deve-se separar a interface (descreve como os objetos de uma classe se relacionam com os demais) da implementação (dados e códigos que descrevem o comportamento do objeto).
- Níveis de acesso:
  - Privado (visível apenas pelos objetos da classe)
  - Público (visível para todos os objetos)
  - Protegido (visível para objetos da classe e seus herdeiros)
    - Em Java, também é visível para para classes e objetos do mesmo pacote
 
 #### Propriedades: expõem indiretamente atributos através de métodos
