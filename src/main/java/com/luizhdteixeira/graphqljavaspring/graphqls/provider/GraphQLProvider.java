package com.luizhdteixeira.graphqljavaspring.graphqls.provider;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.luizhdteixeira.graphqljavaspring.graphqls.datafetcher.ProductDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private final ProductDataFetcher productDataFetcher;

    private GraphQL graphQL;

    public GraphQLProvider(ProductDataFetcher productDataFetcher) {
        this.productDataFetcher = productDataFetcher;
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                              .dataFetcher("getProducts", productDataFetcher.getProducts()))
                .type(newTypeWiring("Query")
                              .dataFetcher("getProductByUuid", productDataFetcher.getProductByUuid()))
                .type(newTypeWiring("Mutation")
                              .dataFetcher("createProduct", productDataFetcher.createProduct()))
                .build();
    }
}
