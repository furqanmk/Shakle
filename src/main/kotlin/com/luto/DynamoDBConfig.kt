package com.luto

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * Created by furqan on 12/07/2017.
 */

val ACCESS_KEY: String = System.getenv("amazon_aws_accesskey")
val SECRET_KEY: String = System.getenv("amazon_aws_secretkey")

@Configuration
@EnableDynamoDBRepositories(basePackages = arrayOf("com.luto"))
data class DynamoDBConfig(
        val amazonAWSAccessKey: String = ACCESS_KEY,
        val amazonAWSSecretKey: String = SECRET_KEY
) {

    @Bean
    fun amazonDynamoDB(amazonAWSCredentials: AWSCredentials): AmazonDynamoDB {
        val staticCredentials = AWSStaticCredentialsProvider(amazonAWSCredentials())
        try {
            val dynamoDB = AmazonDynamoDBClientBuilder.standard()
                    .withRegion(Regions.EU_WEST_1)
                    .withCredentials(staticCredentials)
                    .build()
            return dynamoDB
        } catch (e: Exception) {
            throw e
        }
    }

    @Bean
    fun amazonAWSCredentials(): AWSCredentials {
        // Or use an AWSCredentialsProvider/AWSCredentialsProviderChain
        return BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey)
    }

}