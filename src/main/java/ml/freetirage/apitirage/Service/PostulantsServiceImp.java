package ml.freetirage.apitirage.Service;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Repository.PostulantsRepository;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;


@Service
@AllArgsConstructor
public class PostulantsServiceImp implements PostulantsService {

    @Autowired
    final private PostulantsRepository postulants;
    @Override
    public String AjouterPostulant() {
        ArrayList<String> values = new ArrayList<String>();

        try{
            InputStream input = new FileInputStream("liste1.xlsx");
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()) {
                values.clear();
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();


                while (cells.hasNext()) {

                    HSSFCell cell = (HSSFCell) cells.next();

                    if (CellType.NUMERIC == cell.getCellType())
                        values.add(Integer.toString((int) cell.getNumericCellValue()));
                    else if (CellType.STRING == cell.getCellType())
                        values.add(cell.getStringCellValue());

                }
                postulants.Inserer(values.get(0), values.get(1), values.get(2), values.get(3) );

            }
                     return "Données sont bien enregistrées";
        } catch (IOException e) {

            e.printStackTrace();
            return "Error d'enregistrement";
        }

    }
}

