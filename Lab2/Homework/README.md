# Pavel Petronel 2A3

<ul>
<li>Create a class that describes an instance of the <i>problem</i>.
</li><li> Override the <i>equals</i> method form the <i>Object</i> class for the <i>Event, Room</i> classes.
The problem should not allow adding the same event or room twice.

</li><li>Instead of using an <i>enum</i>, create dedicated classes for lecture halls and computer labs. <i>Room</i> will become <i>abstract</i>.
The course room may have an additional property indicating if there is a video projector, and the lab room may indicate the operating system of its computers.
<!-- <li>Implement the method <i>getSources</i> in the <i>Problem</i> class, returning an array of all the sources. -->
</li><li>Create a class to describe the <i>solution</i>. 

</li><li> Implement a simple algorithm for creating a feasible solution to the problem, "trying" to minimize the number of used rooms.

</li><li>Write <a href="http://www.oracle.com/technetwork/java/javase/tech/index-137868.html">doc comments</a> in your source code 
and generate the class documentation using <a href="https://docs.oracle.com/javase/9/javadoc/toc.htm">javadoc</a>.
</li></ul>

<hr>

- Am creat clasa care reține problema noastră printr-o listă de evenimente și una de încăperi
    - Am creat o metodă care primește ca și parametru un obiect, verifică dacă acest obiect a fost deja adăugat problemei și returnează true/false după caz
    - Am folosit metoda de mai sus în metoda de adăugare a unui obiect în problemă pentru a nu permite problemei să adauge aceleași evenimente/încăperi de mai multe ori.
- Am creat o clasă care va rezolva problema noastră
	- Am ordonat încăperile descrescător după capacitatea acestora
	- Am ordonat evenimentele crescător după ora lor de terminare, și descrescător după dimensiunea acestora
		- Am făcut acest lucru pentru a nu ajunge în situația în care, de exemplu, avem 2 evenimente care încep la aceeași oră, unul cu o dimensiune de 30 de persoane și altul cu 100 de persoane, și luându-le în această ordine, să nu asignăm evenimentul cu 30 de persoane unei săli care ar permite accesul a 100+ persoane în cazul în care este o sală care permite între 30 și 100 de persoane, cel de al doilea eveniment rămănând astfel fără o sală căreia să fie atribuit.
	- Am parcurs fiecare eveniment și încăpere, atribuindu-le după disponibilitate 
	- 
[JavaDoc](https://github.com/Crekto/programare-avansata/tree/main/Lab2/Homework/JavaDoc)
