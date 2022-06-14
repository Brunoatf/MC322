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

### Arquitetura de Software

  - Se concentra na integração de componentes, alto nível de abstração
  - Exemplo: Estilo Arquitetural Model-View-Controller (MVC)
    - **Model:** modelo subjacente da aplicação representada como estruturas de dados ou classes
    - **View:** lida com a apresentação visual
    - **Controller:** define o estado e comportamento da aplicação
  - Exemplo: Estilo Arquitetural Data Flow 
    - Cada componente recebe dados, processa-os e passa para o seguinte

### Componentes

  - Unidades de software auto-contidas e reusáveis
  - Classes e interfaces empacotadas --> pode ser pensado como uma caixa preta
  - Toda a comunicação entre um componente e o resto da aplicação é feita por meio de interfaces
  - No Java: JavaBeans
    - Instanciados como objetos e implementados como classes (não é um consenso em POO) 
    - Possuem propriedades externamente observáveis que customizam a instância do componente (também não é um consenso)
    - O construtor da classe que implementa o componente não deve possuir argumentos no construtor
    - Instanciados como *NomeInterface = new Componente();*
  #### Interface requerida: interface que requer operações de uma interface provida (que fornece serviços). A interface requerida possui apenas um método *connect* que a liga à interface provida

### Exceções:

#### Exception é uma herdeira de Throwable (essa também tem Error como filha)

- Se um bloco catch for acionado, os demais não são testados
- Escritos como *catch(<classe_excecao> nome) {}*
- Na saída de erros, usamos *System.err.println(nome.getMessage())*
  - Usamos err e não out porque err possui funcionalidades próprias para tratamentos de erros, como logging
  - *nome.printStackTrace()* é útil para mostrar o traçado de chamadas da exception
- Exceções herdeiras ativam um catch com argumento em uma exceção superclasse
- Podemos fazer uma função gerar uma exceção com *funcao throws classeExcecao {}*
  - Dentro da função podemos escrever throw classeExcecao("mensagem")*
- Uma exceção é repassada na pilha de chamadas e o funcionamento do programa é interrompido apenas se a exceção chega na main sem ser tratada
- Podemos personalizar uma exceção criando uma classe que extende Exception
- *Checked exception:* precisam ser tratadas, são todas as classes que são filhas de Exception
- *Unchecked exception:* não precisam ser tratadas, interrompem a execução se acontecerem. A classe RunException e todas as classes escritas como herdeiras dela serão unchecked

### Tipagem

- **Wrapper:** O Java possui objetos equivalentes a tipos primitivos. EX: Integer para int, Double para double, etc
- **Conversão implícita:** Podemos atribuir wrappers a tipos simples ou tipos simples a wrappers. O java faz a conversão automaticamente.
  - Ex: *int x1 = new Integer(10);*
  - *Integer x1  = 10;*
- Wrapper no vetor: Podemos atribuir diferentes tipos de dados primitivos a um vetor declarado em *Object*. Toda classe de Java é herdeira de Object, e o vetor armazenará um wrapper para esses tipos no vetor, utilizando polimorfismo
- **Java Generics:** tipos declarados entre *<>*

### Padrões de Projeto (Design Patterns)

- Cada padrão descreve um problema e o núcleo de uma solução para tal. Cada padrão possui um nome, problema alvo, solução e consequências (trade-offs)
- Vantagens: aumento de produtividade e consistência, independentes de linguagem, permitem combinações
- Desvantagens: curva de aprendizado, síndromes de adaptação técnicas, são conceitos e não código
- Divididos em criacionais, estruturais e comportamentais
  - **Strategy:** Resolve o problema da chamada de um mesmo método implementado em classes diferentes por meio de uma interface que contém tal método. Ex: uma classe quer chamar uma ação de pagamento de diversas classes que implementam diferentes métodos de pagamento. Para essa classe não interessa de qual é o método de pagamento, mas sim a ação de pagar - que pode ser colocada em uma interface.
  - **Singleton:** Objetiva limitar o número de instâncias de uma classe na aplicação. 
     - Declara-se o construtor como privado
     - Cria-se um atributo privado, estático e final com o tipo da própria classe que armazenará uma instância
     - Igualamos tal atributo à uma nova instância da classe
     - Escreve-se um método getInstance que retorna tal instância única
     - Desvantagem: a criação do objeto é sempre feita automaticamente, independentemente se ele será usado na aplicação
  - **Facade:** Provê uma interface unificada para um corpo de código maior.
     - Simplifica a utilização de um subsistema, garante maior segurança
  - **Adapter:** Permite a cooperação de interfaces incompatíveis entre si (geralmente que trabalham com tipos de dados diferentes)
    - O adaptador obtém uma interface, compatível com um dos objetos existentes.
    - Usando essa interface, o objeto existente pode chamar os métodos do adaptador com segurança.
    - Ao receber a chamada, o adaptador passa o pedido para o segundo objeto, mas em um formato e ordem que o segundo objeto espera.
  - **Observer/Event-Subscriber/Listener:** Define um relacionamento de um-para-n de dependência entre objetos, de modo que se um for alterado os demais são notificados.
    - O subject implementa a interface do observer, que possui um vetor de subscribers e métodos para subscrição e notificação


