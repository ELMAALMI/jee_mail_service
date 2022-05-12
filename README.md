# jee_mail_service
# Les Etapes a Suivre pour lancer le projet (MAIL SERVER => POSTFIX + DOVECOT + JAVA EE):
## Mail Serveur SetUp
- Telechargé la machine virtual de puis le lien suivant : https://drive.google.com/file/d/1y-wuqSbspKC7v8Jwc8mzA1xsv9qtSqgW/view?usp=sharing
- Ovrire le VM dans le VMWare (v 16)
- Connecter avec utilisateur root ( pwd : 123456789 )
- Puis tapez les commandes suivant : ( mysql -uroot -p123456789 )-> ( use fmail_db; ) -> ( UPDATE domains SET name='votre domain'; )
- Supprimer les utilisateurs qu'ont exite dans la table users ( DELETE FROM inbox; DELETE FROM users; )
## APP SetUp
- clone projet de puis le repository
- Ovrire le avec eclipce ou inteljIDE
- la connection est nécessaire pour telechargé les bibliotheque 
- Aprée changé @ip avec @ip de VM dans le fichier de configuration main/resources/application.properties
- puis lancé le projet
