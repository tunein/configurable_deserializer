package  tunein.kafka.messages

class AdMonitorTest extends munit.FunSuite {
  test("deserialize message") {
    val des = new AdMonitorDeserializer()
    
    val message = scalapb.Encoding.fromBase64(scala.collection.immutable.Seq("CAISBgijqdbDBhoAIgAqADIEbmV3czoFbXNuYmNCCUluc3BlY3RvckoaaW5zcGVjdG9yLTg1Zjk1NzhkZDYteHJrZGJSAFoAYgBqAHAAegA=").mkString)
    val result = des.deserialize("some-topic", message)
    assert(result.broadcastGroup.get == "news")
    assert(result.broadcastName.get == "msnbc")
    assert(result.eventType.name == "AdEndEvent")
    assert(result.podName.get == "inspector-85f9578dd6-xrkdb")
    assert(result.sourceSystem.get == "Inspector")
    assert(result.timestamp.get.seconds == 1752536227)
    assert(result.adFillOrder.get == 0)
  }
}