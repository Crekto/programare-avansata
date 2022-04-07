# Pavel Petronel 2A3


<ul>
<li> Create the object oriented model.
</li><li> Initialize the game by generating random sticks and place them on the board. Implement either <b>direct</b> or <b>retained</b> mode for drawing the game board.
</li><li> Implement the logic of the game. When the player execute a <i>mouse pressed</i> operation, a stone must be drawn at the mouse location: red or blue depending on whose turn it is.
Validate the move, according to the game rules. Determine the winner of the game.
</li><li> (+0.5p) Export the current image of the game board into a PNG file.
</li><li> (+0.5p) Use object serialization in order to save and restore the current status of the game.
</li></ul>

<hr>

- Am creat o clasă care reține grid-ul nostru sub formă de listă de adiacență. Grid = graful format din bețe, pe care se joacă jocul.
    - Pentru a genera acest grid, am ales să-l creez random, fiecare muchie având 65% șanse să fie aleasă.
    - L-am salvat ca listă de adiacență pentru a îmi fi mai ușor de a verifica care sunt opțiunile disponibile pentru a plasa piatra/dacă nu mai sunt opțiuni valide și jocul s-a terminat.
- Am implementat logica jocului, la fiecare pas salvând nodul selectat într-o listă cu toate nodurile vizitate până în momentul respectiv.
    - Primul jucător poate plasa piatra oriunde pe tablă, atâta timp cât nodul respectiv este adiacent cu altul.
    - Alternativ, fiecare jucător este lăsat să plaseze piatra doar pe un nod adiacent cu piatra plasată anterior de celălalt jucător.
    - După fiecare plasare de piatră, verificăm dacă în lista de adiacență a nodului respectiv există noduri nevizitate, însemnând că jocul poate continua, în caz contrar jocul se termină iar jucătorul care a plasat ultima piatră este câștigătorul.
- Pentru a salva starea actuală a jocului sub forma unei imagini, am creat un BufferedImage și cu ajutorul funcției createGraphics am considerat imaginea ca fiind o 'suprafață de desenat' pe care am desenat frame-ul nostru cu ajutorul funcției paint, iar apoi am exportat imaginea într-un fișier PNG.
- Pentru a salva starea actuală a jocului, am salvat toate informațiile cu ajutorul ObjectStream-ului, salvându-le într-un fișier separat.
    - Pentru a relua starea jocului, am citit toate informațiile din fișierul anterior, actualizând toate informațiile și redesenând Panel-ul nostru.
    - Am încercat să folosesc Jackson pentru asta, însă am folosit Ellipse2D pentru a desena pietrele și când le salvam cu ajutorul librăriei Jackson primeam o eroare cu infinite recursion pe care n-am reușit să o rezolv, așa că am folosit ObjectStream.
