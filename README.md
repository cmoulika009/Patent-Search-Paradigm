<h1 agign="center">Patent Search Paradigm</h1>
<h2>1. Introduction</h2>
A patent is a set of exclusive rights granted to inventor or their assignee for  a limited period   of time. Patents are a form of intellectual property.Patent search is for finding the patents that are already there. There are several unique challenges in patent search, mainly due to the difficulty of understanding users query intent and efficiently matching the query keywords to patents. As patent search can help the patent examiners to find previously published relevant patents and validate or invalidate new patent applications, it has become more and more popular, and recently attracts much attention from both industrial and academic communities. There are several unique challenges in patent search, mainly due to the difficulty of understanding users query intent and efficiently matching the query keywords to patents.As part of this project we improved the search efficiency. And we provided the more suggestions for user to check the patents. We correct the errors in the search keywords using the query correction methods. 

<img src="https://github.com/cmoulika009/Patent-Search-Paradigm/blob/master/Patent%20folder/Architecture.jpg">

<h2>2. Project Description</h2>
The three effective techniques we are using are automatic error correction, topic based query suggestion, query expansion.

<b>a.	Automatic error correction:</b>
In the previous methods if there are any errors in the keywords the relevant answers are not returned. To make it more user friendly we are using the trie structure. By using the trie structure if the users type some part of the keyword the relevant accurate keywords are suggested. The idea used in the trie structure is the keyword is checked with the prefix of the trie node, based on that the similar answers are given to the user. For example if the user is searching for “Yamaha” and they have typed “yemaha” it will give all the answers related to “Yamaha”.

<img src="https://github.com/cmoulika009/Patent-Search-Paradigm/blob/master/Patent%20folder/1.jpg">

<b>b.	Topic based query suggestion:</b>
In the topic based query suggestion if the user is searching for any query all the queries related to that topic will be given to them.For example if the user wants to search anything related to “Yamaha “ and they have typed "Yamaha" then all the queries related to it such as “Yamaha keyboards”,”Yamaha bikes” will be shown and the user can select anything in that.We are using LDA model here.The LDA model is used to find the probabaility of the next query keyword over each topic from underlying patents.The keyword distribution is learn by using language model ehich capture the property of patents.

<img src="https://github.com/cmoulika009/Patent-Search-Paradigm/blob/master/Patent%20folder/2.jpg">

<b>c.	Query expansion:</b>
In many cases, the patents donot know the perfect keyword that has been suggested in database so they may type ambiguous keywords.In such a case we utilize search engines which suggests relevant keywords as user’s type in queries.
The another way is to mine the keywords where we use click click through data to mine correlated queries.For example if we take two queries we check number of times user clicked on same patent to denote their relevance, if keyword pair is larger than given threshold then two keywords are relevant.

<img src="https://github.com/cmoulika009/Patent-Search-Paradigm/blob/master/Patent%20folder/3.jpg">

We are ranking the answers that are obtained for our query search by the probability of most relevant patent. That means related to the search of user every time the count changes and the recently and frequently used keyword is given more priority.

<img src="https://github.com/cmoulika009/Patent-Search-Paradigm/blob/master/Patent%20folder/4.jpg">




