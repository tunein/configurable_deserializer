package tunein.kafka.messages

import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import tunein.kafka.messages.monitor._

final class MonitorSerializer extends Serializer[MonitorEvent] {
  override def serialize(topic: String, data: MonitorEvent): Array[Byte] = data.toByteArray
}

final class MonitorDeserializer extends Deserializer[MonitorEvent] {
  override def deserialize(topic: String, data: Array[Byte]): MonitorEvent =
    MonitorEvent.parseFrom(data)
}
