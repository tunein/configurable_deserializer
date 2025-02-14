package tunein.kafka.messages

import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import tunein.kafka.messages.playlist._

final class PlaylistSerializer extends Serializer[PlaylistEvent] {
  override def serialize(topic: String, data: PlaylistEvent): Array[Byte] = data.toByteArray
}

final class PlaylistDeserializer extends Deserializer[PlaylistEvent] {
  override def deserialize(topic: String, data: Array[Byte]): PlaylistEvent =
    PlaylistEvent.parseFrom(data)
}
