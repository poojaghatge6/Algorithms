So to preface this feedback: this is a hard problem. I’ve asked this problem a few times before, and each time the candidate struggled with it. I modified the structure of the interview so that I can better get signal, by asking the isValidCrossword first.


I thought you did really well on the coding part. Java definitely slowed you down, but the coding was otherwise strong. The coding skills makes me lean toward Yes on the hiring.


The algorithm and reasoning skills could use some work. In particular, even though this problem is hard to implement, it should be easy to describe the algorithm, really all you’re saying is “try all possible solutions”. It’s such a common pattern among algorithm problems, that it should be a strategy whenever you’re stuck on an algorithm challenge. Obviously, there are some questions on how you can generate “all the possible solutions” in a reasonable manner that will vary with the problem. Sometimes just talking about the brute force solution in this manner with the interviewer, will help you figure out if there’s an optimal solution (not in today’s question though, the expected solution was a brute force).


If a problem seems easy, assume the interviewer has a harder problem lined up. This is especially true for phone screens, where the interviewer doesn’t have any prior insight about your skills.


Your backtracking implementation was fine, but I think you didn’t do the best in debugging the issues you hit. e.g. There was the issue with System.exit(). In retrospect, I would suggest not using a System.exit in a programming interview, all sort of bad things can happen. There was also the issue with setting globalMatrix = matrix, and then modifying matrix later.


Minor pros: Java gave you the advantage of compiling your code as you went, and I liked that you used it.


Minor Nits: When talking about big-O complexity, instead of saying max(n*^2, n*k), say +: so: O(n^2 + nk). They’re exactly the same thing, but it’s much more common to use the plus notation.
