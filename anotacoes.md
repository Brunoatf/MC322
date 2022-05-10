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
  - É declarada com *nívelDeAcesso class nome extends nomePai*
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
  
### Polimorfismo:

 - Polimorfismo é o princípio pelo qual duas ou mais classes derivadas de uma mesma superclasse podem invocar métodos que têm a mesma identificação, assinatura, mas  comportamentos distintos, especializados para cada classe derivada, usando para tanto uma referência a um objeto do tipo da superclasse.
   - Exemplo: *classe-pai nome = new classe-herdeira();*
   - O contrário não é possível: uma variável declarada na sub-classe não pode ser instanciada na super-classe. 
     - O Java entende que os métodos da sub-classe declarada estarão disponíveis, o que não acontece se a instância for da super-classe
 - Ao chamar um método que possui a mesma assinatura na pai e filha, será chamado o método da filha
 - Contudo, não é possível chamar métodos e atributos que existem apenas na filha. A declaração com o tipo da super-classe filtra fora os métodos e atributos exclusivos da classe herdeira
 - Princípio do polimorfismo no vetor: um vetor declarado em uma super-classe pode receber instâncias da super-classe e das herdeiras
 - Amarração: ligação da chamada de um método ao método.
   - Estática (static binding): faz isso na compilação
     - Escolhe o método da classe na qual foi declarada a referência
     - Pode ser escolhida em C++ para fins de desempenho
   - Dinâmica (late binding): na execução, porém ocorre perda de desempenho.
     - Reflete a intenção do usuário e é empregada por linguagens como Python, Java e Javascript

### Classes abstratas:

  - Classe que define uma família de objetos: é uma definição genérica que não pode ser instanciada. 
  - Métodos não são implementados na super-classe, pois serão sobrescritos pelos herdeiros.
    - Esses métodos da super-classe são chamados de stub. Possuem apenas assinatura, sem implementação.
  - Em Java, coloca-se abstract na declaração de classes abstratas. Ex: *public abstract class nome*
  - Os métodos também recebem a palavra abstract. Ex: *tipo abstract nome(args)*
  - Métodos abstratos são obrigatoriamente implementados pelos herdeiros
  - Classes herdeiras de abstratas também podem ser abstratas, de modo que a resposabilidade de implementar os métodos abstratos é passada para a geração seguinte

### Interfaces:

  - Mecanismo de generalização que declara um conjunto de métodos
    - Tais métodos devem ser implementados pelas classes que utilizam a interface
    - Ex em Java: *public interface nome {
                         public tipo nome();
                         public tipo nome();
                         ... }*
    - No arquivo das classes temos: *public class nomeClass implements nomeInterface*
  - Não tem relação com herança - não é um mecanismo de reuso de código
  - Funciona como um "filtro de visão"
    - Uma variável declarada em uma interface A pode ser instanciada em qualquer classe que implementa tal interface
    - Só é possível chamar os métodos declarados na interface
      - Contudo, é possível chamar um método específico da classe por meio da interface por meio de *casting*
        - Ex: ((classe) variavelInterface).métodoClasse()
        - Casting não é recomendável
    - Diferente do Polimorfismo, as classes que implementam a interface não precisam ser irmãs
