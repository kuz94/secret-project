package ru.kuzmin.rent.order.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import ru.kuzmin.rent.order.api.entities.OrderApi;
import ru.kuzmin.rent.order.api.exceptions.OrderApiException;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class OrderClient implements AutoCloseable {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String PRODUCER_KAFKA_TOPIC = "order_request";
    private static final List<String> CONSUMER_KAFKA_TOPICS = Arrays.asList("order_responce");

    private final KafkaProducer producer;

    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
    }

    private final KafkaConsumer consumer;

    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(CONSUMER_KAFKA_TOPICS);
    }

    public CompletableFuture<OrderApi> create(OrderApi order) throws OrderApiException {
        try {
            producer.send(new ProducerRecord<>(PRODUCER_KAFKA_TOPIC, "1", OBJECT_MAPPER.writeValueAsString(order)));
        } catch (JsonProcessingException e) {
            throw new OrderApiException();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        producer.close();
        consumer.close();
    }
}
