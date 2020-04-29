const { ApolloServer } = require("apollo-server");
const { ApolloGateway } = require("@apollo/gateway");

const server = new ApolloServer({
  gateway: new ApolloGateway({
    debug: true,
    serviceList: [
      { name: "claimgql", url: "http://localhost:8080/graphql" },
      { name: "expensegql", url: "http://localhost:8081/graphql" }
    ]
  }),
  subscriptions: false
});

server.listen().then(({ url }) => {
  console.log(`🚀 Server ready at ${url}`);
});
