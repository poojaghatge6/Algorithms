Reasons to Use each NoSQL Database

Object stores serve data as-is regardless of size, type, or format so any media content can be tossed in here: photos, videos, music, documents, PDFs, arbitrary binary files, etc. They can then be referenced by a URL pointing to where it can be downloaded similar to a filepath on your computer or browser link to download a Zip of GitHub code.

Graph databases optimize querying the relationships between records (the edges between nodes) moreso than the records themselves. If you’re getting all of the interactions (who & what reacted & commented on a post) would require some very involved joins on a relational database but storing interactions as edges between objects in adjacency lists can re-orient how data is represented. Yes, it’s still a “row-column” relationship underneath the covers and a relational database can serve the same purpose but you don’t eat soup with a fork or cut with a spoon because there are better implements specifically tailored for those purposes.

Key-value stores can be your default if you have tables that don’t require the joining of tables together to get results and you need a hashmap storing some primary key to a variable range of optional, nullable columns (e.g. a Facebook user profile possibly with music interests, hobbies, birthday info, location history, education details, relationship details, etc).


Wide-column / Columnar databases are useful for storing continuous streams of data to the same object where you want to keep “appending” more information to an existing record most frequently (e.g. aggregating time-series data from a sensory device on a Tesla, tracking motion and orientation with an accelerometer, how a user navigates pages on your website, etc).

Geospatial databases / Quadtrees would be used to store and locate data on a 2D map where queries are filtered by their presence within a NxM grid. Queries on these types of databases are faster than asking for all results in a traditional database that are between two longitude and latitude values. This would be used by Google Maps, Yelp, and Uber to optimize navigating and locating things around the world as gradually smaller and smaller grids instead of storing everything in a typical database with longitude/latitude coordinates.

Document stores are for unstructured text data with the most common use-case being for search engines by indexing keywords to a result, a hashmap where the key=search_term and the value=search_result(s). A search result can be indexed to multiple keywords with different probabilities/relevancies so that search engines can layer algorithms on top of a probabilistic model to determine the best ordering of results given a search query.

Explanation:

https://www.alooma.com/blog/types-of-modern-databases

How are Geospatial databases useful for Yelp (POI = points of interest):

https://youtu.be/tu6QKpV7GiI?t=504

What is Geohashing and why?

https://www.pubnub.com/learn/glossary/what-is-geohashing/

Picking between different databases in an interview:

https://youtu.be/cODCpXtPHbQ?t=677
