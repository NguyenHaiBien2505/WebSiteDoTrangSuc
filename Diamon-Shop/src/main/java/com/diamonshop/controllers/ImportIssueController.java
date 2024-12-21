package com.diamonshop.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.diamonshop.dtos.ImportIssueDto;
import com.diamonshop.dtos.request.ImportIssueRequest;
import com.diamonshop.entities.ImportIssue;
import com.diamonshop.entities.User;
import com.diamonshop.services.ImportIssueService;
import com.diamonshop.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/management/import")
public class ImportIssueController {

    @Autowired
    private ImportIssueService importIssueService;

    @Autowired
    private ProductService productService;


    @PostMapping("/add/")
    public ResponseEntity<?> addImportIssue(@RequestBody ImportIssueRequest issueRequest, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("/auth/");
        } else {
            ImportIssue importIssue = importIssueService.addImportIssue(issueRequest, currentUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        }

    }

    @ResponseBody
    @GetMapping("/all/")
    public ResponseEntity<?> findAllWaitingIssue(HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("/auth/");
        } else {
            if (!currentUser.getRole().equals("QUANLY")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("home.html");
            } else {
                return ResponseEntity.ok(importIssueService.findAllIssueByStatus("WAITING"));
            }
        }
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<?> findImportIssueDetail(@PathVariable Integer id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("/auth/");
        } else {
            if (!currentUser.getRole().equals("QUANLY")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("home.html");
            } else {
                ImportIssueDto importIssueDto = importIssueService.findImportIssueDetail(id);
                return ResponseEntity.ok(importIssueDto);
            }
        }
    }

    @ResponseBody
    @PostMapping("/{id}")
    public ResponseEntity<?> approveIssue(@RequestParam(name = "action") String action
            , @PathVariable Integer id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("/auth/");
        } else {
            if (!currentUser.getRole().equals("QUANLY")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("home.html");
            } else {
                if (action.equalsIgnoreCase("approve")) {
                    ImportIssue issue = importIssueService.findById(id);
                    if (issue != null) {
                        issue.setStatus("SUCCESS");
                    }
                    ImportIssue importIssue = importIssueService.updateImportIssue(issue);
                } else if (action.equalsIgnoreCase("reject")) {
                    ImportIssue issue = importIssueService.findById(id);
                    if (issue != null) {
                        issue.setStatus("REJECTED");
                    }
                    ImportIssue importIssue = importIssueService.updateImportIssue(issue);
                }
                return ResponseEntity.ok("accept_import.html");
            }
        }
    }

    @ResponseBody
    @GetMapping("/history/")
    public ResponseEntity<?> findAllHistoricIssue(HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("/auth/");
        } else {
            if (!currentUser.getRole().equals("QUANLY")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("home.html");
            } else {
                List<ImportIssue> successIssue = importIssueService.findAllIssueByStatus("SUCCESS");
                List<ImportIssue> rejectedIssue = importIssueService.findAllIssueByStatus("REJECTED");
                List<ImportIssue> allHistoricIssues = new ArrayList<>();
                allHistoricIssues.addAll(successIssue);
                allHistoricIssues.addAll(rejectedIssue);
                return ResponseEntity.ok(allHistoricIssues);
            }
        }
    }
}
