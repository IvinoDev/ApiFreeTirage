package ml.freetirage.apitirage.Importation;

import ml.freetirage.apitirage.Model.Postulants;
import org.apache.poi.ss.usermodel.*;
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
            //Sheet sheet = workbook.getSheet(listeExcel);
            Iterator<Sheet> sheet=workbook.sheetIterator();
            //Iterator<Row> ligne = sheet.iterator();

            // création d'une liste dans laquelle va être stockée la liste recuperée à partir du fichier
            List<Postulants> postulants = new ArrayList<>();

            DataFormatter dataFormatter=new DataFormatter();
            while (sheet.hasNext()){
                Sheet sh= sheet.next();
                Iterator<Row> ligne = sh.iterator();


                int numLigne = 0;
                // Boucle qui parcours ligne par ligne le fichier
                while (ligne.hasNext()) {
                    // Récuperation de la ligne actuelle
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
                                System.out.println(colonneActuelle);
                                postulant.setNom(dataFormatter.formatCellValue(colonneActuelle));
                                break;
                            // seconde colonne contenant le prénom
                            case 1:
                                postulant.setPrenom(dataFormatter.formatCellValue(colonneActuelle));
                                break;
                            // troixième colonne contenant le numéro
                            case 2:
                                postulant.setNumero(dataFormatter.formatCellValue(colonneActuelle));
                                break;
                            // dernière colonne contenant l'adresse e-mail
                            case 3:
                                postulant.setEmail(dataFormatter.formatCellValue(colonneActuelle));
                                break;
                            default:
                                break;
                        }
                        numColonne++;
                    }
                    postulants.add(postulant);
                }


            }
            workbook.close();
            System.out.println(postulants.size());
            return postulants;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }

    }
}
