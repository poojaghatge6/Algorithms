Types of Caching

Key-Value and Primitive DataType Caching

Reaching out to the database is time-consuming and you want to have a copy of the data in or near the microservice if possible. There are a few strategies to cache information each with different trade-offs:

In-memory cache - very fast but isolated to each server’s memory

Distributed/Global cache - hosted on a separate server, it’s fast and is shared memory but uses more space and must consider how to handle partitioning and consistency (modern caching solutions, like Redis or Memcached, solve them by default)

Caches are used more broadly to refer to any optimization made to avoid a longer outreach. This can mean using an in-memory data structure like a hashmap in your code, a web-browser cache, or a cache technology on the same server/microservice to store frequently used information and avoid making a further away call (database accesses can be long because you have to establish a TCP connection and potentially sift through a lot of data).

This means you have to be smart about what you cache and evict to achieve a high cache hit rate (low cache miss rate).

Explanation:

https://www.youtube.com/watch?v=joifNgoXXFk

The cache eviction policies you should be familiar with are the Least Recently Used (LRU cache) and Least Frequently Used (LFU cache) policies. The other policies tend to be very niche and hardware-oriented. The different cache invalidation aren’t that important to understand beyond knowing they exist and that there are trade-offs to each:

https://github.com/RickSayd/navigating-system-design/blob/master/basics/caching.md

Content Delivery Network

Content Delivery Networks (CDN) are caches for static media located geographically near the request for faster delivery of high bandwidth content (videos & high resolution images). Caches are a part of CDNs. Both are meant to make things faster but CDNs are optimized for static content retrieval (media) are typically refer to caches with an edge near the client.

Skim:

https://www.cloudflare.com/learning/cdn/what-is-a-cdn/

CDN vs. Cache:

https://www.quora.com/How-is-CDN-different-from-caching

CDNs and caches should never be treated as primary data sources. They are for improving performance and never to serve as functionality.

For example, if you need some type of quick look-up table, a configuration manager (distributed hashmap) or an extra table with a primary key and regular column are much more appropriate.
