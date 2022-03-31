<html>
<head>
  <title>Laborator 5</title>
</head>
<body>
  <h1>${title}</h1>

  <#list items as item>
      <h2> ${item.id} <h2>
      <ul>
        <li>Title: ${item.title}</li>
        <li>Location: ${item.location}</li>
      </ul>
  </#list>

</body>
</html>