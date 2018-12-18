<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 20/11/2018
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Inscription</title>
      <link type="text/css" rel="stylesheet" href="form.css" />
  </head>
  <body>
  <form method="post" action="inscription">

    <fieldset>

      <legend>Inscription</legend>

      <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <label for="nom">nom <span class="requis">*</span></label>
        <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
        <span class="erreur">${erreurs['nom']}</span>
        <br />

        <label for="prenom">Prénom <span class="requis">*</span></label>
        <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="60" />
        <span class="erreur">${erreurs['prenom']}</span>
        <br />

        <label for="joindre">Le meilleur moyen de te joindre <span class="requis">*</span></label>
        <input type="text" id="joindre" name="joindre" value="" size="20" maxlength="60" />
        <span class="erreur">${erreurs['joindre']}</span>
        <br />

        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
        <span class="erreur">${erreurs['email']}</span>
        <br />


        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
        <span class="erreur">${erreurs['motdepasse']}</span>
        <br />


        <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
        <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
        <span class="erreur">${erreurs['confirmation']}</span>
        <br />

      <input type="submit" value="Inscription" class="sansLabel" />
      <br />
        <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
    </fieldset>

  </form>

  </body>
</html>
