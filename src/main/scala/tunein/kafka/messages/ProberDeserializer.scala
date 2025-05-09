package tunein.kafka.messages

import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import org.apache.kafka.common.header.Headers;
import tunein.kafka.messages.prober._

final class ProberSerializer extends Serializer[ProberEvent] {
  override def serialize(topic: String, data: ProberEvent): Array[Byte] = data.toByteArray
}

final class ProberDeserializer extends Deserializer[ProberEvent] {
  override def deserialize(topic: String, data: Array[Byte]): ProberEvent =
    ProberEvent.parseFrom(data)

  override def deserialize(topic: String, headers: Headers, data: Array[Byte]): ProberEvent = 
    ProberEvent.parseFrom(data)
}
