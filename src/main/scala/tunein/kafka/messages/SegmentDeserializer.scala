package tunein.kafka.messages

import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import tunein.kafka.messages.segment._

final class SegmentSerializer extends Serializer[SegmentEvent] {
  override def serialize(topic: String, data: SegmentEvent): Array[Byte] = data.toByteArray
}

final class SegmentDeserializer extends Deserializer[SegmentEvent] {
  override def deserialize(topic: String, data: Array[Byte]): SegmentEvent =
    SegmentEvent.parseFrom(data)
}
