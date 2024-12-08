package ca.gbc.bookingservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic bookingEventsTopic() {
        return new NewTopic("booking-events", 3, (short) 1); // 3 partitions, replication factor of 1
    }
}
