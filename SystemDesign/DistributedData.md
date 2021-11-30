Challenges with Storing Distributed Data

Now we’ll really get into the weeds of distributed systems and understand different ways to improve performance.

Similarities to microservices: horizontally scaled to use multiple, weak computers

Differences from microservices: you can’t use a load balancer for databases because it does matter which server is picked to answer your request. Only a subset of your entire data exists on each server (unless replication factor == total number of servers but that’s not scalable).

To horizontally scale databases, you need to know where and how to divide your data. This is known as partitioning your database and the partition key is used to locate your data.

Sometimes querying for a database all the way on the opposite region of the United States is slow so we need to introduce local copies closer to our geolocation, known as caching.
