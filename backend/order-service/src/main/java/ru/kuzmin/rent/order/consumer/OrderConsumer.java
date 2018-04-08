package ru.kuzmin.rent.order.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kuzmin.rent.order.api.entities.OrderApi;
import ru.kuzmin.rent.order.entities.Order;
import ru.kuzmin.rent.order.services.interfaces.OrderService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
public class OrderConsumer {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String PRODUCER_TOPIC = "order_response";
    private static final List<String> CONSUMER_TOPIC = Arrays.asList("order_request");

    private final OrderService orderService;

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
        consumer.subscribe(CONSUMER_TOPIC);
    }

    @Autowired
    public OrderConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostConstruct
    public void init() {
        Runnable consumerRunnable = () -> {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    try {
                        System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

                        OrderApi orderApi = OBJECT_MAPPER.readValue(record.value(), OrderApi.class);

                        Order newOrder = orderService.create(Order.builder()
                                .withId(orderApi.getId())
                                .withShopId(orderApi.getId())
                                .withUserId(orderApi.getId())
                                .withEquipmentId(orderApi.getId())
                                .build());

                        OrderApi newOrderApi = new OrderApi(newOrder.getId(), newOrder.getShopId(), newOrder.getUserId(), newOrder.getEquipmentId(), null);

                        producer.send(new ProducerRecord<>(PRODUCER_TOPIC, record.key(), OBJECT_MAPPER.writeValueAsString(newOrderApi)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(consumerRunnable).start();
    }
}
