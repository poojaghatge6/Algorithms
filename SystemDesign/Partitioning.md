Partitioning

Analogous Terminology

Partitioning  == Sharding

Partitioning is the microservices for databases. However unlike microservices, requests can’t routed to any of the servers because these are requests to read or write data and each server only holds a subset of data.

No matter how optimized your queries are, it will be difficult to sift through billions of rows of information within <1 second so we try to split that data into smaller groups of 10-100 million rows (these are hypothetical magnitudes) in such a way that it’s predictable to locate which shard the request should be routed to for faster processing (more on this later). This also helps parallelize requests when multiple database servers can respond independent of each other.

Explanation:

https://youtu.be/RynPj8C0BXA

Hot Partitions

Hot partition means when a subset of partitions gets a disproportionate ratio of the total requests. Ideally your data is distributed in such a way that each partition is accessed evenly so that there are no "hot partitions". This requires you to select a good "partition key".

This video provides an example demonstrating the performance difference of a good key vs. a bad key at 10:00. In the example there is data from multiple self-driving cars and the first partition key is by Date and then with a VehicleID+Date:

https://youtu.be/KlXhee6R0rE

Explanation:

https://github.com/RickSayd/navigating-system-design/blob/master/basics/sharding.md




All types of databases can be distributed so choose your database based on the required functionality for your system instead of the performance and scale they’re supposedly capable of handling (it’s a myth that relational databases can only vertically scale and handle small scale):

https://www.quora.com/Is-sharding-not-as-popular-or-more-difficult-with-Relational-SQL-databases
