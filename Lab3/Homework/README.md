# Pavel Petronel 2A3


<ul>
<li> Each node will contain a <i>Map</i> representing the time costs. Create and print the complete network in the example.
</li><li> Create a <i>default</i> method in the interface <i>Storage</i>, that is able to return the storage capacity in other units of storage (megabyte, kilobyte, byte).
</li><li> In the <i>Network</i> class, create a method to display the nodes that are <i>identifiable</i>, sorted by their addresses. 
<!-- <li> Create the class <i>NetworkInfo</i>. An instance of this class will contain a net and the preferences regarding the visiting order. -->
</li><li> Implement an <u>efficient</u> agorithm to determine <u>all the shortests times</u> required for data packets to travel from an identifiable node to another.
</li></ul>

<hr>

- Pentru a determina toți timpii cei mai scurți pentru a ajunge de la un nod la altul am ales să implementez algoritmul lui Dijkstra, aplicându-l pentru fiecare nod din network.
- Am creat o mapă în care voi memora sub forma de <nod, timp>, timpul cel mai scurt de a ajunge de la un nod sursă la nodul respectiv, în care inițial, timpul pentru nodul sursă este 0, iar pentru restul Integer.MAX_VALUE. Dacă la final, timpul rămâne Integer.MAX_VALUE înseamnă că nodul respectiv este inaccesibil din nodul sursă.
- Am inițializat 2 liste
	- una cu nodurile vizitate deja, deoarece, dacă un nod a fost vizitat, știm că am găsit deja timpul cel mai scurt pentru a ajunge în acesta
	- una cu nodurile nevizitate, care va include inițial doar nodul sursă, iar pe parcurs vor fi adăugați vecinii nodurilor vizitate, pentru a ști în ce noduri putem ajunge la momentul respectiv și de a selecta nodul în care timpul cel mai scurt ar fi cel minim.
- Cât timp avem noduri nevizitate în listă, iterăm prin aceasta și alegem nodul cu timpul cel mai scurt de la nodul sursă.
- Odată selectat un nod, iterăm prin vecinii acestuia și dacă nu au fost deja vizitați, îi inserăm în lista corespunzătoare și le actualizăm timpul dacă este cazul.
- La final, în mapa creată vom avea pentru fiecare nod asociat timpul cel mai scurt de a ajunge de la nodul sursă, care este semnalat prin valoarea timpului 0, la nodul respectiv, sau cu Integer.MAX_VALUE pentru nodurile care sunt inaccesibile din nodul sursă.
