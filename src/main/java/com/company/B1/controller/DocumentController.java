package com.company.B1.controller;

import com.company.B1.model.*;
import com.company.B1.service.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@AllArgsConstructor
public class DocumentController {
    private final static Logger LOGGER = LogManager.getLogger();
    @Autowired
    AccountingAccountsService accountingAccountsService;
    @Autowired
    ClassService classService;
    @Autowired
    DocumentService documentService;
    @Autowired
    IncomingBalanceService incomingBalanceService;
    @Autowired
    OutgoingBalanceService outgoingBalanceService;
    @Autowired
    TurnoversService turnoversService;
    @GetMapping("/LoadingBalanceSheetToDBMS")
    public String LoadingBalanceSheetToDBMS(){ //переход на страницу для загрузки excel документа
        return "AccountingBalance/addFileAccountingBalanceToDB";
    }
    @GetMapping("/ViewingListDownloadedFiles")
    public String ViewingListDownloadedFiles(Model model ){ //Просмотр загруженных файлов
        List<DocumentEntity> documentDTOList = documentService.findALL();
        model.addAttribute("documents", documentDTOList.size() != 0 ? documentDTOList : null);
        return "showLoadingFiles";}
    @GetMapping("/DisplayingDataFromDBMS")
    public String DisplayingDataFromDBMS(Model model){ //Отображение данных из бд на страницу
        List<AccountingAccountsEntity> accountingAccountsDTOList = accountingAccountsService.findALL();
        model.addAttribute("accountingAccounts", accountingAccountsDTOList.size() != 0 ? accountingAccountsDTOList : null);
        List<ClassEntity> classDTOList = classService.findALL();
        model.addAttribute("classes", classDTOList.size() != 0 ? classDTOList : null);
        List<DocumentEntity> documentDTOList = documentService.findALL();
        model.addAttribute("documents", documentDTOList.size() != 0 ? documentDTOList : null);
        List<IncomingBalanceEntity> incomingBalanceDTOList = incomingBalanceService.findALL();
        model.addAttribute("incomingBalances", incomingBalanceDTOList.size() != 0 ? incomingBalanceDTOList : null);
        List<OutgoingBalanceEntity> outgoingBalanceDTOList = outgoingBalanceService.findALL();
        model.addAttribute("outgoingBalances", outgoingBalanceDTOList.size() != 0 ? outgoingBalanceDTOList : null);
        List<TurnoversEntity> turnoversDTOList = turnoversService.findALL();
        model.addAttribute("turnovers", turnoversDTOList.size() != 0 ? turnoversDTOList : null);
        return "showAccountingBalanceFromDB";}
    @GetMapping("/addExcel")
    public void DisplayingDataFromDBMS(Model model, String file) { //Запись данных excel документа в бд
       DocumentEntity document = new DocumentEntity();
        try { POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet= wb.getSheet(String.valueOf(0));
            HSSFRow row = sheet.getRow(0);
            HSSFCell cell = row.getCell(0);
            document.setNameOrganization(cell.toString());
            row = sheet.getRow(1);
            cell = row.getCell(0);
            document.setDocumentName(cell.toString());
            row = sheet.getRow(2);
            HSSFRow row1 = sheet.getRow(3);
            cell = row.getCell(0);
            HSSFCell cell1 = row1.getCell(0);
            document.setDocumentDescription(cell.toString() + cell1.toString());
            row = sheet.getRow(5);
            cell = row.getCell(0);
            document.setDateOfSubmission(new Date(cell));


        }
        catch (Exception e) {  }

    }

}
