### JMS ANNOTATTIONS

***durableSubscriber***

Não permitido ter 2 listeners com o mesmo nameSubscriber; Somente um ficará ativo.
Caso exista duas conexões com clientId diferente, o nameSubscriber poderá ser repetido,
e ambos listeners receberam a mensagem do topic.

***NonDurable***  
Todos os listeners do tópico ouvirão as novas mensagems.

***Connection***

Não é permitido uma mesma connection com mesmo clientId.


## JPA Annotations

Adding some examples using @MapKey, @MapKeyColumn and @MapKeyJoinColumn

@MapKey - the join table has just the foreing key from join columns

@MepKeyColumn - The join table has the field of the join column, @MapKeyColumn, e @Column (representes value from map)

@MapKeyJoinColumn - The join table has the fields of join columns, and the id from entity used as key ` (Spring Not accepted post with rest if object has this annotation)`
