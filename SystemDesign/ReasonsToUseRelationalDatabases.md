Details
Transactions

Transactions allow you to specify a block of code to be be atomic, or "all-or-nothing". Either everything in that chunk of logic must complete successfully or it all rolls back. The term stems from the literal idea of posting a financial transaction between two parties in that either the entire process has to succeed (subtract from the buyer’s wallet and add to the seller’s wallet) or nothing takes place and the transaction is undone. Think of it as an intelligent try-catch block in code.
Explanation (pick one):

Stop @ 9:30 & ignore references to "Cloud Firestore”): https://youtu.be/dOVSr0OsAoU

Read the Introduction, Purpose, and Transactional databases sections: https://en.wikipedia.org/wiki/Database_transaction
Locking

Locking prevents a row from being updated by multiple, concurrent requests which could cause inconsistent responses to be returned. Locking is related and tends to only exist in RDBMS but is different from transactions.
Sequence of Events without Locking

A meeting calendar system allows people to book in 1 hour increments, there are no meetings yet

User1 wants to book roomA from 10:00-12:00

User2 wants to book roomA from 11:00-13:00

Thread1 checks if User1’s request overlaps with any existing meetings (none exist)

Thread2 checks if User2’s request overlaps with any existing meetings (none exist)

Thread1 creates a record for User1 @ 10:00-12:00

Thread2 creates a record for User2 @ 11:00-13:00

There is an overlap between 11:00-12:00

Sequence of Events with Locking

A meeting calendar system allows people to book in 1 hour increments, there are no meetings yet

User1 books roomA from 10:00-12:00

User2 books roomA from 11:00-13:00

Thread1 tries to acquire a lock on roomA for User1, no one holds the lock so it’s granted

Thread1 locks roomA for User1’s request

Thread2 tries to acquire a lock on roomA for User2, it’s denied because Thread1 holds the lock

Thread2 waits N seconds to try again

Thread1 checks if User1’s request overlaps with any existing meetings (none exist)

Thread1 creates a record for User1 @ 10:00-12:00

Thread1 releases the lock

Thread2 tries to acquire a lock on roomA for User2 again, no one holds the lock so it’s granted

Thread2 checks if User2’s request overlaps with any existing meetings (it overlaps between 11:00-12:00)

Thread2 informs User2 of the overlap and fails the request

You can have lock counters to allow multiple threads to operate concurrently on a resource which simply increments and decrements uses of itself (with its own lock on the counter) for more complex use-cases.

Read the Introduction & Granularity of locks sections:

https://en.wikipedia.org/wiki/Record_locking

:::warning
Locking and transactions are not the same thing! The first answer gives a great example of what happens when you use one but not the other:

https://stackoverflow.com/questions/4226766/mysql-transactions-vs-locking-tables
:::

ACID Properties

Relational databases have 4 big priorities that are wrapped up into this 4 letter acronym. Later you’ll learn about NoSQL databases and how they have BASE properties. ACID re-iterates a lot of what you learned so far but formalizes the concepts which will be useful later for comparing trade-offs between SQL to NoSQL databases.
As the page suggests, ACID is strongly tied to the use of transactions and locking. Read everything up to the Implementation section:

https://en.wikipedia.org/wiki/ACID

For Senior Engineers

It will be useful to know the difference between optimistic locking and pessimistic locking when you encounter it in the workplace.

https://stackoverflow.com/q/129329
