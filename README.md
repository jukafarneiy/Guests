# Guests

Informações Gerais:

Neste aplicativo é possível cadastrar convidados em um banco de dados local e selecionar se estão ausentes ou presentes, ao cadastrar, esses convidados são separados em 3 listas, uma com todos os convidados, uma apenas com os presentes e outra apenas com os convidados ausentes. Na lista principal (todos os convidados), é possível selecionar através do clique um convidado específico, fazendo com que abra uma nova tela mostrando os detalhes deste convidado (nome e presença). Também é possível deletar um convidado da lista, basta clicar e segurar em cima do nome do convidado que deseja deletar da lista. Além disso, é possível atualizar os dados de um convidado selecionando o mesmo, editando os dados e então clicando em salvar novamente.
É importante deixar claro que este aplicativo foi feito com base no layout pré montado "Navigation Drawer Activity" disponibilizado pelo próprio Android Studio. O foco principal não foi no design das telas e sim na funcionalidade e lógica de negócio da aplicação.

Tecnologia:

Este projeto foi feito 100% em Kotlin;

viewBinding: para adicionar eventos de cliques;

DataBase: banco de dados local criado para salvar e disponibilizar alterações nos convidados cadastrados;

RecyclerView: para mostrar os nomes dos convidados na lista e poder rolar para baixo com scroll;

MVVM: arquitetura utilizada para separar as responsabilidades e manter os dados cadastrados do banco de dados na tela;

CRUD: Create, Read, Update and Delete - Realizar as funções para cada tipo de situação dos convidados;

Design Pattern Singleton: para garantir que a classe de repositório tenha apenas a instância de si mesma, fornecendo um ponto de acesso a ela.

Dificuldades:

Neste projeto, consegui evoluir mais meus conhecimentos em Android, porém tive uma intermediária dificuldade para criar o banco de dados, visto que só tinha aprendido na teoria, mas quando fui colocar o conhecimento em prática levei um pouco mais de tempo para aplicar.

Bibliotecas:

RecyclerView - 1.2.1;

Retrofit - 2.9.0;

LifeCycle - 'androidx.lifecycle:lifecycle-common:2.4.1' 'androidx.lifecycle:lifecycle-runtime:2.4.1' 'androidx.lifecycle:lifecycle-extensions:2.2.0' 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.1'

Tela 1 - Lista de Todos os Convidados:

![image](https://user-images.githubusercontent.com/104699938/172507740-fec88540-4760-4682-a961-7a99475a077f.png)

Tela 2 - Convidados Presentes:

![image](https://user-images.githubusercontent.com/104699938/172507847-2c487037-9fe8-4071-9ea8-3fd70d2e0917.png)

Tela 3 - Convidados Ausentes: 

![image](https://user-images.githubusercontent.com/104699938/172507883-f608820c-b249-4abd-b126-a73771e8317d.png)

Tela 4 - Detalhe do Convidado:

![image](https://user-images.githubusercontent.com/104699938/172507922-c1254617-85e8-4296-91bb-a9775dad6951.png)

Tela 5 - Deletar Convidado:

![image](https://user-images.githubusercontent.com/104699938/172508003-0900ce9d-5dba-4e7c-9949-4c289f914e3f.png)

Tela 6 - Atualizar Dados do Convidado:

![image](https://user-images.githubusercontent.com/104699938/172508760-b7abff78-b989-42d5-a2f5-4484e3dbdfda.png)

![image](https://user-images.githubusercontent.com/104699938/172508789-0dd5c267-bb7c-4bc7-a967-f203964e9922.png)





