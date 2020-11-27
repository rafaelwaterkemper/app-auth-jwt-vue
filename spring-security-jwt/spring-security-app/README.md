### JMS ANNOTATTIONS

***durableSubscriber***

Não permitido ter 2 listeners com o mesmo nameSubscriber; Somente um ficará ativo.
Caso exista duas conexões com clientId diferente, o nameSubscriber poderá ser repetido,
e ambos listeners receberam a mensagem do topic.

***NonDurable***  
Todos os listeners do tópico ouvirão as novas mensagems.

***Connection***

Não é permitido uma mesma connection com mesmo clientId.
