Pagination

A lot of user facing responses don't require the entire response upfront, especially if it has the potential to return hundreds or thousands of results such as when using a search engine or scrolling through newsfeeds. You can deliver an ultra low latency experience (or the impression of one) by tailoring it to the majority use-case. The difference between 10 results and 10,000 results may not be much but when you have 1000 requests/sec, thats 10 thousand vs. 10 million total results returned that will lower latency and costs in aggregate.

This can be employed using response pagination, prioritizing how to load the page, distraction with graphics/mini-games, and other behavior-driven solutions.

Google search: A majority of users never look past the first 10 results so return one page with links to future pages

Instagram: A majority of users look at the N most recent photos of a profile so only load 9 photos at a time

Newsfeed: A majority of users will only scroll for N minutes or M items so infinite scroll can rely on a constant internet connection to load a small result once you’ve scrolled far enough down

Pagination can be implemented with result offsets or cursors (using a unique, sequential index to identify a row in the database). Both are explained in the video below, the “cursor” way is the start.after() function that probably relies on the restaurant_id field being indexed to be unique and sequential.

Explanation:

https://youtu.be/poqTHxtDXwU

Cursor Pagination

Pagination can be rudimentarily implemented with LIMIT and OFFSET arguments in queries but doesn't work as effectively if records are inserted or removed as you're paging through them. OFFSET also retrieves all the records up to OFFSET and discarding them so it degrades linearly.

Example: To get the next 10 results on the 1000th page means your query has to query 10000 records and discard the first 9990.

Employing cursors allow you to navigate to an exact record and count LIMIT records before/after it in constant time.

Example: Go to the 9990 record, return records 9991-10000.

Cursors can be thought of as pointers to rows in a database. They "point" to a specific row in the database and start looking at rows above or below that cursor. This requires that database column to be unique and ordered, such as an auto-incrementing primary key or any column created with both UNIQUE and ORDER BY ASC/DESC constraints.

The values in that column must be unique so there's no ambiguity which row a cursor is pointing at.

The values in that column must be ordered to determine sequencing "this row R comes before this row Z" or "this row R comes after this row A".

Use-Cases

Cursors are especially useful when you need to find a place where you last left off from on an underlying resource that’s dynamically changing:

Multiple pages of available rooms to book or a list of seats in a venue changes as other users claim/unclaim a reservation

Multiple pages of a video game leaderboard as players gain more points than their competitors

The last thing you saw in your social media newsfeed (you could use timestamp but its not guaranteed because of clock skew and minuscule time differences between each computer)

An in-depth look at cursor pagination and it's performance in large scale systems compared to offset pagination:

https://medium.com/swlh/how-to-implement-cursor-pagination-like-a-pro-513140b65f32

(Optional) How Slack uses pagination for instant messaging:

https://slack.engineering/evolving-api-pagination-at-slack/
