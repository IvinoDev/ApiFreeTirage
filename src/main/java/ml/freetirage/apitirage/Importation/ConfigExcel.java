package ml.freetirage.apitirage.Importation;

import ml.freetirage.apitirage.Model.Postulants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConfigExcel {
    //Déclaration de deux variables pour contenir le type et la liste du fichier excel
    static String Type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String listeExcel = "Postulants";

    // Vérification que le fichier est bien un fichier Excel
    public static Boolean verification(MultipartFile file) {
        if (Type.equals(file.getContentType())) {
            return true;
        } else {
            return false;
        }
    }
    // Methode qui retourne la liste des postulants contenu dans le fichier importé
    public static List<Postulants> postulantsExcel(MultipartFile file) {
        try {
            // lecture du fichier excel
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheet(listeExcel);
            Iterator<Row> ligne = sheet.iterator();

            // création d'une liste dans laquelle va être stockée la liste recuperée dans le fichier
            List<Postulants> postulants = new ArrayList<>();

            int numLigne = 0;
            // Boucle qui parcours ligne par ligne le fichier
            while (ligne.hasNext()) {
                // Recuperation de la ligne actuelle
                Row ligneActuelle = ligne.next();
                // Saut de la première ligne du fichier car elle contient l'entête
                if (numLigne == 0) {
                    numLigne++;
                    continue;
                }

                // Création d'un postulant et récupération de ses attributs
                Postulants postulant = new Postulants();

                Iterator<Cell> colonne = ligneActuelle.iterator();
                int numColonne = 0;
                // parcours des colonnes d'une ligne
                while (colonne.hasNext()) {
                    // Recuperation de la colonne courante
                    Cell colonneActuelle = colonne.next();
                    // recuperation des infos de chaque colonne
                    switch (numColonne) {
                        // première colonne contenant le nom
                        case 0:
                            postulant.setNom_postulant(colonneActuelle.getStringCellValue());
                            break;
                        // seconde colonne contenant le prénom
                        case 1:
                            postulant.setPrenom_postulant(colonneActuelle.getStringCellValue());
                            break;
                        // troixième colonne contenant le numéro
                        case 2:
                            postulant.setNumero_postulant(colonneActuelle.getStringCellValue());
                            break;
                        // dernière colonne contenant l'adresse e-mail
                        case 3:
                            postulant.setMail_postulant(colonneActuelle.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    numColonne++;
                }
                postulants.add(postulant);
            }
            workbook.close();
            return postulants;

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }
}
