# Pavel Petronel 2A3


<b>The Room Assignment Problem</b>
<br>
<p>
An instance of the Room Assignment Problem consists of <i>events</i> and <i>rooms</i>. Events may be courses, labs, seminars, etc. Rooms may be lecture halls, computer labs, etc.
</p>
<ul>
  <li> Each event has a name, a number of participants (its size), a start time and an end time.
  </li><li> Each room has a name, a type and a capacity.
</li></ul>
<p>
We consider the problem of assigning a room to each event such that the constraints are satisfied and the number of used rooms is as small as possible (if possible).
</p>
<p>Consider the following example. 
<br>
</p>
<pre>Events: C1(size=100, start=8, end=10), C2(size=100, start=10, end=12), L1(size=30, start=8, end=10), L2(size=30, start=8, end=10), L3(size=30, start=10, end=12), 
Rooms: 401(cap=30, lab), 403(cap=30, lab), 405(cap=30, lab), 309(cap=100, lecture hall)
</pre>
A solution may be something like that:
<pre>C1 -&gt; 309
C2 -&gt; 309
L1 -&gt; 401
L2 -&gt; 403
L3 -&gt; 401
</pre>

