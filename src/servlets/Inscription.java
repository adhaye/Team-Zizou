package servlets;

import java.util.HashMap;
import java.util.Map;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription extends HttpServlet {

    public static final String VUE = "/WEB-INF/index.jsp";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";
    public static final String CHAMP_CONF = "confirmation";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_JOINDRE = "joindre";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";




    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        /* Affichage de la page d'inscription */

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }



    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();


        /* Récupération des champs du formulaire. */


        String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );
        String confirmation = request.getParameter( CHAMP_CONF );
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String joindre = request.getParameter( CHAMP_JOINDRE );


        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }


        /* Validation des champs mot de passe et confirmation. */

        try {

            validationMotsDePasse( motDePasse, confirmation );

        } catch ( Exception e ) {

            erreurs.put( CHAMP_PASS, e.getMessage() );

        }


        /* Validation du champ nom. */

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM, e.getMessage() );
        }

        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PRENOM, e.getMessage() );
        }

        try {
            validationJoindre( joindre );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_JOINDRE, e.getMessage() );
        }


        /* Initialisation du résultat global de la validation. */

        if ( erreurs.isEmpty() ) {

            resultat = "Succès de l'inscription.";

        } else {

            resultat = "Échec de l'inscription.";

        }


        /* Stockage du résultat et des messages d'erreur dans l'objet request */

        request.setAttribute( ATT_ERREURS, erreurs );

        request.setAttribute( ATT_RESULTAT, resultat );


        /* Transmission de la paire d'objets request/response à notre JSP */

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );



        try {
            validationEmail( email );
            validationMotsDePasse( motDePasse, confirmation );
            validationNom( nom );
            validationPrenom( prenom );
            validationJoindre( joindre );
        }
        catch (Exception e) {

            /* Gérer les erreurs de validation ici. */

        }
    }
    private void validationEmail( String email ) {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                try {
                    throw new Exception( "Merci de saisir une adresse mail valide." );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else try {
            throw new Exception("Merci de saisir une adresse mail.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void validationMotsDePasse( String motDePasse, String confirmation ) {
        if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                try {
                    throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (motDePasse.trim().length() < 3) {
                try {
                    throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            try {
                throw new Exception("Merci de saisir et confirmer votre mot de passe.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void validationNom( String nom ) {
        if ( nom != null && nom.trim().length() < 3 ) {

            try {
                throw new Exception( "Le nom doit contenir au moins 3 caractères." );
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    private void validationPrenom( String prenom ) {
        if ( prenom != null && prenom.trim().length() < 3 ) {

            try {
                throw new Exception( "Le prenom doit contenir au moins 3 caractères." );
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    private void validationJoindre( String joindre ) {
        if (joindre != null && joindre.trim().length() < 2) {

            try {
                throw new Exception("On aimerait pouvoir te joindre, préfères tu Facebook ? Insta ? Mail ? Linkedin ?");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}