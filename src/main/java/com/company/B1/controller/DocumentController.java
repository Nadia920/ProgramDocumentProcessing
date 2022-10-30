package com.company.B1.controller;

import com.company.B1.model.*;
import com.company.B1.service.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
    @GetMapping("/")
    public String LoadingBalanceSheetToDBMS(){
        return "addFileAccountingBalanceToDB";
    }
    @GetMapping("/")
    public String ViewingListDownloadedFiles(Model model ){
        List<DocumentEntity> documentDTOList = documentService.findALL();
        model.addAttribute("documents", documentDTOList.size() != 0 ? documentDTOList : null);
        return "showLoadingFiles";
    }
    @GetMapping("/report")
    public String DisplayingDataFromDBMS(Model model){
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
        return "showAccountingBalanceFromDB";
    }
}
