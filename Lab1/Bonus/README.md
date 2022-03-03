# Pavel Petronel 2A3

<ul>
<li> Implement an efficient algorithm that determines, if possible, a subset of distinct words W<sub>1</sub>,W<sub>2</sub>,...,W<sub>k</sub> (from the ones that you have generated)
such that <b>k ≥ 3</b> and W<sub>i</sub> and W<sub>i+1</sub> are neighbors, for all i in [1..k], where W<sub>k+1</sub>=W<sub>1</sub>.<br>
Can you find the largest possible k? <br>
</li></ul>

<hr>

- Deoarece cerințe ne cere de fapt să găsim un ciclu în graful format din cuvintele generate și relația de vecinătate dintre ele, am folosit un DFS pentru a determina acest ciclu.
- Nu am reușit să implementez astfel încât să găsim cel mai mare ciclu.