# Pavel Petronel 2A3


<ul>
<li>Create a class that describes the city.
</li><li>Using Java Stream API, write a query that display all the streets that are longer than a specified value and join at least 3 streets.
</li><li>Use <a href="https://github.com/DiUS/java-faker">a third-party library</a> in order to generate random fake names for intersections and streets. 
</li><li>You may use <a href="https://jgrapht.org/javadoc/org.jgrapht.core/org/jgrapht/alg/spanning/package-summary.html">this package</a> of <a href="https://jgrapht.org/">JGraphT</a> 
in order to solve the problem (or other library).
<br>
Note: A personal implementation of the algorithm will be will be scored extra (+1p).

</li></ul>

<hr>

- Am creat o clasă care descrie orașul nostru.
    - În această clasă, am creat o mapă a orașului în care asociez străzile unei intersecții pe parcurs ce adaug străzile străzile memorând cele 2 intersecții pe care le unește.
- Cu ajutorul Java Stream API-ului și a mapei menționate anterior am filtrat străzile care au lungimea peste cea primită ca parametru, și a căror capete sunt adiacente cu cel puțin încă 3 străzi și le-am afișat.
- Pentru a vedea pe ce străzi trebuiesc instalate cablurile astfel încât costul să fie minim am implementat algoritmul lui Prim.
    - Din orașul nostru am generat o matrice de adiacență
    - Am creat un vector boolean pentru a vedea dacă intersecțiile au fost vizitate, întrucât odată vizitată o intersecie, nu trebuie să mai ajungem în aceasta.
    - Plecând de la intersecția inițială, am văzut care e costul minim pentru a ajunge în altă intersecție și am ales strada respectivă.
    - Până ce terminăm de vizitat toate intersecțiile, vedem care costul minim pentru a ajunge dintr-o intersecție deja vizitată în altă intersecție nevizitată și alegem strada respectivă.
    - Când am terminat de vizitat toate intersecțile vom rămâne cu arborele de cost minim care va reprezenta ruta pe care trebuiesc instalate cablurile.

