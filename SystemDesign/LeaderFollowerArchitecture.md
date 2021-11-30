Leader-Follower Architecture

Analogous Terminology

Leader-follower == Primary-replica == Parent-child == Master-slave (deprecated term)

By default, most distributed database replication and orchestration treats every server as stewards of the data in their partition and updates to any server will be replicated to the other servers as necessary. All the servers are equivalent so it’s referred to as a multi-master architecture.

A leader-follower architecture is the opposite, where all data has a single authoritative source where information is written to and distributed from (leader) and the others are replicas (followers). For example, if replication_factor=3 then there are 3 copies of every partition in your database system where there are 2 read replicas and 1 write replica. Anytime new information is written, it must go to the write node and the information will be propagated out to the other 2 replicas.

This pattern can be applied for both microservice nodes and database partitions depending on the consistency needs of your system.

Benefits

Systems with a disproportionately larger number of reads can be easily scaled out by adding more followers

Maintains higher consistency while preserving availability. You can still choose either strong or eventual consistency with this architecture depending on when you allow reads to take place

No write conflicts between masters

High availability

Drawbacks

Single point of failure for writes. Takes time to employ a leader election algorithm to pick a new leader

Performance bottleneck

Wikipedia explanation (only read the Database Replication section):

https://en.wikipedia.org/wiki/Replication_(computing)#Database_replication

Use-Cases

Load balancers are a single point of failure unless there are multiple load balancers but only one should be routing requests to the application servers

Configuration managers and clock systems should only have a single authority of information while atomically updating all of the replicas so that there are no inconsistencies with timestamps

Read-heavy systems like Instagram, Youtube, social media platforms, search engines. Writes can be comparatively more expensive than reads if there are a lot of tables, views, and indexes to create/update.

Examples:

https://youtu.be/GeGxgmPTe4c

Analysis:

https://stackoverflow.com/q/3736969

Leader Election

When the leader node goes down, a leader election algorithm, or "quorum" algorithm, has to take place between the remaining follower nodes to achieve consensus on who should be the new leader node. There are proofs and trade-offs to each algorithm but just know that they exist.

(Optional) Zookeeper is a configuration manager that uses Paxos for leader selection:

https://youtu.be/nG4SRSHGIDA

