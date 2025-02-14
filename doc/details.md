
## Deserializers implementation details

Here's the list of the deserializers available in this jar and a quick explanation of each deserializer behaviour.    
These deserializers are for demo/test purpose only.

#### `tunein.kafka.messages.constant.ConstantString`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns `this is a message`.

#### `tunein.kafka.messages.constant.ConstantChar`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns the letter `c`.

#### `tunein.kafka.messages.constant.ConstantInt`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns the value `1`.

#### `tunein.kafka.messages.constant.ConstantDouble`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns the value `1.234`.

#### `tunein.kafka.messages.constant.ConstantFloat`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns the value `1.456`.

#### `tunein.kafka.messages.constant.ConstantShort`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns the value `2`.

#### `tunein.kafka.messages.constant.ConstantBoolean`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns the value `true`.

#### `tunein.kafka.messages.constant.ConstantByte`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns the value `6`.

#### `tunein.kafka.messages.constant.ConstantNull`

This deserializer completely ignores the content of the messages it receives from Kafka.     
For each message it receives from Kafka, it returns `null`.
