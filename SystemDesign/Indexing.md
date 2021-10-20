Details
Indexing

Indexing is an optimization feature available in most databases that allows you to make read queries against indexed columns faster. Indexing involves using extra space to store a sorted or hashed view of your records. You would construct indexes on columns that you know you frequently query for.
For example, you might index date or numerical columns in ascending/descending order (underlying min/max heap) so you can quickly get the most recent review(s), high score(s), or top voted comment(s). Other times you might index on a string column (underlying hashmap) because you commonly do lookups on an almost unique attribute such as player_id or last name. Primary keys are columns that are both indexed & have a uniqueness constraint.

Detailed Explanation:

https://youtu.be/fsG1XaZEa78
The trade-off of optimizing reads comes at the expense of writes. You should use it whenever your system wants to access something very frequently without having to scan the entire table to look for that row.
Primary key constraints are also indexed but indexes aren't always primary keys. Indexes are less restrictive than the primary key constraint.

Creating indices:

https://github.com/RickSayd/navigating-system-design/blob/master/basics/indexes.md
Pre-computation

Behind the scenes, perform some asynchronous calculations ahead of time in anticipation of resource-intense requests. Pre-computation is achieved by creating multiple indexes to create look-up tables of the same data in different orders or doing post-processing (data analytics, aggregation, machine learning outputs) to front-load the effort. All of these operations are time-consuming upfront but result in very fast responses. The great thing is that it doesn’t matter how computationally expensive it is if it’s being done in the background, unbeknownst to your users!
Use-Cases

Sorting reviews by different criteria (old/new, top/lowest, most helpful)

Calculating personalized recommendations for products you might like

Type-ahead suggestions on search engines

preparing a user's news feed

Type-ahead suggestions are made using a prefix trie, pre-computation comes in the form of calculating and storing the top N frequent results at each trie-node on a regular basis instead of only when a user starts typing.

(Optional) Watch an in-depth look at type-ahead suggestions:

https://youtu.be/xrYTjaK5QVM?t=824

(VERY Optional) Read an extensive breakdown of type-ahead suggestions:

https://github.com/RickSayd/navigating-system-design/blob/master/designs/typeahead.md
