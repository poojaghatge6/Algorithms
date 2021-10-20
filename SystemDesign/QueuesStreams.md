Details
Distributed Queues

These are not to be mistaken with the queue data structure used in coding. These queues exist as their own subsystem which can be hosted on separate computers and scaled separately from the rest of your system.
If microservices are responding your requests within seconds, such as making a read/write request for small amounts of data, you’re going to be fine using the typical HTTP protocols. However for completing long-running or background tasks, you will need to do some asynchronous processing since using synchronous calls means your client will be blocked waiting until your system returns a response.
Terminology

Topic: an instance of a queue for a purpose, similar to how you would subscribe to a news category

Publisher: a producer of content; pushes content to a topic

Subscriber: a consumer of content from a topic; synonymous with workers and queue consumers

How They Work

Requests get written to a topic, the topic holds onto the message until a worker:
claims the message by marking it as “read”

applies arbitrary business logic based on the message

informs the queue to delete the message upon completion

The last step is important because if that doesn’t happen, then the message is assumed to have not been “consumed” so the queue will allow another worker to try again.

Amazon AWS SQS uses a visibility timeout to “hide” the message once a consumer has informed the queue about processing the message. If the consumer doesn’t finish within that time limit, SQS assumes another consumer should attempt to process it.

Only read the first 2 paragraphs and inspect the first diagram:
https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html
Overview:
Part 1 - https://www.youtube.com/watch?v=cvu53CnZmGI

Part 2 - https://www.youtube.com/watch?v=MjEam95VLiI

Only read the “What is Pub/Sub?” section and “Common Use-Cases”:
https://cloud.google.com/pubsub/docs/overview

(Optional) Video Processing example:
https://youtu.be/O1PgqUqZKTA

Use-Cases

Asynchronous Processing

If you wanted to post something in a forum that required both a moderator approval and a profanity filter check before it can be submitted, the manual approval could take minutes or hours so you’d have to keep your browser open for the entire duration of the synchronous decision making process before your post is approved/denied. Instead, it’s better to be able to publish requests asynchronously into a buffer so that subscribers can process those requests.
Batch Processing/Bursty Traffic

In the video processing example, each step can take variable amounts of time to complete for different video sizes so there should be some flexibility in allowing a build-up of requests between stages to avoid too much idle resources.
Fault Tolerance

Underneath the covers, queues store data to disk and replicate information to ensure a high guarantee that your messages will be retained.
If your load balancer routes directly to a microservice and all of your servers go down due to someone deploying a bug in the latest version, you risk losing all of those requests. If you placed a big UberEats order with lots of modifications, you would be very upset if you had to re-order that when their OrderPlacementService was temporarily unresponsive.
Queues allow for a buffering of requests and let your system operate at the consumers’ pace rather than the producers’ pace. You have the option to increase the number of consumers but not the obligation to keep up with demand. If your consumers fall behind, those requests won’t get denied or time-out but instead pile up in your topic. They add fault tolerance to your system by holding onto requests until a consumer has guaranteed that it was processed.
Streams

Queues on steroids.
Example Implementations: Apache Kafka, AWS Kinesis Streams

Stream capabilities are a superset of queue capabilities. Streams allow for more flexible processing by retaining messages after processing and are good when there are multiple consumers so you don’t need a topic for each consumer or when you’d like the flexibility to reprocess those messages.
Similarities

Producers produce messages and consumers consume messages

Both can be configured to keep messages in sorted order

Both have high throughput, availability, resiliency, guaranteed at-least-once delivery

Differences

Messages aren't deleted after being read and processed in streams. This allows new consumers to replay messages from any point in time.
Message retention allows for multiple consumers. Queues can only one have subscriber group so a producer has to fan out a message to multiple topics if there are multiple consumers.
Stream consumers provide a cursor to the message they want to read so they can decide whether to rewind, replay, or skip messages instead of processing only from the "front" of the queue
Stream consumers can be configured for "exactly-once" and "at-most-once" message processing
Streams enable partitioning within a topic. So you could divide a topic similar to how you shard databases.
Streams can plug into database actions (insert, update, delete) and output them as actions

Use-Cases

If a notification is supposed to be sent out whenever an order transitions from packing to shipping but your notification system was unavailable at the time, the events could be reprocessed from a stream to try again.

To replay video games by re-processing timestamped actions by actors to simulate the original game. The moves can be stored as text rather than storing high definition videos such as in Starcraft 2 where zooming and 3D camera panning is wanted. Storing the full 3D renderings would be multiple times larger than storing it as text for users to share between personal computers.

If a stock matching engine crashes, orders can be restored from the stream in the order that they were received.

(Optional) Additional use-cases: https://kafka.apache.org/uses
Overview

Explanation:

https://itnext.io/is-kafka-a-message-queue-or-a-stream-processing-platform-7decc3cf1cf
Example:

https://youtu.be/06iRM1Ghr1k
