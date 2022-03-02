# Pavel Petronel 2A3

<ul>
<li> Let <i>n, p</i> be two integers and C<sub>1</sub>,...,C<sub>m</sub> a set of letters (<i>the alphabet</i>), all given as a command line arguments. Validate the arguments!
</li><li> Create an array of <i>n</i> strings (called <i>words</i>), each word containing exactly <i>p</i> characters from the given alphabet. <br> 
Display on the screen the generated array.

</li><li> Two words are <i>neighbors</i> if they have a common letter.  <br>
Create a boolean <i>n x n</i> matrix, representing the adjacency relation of the words. <br>
Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen.

</li><li> For larger <i>n</i> display the running time of the application in nanoseconds (DO NOT display the data structure!). 
Try <i>n &gt; 30_000</i>. You might want to adjust the JVM Heap Space using the VM options <i>-Xms4G -Xmx4G</i>.
</li><li> Launch the application from the command line, for example: <code>java Lab1 100 7 A C G T</code>.
</li>
</ul>

<hr>

- Am validat mai întâi argumentele.
    - Am verificat dacă avem cel puțin 3 argumente pentru a îndeplini sintaxa "\<n> \<p> <C<sub>1</sub>,...,C<sub>m</sub>>", în caz contrar afișăm o eroare sugestivă și închidem programul.
    - Am verificat pe rând dacă argumentele sunt corespunzătoare, n - Integer, p - Integer și alfabetul să fie dat doar din litere separate
- Am generat cuvintele random cu literele date ca argumente folosind formula <code>Math.floor(Math.random() * (max - min + 1) + min)</code>
    - În cazul nostru, min = 2 deoarece primele 2 argumente reprezintă n și p, iar max = args.length - 1
- Am generat matricea de adiacență, parcurgând fiecare cuvânt cu cele care urmează după el, verificând dacă cele 2 cuvinte sunt vecine cu ajutorul unei funcții checkNeighbor
    - Funcția checkNeighbor primește ca parametri 2 argumente de tip String și verifică dacă acestea au o literă în comun, returnând true/false după caz.
- Pentru structura de date care memorează vecinii fiecărui cuvânt, am creat o clasă nouă numită "Neighbors" care memorează un cuvânt ca și "părinte" și o listă cu vecinii acestuia.
    - Pentru a vedea care sunt vecinii fiecărui cuvânt, i-am parcurs pe fiecare în parte și ne-am folosit de matricea de adiacență generată anterior pentru a vedea care sunt vecinii acestuia
