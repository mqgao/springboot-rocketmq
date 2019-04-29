# Spring Boot RocketMQ Starter
Open Source Spring Boot Starter for Apache RocketMQ, develop with RocketMQ easily.

## Quick Start

### Maven Dependency

```xml

    <dependency>
        <groupId>com.boot.rmq.common</groupId>
	    <artifactId>boot-rmq-commom</artifactId>
        <version>0.0.1</version>
    </dependency>

```
### Configuration

You just need to add a few configurations on `application.properties`, configurations are like as follows:

```properties

# Apache RocketMQ
spring.rocketmq.nameServer=localhost:9876
spring.rocketmq.producerGroupName=spring-boot-test-producer-group

```

Look, it's easy, but in the real environment, you need modify above configurations.

### Consume message

For consume message, just inherit from class `AbstractRocketMqConsumer`

Example：

```java

@Component
public class DemoMqConsumer extends AbstractRocketMqConsumer {

    @Override
    public boolean consumeMsg(RocketMqContent content, MessageExt msg) {
          System.out.println(new Date() + ", " + content);
          return true;
    }

    @Override
    public Map<String, String> subscribeTopicTags() {
         Map<String, String> map = new HashMap<>();
         map.put("test-topic", "tagA");
         return map;
    }

    @Override
    public String getConsumerGroup() {
         return "test-consumer-group";
      }
  }
```

### Send message

We encapsulate the part of the message sent for common use. The default implementation is `DefaultRocketMqProducer`.

if you need send message with RocketMQ, autowire this bean in your application. 

example: 

```java

@Component
public class DemoRocketMqProducer {

    @Resource
    private DefaultRocketMqProducer producer; //this bean is provided by default.

  
    public void test() {
         Message msg = new Message("TopicA", "TagA", content.toString().getBytes());
         boolean sendResult = producer.sendMsg(msg);
         System.out.println("发送结果：" + sendResult);
    }

}

```

## More configurations

|   num   | config                                       | description   | default  |
| ---- | ----------------------------------------     | ---- | -------- |
| 1 | spring.rocketmq.nameServer |  name server    |  |
| 2 | spring.rocketmq.producerGroupName |  name of producer    | |
| 3 | spring.rocketmq.producerSendMsgTimeout |  millis of send message timeout    | 3000 |
| 4 | spring.rocketmq.producerCompressMsgBodyOverHowMuch |  Compress message body threshold    | 4000 |
| 5 | spring.rocketmq.producerRetryTimesWhenSendFailed |  Maximum number of retry to perform internally before claiming sending failure in synchronous mode    |  2 |
| 6 | spring.rocketmq.producerRetryTimesWhenSendAsyncFailed |  Maximum number of retry to perform internally before claiming sending failure in asynchronous mode    | 2  |
| 7 | spring.rocketmq.producerRetryAnotherBrokerWhenNotStoreOk |  Indicate whether to retry another broker on sending failure internally    | false |
| 8 | spring.rocketmq.producerMaxMessageSize |  Maximum allowed message size in bytes    | 1024 * 4  |


## License

Adopting the Apache License 2.0 protocol for licensing

