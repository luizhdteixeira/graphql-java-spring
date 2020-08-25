package com.luizhdteixeira.graphqljavaspring.graphqls.provider;

import com.luizhdteixeira.graphqljavaspring.graphqls.datafetcher.ProductDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class GraphQLProvider {

    private final ProductDataFetcher productDataFetcher;

    public GraphQLProvider(ProductDataFetcher productDataFetcher) {
        this.productDataFetcher = productDataFetcher;
    }

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        ClassPathResource pathResource = new ClassPathResource("schemas/schema.graphqls");
        GraphQLSchema graphQLSchema = buildSchema(pathResource);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(ClassPathResource pathResource) throws IOException {
        TypeDefinitionRegistry registry = new SchemaParser().parse(pathResource.getInputStream());
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator generator = new SchemaGenerator();
        return generator.makeExecutableSchema(registry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring.dataFetcher("getProducts", productDataFetcher.getProducts()))
                .type("Query", typeWiring -> typeWiring.dataFetcher("getProductByUuid", productDataFetcher.getProductByUuid()))
                .type("Mutation", typeWiring -> typeWiring.dataFetcher("createProduct", productDataFetcher.createProduct()))
                .build();
    }
}
