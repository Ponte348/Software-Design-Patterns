## Ex3 - Mediator

### Problema - Chat Server de uma empresa
Neste problema temos um chat server que é responsável por receber mensagens de vários clientes e enviar para os outros clientes. O chat server é um mediator.

### Solução
1. Para implementar o chat server, temos de criar uma interface mediator com métodos de **notify** e também de add colleague.
2. Em seguida, criamos uma classe concreta de mediator que implementa a interface mediator. Esta classe tem uma lista de clientes e implementa os métodos da interface mediator.
3. O **notify** percorre a lista de clientes e envia a mensagem para todos os clientes, exceto para o cliente que enviou a mensagem. O **add colleague** adiciona um cliente à lista de clientes.
4. Temos de ter a nossa classe **Colleague** que tem como atributos o mediator e o nome do cliente. Esta classe tem um método **send** que envia a mensagem para o mediator e um método **receive** que recebe a mensagem do mediator.
5. Por fim, temos a nossa classe **MediatorMain** que funciona como Client. Nesta classe, criamos o mediator e os clientes. Adicionamos os clientes ao mediator e enviamos mensagens entre os clientes.

### Referências
- [Mediator Design Pattern](https://refactoring.guru/design-patterns/mediator)
- [Exercício Mediator](https://uapt33090.sharepoint.com/sites/OP_PDS_23-24/Shared%20Documents/Forms/AllItems.aspx?ga=1&id=%2Fsites%2FOP%5FPDS%5F23%2D24%2FShared%20Documents%2FGeneral%2Felearning%2FTP%2F12%2FPDS%5F12%2DBehavioral%20Patterns%202%2Epdf&viewid=bd3ca4ba%2D0adb%2D40e2%2Dbe95%2Dde37473c6e92&parent=%2Fsites%2FOP%5FPDS%5F23%2D24%2FShared%20Documents%2FGeneral%2Felearning%2FTP%2F12)
- [Mediator Diagram](https://www.geeksforgeeks.org/mediator-design-pattern/)
