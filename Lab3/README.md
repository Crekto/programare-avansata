# Pavel Petronel 2A3


<p>
<b>The Network Routing Problem</b><br>

A network contains various <i>nodes</i>, such as <i>computers</i>, <i>routers</i>, <i>switches</i>, etc.
Nodes in the network have unique names and may have other common properties such as hardware (MAC) address, the location on a map, etc. <br>
Some of them are <i>identified</i> using an IP-address. Some of them are able to store data, having a <i>storage capacity</i>, expressed in gigabytes (GB).   <br>
The time (measured in milliseconds) required for a network packet to go from one node to another is known.

<br>
</p>

<p>
Example: locations are: v1 (Computer A)  v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).
<table border="0">
<tbody><tr><td>
<table border="1">
<tbody><tr>
<th>From-To </th> <th> Cost </th>
</tr><tr><td> v1--v2 </td> <td> 10 </td>
</tr><tr><td> v1--v3 </td> <td> 50 </td>
</tr><tr><td> v2--v3 </td> <td> 20 </td>
</tr><tr><td> v2--v4 </td> <td> 20 </td>
</tr><tr><td> v2--v5 </td> <td> 10 </td>
</tr><tr><td> v3--v4 </td> <td> 20 </td>
</tr><tr><td> v4--v5 </td> <td> 30 </td>
</tr><tr><td> v4--v6 </td> <td> 10 </td>
</tr><tr><td> v5--v6 </td> <td> 20 </td>
</tr></tbody></table>
</td>
<td>
<img src="network.png">
</td>
</tr>
</tbody></table>
Computers and routers are identified by IPs, while only computers are able to store data.
  
</p>

