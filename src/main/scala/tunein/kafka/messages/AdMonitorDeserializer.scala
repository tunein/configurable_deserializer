package tunein.kafka.messages

import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import org.apache.kafka.common.header.Headers;
import tunein.kafka.messages.ad._

final class AdMonitorSerializer extends Serializer[AdEvent] {
  override def serialize(topic: String, data: AdEvent): Array[Byte] = data.toByteArray
}

final class AdMonitorDeserializer extends Deserializer[AdEvent] {
  override def deserialize(topic: String, data: Array[Byte]): AdEvent =
    AdEvent.parseFrom(data)
  
  override def deserialize(topic: String, headers: Headers, data: Array[Byte]): AdEvent = 
    AdEvent.parseFrom(data)
}
