# Anotações de aulas
 
### Métodos e atributos estáticos:
 
- Métodos estáticos não podem ter acesso a atributos e métodos de instância
- Contudo, métodos de instância podem usar atributos e métodos estáticos

### Encapsulamento: 
 
- Meta: maximizar a coesão (interações internas de uma classe) e minimizar o acoplamento (interações externas entre classes)
- Deve-se separar a interface (descreve como os objetos de uma classe se relacionam com os demais) da implementação (dados e códigos que descrevem o comportamento do objeto)
- Níveis de acesso:
  - Privado (visível apenas pelos objetos da classe)
  - Público (visível para todos os objetos)
  - Protegido (visível para objetos da classe e seus herdeiros)
    - Em Java, também é visível para para classes e objetos do mesmo pacote
 
 #### Propriedades: expõem indiretamente atributos através de métodos

### Herança:

- Capacidade de classes se expandirem a partir das existentes
- A classe herdeira (subclasse):
  - Possui os mesmos atributos da superclasse
  - Herda acesso aos métodos desta superclasse
  - Pode acrescentar novos atributos e métodos
- Métodos na subclasse sobrescrevem os da superclasse quando têm a mesma assinatura
  - A assinatura é composta pelo nome do método + tipo dos argumentos (considerando a ordem)
  - Pode-se acessar o método da superclasse com *super.método()*
  - Apenas no construtor da subclasse, é possível chamar o construtor da superclasse com *super(args)*
     - Se for chamado, deve ser a primeira instrução no construtor da subclasse
     - Em Java, um construtor sem argumentos não precisa ser declarado - é implícito
     - Quando é declarado um construtor, o implícito se perde - tanto na classe quanto nas herdeiras
 - Sobrecarga de métodos: Técnica que envolve criar vários métodos com o mesmo nome e implementações diferentes
   - Sobrecarga na mesma classe: assinaturas diferentes
   - Em classes herdeiras: assinaturas diferentes ou assinaturas iguais (polimorfismo)
   - Sobrecarga de métodos feita com assinaturas diferenciadas pelo tipo de retorno são inadequadas, pois os métodos não podem ser diferenciados na chamada
   - Construtores também podem ser sobrecarregados
