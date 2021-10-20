Details
Consistent Hashing

:::tip
You won't be asked how consistent hashing works in the interview nor in your career and instead be expected to pick a good partition strategy for your situation. However it’s encouraged that you have a foundational understanding of the underlying implementation.

:::
Consistent hashing is one implementation of partitioning and how databases allow you to create partition keys from any data in your model. Ideally, your data is evenly distributed across all of your partitions even if you have to create more database partitions to scaling up to store more data. This is a lengthy but valuable breakdown of the underlying mechanisms of partitioning with strings.

Explanation:

https://youtu.be/ffE1mQWxyKM

https://github.com/RickSayd/navigating-system-design/blob/master/basics/consistent-hashing.md

:::tip
Consistent hashing usually correlates with picking a partition key based on a unique identifier in your data model. Most likely you wouldn’t partition on a non-unique, user-defined string.
:::
