package com.ddubson.filmfox;

import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class ElasticsearchClient {
    public final static String MOVIES_INDEX = "movies";
    public final static String MOVIES_TYPE = "movie";

    @Autowired
    Logger sysLog;
    Client elasticClient;

    @Autowired
    public ElasticsearchClient(Client client) {
        this.elasticClient = client;
    }

    @PreDestroy
    public void onShutdown() {
        if (elasticClient != null) {
            elasticClient.close();
            sysLog.info("Elasticsearch connection closed.");
        }
    }

    public Client getElasticClient() {
        return elasticClient;
    }

    public void setElasticClient(Client elasticClient) {
        this.elasticClient = elasticClient;
    }
}