package tunein.kafka.messages

import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import tunein.kafka.messages.prober._

final class ProberSerializer extends Serializer[ProberEventMonitoringTask] {
  override def serialize(topic: String, data: ProberEventMonitoringTask): Array[Byte] = data.toByteArray
}

final class ProberDeserializer extends Deserializer[ProberEventMonitoringTask] {
  override def deserialize(topic: String, data: Array[Byte]): ProberEventMonitoringTask =
    ProberEventMonitoringTask.parseFrom(data)
}
