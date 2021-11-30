Details
#

Weighting Database Trade-offs with CAP Theorem
CAP Theorem is the academic definition of ACID vs BASE.

If you have a database on a single server, you’ll never have to worry about consistency because data with replication factor of 1, by definition, has no inconsistencies. There are no other active copies of data to update.

Once your database is no longer hosted on a single source, you will need to consider these 3 trade-offs. The emphasis here is trade-offs, trade-offs, trade-offs. Much like choosing the appropriate data structure for your algorithm, you have to choose the appropriate database and consistency model for your system.

The CAP theorem encapsulates the 3 concepts you have to balance when selecting how to persist data.

Consistency

Availability

Partition Tolerance



Explanation:

https://youtu.be/K12oQCzjPxE

https://en.wikipedia.org/wiki/CAP_theorem



CAP Theorem Venn Diagram:

https://gaboesquivel.com/blog/2013/choosing-the-data-store-for-your-web-app/



Picking AP means giving up C: must accept the possibility of old data

Picking PC means giving up A: must reach consensus on all replicas before responding with a result

Picking CA means giving up P: impossible in practice because there are always writes occurring



#

Picking between Consistency & Availability
By default, bias for high availability. Use strong consistency on an as-needed basis.

Consistency / ACID / SQL

Have a bias for consistency when your system critically depends on having the most up-to-date database information (financials, guaranteed, singular access to global resources). Achieving strong consistency is often why you’ll find most finance-oriented websites to be slower on write operations (including heightened security standards):

checkout flows on e-commerce

bank account transfers

credit card payments

flight/hotel/ticket reservations



The easiest way to decide whether you need ACID is to consider the interactions people and other systems have with your data. If you add or update data, is it important that the very next query is able to see the change? In other words, are important decisions hanging on the current state of the database?

Availability / BASE / NoSQL

Have a bias for availability when your system can return out-dated database results (social media posts being available to some users earlier than others).

Prioritizing availability isn’t any easier because you have stricter performance requirements and humans expect instantaneous loading so even the speed of light going halfway across the globe can be perceived as too slow.

Loading newsfeeds need to be snappy

Instant messaging needs to be instant; it’s right there in the name!

Commenting on social media

Upvoting/Liking/Thumbing-Up can eventually add up to the correct total

Uploaded content should be visible ASAP even if that means not everyone who refreshes will see it yet
