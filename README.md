## Apresentação

**Projeto:** API de apresentação dos ganhadores do prêmio Golden Raspberry Awards

**Funcionalidade**: O objetivo da API é trazer duas listas de produtores sendo que, a primeira lista ("min") trará em ordem crescente os produtores que obtiveram dois prêmios no menor intervalo de tempo e, a segunda lista ("max"), trará em ordem decrescente os produtores que ganharam dois prêmios com maior intervalo.

### Como testar
#### Rodando a aplicação

Para testar a API será necessário seguir os passos descritos abaixo:

1. Baixar o projeto do repositório https://github.com/adrianoacs/producers-api na máquina local.
2. Abrir o projeto utilizando a IDE de preferência.
3. Antes de rodar a aplicação é necessário certificar que o arquivo de carga foi colocado no diretório correto com o nome e estrutura corretos. Em caso de dúvidas, favor verificar seção com detalhes sobre o arquivo de carga.
4. Rodar a aplicação a partir da classe "ProducersApplication".
5. O Swagger para testes da aplicação estará disponível no endereço http://localhost:8090/swagger-ui/
- Clicar sobre "producer-controller".
- Clicar sobre a operação GET "/api/winners".
- Clicar no botão "Try it out".
- Clicar no botão "Execute".

6. Um outro caminho para testar a aplicação é acessando o endereço http://localhost:8090/api/winners.

#### Arquivo de carga
O arquivo de carga deve possuir o nome "movielist.csv" e, deverá ficar dentro da pasta "resources" do projeto. O arquivo deverá possuir cinco colunas delimitadas por ";". Abaixo temos um exemplo do utilizado para carga de dados da api:

```
year;title;studios;producers;winner
1980;Can't Stop the Music;Associated Film Distribution;Allan Carr;yes
1980;Cruising;Lorimar Productions, United Artists;Jerry Weintraub;
1981;Mommie Dearest;Paramount Pictures;Frank Yablans;yes
1981;Endless Love;Universal Studios, PolyGram;Dyson Lovell;
```

#### Rodando os testes
Para rodar os testes basta clicar na pasta "test/java" com o botão direito do mouse e escolher a opção "Run 'All Tests'" e aguardar a concretização dos testes.


